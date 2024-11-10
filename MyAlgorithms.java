/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2.Untitled.Algorithms_ConstructsFeb24;

/**
 *
 * @author air
 */
import java.util.List;

// In this file, I included one of the most efficient algorithm "Quick Sort" which is a recursive one 
// And linear search on both applicants and employees 

public class MyAlgorithms {

    // QuickSort implementation with sorting and displaying first 20 applicants
    public static void quickSortAndDisplayFirst20(List<String> applicantList, boolean ascending) {
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
    public static int linearSearch(List<String> list, String target) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equalsIgnoreCase(target)) {
            return i; // Return the index if found
        }
    }
    return -1; // Return -1 if not found
}

// Linear Search for Employees
public static int linearSearchEmployees(List<Employee> list, String target) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getName().equalsIgnoreCase(target)) {
            return i; // Return the index if found
        }
    }
    return -1; // Return -1 if not found
}
}