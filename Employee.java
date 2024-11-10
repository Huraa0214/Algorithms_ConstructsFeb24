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

    private static void displayAllEmployees() {
        for (Employee employee : employeeList) {
            employee.printEmployeeDetails();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
