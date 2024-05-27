package app;

/**
 * Class represeting a Country from the Studio Project database
 *
 * @author Halil Ali, 2024. email: halil.ali@rmit.edu.au
 */

public class Persona {
   // Persona Name
   private String Name;
   // Persona Image
   private String Image;
   // Persona Attributes
   private String Attributes;
   // Persona Background
   private String Background;
   // Persona Needs
   private String Needs;
   // Persona Goals
   private String Goals;
   // Persona Skills
   private String Skills;

  




   /**
    * Create a Country and set the fields
    */
   public Persona(String name, String image, String attributes, String backgrounds, String needs, String goals, String skills) {
      this.Name = name;
      this.Image = image;
      this.Attributes = attributes;
      this.Background = backgrounds;
      this.Needs = needs;
      this.Goals = goals;
      this.Skills = skills;
   }

   public String getName() {
      return this.Name;
   }

   public String getImage() {
      return this.Image;
   }

   public String getAttributes() {
		return this.Attributes;
	}

   public String getBackground() {
		return this.Background;
	}

   public String getNeeds() {
		return this.Needs;
	}

   public String getGoals() {
		return this.Goals;
	}

   public String getSkills() {
		return this.Skills;
	}

   
}
