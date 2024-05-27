package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Student {

   //Declare variables
   private String StudentCode;
   private String FirstName;
   private String LastName;

   //Student Constructor
   public Student(String studentcode, String firstname, String lastname) {
      this.StudentCode = studentcode;
      this.FirstName = firstname;
      this.LastName = lastname;
   }

   //Getters
   public String getStudentCode() {
      return this.StudentCode;
   }

   public String getFirstName() {
      return this.FirstName;
   }

   public String getLastName() {
      return this.LastName;
   }

}
