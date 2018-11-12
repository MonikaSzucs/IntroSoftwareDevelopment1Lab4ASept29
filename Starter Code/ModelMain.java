
/**
 * Write a description of class ModelMain here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ModelMain
{
    public static void main(String[] args) {
        
        Model billModel = new Model("Bill", "Smith", 73, 198, false, true);
        Model cindyModel = new Model("Cindy", "Chan", 64, 145);
        
        billModel.printDetails();
        
        System.out.println(""); // Empty Line
        
        cindyModel.printDetails();
        
        System.out.println(""); // Empty Line
        System.out.println("Bill's Occupation: " + billModel.getOccupation());
        
        billModel.setWeight(100);
        System.out.println("Bill's New Weight lbs: " + billModel.getWeight());
        System.out.println("Bill's New Weight kg: " + billModel.getWeightKg());
        
        billModel.setHeight(6, 4);
        System.out.println("Bill's New Height Inches: " + billModel.getHeight());
        System.out.println("Bill's New Feet and Inches: " + billModel.getHeightInFeetAndInches());
    }
}

