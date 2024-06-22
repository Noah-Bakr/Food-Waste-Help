package app;

import java.util.ArrayList;
import java.util.Objects;

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
                        <select name="chosen-countries" id="country">""";

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
                        <h3>from</h3> 
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
                    </div>
                    <div class='graph-grid'>
                        <div class='scroll-menu' id='similarity-menu'>
                            <div class='scroll-menu-title'>
                                <h2>Similarity</h2>
                            </div>
                            <div class='similarity-menu-items'> 
                                <div class='similarity-decision'>
                                    <h5>Is decided on:</h5>
                                    <div class='similarity-radio'>""";

                                    String decision = context.formParam("decision");

                                    if (Objects.isNull(decision)) {
                                        html = html + """
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
                                                """;
                                    } else {
                                        if (decision.equals("products")) {
                                            html = html + """
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
                                                    """;
                                        } else if (decision.equals("loss")) {
                                            html = html + """
                                                <div>
                                                <input type="radio" id="products" name="decision" value="products">
                                                    <label for="products">The food products</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="loss" name="decision" value="loss" checked="checked">
                                                        <label for="loss">Overall food loss/waste</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="both" name="decision" value="both">
                                                        <label for="both">Both</label>
                                                </div>
                                                    """;
                                        } else if (decision.equals("both")) {
                                            html = html + """
                                                <div>
                                                <input type="radio" id="products" name="decision" value="products">
                                                    <label for="products">The food products</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="loss" name="decision" value="loss">
                                                        <label for="loss">Overall food loss/waste</label>
                                                </div>
                                                <div>
                                                    <input type="radio" id="both" name="decision" value="both" checked="checked">
                                                        <label for="both">Both</label>
                                                </div>
                                                    """;
                                        }
                                    }
        html = html + """
                                    </div>
                                </div>

                                <div class='similarity-determination'>
                                    <h5>Determined by:</h5>
                                    <div class='similarity-radio'>""";

                                    String determination = context.formParam("determination");

                                    if (Objects.nonNull(determination)) {
                                        if (determination.equals("absolute")) {
                                            html = html + """
                                            <div>    
                                                <input type="radio" id="absolute" name="determination" value="absolute" checked="checked">
                                                    <label for="absolute">The absolute values</label>
                                            </div>
                                            <div>
                                                <input type="radio" id="overlap" name="determination" value="overlap">
                                                    <label for="overlap">The level of overlap/waste</label>
                                            </div>""";
                                        } else if (determination.equals("overlap")) {
                                            html = html + """
                                            <div>    
                                                <input type="radio" id="absolute" name="determination" value="absolute">
                                                    <label for="absolute">The absolute values</label>
                                            </div>
                                            <div>
                                                <input type="radio" id="overlap" name="determination" value="overlap" checked="checked">
                                                    <label for="overlap">The level of overlap/waste</label>
                                            </div>""";
                                        }
                                    } else {
                                        html = html + """
                                        <div>    
                                            <input type="radio" id="absolute" name="determination" value="absolute" checked="checked">
                                                <label for="absolute">The absolute values</label>
                                        </div>
                                        <div>
                                            <input type="radio" id="overlap" name="determination" value="overlap">
                                                <label for="overlap">The level of overlap/waste</label>
                                        </div>""";
                                    }
        html = html + """
                                    </div>
                                </div>

                                <div class='similarity-dropdown'>
                                    <h5>No. of items</h5>
                                    <select name="items-no" id="items-no">""";

                                    String itemsNo = context.formParam("items-no");

                                    if (Objects.nonNull(itemsNo)) {
                                        if (itemsNo.equals("5")) {
                                            html = html + """
                                                <option value="5" selected='selected'>5</option>
                                                <option value="10">10</option>
                                                <option value="15">15</option>
                                                <option value="20">20</option>
                                                <option value="25">25</option>
                                                    """;
                                        } else if (itemsNo.equals("10")) {
                                            html = html + """
                                                <option value="5">5</option>
                                                <option value="10" selected='selected'>10</option>
                                                <option value="15">15</option>
                                                <option value="20">20</option>
                                                <option value="25">25</option>
                                                    """;
                                        } else if (itemsNo.equals("15")) {
                                            html = html + """
                                                <option value="5">5</option>
                                                <option value="10">10</option>
                                                <option value="15" selected='selected'>15</option>
                                                <option value="20">20</option>
                                                <option value="25">25</option>
                                                    """;
                                        } else if (itemsNo.equals("20")) {
                                            html = html + """
                                                <option value="5">5</option>
                                                <option value="10">10</option>
                                                <option value="15">15</option>
                                                <option value="20" selected='selected'>20</option>
                                                <option value="25">25</option>
                                                    """;
                                        } else if (itemsNo.equals("25")) {
                                            html = html + """
                                                <option value="5">5</option>
                                                <option value="10">10</option>
                                                <option value="15">15</option>
                                                <option value="20">20</option>
                                                <option value="25" selected='selected'>25</option>
                                                    """;
                                        }
                                    } else {
                                        html = html + """
                                            <option value="5" selected='selected'>5</option>
                                            <option value="10">10</option>
                                            <option value="15">15</option>
                                            <option value="20">20</option>
                                            <option value="25">25</option>
                                                """;
                                    } 
        html = html + """                                
                                    </select>
                                </div>
                                <div class='similarity-button'>
                                    <button type='submit' class='button'>Reload List</button>
                                </div>
                            </div>
                        </div>
                    </form>""";

                    //Get selected country
                    country = context.formParam("chosen-countries");
                    //Get year
                    firstYear = context.formParam("first-year");
                    //Get Decision
                    decision = context.formParam("decision"); 
                    //Get determination selection
                    determination = context.formParam("determination");
                    //Get No of items to return
                    itemsNo = context.formParam("items-no");
                    //ASC or DESC
                    
                    String orderBy = context.formParam("order-by");

                    if (Objects.isNull(orderBy)) {
                        orderBy = "desc";
                    }

                    html = html + """
                        <div class='twoA-table' id='threeA-table'>
                                    <div class="order-by">
                                        <div>""";
                                            
                                            if (orderBy.equals("asc")) {
                                                html = html + """
                                                    <label>
                                                        <input type="radio" id='asc' name="order-by" value='asc' checked="checked">
                                                        <span>Ascending</span>
                                                    </label>
                                                    <label>
                                                        <input type="radio" id='desc' name="order-by" value='desc'>
                                                        <span>Descending</span>
                                                    </label>
                                                        """;
                                            } else if (orderBy.equals("desc")) {
                                                html = html + """
                                                    <label>
                                                        <input type="radio" id='asc' name="order-by" value='asc'>
                                                        <span>Ascending</span>
                                                    </label>
                                                    <label>
                                                        <input type="radio" id='desc' name="order-by" value='desc' checked="checked">
                                                        <span>Descending</span>
                                                    </label>
                                                        """;
                                            } else {
                                                html = html + """
                                                    <label>
                                                        <input type="radio" id='asc' name="order-by" value='asc'>
                                                        <span>Ascending</span>
                                                    </label>
                                                    <label>
                                                        <input type="radio" id='desc' name="order-by" value='desc' checked="checked">
                                                        <span>Descending</span>
                                                    </label>
                                                        """;
                                            }
                                            
                    html = html + """
                                        </div>
                                    </div>
                                <table> """;

                                    if ((Objects.nonNull(country)) && (Objects.nonNull(firstYear)) && (Objects.nonNull(decision)) && (Objects.nonNull(determination)) && (Objects.nonNull(itemsNo)) && (Objects.nonNull(orderBy))) {
                                        ArrayList<Country> data = jdbc.parse3ADataTable(country, firstYear, decision, determination, itemsNo, orderBy); 
                                        
                                        if (decision.equals("loss")) {
                                            html = html + "<tr>";

                                            html = html + "<th><h2>Country<h2></th>";
                                            html = html + "<th><h2>Loss Percentage<h2></th>";
                                            html = html + "<th><h2>Year<h2></th>";
                                            html = html + "<th><h2>Similarity Score<h2></th>";
                                            html = html + "</tr>";

                                        for (Country entry : data) {
                                            html = html + "<tr>";
                                            
                                            html = html + "<td><h3>" + entry.getName() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getLossPercentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getYear() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarityPercentage() + "</h3></td>";
                                            html = html + "</tr>";
                                            }
                                        } else if (decision.equals("products")) {
                                            html = html + "<tr>";

                                            html = html + "<th><h2>Country<h2></th>";
                                            html = html + "<th><h2>No. of Similar Commodities<h2></th>";
                                            html = html + "<th><h2>Similarity Score<h2></th>";
                                            html = html + "<th><h2>Year<h2></th>";
                                            html = html + "</tr>";

                                        for (Country entry : data) {
                                            html = html + "<tr>";
                                            
                                            html = html + "<td><h3>" + entry.getName() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarCommoditiesNo() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarityPercentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getYear() + "</h3></td>";
                                            html = html + "</tr>";
                                            }
                                        } else if (decision.equals("both")) {
                                            html = html + "<tr>";

                                            html = html + "<th><h2>Country<h2></th>";
                                            html = html + "<th><h2>No. of Similar Commodities<h2></th>";
                                            html = html + "<th><h2>Similarity Score (COM)<h2></th>";
                                            html = html + "<th><h2>Loss Percentage<h2></th>";
                                            html = html + "<th><h2>Similarity Score (FL)<h2></th>";
                                            html = html + "<th><h2>Similarity Total<h2></th>";
                                            html = html + "<th><h2>Year<h2></th>";
                                            html = html + "</tr>";

                                        for (Country entry : data) {
                                            html = html + "<tr>";
                                            
                                            html = html + "<td><h3>" + entry.getName() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarCommoditiesNo() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarCommoditiesPercentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getLossPercentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarCommoditiesLossPercentage() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getSimilarityPercentageTotal() + "</h3></td>";
                                            html = html + "<td><h3>" + entry.getYear() + "</h3></td>";
                                            html = html + "</tr>";
                                            }
                                        }
                                    }
                    html = html + """
                            </table>
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
