package app;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class JDBCConnection {

    // Name of database file (contained in database folder)
    public static final String DATABASE = "jdbc:sqlite:database/foodloss.db";

    /**
     * This creates a JDBC Object so we can keep talking to the database
     */
    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /**
     * Get all of the Countries in the database.
     * @return
     *    Returns an ArrayList of Country objects
     */
    public ArrayList<Country> getAllCountries() {
        // Create the ArrayList of Country objects to return
        ArrayList<Country> countries = new ArrayList<Country>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Country ORDER BY countryName ASC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String m49Code     = results.getString("m49code");
                String name  = results.getString("countryName");

                // Create a Country Object
                Country country = new Country(m49Code, name);

                // Add the Country object to the array
                countries.add(country);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return countries;
    }

    public ArrayList<String> getAllYears() {
        // Create the ArrayList of Country objects to return
        ArrayList<String> years = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT year FROM date ORDER BY year ASC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String year     = results.getString("year");

                // Add the Country object to the array
                years.add(year);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return years;
    }

    public ArrayList<String> getAllYearsInverted() {
        // Create the ArrayList of Country objects to return
        ArrayList<String> years = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT year FROM date ORDER BY year DESC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String year     = results.getString("year");

                // Add the Country object to the array
                years.add(year);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return years;
    }

    // TODO: Add your required methods here

    public ArrayList<Persona> getAllPersonas() {
        // Create the ArrayList of Country objects to return
        ArrayList<Persona> personas = new ArrayList<Persona>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Persona";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String perName = results.getString("NAME");
                String perImage = results.getString("PHOTO");
                String perAttributes = results.getString("ATTRIBUTES");
                String perBackground = results.getString("BACKGROUND");
                String perNeeds = results.getString("NEEDSLIST");
                String perGoals = results.getString("GOALSLIST");
                String perSkills = results.getString("SKILLSEXPERIENCE");

                // Create a Country Object
                Persona persona = new Persona(perName,perImage,perAttributes,perBackground,perNeeds,perGoals,perSkills);

                // Add the Country object to the array
                personas.add(persona);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return personas;
    }

    public ArrayList<Student> getAllStudents() {
        // Create the ArrayList of Country objects to return
        ArrayList<Student> students = new ArrayList<Student>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM Student";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String stuNumber = results.getString("NUMBER");
                String stuFname = results.getString("FNAME");
                String stuLname = results.getString("LNAME");
                

                // Create a Country Object
                Student student = new Student(stuNumber,stuFname,stuLname);

                // Add the Country object to the array
                students.add(student);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return students;
    }

    public ArrayList<String> getAllsubclassNames() {
        // Create the ArrayList of Country objects to return
        ArrayList<String> sclassNames = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM FoodSubclass ORDER BY Descriptor ASC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String groupName = results.getString("Descriptor");

                // Add the Country object to the array
                sclassNames.add(groupName);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return sclassNames;
    }

    public ArrayList<Commodity> getTop5Commodities() {
        // Create the ArrayList of Country objects to return
        ArrayList<Commodity> commodities = new ArrayList<Commodity>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT commodity, MAX(loss_percentage), year FROM completeEvents\n" + //
                            "GROUP BY commodity HAVING MAX(loss_percentage)\n" + //
                            "ORDER BY loss_percentage DESC LIMIT 5 OFFSET 5";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double scale = Math.pow(10, 2);

                String commodity     = results.getString("commodity");
                double loss_percentage     = Math.round(results.getDouble("MAX(loss_percentage)") * scale) / scale;

                Commodity commoditiesObj = new Commodity(commodity, loss_percentage);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    public ArrayList<Commodity> getNext5Commodities() {
        // Create the ArrayList of Country objects to return
        ArrayList<Commodity> commodities = new ArrayList<Commodity>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT commodity, MAX(loss_percentage), year FROM completeEvents\n" + //
            "GROUP BY commodity HAVING MAX(loss_percentage)\n" + //
            "ORDER BY loss_percentage ASC LIMIT 5";

            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double scale = Math.pow(10, 2);

                String commodity     = results.getString("commodity");
                double loss_percentage     = Math.round(results.getDouble("MAX(loss_percentage)") * scale) / scale;

                Commodity commoditiesObj = new Commodity(commodity, loss_percentage);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    //Task 2A line graph X values generator
    public ArrayList<Commodity> parse2ADataXValues(String period, String firstYear, String secondYear, String country, List<String> filter) {
        // Create the ArrayList of Country objects to return
        ArrayList<Commodity> commodities = new ArrayList<Commodity>();

        

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            //mixed year input error tolerance
            if (Integer.valueOf(firstYear) > Integer.valueOf(secondYear)) {
                String temp = secondYear;
                secondYear = firstYear;
                firstYear = temp;
            }

            //period choice
            if (period.equals("Between") || period.equals("between")) {
                period = " BETWEEN '" + firstYear + "' AND '" + secondYear + "'))\n";
            } else {
                period = " = '" + firstYear + "' OR '" + secondYear + "'))\n";
            }

            //checkbox column items
            String selected = String.join(", ", filter);

            

            // The Query
            String query = "SELECT commodity, AVG(loss_percentage), year FROM completeEvents\n" + //
                            "WHERE ((countryName = '" + country + "') AND (year" + period + //
                            "GROUP BY commodity, year HAVING AVG(loss_percentage) AND year NOT NULL\n" + //
                            "ORDER BY commodity, year ASC;";
                                
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double scale = Math.pow(10, 2);

                String commodityName          = results.getString("commodity");
                double AVGloss_percentage     = Math.round(results.getDouble("AVG(loss_percentage)") * scale) / scale;
                String year                   = results.getString("year");

                Commodity commoditiesObj = new Commodity(commodityName, AVGloss_percentage, year);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    //Task 2A table values generator
    public ArrayList<Commodity> parse2ADataTable(String period, String firstYear, String secondYear, String country, List<String> filter) {
        // Create the ArrayList of Country objects to return
        ArrayList<Commodity> commodities = new ArrayList<Commodity>();

        

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            //mixed year input error tolerance
            if (Integer.valueOf(firstYear) > Integer.valueOf(secondYear)) {
                String temp = secondYear;
                secondYear = firstYear;
                firstYear = temp;
            }

            //period choice
            if (period.equals("Between") || period.equals("between")) {
                period = " BETWEEN '" + firstYear + "' AND '" + secondYear + "'))\n";
            } else {
                period = " = '" + firstYear + "' OR '" + secondYear + "'))\n";
            }

            // The Query
            String query = "SELECT commodity, activity, food_supply_stage, cause_of_loss, AVG(loss_percentage), year FROM completeEvents\n" + //
                            "WHERE ((countryName = '" + country + "') AND (year" + period + //
                            "GROUP BY commodity, year HAVING AVG(loss_percentage) AND year NOT NULL\n" + //
                            "ORDER BY commodity, year ASC;";
                                
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double scale = Math.pow(10, 2);

                String commodityName          = results.getString("commodity");
                String activityName           = results.getString("activity");
                String fss                    = results.getString("food_supply_stage");
                String col                    = results.getString("cause_of_loss");

                double AVGloss_percentage     = Math.round(results.getDouble("AVG(loss_percentage)") * scale) / scale;
                String year                   = results.getString("year");

                Commodity commoditiesObj = new Commodity(commodityName, AVGloss_percentage, year, activityName, fss, col);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    //Task 3A table values generator
    public ArrayList<Country> parse3ADataTable(String country, String firstYear, String decision, String determination, String itemsNo, String orderBy) {
        // Create the ArrayList of Country objects to return
        ArrayList<Country> simCountries = new ArrayList<Country>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = null;
            if (determination.equals("absolute")) {
                if (decision.equals("loss")) {
                    // The Query
                    query = "SELECT countryName, AVG(loss_percentage), year, 100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentage' FROM completeEvents\n" + //
                            "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                            "GROUP BY countryName HAVING AVG(loss_percentage)\n" + //
    
                            "UNION\n" + //
    
                            "SELECT countryName, AVG(loss_percentage), year, 100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentage' FROM completeEvents\n" + //
                            "WHERE countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "GROUP BY countryName HAVING AVG(loss_percentage)\n" + //
                            "ORDER BY similarity_percentage " + orderBy + ", countryName\n" + //
                            "LIMIT " + itemsNo + ";";
                } else if (decision.equals("products")) {
                    // The Query
                    query = "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, (CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                "ORDER BY commodity)\n" + //
                                            "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                            "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0 AS 'similarity_percentage', year FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                            "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                            "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName = '" + country + "' AND year = '" + firstYear + "'\n" + //
    
                            "UNION\n" + //
    
                            "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, (CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                "ORDER BY commodity)\n" + //
                                            "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                            "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0 AS 'similarity_percentage', year FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                            "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                            "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "ORDER BY similarity_percentage " + orderBy + " LIMIT " + itemsNo + ";";
                } else if (decision.equals("both")) {
                    // The Query
                    query = "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, AVG(loss_percentage), \n" + //
                                "(CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                                                    "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                    "ORDER BY commodity)\n" + //
                                                                                "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0 AS 'similarity_percentageCOMM', \n" + //
                                "100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                    "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentageLP', \n" + //
                                "year, CAST((((CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents \n" + //
                                                                                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents \n" + //
                                                                                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                                "ORDER BY commodity)\n" + //
                                                                                                                "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                            "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0) + (100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                                                                                        "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100))) / 2.0 AS double) AS similarity_total FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName = '" + country + "' AND year = '" + firstYear + "'\n" + //
                            
                            "UNION\n" + //
                            
                            "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, AVG(loss_percentage), \n" + //
                                "(CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                                                    "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                    "ORDER BY commodity)\n" + //
                                                                                "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0 AS 'similarity_percentageCOMM', \n" + //
                                "100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                    "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentageLP', year, \n" + //
                                "CAST((((CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents \n" + //
                                                                                                                                                                                        "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                                                                                                        "ORDER BY commodity)\n" + //
                                                                                    "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                    "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0) + (100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100))) / 2.0 AS double) AS similarity_total FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "ORDER BY similarity_total " + orderBy + " LIMIT " + itemsNo + ";";
                }
            } else if (determination.equals("overlap")) {
                if (decision.equals("loss")) {
                    // The Query
                    query = "SELECT countryName, AVG(loss_percentage), year, 100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentage' FROM completeEvents\n" + //
                            "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                            "GROUP BY countryName HAVING AVG(loss_percentage)\n" + //
    
                            "UNION\n" + //
    
                            "SELECT countryName, AVG(loss_percentage), year, 100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentage' FROM completeEvents\n" + //
                            "WHERE countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "GROUP BY countryName HAVING AVG(loss_percentage)\n" + //
                            "ORDER BY similarity_percentage " + orderBy + ", countryName\n" + //
                            "LIMIT " + itemsNo + ";";
                } else if (decision.equals("products")) {
                    // The Query
                    query = "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, ((CAST(count(DISTINCT commodity) AS double) /  ((CAST((SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                    "WHERE year = '" + firstYear + "' AND countryName = '" + country + "'\n" + //
                                                                    "ORDER BY commodity)\n" + //
                                                "GROUP BY countryName, year HAVING year = '" + firstYear + "'\n" + //
                                                "ORDER BY similar_commodities DESC) AS double)))) * 100.0) AS 'similarity_percentage', year FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                            "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                            "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName = '" + country + "' AND year = '" + firstYear + "'\n" + //

                            "UNION\n" + //

                            "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, (CAST(count(DISTINCT commodity) AS double) /  ((CAST((SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                    "WHERE year = '" + firstYear + "' AND countryName != '" + country + "'\n" + //
                                                                    "ORDER BY commodity)\n" + //
                                                "GROUP BY countryName, year HAVING year = '" + firstYear + "'\n" + //
                                                "ORDER BY similar_commodities DESC) AS double))) * 100.0) AS 'similarity_percentage', year FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                            "WHERE year = '" + firstYear + "' AND countryName = '" + country + "'\n" + //
                            "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "ORDER BY similarity_percentage " + orderBy + " LIMIT " + itemsNo + ";";
                } else if (decision.equals("both")) {
                    // The Query
                    query = "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, AVG(loss_percentage), \n" + //
                                "(CAST(count(DISTINCT commodity) AS double) /  ((CAST((SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                                                        "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                                                            "WHERE year = '" + firstYear + "' AND countryName = '" + country + "'\n" + //
                                                                                                            "ORDER BY commodity)\n" + //
                                                                                        "GROUP BY countryName, year HAVING year = '" + firstYear + "'\n" + //
                                                                                        "ORDER BY similar_commodities DESC) AS double)))) * 100.0 AS 'similarity_percentageCOMM', \n" + //
                                "100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                    "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentageLP', \n" + //
                                "year, CAST((((CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                                                    "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                    "ORDER BY commodity)\n" + //
                                                                                "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0) + (100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                                                                                        "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100))) / 2.0 AS double) AS similarity_total FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName = '" + country + "' AND year = '" + firstYear + "'\n" + //
                            
                            "UNION\n" + //
                            
                            "SELECT countryName, commodity, count(DISTINCT commodity) AS similar_commodities, AVG(loss_percentage), \n" + //
                                "(CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents\n" + //
                                                                                "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                                                                    "WHERE ((countryName != '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                    "ORDER BY commodity)\n" + //
                                                                                "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0 AS 'similarity_percentageCOMM', \n" + //
                                "100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                    "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                    "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100) AS 'similarity_percentageLP', year, \n" + //
                                "CAST((((CAST(count(DISTINCT commodity) AS double) /  (SELECT count(DISTINCT commodity) AS similar_commodities FROM completeEvents WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents \n" + //
                                                                                                                                                                                        "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                                                                                                                                                        "ORDER BY commodity)\n" + //
                                                                                    "GROUP BY year HAVING year = '" + firstYear + "'\n" + //
                                                                                    "ORDER BY similar_commodities DESC LIMIT 1)) * 100.0) + (100 - (ABS(AVG(loss_percentage) - (SELECT AVG(loss_percentage) FROM completeEvents\n" + //
                                                                                                                                                                                "WHERE (countryName = '" + country + "') AND year = '" + firstYear + "'\n" + //
                                                                                                                                                                                "GROUP BY countryName HAVING AVG(loss_percentage))) / 25 * 100))) / 2.0 AS double) AS similarity_total FROM completeEvents \n" + //
                            "WHERE commodity IN (SELECT DISTINCT commodity FROM completeEvents\n" + //
                                                "WHERE ((countryName = '" + country + "') AND year = '" + firstYear + "')\n" + //
                                                "ORDER BY commodity)\n" + //
                            "GROUP BY countryName, year HAVING similar_commodities AND countryName != '" + country + "' AND year = '" + firstYear + "'\n" + //
                            "ORDER BY similarity_total " + orderBy + " LIMIT " + itemsNo + ";";
                }
            }
            
            
                                
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                double scale = Math.pow(10, 2);
                String countryName = null;
                double AVGloss_percentage = 0.0;
                String year = null;
                double similarityPercentage = 0.0;
                int similarCommodities = 0;
                Country countryObj = null;
                double similarCommoditiesPercentage = 0.0;
                double similarCommoditiesLossPercentage = 0.0;
                double similarityPercentageTotal = 0.0;

                if (decision.equals("loss")) { //String Double String Double
                    countryName          = results.getString("countryName");
                    AVGloss_percentage     = Math.round(results.getDouble("AVG(loss_percentage)") * scale) / scale;
                    year                   = results.getString("year");
                    similarityPercentage     = Math.round(results.getDouble("similarity_percentage") * scale) / scale;

                    countryObj = new Country(countryName, AVGloss_percentage, year, similarityPercentage);
                } else if (decision.equals("products")) { //String Int Double String
                    countryName          = results.getString("countryName");
                    similarCommodities = results.getInt("similar_commodities");
                    similarityPercentage     = Math.round(results.getDouble("similarity_percentage") * scale) / scale;
                    year                   = results.getString("year");

                    countryObj = new Country(countryName, similarCommodities, similarityPercentage, year);
                } else if (decision.equals("both")) { //String Int Double Double Double Double String
                    countryName          = results.getString("countryName");
                    similarCommodities = results.getInt("similar_commodities");
                    similarCommoditiesPercentage = Math.round(results.getDouble("similarity_percentageCOMM") * scale) / scale;
                    AVGloss_percentage     = Math.round(results.getDouble("AVG(loss_percentage)") * scale) / scale;
                    similarCommoditiesLossPercentage = Math.round(results.getDouble("similarity_percentageLP") * scale) / scale;
                    similarityPercentageTotal    = Math.round(results.getDouble("similarity_total") * scale) / scale;
                    year                   = results.getString("year");

                    countryObj = new Country(countryName, similarCommodities, similarCommoditiesPercentage, AVGloss_percentage, similarCommoditiesLossPercentage, similarityPercentageTotal, year);
                }
                

                
                // Add the Country object to the array
                simCountries.add(countryObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return simCountries;
    }

    public ArrayList<Commodity> getAllCommodities() {
        // Create the ArrayList of Country objects to return
        ArrayList<Commodity> commodities = new ArrayList<Commodity>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT commodity FROM completeEvents ORDER BY commodity ASC;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need

                String commodity     = results.getString("commodity");

                Commodity commoditiesObj = new Commodity(commodity);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    public ArrayList<Group> getAllGroupsName() {
        // Create the ArrayList of Country objects to return
        ArrayList<Group> groups = new ArrayList<Group>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM FoodGroup ORDER BY descriptor ASC";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String descriptor     = results.getString("descriptor");
                String groupId     = results.getString("groupid");

                Group groupsObj = new Group(groupId,descriptor);
                // Add the Country object to the array
                groups.add(groupsObj);
            }
            statement.close();

        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return groups;
    }

    public ArrayList<Group> getExistingGroupsName() {
        // Create the ArrayList of Country objects to return
        ArrayList<Group> groups = new ArrayList<Group>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT Groupid, groupdescription FROM completeevents ORDER BY groupDescription ASC;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String descriptor     = results.getString("Groupdescription");
                String groupId     = results.getString("groupid");

                Group groupsObj = new Group(groupId,descriptor);
                // Add the Country object to the array
                groups.add(groupsObj);
            }
            statement.close();

        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return groups;
    }


    public String getNoOfEvents() {
        // Create the ArrayList of Country objects to return
        String result = "0";

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COUNT(GroupDescription) AS CountObject FROM (SELECT \r\n" + //
                                "    GroupDescription, \r\n" + //
                                "    AVG(loss_percentage) AS LossPercentage,\r\n" + //
                                "    ABS((AVG(loss_percentage)-(SELECT AVG(loss_percentage) AS averageLoss FROM completeEvents WHERE groupId = substr('0113', 1, 3)))) AS Difference \r\n" + //
                                "\r\n" + //
                                "FROM completeEvents \r\n" + //
                                "WHERE groupId != substr('0113', 1, 3)\r\n" + //
                                "GROUP BY GroupDescription\r\n" + //
                                "ORDER BY Difference ASC);";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                
                // Create a Country Object
                result = results.getString("CountObject");
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return result;
    }


    public ArrayList<GraphData> getGraphResults(String Year1, String Year2, String GroupId) {
        // Create the ArrayList of Country objects to return
        ArrayList<GraphData> Data = new ArrayList<GraphData>();
        int FirstYearValue = Integer.parseInt(Year1);
        int SecondYearValue = Integer.parseInt(Year2);

        if(FirstYearValue > SecondYearValue)
        {
            int temp = FirstYearValue;
            FirstYearValue = SecondYearValue;
            SecondYearValue = temp;
        }

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT yearRange.year, IFNULL(returnTable.avgLossPercentage,0) AS lossPercentage FROM date as yearRange LEFT JOIN(SELECT EventTable.year, AVG(loss_percentage) AS avgLossPercentage FROM completeEvents as EventTable WHERE GroupId = '"+ GroupId +"' GROUP BY EventTable.Year) as returnTable ON yearRange.year = returnTable.year WHERE yearRange.year BETWEEN " + FirstYearValue +  " AND " + SecondYearValue + " ORDER BY yearRange.year ASC;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String YearResult = results.getString("year");
                String LossResult = results.getString("lossPercentage");

                // Create a Country Object
                GraphData datas = new GraphData(YearResult,LossResult);

                // Add the Country object to the array
                Data.add(datas);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return Data;
    }

    public ArrayList<LossPercentageData> getGraphTable(String Year1, String Year2, String GroupId, boolean limiter) {
        // Create the ArrayList of Country objects to return
        ArrayList<LossPercentageData> Data = new ArrayList<LossPercentageData>();
        int FirstYearValue = Integer.parseInt(Year1);
        int SecondYearValue = Integer.parseInt(Year2);

        if(FirstYearValue > SecondYearValue)
        {
            int temp = FirstYearValue;
            FirstYearValue = SecondYearValue;
            SecondYearValue = temp;
        }

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            
            String query = "SELECT year, loss_percentage, countryName, commodity, activity, food_supply_stage, cause_of_loss FROM completeevents WHERE GroupId = '" + GroupId + "' AND year BETWEEN " + FirstYearValue + " AND " + SecondYearValue + " ORDER BY year DESC LIMIT 500;";
            
            if(limiter !=true)
            {
                query = "SELECT year, loss_percentage, countryName, commodity, activity, food_supply_stage, cause_of_loss FROM completeevents WHERE GroupId = '" + GroupId + "' AND year BETWEEN " + FirstYearValue + " AND " + SecondYearValue + " ORDER BY year DESC;";
            }
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String YearResult = results.getString("year");
                String LossResult = results.getString("loss_Percentage");
                String countryName = results.getString("countryName");
                String commodity = results.getString("commodity");
                String activity = results.getString("activity");
                String foodSupplyStage = results.getString("food_supply_stage");
                String causeOfLoss = results.getString("cause_of_loss");

                // Create a Country Object
                LossPercentageData datas = new LossPercentageData(YearResult,LossResult,countryName,commodity,activity,foodSupplyStage,causeOfLoss);

                // Add the Country object to the array
                Data.add(datas);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return Data;
    }

    //Temporary data in order to make java not freak out
    public ArrayList<GraphData> createTemp()
    {
        ArrayList<GraphData> Data = new ArrayList<GraphData>();
        GraphData datas = new GraphData("Thingy","Thonger");
        Data.add(datas);
        return Data;
    }

    public ArrayList<LossPercentageData> createTempTable()
    {
        ArrayList<LossPercentageData> Data = new ArrayList<LossPercentageData>();
        LossPercentageData datas = new LossPercentageData("No Data","No Data","No Data","No Data","No Data","No Data","No Data");

                // Add the Country object to the array
                Data.add(datas);
        return Data;
    }

    public String getNoOfGroupsCat(String categoryGroup, String Year1, String Year2) {
        // Create the ArrayList of Country objects to return
        String result = "0";
        int FirstYearValue = Integer.parseInt(Year1);
        int SecondYearValue = Integer.parseInt(Year2);

        if(FirstYearValue > SecondYearValue)
        {
            int temp = FirstYearValue;
            FirstYearValue = SecondYearValue;
            SecondYearValue = temp;
        }

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT COUNT(year) as countNumber FROM completeevents where Groupid = '" + categoryGroup + "' AND year BETWEEN " + FirstYearValue + " AND " + SecondYearValue + ";";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                
                // Create a Country Object
                result = results.getString("countNumber");
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return result;
    }

    public ArrayList<CommodityLookup> getAllAvailableCpcCommodities() {
        // Create the ArrayList of Country objects to return
        ArrayList<CommodityLookup> commodities = new ArrayList<CommodityLookup>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT commodity, cpc_code FROM completeEvents ORDER BY commodity ASC;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need

                String descriptor     = results.getString("commodity");
                String cpcCode     = results.getString("cpc_code");

                CommodityLookup commoditiesObj = new CommodityLookup(descriptor, cpcCode);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }


    public ArrayList<DifferenceTableResults> getTableSimilar(String sortBy, String numberOfResults, String searchKey) {
        // Create the ArrayList of Country objects to return
        ArrayList<DifferenceTableResults> commodities = new ArrayList<DifferenceTableResults>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT \r\n" + //
                                "    GroupDescription, \r\n" + //
                                "    ROUND(" + sortBy + "(loss_percentage),4) AS LossPercentage,\r\n" + //
                                "    ROUND(ABS((" + sortBy + "(loss_percentage)-(SELECT " + sortBy + "(loss_percentage) AS averageLoss FROM completeEvents WHERE groupId = substr('" + searchKey + "', 1, 3)))),4) AS Difference \r\n" + //
                                "\r\n" + //
                                "FROM completeEvents \r\n" + //
                                "WHERE groupId != substr('" + searchKey + "', 1, 3)\r\n" + //
                                "GROUP BY GroupDescription\r\n" + //
                                "ORDER BY Difference ASC\r\n" + //
                                "LIMIT " + numberOfResults + ";";

                              
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need

                String descriptor     = results.getString("GroupDescription");
                String lossPercentage     = results.getString("lossPercentage");
                String difference     = results.getString("Difference");

                DifferenceTableResults commoditiesObj = new DifferenceTableResults(descriptor, lossPercentage, difference);
                // Add the Country object to the array
                commodities.add(commoditiesObj);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }


    public String convertCommodtyToString(String cpc_code) {

        // Setup the variable for the JDBC connection
        Connection connection = null;

        String descriptor="";

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT commodity FROM completeEvents WHERE cpc_code = '" + cpc_code + "';";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                descriptor = results.getString("commodity");
                
            }
            
            statement.close();

        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return descriptor;
    }


    public DifferenceTableSelected getTableSelectedResults(String searchKey, String sortBy) {
        // Create the ArrayList of Country objects to return
        DifferenceTableSelected commodities = new DifferenceTableSelected( "two", "three", "four");

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT GroupDescription, GroupId, " + sortBy + "(loss_percentage) AS LossPercentage FROM completeEvents WHERE groupId == substr('" + searchKey + "', 1, 3);";

                                // System.out.println(query);
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String descriptor     = results.getString("GroupDescription");
                String groupId     = results.getString("groupId");
                String lossPercentage     = results.getString("LossPercentage");
                

                commodities = new DifferenceTableSelected(descriptor,groupId,lossPercentage);
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

    public DifferenceTableSelected getTableSelectedCommodity(String searchKey) {
        // Create the ArrayList of Country objects to return
        DifferenceTableSelected commodities = new DifferenceTableSelected("one", "two");

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT Commodity, cpc_code FROM completeEvents WHERE cpc_code == '21435.01';";

                                // System.out.println(query);
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                String commodity     = results.getString("commodity");
                String cpc_code     = results.getString("cpc_code");
                

                commodities = new DifferenceTableSelected(commodity,cpc_code);
                
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the countries
        return commodities;
    }

}
