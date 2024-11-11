/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2.Untitled.Algorithms_ConstructsFeb24;

import java.io.*; // to call file reader, buffered reader and its exceptions
import java.util.*; // to call arraylist, scanner and random function

// Main class to manage the hospital's employees and applicants.
// Handles the command-line interface and provides options for sorting,
// searching, and generating employees from applicants.

// GITHUB IS NOW LINKED
/**
 *
 * @author air
 */
public class HospitalManagement {

    /**
     * @param args the command line arguments
     */
    private static final List<String> applicantList = new ArrayList<>(); // declaring and initializing List to store applicants from file
    private static final List<Employee> employeeList = new ArrayList<>(); // List to store employees
    //private and static to ensure the employees or applicants list remains accessible across methods while keeping encapsulation within HospitalManagement.
    
    public static void main(String[] args) {
        
       Scanner scann = new Scanner(System.in); // scanner for user input
        System.out.println("Please enter the file name to access: ");   // asking user to enter the file
        String fileName = scann.nextLine(); // capturing the file name from the user
        //Loading the applicants from the file before the menu appears
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; //
           while ((line = br.readLine()) !=null){ //as long is there is more lines
               applicantList.add(line.trim()); //add them in applicantList without any spaces
           }
            System.out.println("Applicants names loaded succesfully");
            
        } catch (FileNotFoundException e) {
              System.out.println("Sorry, File is not found. Make sure file is in the root folder");
         // file not found error handled,
        } catch (IOException e) {
            System.out.println("Sorry, error loading an applicant data.");
        // any issues with reading from file is handled
        } catch (Exception e) {
            System.out.println("Sorry, invalid file content or format. Please try again.");
            // for any other exceptions
        }
        
        int choice; //variable to store user's choice 
        do {
         // Integrated everything in one big menu 
         // instead of having continious or tree-like menu 
         displayMenu(); //method is defined below
            System.out.println("Please enter your choice: ");
            choice = scann.nextInt(); //capturing user's choice
            scann.nextLine(); //consuming a new line 
            
            switch (MenuOption.fromValue(choice)) {
                case SORT_APPLICANTS:
                // Ask the user for the sorting order (ascending or descending)
                int sortOrder;
                boolean ascending;

                do {
                    System.out.println("Choose sorting order:");
                    System.out.println("(1) Ascending");
                    System.out.println("(2) Descending");
                    System.out.print("Enter choice (1 or 2): ");

                    while (!scann.hasNextInt()) {  // Check for non-integer inputs
                        System.out.println("Invalid input. Please enter 1 or 2.");
                        System.out.print("Enter choice (1 or 2): ");
                        scann.next(); // Consume invalid input
                    }

                    sortOrder = scann.nextInt();
                    scann.nextLine(); // consume newline

                    if (sortOrder != 1 && sortOrder != 2) {
                        System.out.println("Invalid choice. Please enter 1 for Ascending or 2 for Descending.");
                    }
                } while (sortOrder != 1 && sortOrder != 2); // Repeat until valid input

                ascending = (sortOrder == 1);  // Set sorting order based on user choice (true for ascending, false for descending)

                // Call quickSortAndDisplayFirst20 with the determined sorting order
                MyAlgorithms.quickSortAndDisplayFirst20(applicantList, ascending);
                System.out.println("Applicants have been sorted and the first 20 are displayed.");
                break;

                case SEARCH_APPLICANTS:
                    //Calling a LinearSearch on applicants
                    System.out.println("Enter an applicants name you would like to search: ");
                    String applicantName = scann.nextLine();
                    int applicantIndex = MyAlgorithms.linearSearch(applicantList, applicantName);
                    if (applicantIndex != -1) { // If a match is found
                        System.out.println("Applicant \"" + applicantName + "\" found at index " + applicantIndex + ":");
                        System.out.println(applicantList.get(applicantIndex)); // Display full applicant name
                    } else {
                        System.out.println("Applicant \"" + applicantName + "\" is not found.");
                    }
                break;
                
                case SEARCH_EMPLOYEES:
                    //Call Linear Search on Employees
                    //RETURNS WITH THEIR CORRESPONDING ROLE AND DEPARTMENTS
                    System.out.println("Enter an employee name to search: ");
                    String employeeName = scann.nextLine();
                    int employeeIndex = MyAlgorithms.linearSearchEmployees(employeeList, employeeName);
                    if (employeeIndex != -1) {
                        Employee foundEmployee = employeeList.get(employeeIndex);
                        System.out.println("Employee found: " + foundEmployee);
                        
                    } else {
                        System.out.println(employeeName + " is not found among the staffs. ");
                    } 
                    break;
                    
                case ADD_EMPLOYEE: 
                    //GIVE 2 OPTION, either add from appliants list or enter new employee
                    //za teriigee zugeer yrichiidoo
                   Employee.addNewEmployee(scann, employeeList); // Pass employeeList to the method
                    //this will be defined in Employees.java class 
                case GENERATE_RANDOM_EMPLOYEE:
                    // Generate employee randomly from applicants list
                     Employee randomEmployee = Employee.generateRandomEmployee(applicantList);
                     if (randomEmployee != null) {
                    employeeList.add(randomEmployee);
                    System.out.println("Randomly generated employee added: " + randomEmployee);
                     }
                    break;
                    //defined in Employees.java class 
                case DISPLAY_EMPLOYEES: 
                    // Display all employees
                    Employee.displayAllEmployees(employeeList);
                    break;
                //also will be defined in Employees.java class 
                //for the sake of clear structure and logic, every method related to employees are there 
                case EXIT: 
                    //exit the menu
                    System.out.println("Exiting the programme...");
                    break;
                    
                default: 
                    System.out.println("Invalid choice, please try again.");
            }
            
        } while (choice != MenuOption.EXIT.getValue()); //as long as choice is not 7, iterates through menu 
                          
        }
    
    // Method for display, private so no one can change the properties 
    
    private static void displayMenu() {
        //used above 
        System.out.println("\nMenu: ");
        for (MenuOption option : MenuOption.values()) {
            // using enhanced for-each loop, option is a variable that takes on 
            // the value of each MenuOption constant one at a time as the loop iterates over the array returned by values().
             System.out.println("(" + option.getValue() + ") " + option.name());
        }
        }
    
    
    // Enum for the Menu
    // Added integer value and description to make it appear user friendly 
    // rather than all capital letters and underscore as its the convention
    
    private enum MenuOption {
        SORT_APPLICANTS(1),
        SEARCH_APPLICANTS(2),
        SEARCH_EMPLOYEES(3),
        ADD_EMPLOYEE(4),
        GENERATE_RANDOM_EMPLOYEE(5),
        DISPLAY_EMPLOYEES(6),
        EXIT(7);
      
        private final int value;
   
        
        //constructor for enum constants 
        MenuOption(int value) {
            this.value = value; //assign the value
            
        }
        
        //getter method for the numeric value, used in displayMenu
        public int getValue(){
            return value;
        }
       
        
         // Method to retrieve enum by its numeric value, used in switch-case
    public static MenuOption fromValue(int value) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == value) {
                return option; // Return the matching enum constant
            }
        }
        return null; // Return null if no match is found
    }
    }  
       
        
          
    }
    

