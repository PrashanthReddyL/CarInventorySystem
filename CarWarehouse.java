import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 * This is the CarWarehouse Class
 * This class does all the inputs and outputs from and to the user
 * It validates the user input based on some conditions
 * 
 * @author Prashanth Reddy
 * @version 20 Oct 2017
 */
public class CarWarehouse
{
    private CarList carList;
    private File file;
    
    /**
    * Default constructor for CarWarehouse class
    */ 
    public CarWarehouse()
    {
        file = new File();
        carList = new CarList();
    }
    
    /**
    * This method diaplays the main menu of the program.
    */
    private void displayMenu()
    {
        System.out.println("\nWelcome to Used Car Warehouse Database System");
        System.out.println("=============================================");
        System.out.println("(1)Search Cars  ");
        System.out.println("(2)Add Car ");
        System.out.println("(3)Edit car ");
        System.out.println("(4)Delete car ");
        System.out.println("(5)Exit System ");
        System.out.println("\nSelect an Option: ");
    }
    
    /**
    * This method diaplays the menu to search a car based on different options.
    */
    private void displaySearchOptions()
    {
        System.out.println("\nCar Searching Options:");
        System.out.println("\t(1) By Registration Number");
        System.out.println("\t(2) By Car Make and Car Model ");
        System.out.println("\t(3) By Age");
        System.out.println("\t(4) By Colour");
        System.out.println("\t(5) By Price (range)");
        System.out.println("\t(6) Back to Main Menu");
        System.out.println("\nSelect an Option: ");
    }
    
    /**
    * This method diaplays the menu to edit the details of a car.
    */
    private void displayEditOptions()
    {
        System.out.println(" \n Car Searching options:");
        System.out.println("---------------------------");
        System.out.println("(1)Edit Price of the Car");
        System.out.println("(2)Edit colors of Car");
        System.out.println("(3)Edit colours and price of the car together");
        System.out.println("(4)Main Menu");
        System.out.println("Choose an option:");
    }
    
    /**
    * This method starts the actual CarWarehouse System.
    */
    public void startSystem()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Current Year is:" +carList.getYear());
        System.out.println("=====================");
        while(true)
        {
            displayMenu();
            if (console.hasNextInt())
            {
                int choice = console.nextInt();
                switch(choice)
                {
                    case 1: searchCars();
                            break;
                    case 2: addCar();
                            break;
                    case 3: editCar();
                            break;
                    case 4: deleteCar();
                            break;
                    case 5: exitSystem();
                            break;
                    default: System.out.println("\n Please choose the input from 1-5");
                }
            }
            else
            {
                System.out.println("\n Please choose the input from 1-5");
                console.next();
            }
        }
    }
    
    /**
    * This method adds a car.
    */
    private void addCar()
    {
        String carReg = validateRegNo("addCar");
        int yearMade = validateYearMade();
        String[] color = validateColor();
        String carMake = validateMake();
        String carModel = validateModel();
        int price = validatePrice();
        carList.addCar(new Car(carReg, yearMade, color[0], color[1], color[2], carMake, carModel, price));
        System.out.println("\nNew Car has been added to the Database");
    }
    
    /**
    * This method deletes a car.
    */
    private void deleteCar()
    {
        String carReg = validateRegNo("deleteCar");
        if(carList.deleteCar(carReg))
            System.out.println("\nYour car has been deleted\n");
        else
            System.out.println("\nNo Such Car Exists \n");
    }
    
    /**
    * This method starts the Edit function of the program.
    */
    private void editCar()
    {
        int choice = 0;
        Scanner console = new Scanner(System.in);
        do
        {
            displayEditOptions();
            if(console.hasNextInt())
            {
                choice = console.nextInt();
                switch(choice)
                {
            
                    case 1: editPrice();
                            break;
                    case 2: editColor();
                            break;
                    case 3: editColorPrice();
                            break;
                    case 4: break;
                    default: System.out.println("\nPlease choose input from 1-4");
                }
            }
            else
            {
                System.out.println("\nPlease choose input from 1-4");
                console.next();
            }
        }while(choice!=4);
    }
    
    /**
    * This method edits price of a car.
    */
    private void editPrice()
    {
        if(carList.editPrice(validateRegNo("editCar"),validatePrice()))
            System.out.println("\nPrice has been edited");
        else
            System.out.println("\nNo Such Car Exists \n");
    }
    
    /**
    * This method edits colours of a car.
    */
    private void editColor()
    {
        if(carList.editColor(validateRegNo("editCar"),validateColor()))
            System.out.println("\nColour has been edited");
        else
            System.out.println("\nNo Such Car Exists \n");
    }
    
    /**
    * This method edits price and colours of a car simultaneously.
    */
    private void editColorPrice()
    {
        if(carList.editColorPrice(validateRegNo("editCar"),validateColor(), validatePrice()))
            System.out.println("\nColour,Price has been edited");
        else
            System.out.println("\nNo Such Car Exists \n");
    }
    
    /**
    * This method starts the search menu of a car.
    */
    private void searchCars()
    {
        int choice = 0;
        ArrayList<Car> searchList = new ArrayList<Car>();
        Scanner console = new Scanner(System.in);
        do
        {
            displaySearchOptions();
            if(console.hasNextInt())
            {
                choice = console.nextInt();
                switch(choice)
                {
                    case 1: String search = carList.searchCarRegNo(validateRegNo("searchCar"));
                            if(search.equals(""))
                                System.out.println("\nNo Such Car Found");
                            else
                            {
                                System.out.println("\n" +search);
                            }
                            break;
                    
                    case 2: searchList = carList.searchCarMakeModel(validateMake(), validateModel());
                            if(searchList.size() == 0)
                                System.out.println("\nNo car found");
                            else
                            {
                                for(Car car : searchList)
                                {
                                    System.out.println("\n" +car.displayCar());
                                }
                            }
                            break;
                           
                    case 3: searchList = carList.searchCarAge(validateAge());
                            if(searchList.size() == 0)
                                System.out.println("\nNo car found");
                            else
                            {
                                for(Car car : searchList)
                                {
                                    System.out.println("\n" +car.displayCar());
                                }
                            }
                            break;
                            
                    case 4: searchList = carList.searchCarColor(validateColor());
                            if(searchList.size() == 0)
                                System.out.println("\nNo car found");
                            else
                            {
                                for(Car car : searchList)
                                {
                                    System.out.println("\n" +car.displayCar());
                                }
                            }
                            break;
                            
                    case 5: int min = validateMin();
                            int max = validateMax(min);
                            searchList = carList.searchCarPrice(min,max);
                            if(searchList.size() == 0)
                                System.out.println("\nNo car found");
                            else
                            {
                                for(Car car : searchList)
                                {
                                    System.out.println("\n" +car.displayCar());
                                }
                            }
                            break;
                            
                    case 6: break;
                    default: System.out.println("\nPlease choose from 1-6");
                }
            }
            else
            {
                System.out.println("\nPlease choose from 1-6");
                console.next();
            }
        }while(choice!=6);
    }
    
    /**
    * This method exits the program.
    */
    private void exitSystem()
    {
        file.writeMyCar(carList);
        System.exit(0);
    }
    
    /**
    * This method validates the Registration Number of a car.
    */
    public String validateRegNo(String name)
    {
        String regNo = null;
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Registration Number:");
            regNo = input.nextLine().trim().toUpperCase();
            
            if(regNo.isEmpty())
                System.out.println("\nError.. Reg.no cannot be empty\n");
            else if(!regNo.matches("[a-zA-Z0-9]+")|| regNo.length()> 6)
                System.out.println("\nError.. Please enter valid registration number\n");            
            else
                valid = true;
        }
        return regNo;
    }
    
    /**
    * This method validates the Make of a car.
    */
    public String validateMake()
    {
        String carMake = null;
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Car Make:");
            carMake = input.nextLine().trim().toUpperCase();            
            if(carMake.isEmpty())
                System.out.println("\nError.. Car Make cannot be empty\n");
            else if(!carMake.matches("[a-zA-Z]+"))
                System.out.println("\nError.. Please enter valid car make\n");
            else
                valid = true;
        }
        return carMake;
    }
    
    /**
    * This method validates the Model of a car.
    */
    public String validateModel()
    {
        String carModel = null;
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Car Model:");
            carModel = input.nextLine().trim().toUpperCase();
            
            if(carModel.isEmpty())
                System.out.println("\nError.. Car Model cannot be empty\n");
            else if(!carModel.matches("[a-zA-Z0-9]+"))
                System.out.println("\nError.. Please enter valid car model\n");
            else
                valid = true;
        }
        if(carModel.equals("ANY"))
            return "";
        return carModel;
    }
    
    /**
    * This method validates the Age of a car.
    */
    public int validateAge()
    {
        int age = 0;
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Age of Car:");
            if(input.hasNextInt())
            {
                age = input.nextInt();
                if(age < 0)
                    System.out.println("\nError.. Enter valid age\n");
                else
                    valid = true;
            }
            else
            {
                System.out.println("\nError.. Enter valid age\n");
                input.next();
            }
        }
        return age;
    }
    
    /**
    * This method validates the price of a car.
    */
    public int validatePrice()
    {
        int carPrice = 0;
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter price of Car:");
            if(input.hasNextInt())
            {
                carPrice = input.nextInt();
                if(carPrice < 0)
                    System.out.println("\nError.. Enter valid price\n");
                else
                    valid = true;
            }
            else
            {
                System.out.println("\nError.. Enter valid price\n");
                input.next();
            }
        }
        return carPrice;
    }
    
    /**
    * This method validates the Minimum price of a car.
    */
    public int validateMin()
    {
        int min = 0;
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Minimum price of Car:");
            if(input.hasNextInt())
            {
                min = input.nextInt();
                if(min < 0)
                    System.out.println("\nError.. Enter valid min price\n");
                else
                    valid = true;
            }
            else
            {
                System.out.println("\nError.. Enter min price\n");
                input.next();
            }
        }
        return min;
    }

    /**
    * This method validates the Maximum price of a car.
    */
    public int validateMax(int min)
    {
        int max = 0;
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter Maximum price of Car:");
            if(input.hasNextInt())
            {
                max = input.nextInt();
                if(max < min)
                    System.out.println("\nError.. Enter valid max price\n");
                else
                    valid = true;
            }
            else
            {
                System.out.println("\nError.. Enter valid max price\n");
                input.next();
            }
        }
        return max;
    }     
    
    /**
    * This method validates the colours of a car.
    */
    public String[] validateColor()
    {
        String[] color = new String[3];
        Scanner input = new Scanner(System.in);
        for( int colorIndex = 0; colorIndex < color.length; colorIndex++)
        {
            boolean valid = false;
            while(!valid)
            {
                System.out.println("Enter Colour" + ( colorIndex + 1) + ":");
                color[colorIndex] = input.nextLine().trim().toUpperCase();
                
                switch(colorIndex)
                {
                   case 0: if(color[0].isEmpty())
                                System.out.println("Color cannot be empty");
                           else if(!color[0].matches("[a-zA-Z]+"))
                                System.out.println("Enter valid colour");
                           else
                                valid = true;
                           break;
                   case 1: if(color[1].isEmpty() && color[0].equals(color[1]))
                                System.out.println("\nColor cannot be same");
                           else if(!color[0].matches("[a-zA-Z]+"))
                                System.out.println("Enter valid colour");
                           else
                                valid = true;
                           break;       
                            
                   case 2: if(color[2].isEmpty() && ( color[0].equals(color[2]) ))
                                System.out.println("\nColor cannot be same");
                           else if(!color[0].matches("[a-zA-Z]+"))
                                System.out.println("Enter valid colour");
                           else
                                valid = true;
                           break;
                }
                
            }
        }
        return color;
    }
    
    /**
    * This method validates the Year Made of a car.
    */
    public int validateYearMade()
    {
        int year = 0;
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        
        while(!valid)
        {
            System.out.print("Enter year made of Car:");
            if(input.hasNextInt())
            {
                year = input.nextInt();
                if(year < 1950 || year > carList.getYear())
                    System.out.println("\nError.. Enter valid year made\n");
                else
                    valid = true;
            }
            else
            {
                System.out.println("\nError.. Enter valid year made\n");
                input.next();
            }
        }
        return year;
    }
}
  
                    
        