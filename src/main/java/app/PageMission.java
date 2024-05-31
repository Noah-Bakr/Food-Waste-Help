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

public class PageMission implements Handler {
    WebsiteElementBuilder nav = new WebsiteElementBuilder();

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Our Mission</title>";

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
                <h1>Our Mission</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <h1>How the website addresses the social challenge</h1>
            """;

        html = html + "<p>The website addresses the social challenge by providing a simple to use as well as intuitive design that allows for people experienced in food waste to find information surrounding the topic. For new users and people who are less knowledgeable about food waste the site allows them to quickly find information as a place to get started. The graphs presented allow the user to filter based off many factors that they may want to know about, educating people about food waste in an easy to approach format with summaries for the general information someone new could want to know about and graphs containing data for people who are more knowledgeable.</p>";

        html = html + "<h1>Usage and primary functions</h1>";

        html = html + "<p>The site has multiple primary ways that it can be used depending on what the intended user wants to do. If the user is new or does not understand much about food waste and just needs a summary, the website contains sections that allows for the user to read a brief summary of what food waste is and what the website aims to do to help prevent or educate about it. There is a section that informs new users of the most important information summarized in the form of a few small boxes, these will tell the user about percentage changes, this can also be repurposed into a grid that tells the user 8 or so (4 Increase, 4 Decrease) of the highest percentage changes within the year / averaged over a few years. For advanced users and people looking for more specific information, there may be one (possibly two depending on how it turns out) interactive charts, depending on how the end website layout ends up (One big page or many little pages with navigation) The simple graph will only allow customization of some parameters such as start and end year as well as categorizing by or choosing a country or a food group which will then be summarized into a simple graph. For the advanced usage graph it will provide more ways to filter through the data, possibly bringing thuser to a different area dedicated to the advanced graph that allows for sorting for specifics such as by specific food divisions as well as being able to compare the yearly food waste of different products side by side, this is on top of the other features that are provided in the simple graph menu on the main page.</p>";


        html = html + "<h1>The Creators</h1>";
        
        // This example uses JDBC to lookup the countries
        JDBCConnection jdbc = new JDBCConnection();

        ArrayList<Student> students = jdbc.getAllStudents();

        // Next we will ask this *class* for the Countries
        ArrayList<Country> countries = jdbc.getAllCountries();

        ArrayList<Persona> personas = jdbc.getAllPersonas();

        for(Student student : students)
        {
            // html = html + "<personaIntro>";
            html = html + "<p>"+student.getFirstName()+ " " + student.getLastName() + " | " + student.getStudentCode() + "</p>";
            
        }

        // Add HTML for the countries list
        // html = html + "<h1>All Countries in the foodloss database (using JDBC Connection)</h1>" + "<ul>";

        // Finally we can print out all of the Countries
        // for (Country country : countries) {
        //     html = html + "<li>" + country.getM49Code()
        //                 + " - " + country.getName() + "</li>";
        // }

            html = html + "<h1>Personas</h1>";

            //TODO Fix quotation marks breaking
        for(Persona persona : personas)
        {
            // html = html + "<personaIntro>";
            html = html + "<h2>"+persona.getName()+"</h2>";
            html = html + "<p>"+ persona.getAttributes() + " " + persona.getBackground() +"</p>";
            html = html + "<img src ='./" + persona.getImage() + "'class = 'persona_thumbnail'>";
            // html = html + "</personaIntro>";
            html = html + "<h3>Needs</h3>";
            html = html + "<p>" + persona.getNeeds() + "</p>";
            html = html + "<h3>Goals</h3>";
            html = html + "<p>" + persona.getGoals() + "</p>";
            html = html + "<h3>Skills and Experience</h3>";
            html = html + "<p>" + persona.getSkills() + "</p>";
        }

        // Finish the List HTML
        html = html + "</ul>";


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
