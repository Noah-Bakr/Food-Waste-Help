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

          String sort_by = context.formParam("sortby");
          String no_of_results = context.formParam("number_of_results");
          String searchedProduct = context.formParam("searchList");

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
            html = html + "<input type='radio' id='avg' name='sortby' value='AVG' required";
            if(sort_by != null){
            if(sort_by.equals("AVG"))
            {
              html = html + " checked";
            }
          }
            html = html + ">";
            html = html + "<label for='avg'>Food Loss Average </label><br>";
          html = html + "</div>";
          html = html + "<div>";
            html = html + "<input type='radio' id='highest' name='sortby' value='MAX'";
            if(sort_by != null){
              if(sort_by.equals("MAX"))
              {
                html = html + " checked";
              }
            }
            html = html + ">";
            html = html + "<label for='highest'>Highest Percentage of Food Loss</label><br>";
           html = html + "</div>";
          html = html + "<div>";
            html = html + "<input type='radio' id='lowest' name='sortby' value='MIN'";
            if(sort_by != null){
              if(sort_by.equals("MIN"))
              {
                html = html + " checked";
              }
            }
            html = html + ">";
            html = html + "<label for='lowest'>Lowest Percentage or Food Loss</label>";
          html = html + "</div>";

          String maximum = jdbc.getNoOfEvents();

          //Text box for how many results you want
          html = html + "<input type='number' min='1' max='" + maximum + "' class='form-control' id='number_of_results' name='number_of_results' placeholder = 'Enter number of results' autocomplete='off' required style='width:15%; margin-left:10px'";
              if(no_of_results != null)
              {
                html = html + "value='" + no_of_results + "'";
              }
          html = html + ">";
          html = html + "   <button type='submit' class='searchButton'>Search</button>";



        html = html + "</div>"; //Class Switcher End Div

        html = html + "<br>";

        


        //Sourced from w3 schools
        html = html +"""
        <input type='text' id='myInput' onkeyup='myFunction()' placeholder='Search for Products...' autocomplete='off'>
        <div class='partThreeFlex'>
        <div class='searchResults'>
        <ul id='myUL'>""";

        ArrayList<CommodityLookup> listSubclassNames = jdbc.getAllAvailableCpcCommodities();


        //Generates scrolling list radio buttons for only commodities present in the events table
        for (CommodityLookup output : listSubclassNames) {
        
          html = html + "<li style='display:flex'>";
          html = html + "<input style='display: flex; flex-direction: row; align-items: center;' type='radio' id='" + output.getDescriptor() + "' class='beans' name='searchList' value='"+output.getCpcCode()+"'  onclick='textChange(" + '"' + output.getDescriptor() + '"' + ")' required ";
          if(output.getCpcCode().equals(searchedProduct))
          {
            html = html + "checked";
          }
          html = html + "> ";
          html = html + "<label for='"+output.getDescriptor()+"'>"+output.getDescriptor()+"</label></li>";
        }
        html = html + "</ul>";
        html = html + "</div>";
        html = html + "<div class='javascriptCheckedContainer'>";
        
        if(searchedProduct != null)
        {
          html = html + "<p style='color:black' id='testP'>" + jdbc.convertCommodtyToString(searchedProduct) + "</p>";
        }
        else
        {
          html = html + "<p style='color:grey' id='testP'>No Commodity Selected</p>";
        }

        if(searchedProduct != null)
        {
          html = html + "<div class='individualItem'>";
          DifferenceTableSelected lookupResults = jdbc.getTableSelectedResults(searchedProduct, sort_by);
            html = html + "<table>";

              html = html + "<tr>";
                html = html + "<th><h3></h3></th>";
                html = html + "<th><h3>Name</h3></th>";
                html = html + "<th><h3>Code</h3></th>";
                html = html + "<th><h3>(%)Loss</h3></th>";
                html = html + "</tr>";

              html = html + "<tr>";
                html = html + "<td><p><strong>Commodity</strong></p></td>";
                html = html + "<td><p>" + lookupResults.getCommodity() + "</p></td>";
                html = html + "<td><p>" + lookupResults.getCpcCode() + "</p></td>";
              html = html + "</tr>";

              html = html + "<tr>";
                html = html + "<td><p><strong>Group</strong></p></td>";
                html = html + "<td><p>" + lookupResults.getGroupDescriptor() + "</p></td>";
                html = html + "<td><p>" + lookupResults.getGroupId() + "</p></td>";
                html = html + "<td><p>" + lookupResults.getLossPercentage() + "%</p></td>";
              html = html + "</tr>";
            html = html + "</table>";

          
          html = html + "</div>";
        }

        html = html + "</div>";
        html = html + "</div>";

        // Form End-----------------------------------------
        html = html + "</form>";

        html = html + "<div class='tableContainer'>";
          html = html + "<table class=differenceTable>";
            html = html + "<tr>";
              html = html + "<th><h2>Group</h2></th>";

              if(sort_by != null)
              {
              html = html + "<th><h2>" + sort_by + "(%) food loss</h2></th>";
              }

              else
              {
              html = html + "<th><h2>Sort By</h2></th>";
              }

              html = html + "<th><h2>Difference</h2></th>";
            html = html + "</tr>";

            
              if(sort_by != null)
              {
                ArrayList<DifferenceTableResults> lookupResults = jdbc.getTableSimilar(sort_by, no_of_results, searchedProduct);

                for (DifferenceTableResults output : lookupResults) {
                  html = html + "<tr>";
                  html = html + "<td><h3>" + output.getDescriptor() + "</h3></td>";
                  html = html + "<td><h3>" + output.getLossPercentage() + "%</h3></td>";
                  html = html + "<td><h3>" + output.getDifferences() + "</h3></td>";
                  html = html + "</tr>";
                }
              }
              else
              {
                html = html + "<tr>";
                html = html + "<td><h3>No</h3></td>";
                html = html + "<td><h3>Selection</h3></td>";
                html = html + "<td><h3>Made</h3></td>";
                html = html + "</tr>";
              }
            
          html = html + "</table>";
        html = html + "</div>";


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


function textChange(newText)
{
        const elem = document.getElementById("testP");
        elem.style.color = 'Black';
        document.getElementById("testP").innerHTML = newText;
}
</script>
                """;

        html = html + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
