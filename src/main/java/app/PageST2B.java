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

public class PageST2B implements Handler {
    WebsiteElementBuilder nav = new WebsiteElementBuilder();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2B.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 2.2</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js'></script>";
        html = html + nav.getExtraCSS();
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        html = html + "<div class='two-a-content'>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + nav.getNavBar();

        

        //NOTE: IT IS BAD PRACTICE TO DO THIS, I DONT WANT TO TOUCH NOAH's FLEX STYLING BECAUSE I DONT WANT TO BREAK IT, DONT DO STYLING LIKE THIS
        html = html + """
                <div class='timed-data' style='padding-top:25px'>
                    <div class='timed-data-header'>
                        <div class='timed-data-title' style='align-items: flex-start; padding-bottom:10px; padding-top:10px'>
                            <h3 style='text-align:left'>Loss Percentage</h3>
                            <h4 style='text-align:left'>1966 - 2022</h4>
                        </div>
                        <div class='timed-data-info'>
                            <h2>Changes in loss percentage for selected groups</h2>
                        </div>
                    </div>      
                    """;

        
        JDBCConnection jdbc = new JDBCConnection();
// Form Start----------------------------------------------------------------------------------
html = html + "<form action='/page2B.html' method='post'>";
                        html = html + "<div class='timed-search-box'>";

                        html = html + "<select name='selectedGroup' id='selectedGroup'> <optgroup>";
                        

                        ArrayList<Group> groups = jdbc.getAllGroupsName();

                        for (Group group : groups) {
                            html = html + "<option value='" + group.getGroupId() + "'>" + group.getDescriptor() + "</option>";
                        }
html = html + "</optgroup> </select>";
html = html + "<h3>Between</h3>";

html = html + "<select name='first-year' id='first-year'> <optgroup>";

                        ArrayList<String> firstYear = jdbc.getAllYears();

                        for (String year : firstYear) {
                            html = html + "<option value='" + year + "'>" + year + "</option>";
                        }

        html = html + """
                        </optgroup> </select> 
                        <h3>And</h3>
                        <select name="second-year" id="second-year"> <optgroup>
                        """;

                        ArrayList<String> secondYear = jdbc.getAllYearsInverted();
                        for (String year : secondYear) {
                            html = html + "<option value='" + year + "'>" + year + "</option>";
                        }
        
        html = html + "</optgroup></select>";

//Text box for how many results you want


html = html + "</div>";

html = html + """
        <div class='switcher'>
            <div>
                <input type="radio" id="Activity" name="additionalSelector" value="Act" Required>
                <label for="Activity">Activity</label><br>
            </div>
            <div>    
                <input type="radio" id="FoodSupplyStage" name="additionalSelector" value="Fss" Required>
                <label for="FoodSupplyStage">Food Supply Stage</label><br>
            </div>
            <div>    
                <input type="radio" id="CauseOfLoss" name="additionalSelector" value="Col" Required>
                <label for="CauseOfLoss">Cause Of Loss</label> 
            </div>
            
                <button type='submit' class='Button' style='padding:1% 3% 1% 3%; border-radius:20px; font-size:30px; margin-top: 5px;'>Generate</button>
            
        </div>
        """;

html = html + "</form>";

// Form End ------------------------------------------------------------------------------------

html = html + """
                        <div class='line-graph' style='width:40%'>
                            <canvas id="line-graph"></canvas>
                            <script> """;

                                html = html + "const xValues = [50,60,70,80,90,100,110,120,130,140,150];";
                                html = html + "const yValues = [7,8,8,9,9,9,10,11,14,14,15];";
                            
                html = html + """
                            new Chart("line-graph", {
                            type: "line",
                            data: {
                                labels: xValues,
                                datasets: [
                                    {fill: false,
                                    lineTension: 0,
                                    backgroundColor: "rgba(0,0,255,1.0)",
                                    borderColor: "rgba(0,0,255,0.1)",
                                    data: yValues}
                                ]
                            },
                            options: {
                                legend: {display: false},
                                scales: {
                                yAxes: [{beginAtZero: false}],
                                }
                            }
                            });
                            </script>
                        </div>""";




String key1 = context.formParam("selectedGroup");
String years1 = context.formParam("first-year");
String years2 = context.formParam("second-year");

        //Debug
        // html = html + "<p>" + key1 + "</p>";
        // html = html + "<p>" + years1 + "</p>";
        // html = html + "<p>" + years2 + "</p>";

        html = html + "</div>";

        // Footer
        html = html + nav.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
