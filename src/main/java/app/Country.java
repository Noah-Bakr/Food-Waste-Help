package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Country {
   // country Code
   private String m49Code;

   // country Name
   private String name;

   private double AVGloss_percentage;
   private String year;
   private double similarityPercentage;

   private int similarCommodities;
   private double similarCommoditiesPercentage;
   private double similarityPercentageTotal;
   private double similarCommoditiesLossPercentage;

   /**
    * Create a Country and set the fields
    */
   public Country(String m49Code, String name) {
      this.m49Code = m49Code;
      this.name = name;
   }

   public Country(String countryName, double AVGloss_percentage, String year, double similarityPercentage) {
      name = countryName;
      this.AVGloss_percentage = AVGloss_percentage;
      this.year = year;
      this.similarityPercentage = similarityPercentage;
   }

   public Country(String countryName, int similarCommodities, double similarityPercentage, String year) {
      name = countryName;
      this.similarCommodities = similarCommodities;
      this.similarityPercentage = similarityPercentage;
      this.year = year;
   }

   //String Int Double Double Double Double String
   public Country(String countryName, int similarCommodities, double similarCommoditiesPercentage, double AVGloss_percentage, double similarCommoditiesLossPercentage, double similarityPercentageTotal, String year) {
      name = countryName;
      this.similarCommodities = similarCommodities;
      this.similarCommoditiesPercentage = similarCommoditiesPercentage;
      this.AVGloss_percentage = AVGloss_percentage;
      this.similarCommoditiesLossPercentage = similarCommoditiesLossPercentage;
      this.similarityPercentageTotal = similarityPercentageTotal;
      this.year = year;
   }

   public String getM49Code() {
      return m49Code;
   }

   public String getName() {
      return name;
   }

   public double getLossPercentage() {
      return AVGloss_percentage;
   }

   public String getYear() {
      return year;
   }

   public double getSimilarityPercentage() {
      return similarityPercentage;
   }

   public int getSimilarCommoditiesNo() {
      return similarCommodities;
   }

   public double getSimilarCommoditiesPercentage() {
      return similarCommoditiesPercentage;
   }

   public double getSimilarityPercentageTotal() {
      return similarityPercentageTotal;
   }

   public double getSimilarCommoditiesLossPercentage() {
      return similarCommoditiesLossPercentage;
   }
}
