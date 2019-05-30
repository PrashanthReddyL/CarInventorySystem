import java.util.Scanner;
import java.util.ArrayList;
import java.time.Year;

/**
 * The CarList Class stores the data in Arraylist.
 * 
 * @author Prashanth Reddy
 * @version 20 Oct 2017
 */
public class CarList
{
    private ArrayList<Car> carList; //array list of type Car
    private int year;
    private File file;

    /**
     * Constructor for objects of class CarList
     */
    public CarList()
    {
        file = new File();
        carList = file.readMyCar();
        year = Year.now().getValue();
    }

    public void addCar(Car car)
    {
    carList.add(car);
    }
    
    /**
    * This Method deletes a car based on the Registration Number.
    */
    public boolean deleteCar (String regNo)
    {
        for(Car eachCar:carList)
        {
            if(eachCar.getCarReg().toUpperCase().equals(regNo))
            {
                carList.remove(eachCar);
                return true;
            }
        }
        return false;
    }
    
    /**
    * This Method deletes a car based on the Registration Number.
    */
    public boolean editPrice(String regNo, int price)
    {
        for(Car eachCar:carList)
        {
            if(eachCar.getCarReg().equalsIgnoreCase(regNo))
            {
                eachCar.setPrice(price);
                return true;
            }
        }
        return false;
    }
    
    public boolean editColor(String regNo, String[] color)
    {
        for(Car eachCar:carList)
        {
            if(eachCar.getCarReg().equalsIgnoreCase(regNo))
            {
                eachCar.setColor(color[0], color[1], color[2]);
                return true;
            }
        }
        return false;
    }
    
    public boolean editColorPrice(String regNo, String[] color, int price)
    {
        for (Car eachCar : carList)
        {
            if(eachCar.getCarReg().equalsIgnoreCase(regNo))
            {
                eachCar.setColor(color[0], color[1], color[2]);
                eachCar.setPrice(price);
                return true;
            }
        }
        return false;
    }
    
    public String searchCarRegNo(String regNo)
    {
        ArrayList<Car> searchList = new ArrayList<Car>();
        for (Car eachCar : carList)
        {
            if(eachCar.getCarReg().equals(regNo))
            {
                return eachCar.displayCar();
            }
        }
        return "";
    }
    
    public ArrayList<Car> searchCarMakeModel(String make, String model)
    {
        ArrayList<Car> searchList = new ArrayList<Car>();
        for (Car eachCar : carList)
        {
            if(eachCar.getCarMake().toUpperCase().contains(make) &&
                eachCar.getCarModel().toUpperCase().contains(model))
            {
                searchList.add(eachCar);
            }
        }
        return searchList;
    }
    
    public ArrayList<Car> searchCarAge(int age)
    {
        ArrayList<Car> searchList = new ArrayList<Car>();
        for(Car eachCar : carList)
        {
            if(eachCar.getYearMade() >= (year-age))
            {
                searchList.add(eachCar);
            }
        }
        return searchList;
    }
    
    public ArrayList<Car> searchCarColor(String[] color)
    {
        ArrayList<Car> searchList = new ArrayList<Car>();
        for(Car eachCar : carList)
        {
            if(eachCar.getColor().contains(color[0]) &&
                eachCar.getColor().contains(color[1]) &&
                eachCar.getColor().contains(color[2]))
            {
                searchList.add(eachCar);
            }
        }
        return searchList;
    }
    
    public ArrayList<Car> searchCarPrice(int min, int max)
    {
        ArrayList<Car> searchList = new ArrayList<Car>();
        for(Car eachCar : carList)
        {
            if(eachCar.getPrice() >= min &&
                eachCar.getPrice() <= max )
            {
                searchList.add(eachCar);
            }
        }
        return searchList;
    }
    
    public ArrayList<Car> getCarArrayList()
    {
        return carList;
    }
    
    public int getYear()
    {
        return year;
    }
}
    
                
                    
        
        
    
    
    
    
    
    
    
    