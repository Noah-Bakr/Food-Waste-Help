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
        html = html + "<div class='two-a-content'>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + nav.getNavBar();

        // Add header content block
        html = html + """
                <div class='timed-data' style='padding-top:25px'>
                    <div class='timed-data-header'>
                        <div class='timed-data-title' style='align-items: flex-start; padding-bottom:10px; padding-top:10px'>
                            <h3 style='text-align:left'>Commodity Code and Statistics Lookup</h3>
                        </div>
                    </div>     
                    """;

        // Add Div for page Content
        
        JDBCConnection jdbc = new JDBCConnection();

        // Form Start----------------------------------------------------------
        html = html + "<form action='/page3B.html' method='post'>";

        //Radio buttons to select what to sort by
        html = html + "<div class='switcher'>";
          html = html + "<div>";
            html = html + "<input type='radio' id='avg' name='sortby' value='avg' required>";
            html = html + "<label for='avg'>Food Loss Average </label><br>";
          html = html + "</div>";
          html = html + "<div>";
            html = html + "<input type='radio' id='highest' name='sortby' value='highest'>";
            html = html + "<label for='highest'>Highest Percentage of Food Loss</label><br>";
           html = html + "</div>";
          html = html + "<div>";
            html = html + "<input type='radio' id='lowest' name='sortby' value='lowest'>";
            html = html + "<label for='lowest'>Lowest Percentage or Food Loss</label>";
          html = html + "</div>";

          String maximum = jdbc.getNoOfEvents();

          //Text box for how many results you want
          html = html + "<input type='number' min='1' max='" + maximum + "' class='form-control' id='number_of_results' name='number_of_results' placeholder = 'Enter number of results' autocomplete='off' required style='width:15%; margin-left:10px'>";
          html = html + "   <button type='submit' class='searchButton'>Search</button>";



        html = html + "</div>"; //Class Switcher End Div

        html = html + "<br>";

        


        //Sourced from w3 schools
        html = html +"""
        <input type='text' id='myInput' onkeyup='myFunction()' placeholder='Search for Products...' autocomplete='off'>
        <div class='searchResults'>
        <ul id='myUL'>""";

        ArrayList<String> listSubclassNames = jdbc.getAllsubclassNames();

        
        for (String output : listSubclassNames) {
        
          html = html + "<li style='display:flex'><input style='display: flex; flex-direction: row; align-items: center;' type='radio' id='" + output + "' class='beans' name='searchList' value='"+output+"'  onclick='heheha()' required> <label for='"+output+"'>"+output+"</label></li>";
        }
        html = html + "</ul>";
        html = html + "</div>";

        // Form End-----------------------------------------
        html = html + "</form>";


            String sort_by = context.formParam("sortby");
            String no_of_results = context.formParam("number_of_results");
            String searchedProduct = context.formParam("searchList");

        html = html + "<p>" + sort_by + "</p>";
        html = html + "<p>" + no_of_results + "</p>";
        html = html + "<p>" + searchedProduct + "</p>";
        html = html + "<div><p id='testP'>Before</p></div>";
        html = html + "</div>";
        html = html + "</div>";


        // Footer
        html = html + nav.getFooter();

        html = html + "</body>";

        html = html + """
                <script>
function myFunction() {
  // Declare variables
  var input, filter, ul, li, label, i, txtValue;
  input = document.getElementById('myInput');
  filter = input.value.toUpperCase();
  ul = document.getElementById("myUL");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    label = li[i].getElementsByTagName("label")[0];
    txtValue = label.textContent || label.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}


function heheha()
{
        alert(2);
        const elem = document.getElementById("testP");
        elem.style.color = 'red';
        document.getElementById("testP").innerHTML = "After";
}
</script>
                """;

        html = html + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
