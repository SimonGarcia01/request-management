package ui;

import java.util.Scanner;
import model.University;

public class RequestManagementApp{
    //Attributes
    private Scanner sk;

    //Relations
    private University controller;

    //Methods

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
                case 2: //To register a department
                    objMain.registerCollaborator();
                    break;
                case 3: //To register a request
                    objMain.registerCollaborator();
                    break;
                case 4: //To change the status of a request. 
                    //To create a knowledge or improvement project is request is accepted.
                    objMain.registerCollaborator();
                    break;
                case 5: //To close a project
                    objMain.registerCollaborator();
                    break;
                case 6: //To display information of the last 5 projects of each team member as a matrix
                    //Tio ccess the detailed information of a project from the displayed ones in the matrix
                objMain.registerCollaborator();
                    break;
                case 7: //Review the efficiency of DTI collaborators, projects or requests
                    objMain.registerCollaborator();
                    break;
                case 8: //Consult information of projects organized by priority and type
                //Consult the number of projects led by every DTI member
                //Consult the number of received and managed request in a month
                    objMain.registerCollaborator();
                    break;

                case 9: //To end the program
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

     //CONSTRUCTOR
    /**
     * <p><b>RequestManagementApp</b></p>
     * <b>Description:</b> Constructs a new RequestManagementApp object.
     * This constructor initializes a new instance of RequestManagementApp.
     * It also initializes a Scanner object for user input and a University object for managing requests.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code None}: No preconditions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new RequestManagementApp object is created with a Scanner object for user input and a University object for managing requests.</li>
     * </ul>
     */
public RequestManagementApp(){
    sk = new Scanner(System.in);
    controller = new University();
}

    //GENERAL MENU
    /**
     * <p><b>Menu</b></p>
     * <b>Description:</b> Displays a general menu and retrieves the user's choice.
     * After displaying the following options, it prompts the user to enter an option and returns it.
     * 
     * <p><b>Options:</b></p>
     * <ol>
     *   <li>Register a collaborator</li>
     *   <li>Register a department</li>
     *   <li>Register a request</li>
     *   <li>Change a request's status
     *       <ul>
     *           <li>Allows to create a Knowledge Management Project</li>
     *           <li>Allows to create a Transformation and Improvement Project</li>
     *       </ul>
     *   </li>
     *   <li>Close a project</li>
     *   <li>Display the last 5 projects (based on query date) of all the DTI collaborators
     *       <ul>
     *           <li>Allows to access the detailed information of a project</li>
     *       </ul>
     *   </li>
     *   <li>Review efficiency:
     *       <ul>
     *           <li>DTI collaborator</li>
     *           <li>Project</li>
     *           <li>Request</li>
     *       </ul>
     *   </li>
     *   <li>Consult general information:
     *       <ul>
     *           <li>Projects organized by priority and type</li>
     *           <li>Projects led by every DTI team member</li>
     *           <li>Number of received and managed requests</li>
     *       </ul>
     *   </li>
     *   <li>Exit Program</li>
     * </ol>
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
        System.out.println("General Menu:\n\t1. Register a collaborator\n\t2. Register a department\n\t3. Register a request\n\t4. Change a request's status\n\t5. Close a project\n\t6. Display the last 5 projects (based on query date) of all the DTI collaborators \n\t7. Review efficiency\n\t8. Consult general information\n\t9. Exit Program");
        System.out.print("Enter one of the options: ");
        int option = sk.nextInt();
        sk.nextLine();
        System.out.println("------------------------------------------------------------------------------------------");
        
        return option;
    }

    //REGISTER A COLLABORATOR
    /**
     * <p><b>registerCollaborator</b></p>
     * <b>Description:</b> Registers a collaborator based on the user's input.
     * This method guides the user through the process of registering a collaborator by providing options for the type of collaborator (DTI or general) and collecting relevant information such as full name, ID, email, and extension (optional).
     * It then calls the {@link University#registerCollaborator(int, String, String, String, String)} method in the controller class to handle the registration process and returns the message indicating the success or failure of the registration.
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