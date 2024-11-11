/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2.Untitled.Algorithms_ConstructsFeb24;

/**
 *
 * @author air
 */
public enum ManagerType {
    HEAD_DOCTOR,
    ASSISTANT_DOCTOR,
    NURSE_MANAGER,
    CHIEF_SURGEON,
    ADMINISTRIVE_STAFF,
    STAFF;
    
  // Method to print all manager type options
  // Much clearer and concise this way since error also must be handled
    
    public static void printOptions() {
        System.out.println("Please enter manager type:");
        for (int i = 0; i < values().length; i++) {
            System.out.println((i + 1) + ". " + values()[i].name());
        }
    }
}