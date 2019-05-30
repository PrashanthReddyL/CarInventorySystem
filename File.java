import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;
/**
 * The File class handles the read and write operations to the text file.
 * 
 * @author Prashanth Reddy
 * @version 20 Oct 2017
 */
public class File
{
    private String fileName;
    private ArrayList<Car> tempCarList;
    
    /**
    * Default constructor for File class
    */ 
    public File()
    {
        fileName = "UsedCars.txt";
        tempCarList = new ArrayList <Car>();
    }
    
    /**
    * This method writes all the Cars to the text file
    */   
    public void writeMyCar( CarList list)
    {
        try
        {
            tempCarList = list.getCarArrayList();
            FileWriter writeToMyCar = new FileWriter (fileName);
            BufferedWriter buffer = new BufferedWriter(writeToMyCar);
            for ( Car car: tempCarList)
            {
                buffer.write (car.displayCar());
                buffer.newLine();
            }
            buffer.close();
        }
        catch(IOException ex)
        {
            System.out.println("\n Error writing to file:" + fileName + "\n");
        }
    }
    
    /**
    * This method reads all the Cars from the text file
    */
    public ArrayList<Car> readMyCar()
    {
        try 
        {
            FileReader readMyCar = new FileReader (fileName);
            Scanner input = new Scanner (readMyCar);
            while (input.hasNextLine())
            {
                String name = input.nextLine();
                String[] cars = name.split(",",8);
                tempCarList.add(new Car(cars[0],
                                        Integer.valueOf(cars[1]),
                                        cars[2],
                                        cars[3],
                                        cars[4],
                                        cars[5],
                                        cars[6],
                                        Integer.valueOf(cars[7])));
                readMyCar.close();
            }
        }
        catch(FileNotFoundException |
                IndexOutOfBoundsException ex)
        {
            System.out.println("Unable to read car Collection");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file");
        }
        return tempCarList;
    }
    
     /**
    * Accessor for the file name
    */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
    * Mutator for the file name
    */ 
    public void setFileName(String newFileName)
    {
        fileName = newFileName + ".txt";
    }
}
                
            
        
    
    