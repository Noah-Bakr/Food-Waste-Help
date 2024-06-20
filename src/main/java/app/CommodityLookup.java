package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class CommodityLookup {
   // country Code
   private String cpcCode;

   // country Name
   private String Descriptor;

   /**
    * Create a Country and set the fields
    */
   public CommodityLookup(String name, String Id) {
      this.cpcCode = Id;
      this.Descriptor = name;
   }

   public String getCpcCode() {
      return cpcCode;
   }

   public String getDescriptor() {
      return Descriptor;
   }
}
