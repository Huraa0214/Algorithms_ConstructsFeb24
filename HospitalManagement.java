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
    private static List<String> applicantList = new ArrayList<>(); // declaring and initializing List to store applicants from file
    private static List<Employee> employeeList = new ArrayList<>(); // List to store employees
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
                    //Calling a Quicksort method (recursive) on applicants names
                    MyAlgorithms.quickSortsortAndDisplayFirst20(applicantList); 
                      //calling quick sort method from MyAlgorithms class, show first 20 feature is defined within
                    System.out.println("Applicants are sorted alphabetically");
                    break;
                    
                case SEARCH_APPLICANTS:
                    //Calling a LinearSearch on applicants
                    System.out.println("Enter an applicants name you would like to search: ");
                    String applicantName = scann.nextLine();
                    int applicantIndex = MyAlgorithms.linearSearch(applicantList, applicantName);
                    if (applicantIndex != -1) { //if there is such named applicant
                        System.out.println(applicantName + " found at index " + applicantIndex);
                    } else {
                        System.out.println(applicantName + "is not found. ");
                    }
                    break;
                
                case SEARCH_EMPLOYEE:
                    //Call Linear Search on Employees
                    //RETURNS WITH THEIR CORRESPONDING ROLE AND DEPARTMENTS
                    System.out.println("Enter an employee name to search: ");
                    String employeeName = scann.nextLine();
                    int employeeIndex = MyAlgorithms.linearSearch(employeeList, employeeName);
                    if (employeeIndex != -1) {
                        Employee foundEmployee = employeeList.get(employeeIndex);
                        System.out.println("Employee found: " + foundEmployee);
                        
                    } else {
                        System.out.println(employeeName + " is not found among the staffs. ");
                    } 
                    break;
                    
                case ADD_EMPLOYEE: 
                    //GIVE 2 OPTION, either add from appliants list or enter new employee
                    addNewEmployee(scann); // uurchlunu
                    break;
                    //this will be defined in Employees.java class 
                case GENERATE_RANDOM_EMPLOYEE:
                    // Generate employee randomly from applicants list
                     Employee randomEmployee = Employee.generateRandomEmployee(applicantList);
                    employeeList.add(randomEmployee);
                    System.out.println("Randomly generated employee added: " + randomEmployee);
                    break;
                    //also will be fully defined in Employees.java class 
                case DISPLAY_EMPLOYEES: 
                    // Display all employees
                    displayAllEmployees();
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
    
    // Method for display 
    
    private static void displayMenu() {
        //used above 
        System.out.println("\nMenu: ");
        for (MenuOption option : MenuOption.values()) {
            // using enhanced for-each loop, option is a variable that takes on 
            // the value of each MenuOption constant one at a time as the loop iterates over the array returned by values().
            System.out.println("(" + option.getValue() + ")" + option.getDescription());
        }
    }
    
    // Enum for the Menu
    // Added integer value and description to make it appear user friendly 
    // rather than all capital letters and underscore as its the convention
    
    private enum MenuOption {
        SORT_APPLICANTS(1, "Sort Applicants"),
        SEARCH_APPLICANTS(2, "Search Applicants"),
        SEARCH_EMPLOYEES(3, "Search Employees"),
        ADD_EMPLOYEE(4, "Add New Employee"),
        GENERATE_RANDOM_EMPLOYEE(5, "Generate Employee Randomly"),
        DISPLAY_EMPLOYEES(6, "Display All Employees"),
        EXIT(7, "Exit");
      
        //fields to store values and descriptions
        private final int value;
        private final String description; 
        
        //constructor for enum constants 
        MenuOption(int value, String description) {
            this.value = value; //assign the value
            this.description = description; //assign the description
        }
        
        //getter method for the numeric value
        
        
        
    }   
       
        
          
    }
    

