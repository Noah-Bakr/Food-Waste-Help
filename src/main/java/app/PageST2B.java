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
        int globalCounter1 = 0;
        int globalCounter2 = 0;


        String key1 = context.formParam("selectedGroup");
        String years1 = context.formParam("first-year");
        String years2 = context.formParam("second-year");
        String actSelect = context.formParam("actSelector");
        String fssSelect = context.formParam("fssSelector");
        String colSelect = context.formParam("colSelector");

        // if(key1 != null)

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
                            String groupIdValue = group.getGroupId();
                            html = html + "<option value='" + groupIdValue + "' ";
                            if(key1 != null)
                            {
                            if(key1.equals(groupIdValue))
                            {
                                html = html + "selected = 'selected'";
                            }
                            }
                            html = html + ">" + group.getDescriptor() + "</option>";
                        }
html = html + "</optgroup> </select>";
html = html + "<h3>Between</h3>";

html = html + "<select name='first-year' id='first-year'> <optgroup>";

                        ArrayList<String> firstYear = jdbc.getAllYears();

                        for (String year : firstYear) {
                            
                            html = html + "<option value='" + year + "' ";
                            if(years1 != null)
                            {
                                if(years1.equals(year))
                                {
                                    html = html + "selected = selected";
                                }
                            }
                            html = html +">" + year + "</option>";
                        }

        html = html + """
                        </optgroup> </select> 
                        <h3>And</h3>
                        <select name="second-year" id="second-year"> <optgroup>
                        """;

                        ArrayList<String> secondYear = jdbc.getAllYearsInverted();
                        for (String year : secondYear) {
                            html = html + "<option value='" + year + "' ";
                            if(years2 != null)
                            {
                                if(years2.equals(year))
                                {
                                    html = html + "selected = selected";
                                }
                            }
                            html = html +">" + year + "</option>";
                        }
        
        html = html + "</optgroup></select>";

//Text box for how many results you want


html = html + "</div>";

html = html + """
        <div class='switcher'>
            <div>""";
                    
                html = html + "<input type='checkbox' id='Activity' name='actSelector' value='Act'";

                        if(actSelect != null)
                        {
                            html = html + "checked";
                        }

                html = html + """
                        
                        >
                <label for="Activity">Activity</label><br>
            </div>
            <div>    
            """;
            html = html + "<input type='checkbox' id='FoodSupplyStage' name='fssSelector' value='Fss'";
            
            if(fssSelect != null)
            {
                html = html + "checked";
            }

            html = html + """
                    ;>
            <label for="FoodSupplyStage">Food Supply Stage</label><br>
                </div>
            <div>    
                <input type="checkbox" id="CauseOfLoss" name="colSelector" value="Col"
                    """;
                
                    if(colSelect != null)
                    {
                        html = html + "checked";
                    }
                
                    html = html + """
                            >
<label for="CauseOfLoss">Cause Of Loss</label> 
            </div>
            
                <button type='submit' class='Button' style='padding:1% 3% 1% 3%; border-radius:20px; font-size:30px; margin-top: 5px;'>Generate</button>
                """;

            html = html + "<div style='width:40%; padding-left:2%; border: 2px solid #4F7302; background-color:white' id='numberOfResults'>";

            String numberOfEvents = "No Group Selected";
            if(key1 != null)
            {
                numberOfEvents = jdbc.getNoOfGroupsCat(key1,years1,years2);
                html = html + "<p style='color:#4F7302; font-size:30px; text-align:center;'> Number of results: " + numberOfEvents + "</p>";
            }
            else
            {
                html = html + "<p style='color:#4F7302; font-size:30px; text-align:center;'>" + numberOfEvents + "</p>";
            }
                    
            html = html + "</div>";
            
        html = html + "</div>";
                            
                
                
    
html = html + "</form>";

// Form End ------------------------------------------------------------------------------------
ArrayList<GraphData> ReturnedGraphData = jdbc.createTemp();
if(key1 != null){
ReturnedGraphData = jdbc.getGraphResults(years1,years2,key1);
};


html = html + "<div class='twobGraphTable'>";

html = html + """
                        <div class='line-graph' style='width:40%; display:flex; align-items:center;'>
                            <canvas id="line-graph"></canvas>
                            <script> """;

                                html = html + "const xValues = [";
                                
//Makes the website not break when there is not data selected
                                if(key1 != null)
                                {

                                    for (GraphData years : ReturnedGraphData) {
                                        if(globalCounter1 < ReturnedGraphData.size()-1)
                                        {
                                            html = html + years.getYear() + ",";
                                        }
                                        else
                                        {
                                            html = html + years.getYear();
                                        }
                                        
                                        globalCounter1 = globalCounter1 + 1;
                                    }
                                }
                                else
                                {
                                    html = html + "50,60,70,80,90,100,110,120,130,140,150";
                                }
                                html = html + "];";

//Same thing for Y value
                                html = html + "const yValues = [";
                                if(key1 != null)
                                {
                                    for (GraphData percentages : ReturnedGraphData) {
                                        if(globalCounter2 < ReturnedGraphData.size()-1)
                                        {
                                            html = html + percentages.getPercentageLoss() + ",";
                                        }
                                        else
                                        {
                                            html = html + percentages.getPercentageLoss();
                                        }
                                        
                                        globalCounter2 = globalCounter2 + 1;
                                    }
                                }
                                else
                                {
                                    html = html + "7,8,8,9,9,9,10,11,14,14,15";
                                }
                                html = html + "];";
                            
                html = html + """
                            new Chart("line-graph", {
                            type: "line",
                            data: {
                                labels: xValues,
                                datasets: [
                                    {fill: false,
                                    lineTension: 0,
                                    backgroundColor: "#4F7302",
                                    borderColor: "#9FC847",
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

                        ArrayList<LossPercentageData> TableData = jdbc.createTempTable();

                        if(key1!=null){
                        TableData = jdbc.getGraphTable(years1,years2,key1);
                        }
                        
                        

                        //Table Generator
                        html = html + "<div class='twoB-table' style='margin-top:0px; margin-left:5px; width:70%;'>";
                        //Creates Table
                                html = html +"<table>";
                                //Generates table headings
                                            html = html +"<tr>";

                                            //001
                                            if((actSelect==null)&&(fssSelect == null)&&(colSelect != null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Cause Of Loss</h2></th>";
                                            }
                                            //010
                                            else if((actSelect==null)&&(fssSelect != null)&&(colSelect == null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Food Supply Stage</h2></th>";
                                            }
                                            //011
                                            else if((actSelect==null)&&(fssSelect != null)&&(colSelect != null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Food Supply Stage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Cause Of Loss</h2></th>";
                                            }
                                            //100
                                            else if((actSelect!=null)&&(fssSelect == null)&&(colSelect == null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Activity</h2></th>";
                                            }
                                            //101
                                            else if((actSelect!=null)&&(fssSelect == null)&&(colSelect != null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Activity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Cause Of Loss</h2></th>";
                                            }
                                            //110
                                            else if((actSelect!=null)&&(fssSelect != null)&&(colSelect == null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Activity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Food Supply Stage</h2></th>";
                                            }
                                            //111
                                            else if((actSelect!=null)&&(fssSelect != null)&&(colSelect != null))
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                                html = html +"<th><h2 style='20px'>Activity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Food Supply Stage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Cause Of Loss</h2></th>";
                                            }
                                            //000
                                            else
                                            {
                                                html = html +"<th><h2 style='20px'>Year</h2></th>";
                                                html = html +"<th><h2 style='20px'>Loss Percentage</h2></th>";
                                                html = html +"<th><h2 style='20px'>Commodity</h2></th>";
                                                html = html +"<th><h2 style='20px'>Country</h2></th>";
                                            }
                                            
                                            
                                            html = html +"</tr>";

                                            //Generates the contents of the table depending on the multi select

                                           //001
                                           if((actSelect==null)&&(fssSelect == null)&&(colSelect != null))
                                           {
                                               
                                               for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCauseOfLoss() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                               
                                           }
                                           //010
                                           else if((actSelect==null)&&(fssSelect != null)&&(colSelect == null))
                                           {
                                            
                                               for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getFoodSupplyStage() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                               
                                           }
                                           //011
                                           else if((actSelect==null)&&(fssSelect != null)&&(colSelect != null))
                                           {
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getFoodSupplyStage() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCauseOfLoss() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                           //100
                                           else if((actSelect!=null)&&(fssSelect == null)&&(colSelect == null))
                                           {
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getActivity() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                           //101
                                           else if((actSelect!=null)&&(fssSelect == null)&&(colSelect != null))
                                           {
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getActivity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCauseOfLoss() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                           //110
                                           else if((actSelect!=null)&&(fssSelect != null)&&(colSelect == null))
                                           {
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getActivity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getFoodSupplyStage() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                           //111
                                           else if((actSelect!=null)&&(fssSelect != null)&&(colSelect != null))
                                           {
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getActivity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getFoodSupplyStage() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCauseOfLoss() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                           //000
                                           else
                                           {
                                            html = html + "<tr>";
                                            for (LossPercentageData entry : TableData) {
                                                html = html + "<tr>";
                                                html = html + "<td> <h3>" + entry.getYear() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getPercentageLoss() + "%</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCommodity() + "</h3> </td>";
                                                html = html + "<td> <h3>" + entry.getCountryName() + "</h3> </td>";
                                                html = html + "</tr>";
                                            }
                                           }
                                html = html + "</table>";
                                
                                
                                // html = html + "<p>Test Text Trust Me</p>";
                        // html = html + "</div>";







        //Debug
        // html = html + "<p>" + key1 + "</p>";
        // html = html + "<p>" + years1 + "</p>";
        // html = html + "<p>" + years2 + "</p>";

        //Close 2bGraphtable
        html = html + "</div>";
        //Close Timed Data
        html = html + "</div>";
        //Close two-a-Content
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
