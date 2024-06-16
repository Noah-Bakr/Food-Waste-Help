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

public class PageST3A implements Handler {
    WebsiteElementBuilder elements = new WebsiteElementBuilder();
    JDBCConnection jdbc = new JDBCConnection();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Sub Task 3.A</title>";

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
                            <h2>Locations with similar food<br>
                                loss/waste percentages</h2>
                        </div>
                    </div>
                    <form action='/page3A.html' method='post'>
                    <div class='timed-search-box'>
                        <h3>Countries Similiar to</h3>
                        <select name="country" id="country">""";

                        ArrayList<Country> countryNames = jdbc.getAllCountries();

                        for (Country name : countryNames) {
                            html = html + "<option value='" + name.getName() + "'>" + name.getName() + "</option>";
                        }
                    
        html = html + """
                        </select>
                        <h3>from</h3> 
                        <select name="first-year" id="first-year">
                            """;

                        ArrayList<String> years = jdbc.getAllYears();

                        for (String year : years) {
                            html = html + "<option value='" + year + "'>" + year + "</option>";
                        }

        html = html + """
                        </select>
                    </div>
                    <div class='graph-grid'>
                        <div class='scroll-menu' id='similarity-menu'>
                            <div class='scroll-menu-title'>
                                <h2>Similarity</h2>
                            </div>
                            <div class='similarity-menu-items'> 
                                <div class='similarity-decision'>
                                    <h5>Is decided on:</h5>
                                    <div class='similarity-radio'>
                                        <div>
                                            <input type="radio" id="products" name="decision" value="products" checked="checked">
                                                <label for="products">The food products</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="loss" name="decision" value="loss">
                                                <label for="loss">Overall food loss/waste</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="both" name="decision" value="both">
                                                <label for="both">Both</label>
                                        </div>
                                    </div>
                                </div>

                                <div class='similarity-determination'>
                                    <h5>Determined by:</h5>
                                    <div class='similarity-radio'>
                                        <div>    
                                            <input type="radio" id="absolute" name="determination" value="absolute" checked="checked">
                                                <label for="absolute">The absolute values</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="overlap" name="determination" value="overlap">
                                                <label for="overlap">The level of overlap/waste</label>
                                        </div>
                                    </div>
                                </div>

                                <div class='similarity-dropdown'>
                                    <h5>No. of items</h5>
                                    <select name="items-no" id="items-no">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="20">20</option>
                                        <option value="25">25</option>
                                    </select>
                                </div>
                                <div class='similarity-button'>
                                    <button type='submit' class='button'>Reload List</button>
                                </div>
                            </div>
                        </div>
                    </form>
                        <div class='line-graph'>
                            <canvas id="line-graph"></canvas>
                            <script>
                            const xValues = [50,60,70,80,90,100,110,120,130,140,150];
                            const yValues = [7,8,8,9,9,9,10,11,14,14,15];

                            new Chart("line-graph", {
                            type: "line",
                            data: {
                                labels: xValues,
                                datasets: [{
                                fill: false,
                                lineTension: 0,
                                backgroundColor: "rgba(0,0,255,1.0)",
                                borderColor: "rgba(0,0,255,0.1)",
                                data: yValues
                                }]
                            },
                            options: {
                                legend: {display: false},
                                scales: {
                                yAxes: [{ticks: {min: 6, max:16}}],
                                }
                            }
                            });
                            </script>
                        </div>
                    </div>
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
