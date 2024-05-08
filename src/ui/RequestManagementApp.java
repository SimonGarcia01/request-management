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
                    objMain.registerDepartment();
                    break;
                case 3: //To register a request
                    objMain.registerRequest();
                    break;
                case 4: //To change the status of a request. 
                    //To create a knowledge or improvement project is request is accepted.
                    objMain.changeRequestStatus();
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

        System.out.print("Enter the collaborator's full name: ");
        String fullName = sk.nextLine();

        System.out.print("Enter the collaborator's ID: ");
        String id = sk.nextLine();

        System.out.print("Enter the collaborator's email: ");
        String email = sk.nextLine();
        
        System.out.print("Enter the collaborator's extension (optional): " );
        String extension = sk.nextLine();
        System.out.println(controller.registerCollaborator(intCollabType, fullName, id, email, extension)); 
    }

    //REGISTER A DEPARTMENT
    /**
     * <p><b>registerDepartment</b></p>
     * <b>Description:</b> Registers a new department in the university system.
     * This method ensures there is at least one saved collaborator in the system before allowing department registration (({@link University#oneMinCollaborator()}).
     * It also checks for the existence of a department with the provided internal code before registering ({@link University#searchDepartment(String)})
     * Then it allows the using to enter the rest of the information.
     * The responsable collaborator must be selected from the list made by {@link University#displayCollaborators()}.
     * The method finally calls {@link University#registerDepartment(String, String, String, int)} to create the object.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code internalCode} must be a String.</li>
     *      <li>{@code  name} must be a String.</li>
     *      <li>{@code address} must be a String.</li>
     *      <li>{@code intResponsibleCollaborator} must be an int from the displayed list.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new department is registered in the university system.</li>
     *      <li>If there wasn't at least one preregistered collaborator, the system will ask the user to enter one.</li>
     *      <li>If a department with the provided internal code already exists, an error message is displayed, and the user is prompted to try another internal code.</li>
     * </ul>
     */
    public void registerDepartment(){
        System.out.println("REGISTERING A DEPARTMENT:");
        
        if(controller.oneMinCollaborator()){

            System.out.print("Enter the department's internal code: ");
            String internalCode = sk.nextLine();

            if(controller.searchDepartment(internalCode)==null){
                System.out.print("Enter the name of the department: ");
                String name = sk.nextLine();

                System.out.print("Enter the department's address: ");
                String address = sk.nextLine();

                System.out.println(controller.displayCollaborators());
                System.out.print("Please enter one of the collaborators: ");
                int intResponsibleCollaborator = sk.nextInt();
                sk.nextLine();

                System.out.println(controller.registerDepartment(internalCode, name, address, intResponsibleCollaborator));

            } else {
                System.out.println("A Department with that internal code has already been registered. Please try another one.");
            }
        } else {
            System.out.println("There must be at least one saved collaborator in order to enter a Department.");
        }
    }

    //REGISTER A REQUEST
    /**
     * <p><b>registerRequest</b></p>
     * <b>Description:</b> Registers a new request in the system, assigning it to a responsible collaborator and department.
     *  The system will first make sure there is at least one registered collaborator ({@link University#oneMinCollaborator()}) and one department ({@link University#oneMinDepartment()}).
     *  Then it will display menus where the user can choose a preregistered collaborator ({@link University#displayCollaborators()}) and a department ({@link University#displayDepartments() })
     *  Afterwards the use will be able to add the subject of the request and using {@link University#isDuplicateRequest(int, String)} will verify whether or not there is another request in the list inside the responsible departement.
     *  If there is no duplicate,  finally, the user will enter the description.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code controller} must be initialized.</li>
     *   <li>{@code intResponsibleCollaborator} must be an int chosen from the displayed list of collaborators.</li>
     *   <li>{@code intResponsibleDepartment} must be an int chosen from the displayed list of departments.</li>
     *   <li>{@code subject} must be a String. </li>
     *   <li>{@code description} must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new request is registered with the provided subject, description, responsible department, and responsible collaborator.</li>
     *   <li>If there is not at least one collaborator registered an "at least one collaborator" message will be printed.</li>
     *   <li>If there is not at leaste one department registered an "at least one department" message will be printed.</li>
     *   <li>If there is another request with the same subject within the department a "duplicate" message will be printed. </li>
     * </ul>
     */
    public void registerRequest(){
        System.out.println("REGISTERING A REQUEST:");

        if(controller.oneMinCollaborator()){
            System.out.println(controller.displayCollaborators());
            System.out.print("Enter the collaborator responsible for the new request: ");
            int intResponsibleCollaborator = sk.nextInt();
            sk.nextLine();

            if(controller.oneMinDepartment()){
                System.out.println(controller.displayDepartments());
                System.out.print("Enter one of the displayed departments, responsable for the request: ");
                int intResponsibleDepartment = sk.nextInt();
                sk.nextLine();

                System.out.print("Enter the requests subject:  ");
                String subject = sk.nextLine();

                if(!controller.isDuplicateRequest(intResponsibleDepartment, subject)){

                    System.out.print("Enter the description of the request: ");
                    String description = sk.nextLine();
    
                    System.out.println(controller.registerRequest(subject, description, intResponsibleDepartment, intResponsibleCollaborator));
                    
                } else {
                    System.out.println("A Request with that subject inside that department has already been submitted. Please try another one.");
                }
            } else {
                System.out.println("There must be at least one saved department to mark as reponsible for the request.");
            }
        } else {
            System.out.println("There must be at least one saved collaborator to be able to relate a request to one person.");
        }
    }

    //CHANGE THE STATUS OF A REQUEST
    public void changeRequestStatus(){
        System.out.println("CHANGING THE STATUS OF A REQUEST:");

        if(controller.oneMinDepartment()){
            System.out.println(controller.displayDepartments());
            System.out.print("Enter one of the displayed departments, responsable for the request: ");
            int intResponsibleDepartment = sk.nextInt();
            sk.nextLine();

            if(controller.oneMinRequest(intResponsibleDepartment)){
                System.out.println(controller.displayPendingRequests(intResponsibleDepartment));
                System.out.print("Enter the request which you would like to change the status to: ");
                int intRequest = sk.nextInt();
                sk.nextLine();

                System.out.println(controller.displayStatusTypes());
                System.out.print("Enter the one of the status options: ");
                int intStatusType = sk.nextInt();
                sk.nextLine();

                System.out.println(controller.changeRequestStatus(intResponsibleDepartment, intRequest, intStatusType));

                if(intStatusType==2){
                    createProject(intResponsibleDepartment, intRequest);
                }

            } else {
                System.out.println("The department doesn't have any stored request. Add one.");
            }
        } else {
            System.out.println("There must be at least one registered department that holds the requests.");
        }

    }

    //CREATE A PROJECT
    
    public void createProject(int intResponsibleDepartment, int intRequest){
        System.out.println("Since the request was approved, a project must be created.");
        System.out.println("CREATING A PROJECT:");
        System.out.println("Types of project:\n\t1. Knowledge management project\n\t2. Transformation and improvement project.");
        System.out.print("Please enter one of the types of projects: ");
        int intProjectType = sk.nextInt();
        sk.nextLine();

        System.out.print("Enter the name of the project: ");
        String name = sk.nextLine();

        System.out.println(controller.displayDtiCollaborators());
        System.out.print("Enter the DTI collaborator that will be assigned as a leader: ");
        int intLeader = sk.nextInt();
        sk.nextLine();

        System.out.println(controller.displayPriorities());
        System.out.print("Enter the priority level of the project: ");
        int intPriority = sk.nextInt();
        sk.nextLine();

        if(intProjectType == 1){
            System.out.println(controller.displayImpactCommunities());
            System.out.print("Enter the impacted community: ");
            int intImpactedCommunity = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.displayKnowledgeTypes());
            System.out.print("Enter one of the types of knowledge projects: ");
            int intKnowledgeType = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.createProject(name, intPriority, intLeader, intResponsibleDepartment,  intRequest, intImpactedCommunity, intKnowledgeType));
        } else {
            System.out.print("Enter the process code of the project: ");
            String processCode = sk.nextLine();

            System.out.println(controller.createProject(name, intPriority, intLeader, intResponsibleDepartment, intRequest, processCode));
        }
    }
}