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
   private double loss_percentage;

   // year
   private String year;

   private String activityName;
   private String fss;
   private String col;

   /**
    * Create a Country and set the fields
    */

    public Commodity(String commodity) {
      this.commodity = commodity;
   }

   public Commodity(String commodity, double loss_percentage) {
      this.commodity = commodity;
      this.loss_percentage = loss_percentage;
   }

   public Commodity(String commodity, double loss_percentage, String year) {
      this.commodity = commodity;
      this.loss_percentage = loss_percentage;
      this.year = year;
   }

   public Commodity(String commodity, double loss_percentage, String year, String activityName, String fss, String col) {
      this.commodity = commodity;
      this.loss_percentage = loss_percentage;
      this.year = year;
      this.activityName = activityName;
      this.fss = fss;
      this.col = col;
   }

   public String getCommodity() {
      return commodity;
   }

   public double getLoss_Percentage() {
      return loss_percentage;
   }

   public String getYear() {
      return year;
   }

   public String getActivity() {
      return activityName;
   }

   public String getFSS() {
      return fss;
   }

   public String getCOL() {
      return col;
   }
}
