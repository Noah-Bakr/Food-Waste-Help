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
        html = html + nav.getExtraCSS();
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + nav.getNavBar();

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Subtask 2.B</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";
        
        JDBCConnection jdbc = new JDBCConnection();

        // Add HTML for the page content
        html = html + """
            <p>Subtask 2.B page content</p>
            """;
// Form Start----------------------------------------------------------------------------------
        html = html + "<form action='/page2B.html' method='post'>";

        html = html + "<button type='submit' class='searchButton'>Search</button>";

        html = html + """
                <label for="dropdownGroups">Select groups to display:</label>
                    <select name="selectedGroups" id="dropdownGroups">
                """;
    ArrayList<String> listGroupNames = jdbc.getAllGroupsName();

    for (String output : listGroupNames) {
        html = html + "<option value='" + output +"'>" + output + "</option>";
        }  

        

        html = html + "</form>";
// Form End ------------------------------------------------------------------------------------

String key1 = context.formParam("selectedGroups");

        html = html + "<p>" + key1 + "</p>";
        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr24)</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
