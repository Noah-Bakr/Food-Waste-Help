package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class DifferenceTableResults {
   // country Code
   private String LossPercentage;

   //Differences
   private String Differences;

   // country Name
   private String Descriptor;

   /**
    * Create a Country and set the fields
    */
   public DifferenceTableResults(String name, String lossPercentage, String differences) {
      this.LossPercentage = lossPercentage;
      this.Descriptor = name;
      this.Differences = differences;
   }

   public String getLossPercentage() {
      return LossPercentage;
   }

   public String getDifferences()
   {
      return Differences;
   }

   public String getDescriptor() {
      return Descriptor;
   }
}
