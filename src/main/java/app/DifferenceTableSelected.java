package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class DifferenceTableSelected {

   private String Commodity;

   private String GroupDescriptor;

   private String GroupId;

   private String LossPercentage;

   /**
    * Create a Country and set the fields
    */
   public DifferenceTableSelected(String commodity, String descriptor, String groupid, String losspercentage) {
      this.Commodity = commodity;
      this.GroupDescriptor = descriptor;
      this.GroupId = groupid;
      this.LossPercentage = losspercentage;
   }

   public String getCommodity()
   {
      return Commodity;
   }

   public String getGroupId()
   {
      return GroupId;
   }

   public String getGroupDescriptor() {
      return GroupDescriptor;
   }

   public String getLossPercentage() {
      return LossPercentage;
   }

}
