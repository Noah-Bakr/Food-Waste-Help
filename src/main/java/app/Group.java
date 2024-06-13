package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Group {
   // country Code
   private String GroupId;

   // country Name
   private String Descriptor;

   /**
    * Create a Country and set the fields
    */
   public Group(String Id, String name) {
      this.GroupId = Id;
      this.Descriptor = name;
   }

   public String getGroupId() {
      return GroupId;
   }

   public String getDescriptor() {
      return Descriptor;
   }
}
