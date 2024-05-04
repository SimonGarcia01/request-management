package ui;

import java.util.Scanner;
import model.University;

public class RequestManagementApp{
    //Attributes
    private Scanner sk;

    //Relations
    private University controller;

    //Methods
    //CONSTRUCTOR
    public RequestManagementApp(){
        sk = new Scanner(System.in);
        controller = new University();
    }

    //MAIN
    public static void main(String[] args){
        RequestManagementApp objMain = new RequestManagementApp();

        boolean generalLoop = true;
        int option = 0;

        do{
            option = objMain.menu();

            switch (option) {
                case 1: //To register a collaborator
                    objMain.registerCollaborator();
                    break;

                case 2: //To end the program
                    generalLoop = false;
                    System.out.println("EXITING PROGRAM...");
                    break;
                    
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }

        }while(generalLoop);

    }

    //General methods
    /**
     * <p><b>menu</b></p>
     * <b>Description:</b> Displays a general menu and retrieves the user's choice.
     * After displaying the following options, it prompts the user to enter an option and returns it.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The scanner object {@code sk} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The user's choice is returned as an integer.</li>
     * </ul>
     * 
     * @return The user's choice.
     */
    public int menu(){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("General Menu:\n\t1. Register a collaborator\n\t2. Exit Program");
        System.out.print("Enter one of the options: ");
        int option = sk.nextInt();
        sk.nextLine();
        System.out.println("------------------------------------------------------------------------------------------");
        
        return option;
    }

    /**
     * <p><b>registerCollaborator</b></p>
     * <b>Description:</b> Registers a collaborator based on the user's input.
     * This method guides the user through the process of registering a collaborator by providing options for the type of collaborator (DTI or general) and collecting relevant information such as full name, ID, email, and extension (optional).
     * It then calls the {@link Controller#registerCollaborator(int, String, String, String, String)} method in the controller class to handle the registration process and returns the message indicating the success or failure of the registration.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code intCollabType} must be an int representing the type of collaboratos (1 or 2).</li>
     *   <li>The {@code fullName}, {@code id}, {@code email}, and {@code extension} parameters must be Strings.</li>
     *   <li>The scanner object {@code sk} must be initialized.</li>
     *   <li>The {@code Controller} object {@code controller} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A collaborator is registered based on the user's input, and a message indicating the success or failure of the registration is returned.</li>
     * </ul>
     */

    public void registerCollaborator(){
        System.out.println("REGISTERING A COLLABORATOR:");
        System.out.println("The types of collaborators are:\n\t1. DTI collaborator\n\t2. General collaborator");
        System.out.print("Enter one of the options: ");
        int intCollabType = sk.nextInt();
        sk.nextLine();

        System.out.print("Enter the collaboratos full name: ");
        String fullName = sk.nextLine();

        System.out.print("Enter the collaborator's ID: ");
        String id = sk.nextLine();

        System.out.print("Enter the collaborator's email: ");
        String email = sk.nextLine();
        
        System.out.print("Enter the collaborator's extension (optional): " );
        String extension = sk.nextLine();
        System.out.println(controller.registerCollaborator(intCollabType, fullName, id, email, extension));
        
    }
}