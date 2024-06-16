package app;

import java.util.ArrayList;
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
    public ArrayList<Commodity> parse2ADataXValues(String period, String firstYear, String secondYear, String country) {
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
                period = " BETWEEN '" + firstYear + "' AND '" + secondYear + "')\n";
            } else {
                period = " = '" + firstYear + "' OR '" + secondYear + "')\n";
            }

            // The Query
            String query = "SELECT commodity, AVG(loss_percentage), year FROM completeEvents\n" + //
                            "WHERE (countryName = '" + country + "') AND (year" + period + //
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
            String query = "SELECT COUNT(m49code) as thingy from completeEvents;";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                
                // Create a Country Object
                result = results.getString("thingy");
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


}
