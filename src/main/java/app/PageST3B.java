package app;

import java.util.ArrayList;

import helper.WebsiteElementBuilder;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class PageST3B implements Handler {
    WebsiteElementBuilder nav = new WebsiteElementBuilder();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3B.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.2</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + nav.getExtraCSS();
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + nav.getNavBar();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Commodity code and statistic lookup</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";
        JDBCConnection jdbc = new JDBCConnection();

        // Form Start----------------------------------------------------------
        html = html + "<form action='/page3B.html' method='post'>";

        //Radio buttons to select what to sort by
        html = html + "<input type='radio' id='avg' name='sortby' value='avg' required>";
        html = html + "<label for='avg'>Food Loss Average </label><br>";
        html = html + "<input type='radio' id='highest' name='sortby' value='highest'>";
        html = html + "<label for='highest'>Highest Percentage of Food Loss</label><br>";
        html = html + "<input type='radio' id='lowest' name='sortby' value='lowest'>";
        html = html + "<label for='lowest'>Lowest Percentage or Food Loss</label>";

        html = html + "<br>";

        //Text box for how many results you want
        html = html + "<input type='number' min='1' class='form-control' id='number_of_results' name='number_of_results' placeholder = 'Enter number of results' required>";
        html = html + "   <button type='submit' class='searchButton'>Search</button>";


        //TODO: Replace Anchor with button that lets you do sql stuff
        //Sourced from w3 schools
        html = html +"""
        <input type='text' id='myInput' onkeyup='myFunction()' placeholder='Search for Products..'>
        <ul id='myUL'>""";

        ArrayList<String> listSubclassNames = jdbc.getAllsubclassNames();

        for (String output : listSubclassNames) {
        html = html + "<li><a href='#'>" + output +"</a></li>";
        }
        html = html + "</ul>";

        // Form End-----------------------------------------
        html = html + "</form>";
      

        // Add HTML for the page content
        html = html + """
            <p>Subtask 3.B page content</p>
            """;


            String sort_by = context.formParam("sortby");
            String no_of_results = context.formParam("number_of_results");

        html = html + "<p>" + sort_by + "</p>";
        html = html + "<p>" + no_of_results + "</p>";

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr24)</p>
            </div>
        """;

        html = html + "</body>";

        html = html + """
                <script>
function myFunction() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('myInput');
  filter = input.value.toUpperCase();
  ul = document.getElementById("myUL");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("a")[0];
    txtValue = a.textContent || a.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>
                """;

        html = html + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
