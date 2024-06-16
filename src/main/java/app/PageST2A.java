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
        html = html + """
                    <div class='timed-search-box'>
                        <h3>Present Data</h3>
                        <select name="period" id="period">
                            <option value="between">Between</option>
                            <option value="from">From</option>
                        </select>
                        <select name="first-year" id="first-year">
                        """;

                        ArrayList<String> years = jdbc.getAllYears();

                        for (String year : years) {
                            html = html + "<option value='" + year + "'>" + year + "</option>";
                        }

        html = html + """
                        </select>
                        <h3>and</h3> 
                        <select name="second-year" id="second-year">
                        """;

                        for (String year : years) {
                            html = html + "<option value='" + year + "'>" + year + "</option>";
                        }
        
        html = html + """
                        </select>
                    </div>
                    <div class='graph-grid'>
                        <div class='scroll-menus'>
                            <div class='scroll-menu'>
                                <div class='scroll-menu-title'>
                                    <h2>Country</h2>
                                </div>
                                <div class='scroll-menu-items'> """;

                                ArrayList<Country> countryNames = jdbc.getAllCountries();

                                for (Country name : countryNames) {
                                    html = html + "<a><input type='radio' id='" + name.getM49Code() + "' name='chosen-countries' value='" + name.getName() + "'>";
                                    html = html + "<label for='" + name.getM49Code() + "'>" + name.getName() + "</label></a>";
                                }
            html = html + """
                                </div>
                            </div>
                            <div class='scroll-menu'>
                                <div class='scroll-menu-title'>
                                    <h2>Filter</h2>
                                </div>
                                <div class='scroll-menu-items'>
                                    <a><input type='checkbox' id='commodity' name='chosen-filter' value='commodity' checked='checked'>
                                        <label for='commodity'>Commodity</label></a>
                                    <a><input type='checkbox' id='activity' name='chosen-filter' value='activity'>
                                        <label for='activity'>Activity</label></a>
                                    <a><input type='checkbox' id='food-supply-stage' name='chosen-filter' value='food-supply-stage'>
                                        <label for='food-supply-stage'>Food Supply Stage</label></a>
                                    <a><input type='checkbox' id='cause-of-loss' name='chosen-filter' value='cause-of-loss'>
                                        <label for='cause-of-loss'>Cause Of Loss</label></a>
                                </div>
                            </div>
                        </div>
                        </form>
                                    """;

                        //Get either 'between' or 'from'
                        String period = context.formParam("period");
                        //Get first year
                        String firstYear = context.formParam("first-year");
                        //Get second year
                        String secondYear = context.formParam("second-year"); 
                        //Get chosen countries
                        String country = context.formParam("chosen-countries");
                        //Get chosen countries
                        String filter = context.formParam("chosen-filter");

                html = html + """
                        <div class='line-graph'>
                            <canvas id="line-graph"></canvas>
                            <button type='submit' class='button'>Reload Graph</button>
                            <script> """;

                            if ((Objects.nonNull(period)) && (Objects.nonNull(firstYear)) && (Objects.nonNull(secondYear)) && (Objects.nonNull(country))) {
                                ArrayList<Commodity> commodityList = jdbc.parse2ADataXValues(period, firstYear, secondYear, country);
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
