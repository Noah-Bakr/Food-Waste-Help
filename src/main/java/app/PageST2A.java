package app;

import java.util.ArrayList;

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
                    <div class='timed-search-box'>
                        <h3>Present Data</h3>
                        <select name="period" id="period">
                            <option value="between">Between</option>
                            <option value="from">From</option>
                        </select>
                        <select name="first-year" id="first-year">
                            <option value="1966">1966</option>
                            <option value="1967">1967</option>
                        </select>
                        <h3>and</h3> 
                        <select name="second-year" id="second-year">
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                        </select>
                    </div>
                    <div class='graph-grid'>
                        <div class='scroll-menu'>
                            <div class='scroll-menu-title'>
                                <h2>Country</h2>
                            </div>
                            <div class='scroll-menu-items'> """;

                            ArrayList<Country> countryNames = jdbc.getAllCountries();

                            for (Country name : countryNames) {
                                html = html + "<a><input type='checkbox' id='" + name.getM49Code() + "' name='" + name.getM49Code() + "' value='" + name.getName() + "'>";
                                html = html + "<label for='" + name.getM49Code() + "'>" + name.getName() + "</label></a>";
                            }
                                
        html = html + """
                            </div>
                        </div>
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

        // Add header content
        //Image Credits: https://stock.adobe.com/au/Library/urn:aaid:sc:AP:726decc2-5dcc-4f8c-9401-fc8719bcff2e?asset_id=118175173
        html = html + """
            <div id='header-grid' class='header-section'>
                <div class='header'>
                    <h1>The Road to a <br>
                    Greener Future <br>
                    Starts With You.</h1>
                    <div class='header-button'>
                        <a href='mission.html'>
                            <button class="button">Learn More</button>
                        </a>
                    </div>
                </div>
                <div>
                    <img src='./AdobeStock_LandingPageVeggies.jpeg' class='top-image' alt='Fresh Veggies'>
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
