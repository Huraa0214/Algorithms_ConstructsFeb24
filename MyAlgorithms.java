/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2.Untitled.Algorithms_ConstructsFeb24;

/**
 *
 * @author air
 */
import java.util.*;


// In this file, I included one of the most efficient algorithm "Quick Sort" which is a recursive one 
// And linear search on both applicants and employees 

public class MyAlgorithms {

    // QuickSort implementation with sorting and displaying first 20 applicants
    // both in ascending and descending order subject to choice
    
    public static void quickSortAndDisplayFirst20(List<String> applicantList, boolean ascending){
        
        quickSort(applicantList, 0, applicantList.size() - 1, ascending);

        // Display the first 20 sorted applicants
        System.out.println("Displaying the first 20 applicants after sorting:");
        for (int i = 0; i < Math.min(20, applicantList.size()); i++) {
            System.out.println(applicantList.get(i));
        }
    }
    // helper method for quickSort, aka "base case" for the recursion
    // which ensures it continues only if there are two or more elements to sort
    
    private static void quickSort(List<String> list, int low, int high, boolean ascending) {
        if (low < high) { //low being less than high means there is at least 2 elements
            int pivotIndex = partition(list, low, high, ascending);
            quickSort(list, low, pivotIndex - 1, ascending);  // Sort left side of pivot
            quickSort(list, pivotIndex + 1, high, ascending); // Sort right side of pivot
        }
    }
    
    // Partition method for the quickSort
    private static int partition(List<String> list, int low, int high, boolean ascending) {
        String pivot = list.get(high);
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if ((ascending && list.get(j).compareTo(pivot) < 0) ||
                (!ascending && list.get(j).compareTo(pivot) > 0)) {
                i++;
                String temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        
        String temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        
        return i + 1;
    }

    
    // Linear Search method to find an applicant in the list
    // User can enter only the first or last name and it can find it 
    public static void linearSearch(List<String> applicants, String namePart) {
    List<String> matchedApplicants = new ArrayList<>();  // List to store matching applicants
    for (String applicantName : applicants) {
        if (applicantName.toLowerCase().contains(namePart.toLowerCase())) {
            matchedApplicants.add(applicantName); // Add matching names to the list
        }
    }
    
    if (!matchedApplicants.isEmpty()) {
        System.out.println("Found the following applicants matching \"" + namePart + "\":");
        for (String matchedName : matchedApplicants) {
            System.out.println(matchedName); // Print all matching names
        }
    } else {
        System.out.println("No applicants found with the name \"" + namePart + "\".");
    }

    }
// Linear Search for Employees
// Similarly compares in substring instead of whole name
public static void linearSearchEmployees(List<Employee> employees, String namePart) {
    List<Employee> matchedEmployees = new ArrayList<>();  // List to store matching employees
    for (Employee employee : employees) {
        String fullName = employee.getName();  // Assuming Employee class has a getName() method
        
        if (fullName.toLowerCase().contains(namePart.toLowerCase())) {
            matchedEmployees.add(employee); // Add matching employees to the list
        }
    }
    
    if (!matchedEmployees.isEmpty()) {
        System.out.println("Found the following employees matching \"" + namePart + "\":");
        for (Employee matchedEmployee : matchedEmployees) {
            System.out.println(matchedEmployee); // Print all matching employees
        }
    } else {
        System.out.println("No employees found with the name \"" + namePart + "\".");
    }
}
}