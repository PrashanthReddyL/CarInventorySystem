/**
 * The Car Class Consists of all the Accessor and Mutator Methods.
 * 
 * @author Prashanth Reddy
 * @version 20 Oct 2017
 */
public class Car
{
    private String carReg;
    private int yearMade;
    private String[] color = new String[3];
    private String carMake;
    private String carModel;
    private int price;
    private CarList carList;
    /**
    * Default constructor for Car class
    */
    public Car()
    {
        carReg = null;
        yearMade = 0;
        color[0] = null;
        color[1] = null;
        color[2] = null;
        carMake = null;
        carModel = null;
        price = 0;
    }
    
    /**
    * Parametric constructor for Car class
    */
    public Car( String newCarReg, int newYearMade, String color1, String color2, String color3, String newCarMake, String newCarModel, int newPrice)
    {
        carReg = newCarReg;
        yearMade = newYearMade;
        color[0] = color1;
        color[1] = color2;
        color[2] = color3;
        carMake = newCarMake;
        carModel = newCarModel;
        price = newPrice;
    }
    
    /**
    * This method returns the details of the Car as a string
    */
    public String displayCar()
    {
        return carReg + "," +
               yearMade + "," +
               color[0] + "," +
               color[1] + "," +
               color[2] + "," +
               carMake + "," +
               carModel + "," +
               price;
    }
    
    /**
    * Accessor for Car Registration Number
    */
    public String getCarReg()
    {
        return carReg;
    }
    
    /**
    * Mutator for Car Registration Number
    */
    public boolean setCarReg(String newCarReg)
    {
        if(newCarReg == null || newCarReg.trim().isEmpty())
            return false;
        else if(!newCarReg.trim().matches("[a-zA-Z0-9]+") ||newCarReg.length() > 6)
            return false;
        else
        {
            carReg = newCarReg.trim();
            return true;
        }       
    }
    
    /**
    * Accessor for Year Made
    */
    public int getYearMade()
    {
        return yearMade;
    }
    
    /**
    * Mutator for Year Made
    */
    public boolean setYearMade(int newYearMade)
    {
        if(newYearMade < 1950 || newYearMade > carList.getYear())
            return false;
        else
        {
            yearMade = newYearMade;
            return true;
        }
        
    }
    
    /**
    * Accessor for Car Make
    */
    public String getCarMake()
    {
        return carMake;
    }
    
    /**
    * Mutator for Car Make
    */
    public boolean setCarMake(String newCarMake)
    {
        if(newCarMake == null || newCarMake.trim().isEmpty())
            return false;
        else if(!newCarMake.trim().matches("[a-zA-Z]+"))
            return false;
        else
        {
            carMake = newCarMake.trim();
            return true;
        }
    }
    
    /**
    * Accessor for Car Model
    */
    public String getCarModel()
    {
        return carModel;
    }
    
    /**
    * Mutator for Car Model
    */
    public boolean setCarModel(String newCarModel)
    {
        if(newCarModel == null || newCarModel.trim().isEmpty())
            return false;
        else if(!newCarModel.trim().matches("[a-zA-Z]+"))
            return false;
        else
        {
            carModel = newCarModel.trim();
            return true;
        }
    }
    
    /**
    * Accessor for Price
    */
    public int getPrice()
    {
        return price;
    }
    
    /**
    * Mutator for Price
    */
    public boolean setPrice(int newPrice)
    {
        if(newPrice < 0)
            return false;
        else
        {
            price = newPrice;
            return true;
        }
    }
    
    /**
    * Accessor for Colours
    */
    public String getColor()
    {
        return color[0] + "," + color[1] + "," + color[2];
    }
    
    /**
    * Mutator for Colours
    */
    public void setColor(String color1, String color2, String color3)
    {
        if(color1.isEmpty())
            System.out.println("\nError! Color cannot be empty");
        else if(color1.isEmpty())
            System.out.println("\nError! Color cannot be same");
        else if(!color3.isEmpty() && (color1.equals(color3) || color2.equals(color3)))
            System.out.println("\nError! Color cannot be same");
        else 
        {
            color[0] = color1;
            color[1] = color2;
            color[2] = color3;
        }
    }    
}
        
    
    
    
    