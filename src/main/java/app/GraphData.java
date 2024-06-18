package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class GraphData {
   // Year (x)
   private String Year;

   // PercentageLoss (y)
   private String PercentageLoss;

   /**
    * Create a Country and set the fields
    */
   public GraphData(String Year, String PercentageLoss) {
      this.Year = Year;
      this.PercentageLoss = PercentageLoss;
   }

   public String getYear() {
      return Year;
   }

   public String getPercentageLoss() {
      return PercentageLoss;
   }
}
