package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class LossPercentageData {
   
   private String Year;
   private String PercentageLoss;
   private String CountryName;
   private String Commodity;
   private String Activity;
   private String Food_supply_stage;
   private String Cause_of_loss;

   /**
    * Create a Country and set the fields
    */
   public LossPercentageData(String Year, String PercentageLoss, String CountryName, String Commodity, String Activity, String Food_supply_stage, String Cause_of_loss) {
      this.Year = Year;
      this.PercentageLoss = PercentageLoss;
      this.CountryName = CountryName;
      this.Commodity = Commodity;
      this.Activity = Activity;
      this.Food_supply_stage = Food_supply_stage;
      this.Cause_of_loss = Cause_of_loss;
   }

   public String getYear() {
      return Year;
   }

   public String getPercentageLoss() {
      return PercentageLoss;
   }
}
