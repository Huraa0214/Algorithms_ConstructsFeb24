package ca_2.Untitled.Algorithms_ConstructsFeb24;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*; // to call file reader, buffered reader and its exceptions
import java.util.*; // to call arraylist, scanner and random function

/**
 *
 * @author air
 */
// This class is to define employees and its constructor and
// define methods that are connected to employee list 

public class Employee {
       // every employee will have these attributes
    
    private String name; //employee name
    private int age; //employee age
    private double salary; //their salary
    private Department department; // Changed to Department object
    private ManagerType managerType; // Changed to ManagerType object
    
    // Constructor to initialize attributes
    public Employee(String name, int age, double salary, Department department, ManagerType managerType) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.managerType = managerType;
    }
    
        // Override to display a readable format when Employee instance is printed
    
            @Override
        public String toString() {
            return "Name: " + name +
                   "\nAge: " + age +
                   "\nSalary: " + salary +
                   "\nDepartment: " + department +
                   "\nManager Type: " + managerType + "\n";
}
    // Getter methods for employee attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    // Here's the method to add new employee from scratch
    // Originally i wanted 
    public static void addNewEmployee(Scanner scann, List <Employee> list) {
        System.out.println("Please enter employee name: ");
        String name = scann.nextLine();

        System.out.println("Please enter employee age: ");
        int age = scann.nextInt();
        scann.nextLine(); 

        System.out.println("Please enter employee salary: ");
        double salary = scann.nextDouble();
        scann.nextLine(); 

        // If user enters different option than department options, 
        // error is handled here, alongside with calling printoption from enums
        Department department = null; 
        Department.printOptions();
        
        while (department == null) { //as long as there;s no valid department value is given yet
        int departmentChoice = scann.nextInt();
        scann.nextLine();
        if (departmentChoice >= 1 && departmentChoice <= Department.values().length) {
            department = Department.values()[departmentChoice - 1];
        } else {
            System.out.println("Invalid choice. Please enter a valid department number.");
        }
    }

    // Handle manager type choice
        ManagerType managerType = null;
        ManagerType.printOptions();
        // preferable here rather than while (true) loop because it avoids infinite looping, 
        // enhances readability, and doesn’t rely on break.
        while (managerType == null) {
        int managerChoice = scann.nextInt();
        scann.nextLine();
        if (managerChoice >= 1 && managerChoice <= ManagerType.values().length) {
            managerType = ManagerType.values()[managerChoice - 1];
        } else {
            System.out.println("Invalid choice. Please enter a valid manager type number.");
        }
    }

    // Create new employee and add to list
    Employee newEmployee = new Employee(name, age, salary, department, managerType);
    list.add(newEmployee);
    System.out.println("New employee added: " + newEmployee);
}
    // Method to create random employee from applicants list to populate the employee list
    // Using HashSet to track already assigned department-manager combinations
    // to avoid conflict with existing Manager types and Departments
    private static Set<String> usedDepartmentManagerCombinations = new HashSet<>();

    public static Employee generateRandomEmployee(List<String> applicantList) {
    // Check if there are any applicants left to choose from
    if (applicantList.isEmpty()) {
        System.out.println("No applicants left to generate.");
        return null;  // Return null if no applicants are available
    }

    // Select a random name from the applicants list
    Random rand = new Random();
    int randomIndex = rand.nextInt(applicantList.size());
    String name = applicantList.get(randomIndex);

    // Remove the selected applicant from the list since they are employees now
    applicantList.remove(randomIndex);

    // Randomly generate age between 22 and 60 (working standart)
    int age = rand.nextInt(39) + 22;

    // Randomly generate salary between 40,000 and 150,000 (Hospital salary range)
    double salary = rand.nextInt(110000) + 40000;
    
 // Generate a random department and manager type, avoiding duplicates
        Department department = null; //start as null so they can be assigned meaningful values later,
        ManagerType managerType = null;

        // Loop until we find a unique department-manager combination
        while (true) {
            department = Department.values()[rand.nextInt(Department.values().length)];
            managerType = ManagerType.values()[rand.nextInt(ManagerType.values().length)];

            String combination = department + "-" + managerType;
            if (!usedDepartmentManagerCombinations.contains(combination)) {
                // Add the combination to the used set
                usedDepartmentManagerCombinations.add(combination);
                break;  // Exit the loop if the combination is unique
            } else {
                // If combination already used, try again
                System.out.println("This role has been filled. Retrying...");
            }
        }

        // Create and return the new employee
        Employee newEmployee = new Employee(name, age, salary, department, managerType);
        return newEmployee;
    }
    
    public static void displayAllEmployees(List<Employee> employeeList) {
    if (employeeList.isEmpty()) {
        System.out.println("No employees to display.");
    } else {
        System.out.println("\nEmployees List:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
            System.out.println("----------------------");
        }
    }
}
}



    
    
    
    
    
    
    
    
    
    
    

