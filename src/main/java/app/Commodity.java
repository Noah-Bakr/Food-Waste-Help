package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Commodity {
   // commodity
   private String commodity;

   // loss_percentage
   private String loss_percentage;

   /**
    * Create a Country and set the fields
    */
   public Commodity(String commodity, String loss_percentage) {
      this.commodity = commodity;
      this.loss_percentage = loss_percentage;
   }

   public String getCommodity() {
      return commodity;
   }

   public String getLoss_Percentage() {
      return loss_percentage;
   }
}
