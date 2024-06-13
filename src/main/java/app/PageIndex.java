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

public class PageIndex implements Handler {
    WebsiteElementBuilder elements = new WebsiteElementBuilder();
    JDBCConnection jdbc = new JDBCConnection();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";

        html = html + elements.getExtraCSS();

        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add the topelements
        html = html + elements.getNavBar();

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

        // Add HTML for the damages section
        html = html + """
            <div class='damages-section'>
                <div class='damages-heading-grid'>
                    <h2>Let us take a look at the <br>damages...</h2>
                    <div class='damages-tooltip'>
                        <h3>High Impact Data</h3>
                        <p>An overview of the food loss waste percentages. 
                            Commodities on the left have a large percentage of 
                                food waste while commodites on the right have the least</p>
                        <h4>1966 - 2002</h4>
                    </div>
                </div>
                <div class='damages-tables-grid'>
                    <div class='damages-table'>
                        <table>
                            <tr>
                                <th>Country</th>
                                <th>Percentage</th>
                            </tr> """;
                            ArrayList<Commodity> top5Commodities = jdbc.getTop5Commodities();

                            for (Commodity top5 : top5Commodities) {
                                html = html + "<tr>";
                                html = html + "<td><h3>" + top5.getCommodity() + "</h3></td>";
                                if (top5.getLoss_Percentage() >= 9.0) {
                                    html = html + "<td><h4 target='red'>" + top5.getLoss_Percentage() + "%</h4></td>";
                                } else {
                                    html = html + "<td><h4>" + top5.getLoss_Percentage() + "%</h4></td>";
                                }
                                html = html + "</tr>";
                            }
        html = html + """
                        </table>
                    </div>
                    <div class='damages-table'>
                        <table>
                            <tr>
                                <th>Country</th>
                                <th>Percentage</th>
                            </tr> """;

                            ArrayList<Commodity> next5Commodities = jdbc.getNext5Commodities();

                            for (Commodity top5 : next5Commodities) {
                                html = html + "<tr>";
                                html = html + "<td><h3>" + top5.getCommodity() + "</h3></td>";
                                if (top5.getLoss_Percentage() >= 9.9) {
                                    html = html + "<td><h4 target='red'>" + top5.getLoss_Percentage() + "</h4></td>";
                                } else {
                                    html = html + "<td><h4>" + top5.getLoss_Percentage() + "%</h4></td>";
                                }
                                html = html + "</tr>";
                            }
        html = html + """
                        </table>
                    </div>
                </div>
                <div class='damages-button'>
                    <a href='/page2A.html'>
                        <button class="button">Show More</button>
                    </a>
                </div>
            </div>
            """;

        // Add HTML for the businesses section
        html = html + """
            <div class='business-section'>
                <div class='business-heading-grid'>
                    <h2>What businesses are doing to <br>
                    help this social challenge</h2>
                </div>
                <div class='business-item-grid'>
                    <div class='business-item'>
                        <h3>Woolworths</h3>
                        <p>OzHarvest distributes our surplus fresh food from our
                                 supermarkets and Metro stores to over 1,500 charities across the nation
                                         to help Australians in need of food relief.</p>
                        <div class='business-button'>
                            <a href='https://www.woolworthsgroup.com.au/au/en/sustainability/Planet/food-waste.html#:~:text=OzHarvest%20distributes%20our%20surplus%20fresh,reach%20more%20than%202%2C400%20charities.' target=”_blank”>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                    <div class='business-item'>
                        <h3>Coles</h3>
                        <p>Our first choice for unsold, edible food is to donate it to food rescue organisations such as Secondbite and Foodbank. Following that, we have other food waste solutions including donations to farmers and animal or wildlife services, organics collections and in-store food waste disposal equipment.</p>
                        <div class='business-button'>
                            <a href='https://www.coles.com.au/about/sustainability/foodwaste' target=”_blank”>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class='business-item-grid'>
                    <div class='business-item'>
                        <h3>StarBucks</h3>
                        <p>In 2016, Starbucks partners (employees) advocated for a program that would allow stores to donate unsold food and distribute it to people facing hunger in communities across the U.S. In response, Starbucks partnered with Feeding America®, and other hunger-relief organizations to create a sustainable food rescue program – FoodShare – that diverts surplus food from landfills and donate it to people facing hunger</p>
                        <div class='business-button'>
                            <a href='https://stories.starbucks.com/stories/hunger-relief/' target=”_blank”>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                    <div class='business-item'>
                        <h3>Fruit Leather</h3>
                        <p>Over the years we have been experimenting on how to convert wasted fruit into leather-like material. By doing so, we are able to bring an eco-friendly and animal-friendly product to the market. Fruitleather is a versatile material which can be made into footwear, fashion accessories, upholstery, furnishing, and more</p>
                        <div class='business-button'>
                            <a href='https://fruitleather.nl/introduction-2/#:~:text=Over%20the%20years%20we%20have,upholstery%2C%20furnishing%2C%20and%20more' target=”_blank”>
                                <button class="button">Learn More</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        """;

        // // Close Content div
        html = html + "</div>";

        // Footer
        html = html + elements.getFooter();

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }
}
