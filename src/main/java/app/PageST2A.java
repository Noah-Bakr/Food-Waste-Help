package app;

import java.util.ArrayList;
import java.util.Objects;

import org.sqlite.JDBC;

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

public class PageST2A implements Handler {
    WebsiteElementBuilder elements = new WebsiteElementBuilder();
    JDBCConnection jdbc = new JDBCConnection();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Sub Task 2.A</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js'></script>";

        html = html + elements.getExtraCSS();

        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add Div for page Content
        html = html + "<div class='two-a-content'>";

        // Add the topelements
        html = html + elements.getNavBar();

        // Add line graph section
        html = html + """
                <div class='timed-data'>
                    <div class='timed-data-header'>
                        <div class='timed-data-title'>
                            <h3>World Data</h3>
                            <h4>1966 - 2022</h4>
                        </div>
                        <div class='timed-data-info'>
                            <h2>Food loss and waste changes<br>
                                for user selected Countries</h2>
                        </div>
                    </div>      
                    """;
        html = html + "<form action='/page2A.html' method='post'>";
                        String period = context.formParam("period");
        html = html + """
                    <div class='timed-search-box'>
                        <h3>Present Data</h3>
                        <select name="period" id="period">""";

                        if (period.equals("between")) {
                            html = html + "<option value='between' selected='selected'>Between</option>";
                            html = html + "<option value='from'>From</option>";
                        } else if (period.equals("from")) {
                            html = html + "<option value='between'>Between</option>";
                            html = html + "<option value='from' selected='selected'>From</option>";
                        } else {
                            html = html + "<option value='between' selected='selected'>Between</option>";
                            html = html + "<option value='from'>From</option>";
                        }
                            
        html = html + """
                        </select>
                        <select name="first-year" id="first-year">
                        """;

                        ArrayList<String> years = jdbc.getAllYears();

                        String firstYear = context.formParam("first-year");

                        for (String year : years) {
                            if (year.equals(firstYear)) {
                                html = html + "<option value='" + year + "'selected='selected'>" + year + "</option>";
                            } else {
                                html = html + "<option value='" + year + "'>" + year + "</option>";
                            }
                        }

        html = html + """
                        </select>
                        <h3>and</h3> 
                        <select name="second-year" id="second-year">
                        """;
                        ArrayList<String> yearsInv = jdbc.getAllYearsInverted();

                        String secondYear = context.formParam("second-year"); 
                        for (String year : yearsInv) {
                            if (year.equals(secondYear)) {
                                html = html + "<option value='" + year + "'selected='selected'>" + year + "</option>";
                            } else {
                                html = html + "<option value='" + year + "'>" + year + "</option>";
                            }
                        }
        
        html = html + """
                        </select>
                    </div>
                    <div class='graph-grid'>
                        <div class='scroll-menus'>
                            <div class='country-menu'>
                                <div class='scroll-menu-title'>
                                    <h2>Country</h2>
                                </div>
                                
                                <select name="chosen-countries" id="country"> """;

                                ArrayList<Country> countryNames = jdbc.getAllCountries();

                                String country = context.formParam("chosen-countries");

                                for (Country name : countryNames) {
                                    if (name.getName().equals(country)) {
                                        html = html + "<option value='" + name.getName() + "'selected='selected'>" + name.getName() + "</option>";

                                    } else {
                                        html = html + "<option value='" + name.getName() + "'>" + name.getName() + "</option>";
                                    }
                                }
            html = html + """
                                </select>
                                
                            </div>
                            <div class='scroll-menu'>
                                <div class='scroll-menu-title'>
                                    <h2>Filter</h2>
                                </div>
                                <div class='scroll-menu-items'>""";

                                java.util.List<String> filter = context.formParams("chosen-filter");

                                int commodity = 0;
                                int activity = 0;
                                int fss = 0;
                                int col = 0;

                                for (int i = 0; i < filter.size(); i++) {
                                    if (filter.get(i).equals("commodity")) {
                                        commodity++;
                                    } else if (filter.get(i).equals("activity")) {
                                        activity++;
                                    } else if (filter.get(i).equals("food_supply_stage")) {
                                        fss++;
                                    } else if (filter.get(i).equals("cause_of_loss")) {
                                        col++;
                                    }
                                }
                                //Commodity
                                if (commodity == 1) {
                                    html = html + """
                                        <a><input type='checkbox' id='commodity' name='chosen-filter' value='commodity' checked='checked'>
                                    <label for='commodity'>Commodity</label></a>""";
                                } else {
                                        html = html + """
                                        <a><input type='checkbox' id='commodity' name='chosen-filter' value='commodity'>
                                    <label for='commodity'>Commodity</label></a>""";
                                } 
                                //Acitivity
                                if (activity == 1) {
                                    html = html + """
                                        <a><input type='checkbox' id='activity' name='chosen-filter' value='activity' checked='checked'>
                                        <label for='activity'>Activity</label></a>""";
                                } else {
                                    html = html + """
                                        <a><input type='checkbox' id='activity' name='chosen-filter' value='activity'>
                                        <label for='activity'>Activity</label></a>""";
                                }
                                //Food Supply Stage
                                if (fss == 1) {
                                    html = html + """
                                        <a><input type='checkbox' id='food-supply-stage' name='chosen-filter' value='food_supply_stage' checked='checked'>
                                        <label for='food-supply-stage'>Food Supply Stage</label></a>""";
                                } else {
                                    html = html + """
                                        <a><input type='checkbox' id='food-supply-stage' name='chosen-filter' value='food_supply_stage'>
                                        <label for='food-supply-stage'>Food Supply Stage</label></a>""";
                                }
                                //Cause of Loss
                                if (col == 1) {
                                    html = html + """
                                        <a><input type='checkbox' id='cause-of-loss' name='chosen-filter' value='cause_of_loss' checked='checked'>
                                        <label for='cause-of-loss'>Cause Of Loss</label></a>""";
                                } else {
                                    html = html + """
                                        <a><input type='checkbox' id='cause-of-loss' name='chosen-filter' value='cause_of_loss'>
                                        <label for='cause-of-loss'>Cause Of Loss</label></a>""";
                                }
                                    
            html = html + """
                                </div>
                            </div>
                            <button type='submit' class='button'>Reload Data</button>
                        </div>
                        </form>
                                    """;

                        //Get either 'between' or 'from' (previously defined)
                        period = context.formParam("period");
                        //Get first year (previously defined)
                        firstYear = context.formParam("first-year");
                        //Get second year (previously defined)
                        secondYear = context.formParam("second-year"); 
                        //Get chosen countries (previously defined)
                        country = context.formParam("chosen-countries");
                        //Get chosen filters (previously defined)
                        filter = context.formParams("chosen-filter");
                        

                html = html + """
                        <div class='data-rep2A'>
                            <div class='line-graph'>
                                <canvas id="line-graph"></canvas>
                                <script> """;

                                if ((Objects.nonNull(period)) && (Objects.nonNull(firstYear)) && (Objects.nonNull(secondYear)) && (Objects.nonNull(country))) {
                                    ArrayList<Commodity> commodityList = jdbc.parse2ADataXValues(period, firstYear, secondYear, country, filter);
                                    //x values (year)
                                    html = html + "const xValues = [";
                                    for (Commodity commodityX : commodityList) {
                                        html = html + commodityX.getYear() + ",";
                                    }
                                    html = html + "];";
                                    //y values (food loss percent)
                                    html = html + "const yValues = [";
                                    for (Commodity commodityY : commodityList) {
                                        html = html + Double.toString(commodityY.getLoss_Percentage()) + ",";
                                    }
                                    html = html + "];";
                                } else {
                                    html = html + "const xValues = [50,60,70,80,90,100,110,120,130,140,150];";
                                    html = html + "const yValues = [7,8,8,9,9,9,10,11,14,14,15];";
                                }
                                
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
                            </div>

                            <div class='twoA-table'>
                                <table> """;

                                    if ((Objects.nonNull(period)) && (Objects.nonNull(firstYear)) && (Objects.nonNull(secondYear)) && (Objects.nonNull(country)) && (Objects.nonNull(filter))) {
                                        ArrayList<Commodity> cl = jdbc.parse2ADataTable(period, firstYear, secondYear, country, filter); 
                                        html = html + "<tr>";
                                        for (int i = 0; i < filter.size(); i++) {
                                            String str = null;
                                            if (filter.get(i).equals("commodity")) {
                                                str = "Commodity";
                                            } else if (filter.get(i).equals("activity")) {
                                                str = "Activity";
                                            } else if (filter.get(i).equals("food_supply_stage")) {
                                                str = "Food Supply Stage";
                                            } else if (filter.get(i).equals("cause_of_loss")) {
                                                str = "Cause of Loss";
                                            }
                                            
                                            html = html + "<th><h2>" + str + "<h2></th>";
                                        }

                                        html = html + "<th><h2>Loss Percentage<h2></th>";
                                        html = html + "<th><h2>Year<h2></th>";
                                        html = html + "</tr>";

                                        for (Commodity entry : cl) {
                                            html = html + "<tr>";
                                            for (int j = 0; j < filter.size(); j++) {
                                                if (filter.get(j).equals("commodity")) {
                                                    html = html + "<td><h3>" + entry.getCommodity() + "</h3></td>";
                                                } else if (filter.get(j).equals("activity")) {
                                                    html = html + "<td><h3>" + entry.getActivity() + "</h3></td>";
                                                } else if (filter.get(j).equals("food_supply_stage")) {
                                                    html = html + "<td><h3>" + entry.getFSS() + "</h3></td>";
                                                } else if (filter.get(j).equals("cause_of_loss")) {
                                                    html = html + "<td><h3>" + entry.getCOL() + "</h3></td>";
                                                }
                                            }
                                            html = html + "<td><h3>" + entry.getLoss_Percentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getYear() + "</h3></td>";
                                        }
                                        
                                            html = html + "</tr>";
                                    }
                                    
                html = html + """
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                """;

        html = html + """
                <div class=''>
                </div>
                """;
        // Footer
        html = html + elements.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
