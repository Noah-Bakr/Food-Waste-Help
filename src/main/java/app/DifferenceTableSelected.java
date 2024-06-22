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

   private String Cpc_Code;

   /**
    * Create a Country and set the fields
    */
   public DifferenceTableSelected(String commodity, String descriptor, String groupid, String losspercentage, String cpcCode) {
      this.Commodity = commodity;
      this.GroupDescriptor = descriptor;
      this.GroupId = groupid;
      this.LossPercentage = losspercentage;
      this.Cpc_Code = cpcCode;
   }

   public String getCommodity()
   {
      return Commodity;
   }

   public String getCpcCode()
   {
      return Cpc_Code;
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
