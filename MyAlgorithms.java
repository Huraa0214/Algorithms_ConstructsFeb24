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

public class MyAlgorithms {

    // QuickSort implementation with sorting and displaying first 20 applicants
    public static void quickSortsortAndDisplayFirst20(List<Applicant> applicantList, boolean ascending) {
        // Sort the list using quicksort
        quickSort(applicantList, 0, applicantList.size() - 1, ascending);

        // Display the first 20 sorted applicants
        System.out.println("Displaying the first 20 applicants after sorting:");
        for (int i = 0; i < Math.min(20, applicantList.size()); i++) {
            System.out.println(applicantList.get(i));
        }
    }

    // QuickSort algorithm implemented manually with loops
    private static void quickSort(List<Applicant> list, int low, int high, boolean ascending) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, ascending);
            quickSort(list, low, pivotIndex - 1, ascending);  // Sort left side of pivot
            quickSort(list, pivotIndex + 1, high, ascending); // Sort right side of pivot
        }
    }

    // Partition method for QuickSort
    private static int partition(List<Applicant> list, int low, int high, boolean ascending) {
        Applicant pivot = list.get(high);
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // Swap based on ascending or descending order
            if ((ascending && list.get(j).compareTo(pivot) < 0) ||
                (!ascending && list.get(j).compareTo(pivot) > 0)) {
                i++;
                // Swapping elements
                Applicant temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        
        // Place pivot in the correct position
        Applicant temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        
        return i + 1;
    }

    // Linear search implementation for applicants by name
    public static int linearSearch(List<Applicant> applicantList, String applicantName) {
        for (int i = 0; i < applicantList.size(); i++) {
            if (applicantList.get(i).getName().equalsIgnoreCase(applicantName)) {
                System.out.println("Applicant found at index: " + i);
                return i; // Return the index of the applicant
            }
        }
        System.out.println("Applicant not found.");
        return -1; // Return -1 if not found
    }

    // Linear search implementation for employees by name
    public static int linearSearch(List<Employee> employeeList, String employeeName) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equalsIgnoreCase(employeeName)) {
                System.out.println("Employee found at index: " + i);
                return i; // Return the index of the employee
            }
        }
        System.out.println("Employee not found.");
        return -1; // Return -1 if not found
    }
}
