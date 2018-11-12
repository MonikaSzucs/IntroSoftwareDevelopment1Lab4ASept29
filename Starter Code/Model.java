/**
 * Represents a person who models
 *
 * @author Mike Mulder
 * @version 1.0
 */
public class Model
{
    // Constants
    private static final int MIN_NAME_LENGTH    = 3;
    private static final int MAX_NAME_LENGTH    = 20;
    private static final int MIN_HEIGHT_INCHES  = 24;
    private static final int MAX_HEIGHT_INCHES  = 84;
    private static final double MIN_WEIGHT_LBS  = 80.0;
    private static final double MAX_WEIGHT_LBS  = 280.0;
    private static final double KG_PER_LB       = 0.454;
    private static final int    INCHES_PER_FOOT = 12;
    
    // Static Class Variables
    private static String occupation = "modeling";
    
    // Instance Variables
    private String  firstName;
    private String  lastName;
    private int     heightInches;
    private double  weightLbs;
    private boolean canTravel;
    private boolean smokes;
    
    /**
     * Creates a new model
     * 
     * @param newFirstName Model first name
     * @param newLastName Model last name
     * @param newHeightInches Model height, in inches
     * @param newWeightIbs Model weight, in lbs
     * @param newCanTravel Whether the Model can travel
     * @param newSmokes Whether the Model smokes
     */
    public Model(String newFirstName, 
                 String newLastName, 
                 int newHeightInches, 
                 double newWeightLbs, 
                 boolean newCanTravel, 
                 boolean newSmokes) {
                     
        setFirstName(newFirstName);
        setLastName(newLastName);
        setHeight(newHeightInches);
        setWeight(newWeightLbs);
        setCanTravel(newCanTravel);
        setSmokes(newSmokes);
    }
    
    /**
     * Creates a new model. Assumes the Model can travel and does not smoke.
     * 
     * @param newFirstName Model first name
     * @param newLastName Model last name
     * @param newHeightInches Model height, in inches
     * @param newWeightIbs Model weight, in lbs
     */
    public Model(String newFirstName, 
                 String newLastName, 
                 int newHeightInches, 
                 double newWeightLbs) {
            
        setFirstName(newFirstName);
        setLastName(newLastName);
        setHeight(newHeightInches);
        setWeight(newWeightLbs);
        setCanTravel(true);
        setSmokes(false);
    }
    
    //
    // Setter Methods - defined as final as a best practice
    //
    
    /**
     * @param newFirstName New first name
     */
    public final void setFirstName(String newFirstName) {
        if (newFirstName != null && 
            (newFirstName.length() >= MIN_NAME_LENGTH) && 
            (newFirstName.length() <= MAX_NAME_LENGTH)) {
            firstName = newFirstName;
        } else {
            throw new IllegalArgumentException("First Name must not be null");
        }
    }
    
    /**
     * @param newLastName New last name
     */
    public final void setLastName(String newLastName) {
        if (newLastName != null && 
            (newLastName.length() >= MIN_NAME_LENGTH) && 
            (newLastName.length() <= MAX_NAME_LENGTH)) {
            lastName = newLastName;
        } else {
            throw new IllegalArgumentException("Last Name must not be null");
        }
    }
    
    /**
     * @param newHeightInches New height, in inches
     */
    public final void setHeight(int newHeightInches) {
        if (newHeightInches >= MIN_HEIGHT_INCHES && newHeightInches <= MAX_HEIGHT_INCHES) {
            heightInches = newHeightInches;
        } else {
            throw new IllegalArgumentException("Height must be between 24 and 84 inches");
        }
    }
    
    /**
     * @param feet New height in feet
     * @param inches New height remaining inches
     */
    public final void setHeight(int feet, int inches) {
     
        int totalInches = (feet * INCHES_PER_FOOT) + inches;
        
        setHeight(totalInches);
    }
    
    /**
     * @param newWeightLbs New weight, in lbs
     */
    public final void setWeight(double newWeightLbs) {
        if (newWeightLbs >= MIN_WEIGHT_LBS && newWeightLbs <= MAX_WEIGHT_LBS) {
            weightLbs = newWeightLbs;
        } else {
            throw new IllegalArgumentException("Weight must be between 80 and 240 pounds");
        }
    }    
    
    /**
     * @param kilograms New weight, in kilograms
     */
    public final void setWeight(long kilograms) {
     
        double pounds = (double)kilograms / KG_PER_LB;
        
        setWeight(pounds);
    }
    
    /**
     * @param newCanTravel Whether the model can travel
     */
    public final void setCanTravel(boolean newCanTravel) {
        canTravel = newCanTravel;
    }
    
    /**
     * @param newSmokes Whether the model smokes
     */
    public final void setSmokes(boolean newSmokes) {
        smokes = newSmokes;
    }
    
    //
    // Getter Methods
    //
    
    /**
     * @return firstName First name of the model
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * @return lastName Last name of the model
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * @return heightInches Height of the model, in inches
     */
    public int getHeight() {
        return heightInches;
    }
    
    /**
     * @return height Model height in feet and inches
     */
    public String getHeightInFeetAndInches() {
        int numFeet = heightInches / 12;
        int numInches = heightInches % 12;
        
        String feetAndInchesStr = "";
        if (numInches == 0) {
            feetAndInchesStr = numFeet + " feet";
        } else if (numInches == 1) {
            feetAndInchesStr = numFeet + " feet 1 inch";
        } else {
            feetAndInchesStr = numFeet + " feet " + numInches + " inches";
        }
        
        return feetAndInchesStr;
    }
    
    /** 
     * @return weight Model weight in lbs
     */
    public double getWeight() {
        return weightLbs;
    }
    
    /**
     * @return weight Model weight in kilograms
     */
    public long getWeightKg() {
        long weightKg = Math.round(weightLbs * KG_PER_LB);
        
        return weightKg;
    }
    
    /**
     * @return canTravel Whether the model can travel
     */
    public boolean getCanTravel() {
        return canTravel;
    }
    
    /**
     * @return smokes Whether the model smokes
     */
    public boolean getSmokes() {
        return smokes;
    }
    
    /**
     * @return occupation The occupation of the model
     */
    public static String getOccupation() {
        return occupation;
    }
    
    //
    // Other Methods
    //
    
    /**
     * Prints the details of a model to the console.
     * 
     * Details include name, height, weight, can travel and smokes.
     */
    public void printDetails() {
        
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " inches");
        System.out.println("Weight: " + Math.round(getWeight()) + " pounds");
        
        if (getCanTravel()) {
            System.out.println("Does travel");
        } else {
            System.out.println("Does not travel");
        }
        
        if (getSmokes()) {
            System.out.println("Does smoke");
        } else { 
            System.out.println("Does not smoke");
        }
    }
}

