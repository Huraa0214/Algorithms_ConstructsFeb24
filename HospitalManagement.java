/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_2;

import java.io.*; // to call file reader, buffered reader and its exceptions
import java.util.*; // to call arraylist, scanner and random function

// Main class to manage the hospital's employees and applicants.
// Handles the command-line interface and provides options for sorting,
// searching, and generating employees from applicants.


/**
 *
 * @author air
 */
public class HospitalManagement {

    /**
     * @param args the command line arguments
     */
    private static List<String> applicantList = new ArrayList<>(); // List to store applicants from file
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
            System.out.println("Sorry, error loading applicant data.");
        // any issues with reading from file is handled
        } 
        
        int choice; //variable to store user's choice 
        do {
          //Display menu options 
            System.out.println("\nMenu:");
            System.out.println("(1) Sort Applicants");
            System.out.println("(2) Search Applicants");
            System.out.println("(3) Search Employees");
            System.out.println("(4) Add new Employee");
            System.out.println("(5) Generate Employee randomly");
            System.out.println("(6) Display all employees");
            System.out.println("(7) Exit");
            System.out.println("Please enter your choice: ");
            choice = scann.nextInt();
            
            
            
            
            
        }
        
        
       
        
          
    }
    
}
