package ui;

import java.util.Scanner;
import model.University;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class RequestManagementApp{
    //Attributes
    private Scanner sk;

    //Relations
    private University controller;

    //Methods

    //MAIN
    public static void main(String[] args){
        RequestManagementApp objMain = new RequestManagementApp();
        objMain.createBaseDtiCollaborators();

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
                    objMain.closeProject();
                    break;
                case 6: //To display information of the last 5 projects of each team member as a matrix
                    //To access the detailed information of a project from the displayed ones in the matrix
                    objMain.displayProjectMatrix();
                    break;
                case 7: //Review the efficiency of DTI collaborators, projects or requests
                    objMain.reviewEfficiencies();
                    break;
                case 8: //Consult information of projects organized by priority and type
                //Consult the number of projects led by every DTI member
                //Consult the number of received and managed request in a month
                    objMain.registerCollaborator();
                    break;
                
                case 9: //Generate test objects
                    objMain.generateTestObjects();
                    break;

                case 10: //To end the program
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
     *   <li>Generate test objects</li>
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
        System.out.println("General Menu:\n\t1. Register a collaborator\n\t2. Register a department\n\t3. Register a request\n\t4. Change a request's status\n\t5. Close a project\n\t6. Display the last 5 projects (based on query date) of all the DTI collaborators\n\t7. Review efficiency\n\t8. Consult general information\n\t9. Generate test objects\n\t10. Exit Program");
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
    /**
     * <p><b>changeRequestStatus</b></p>
     * <b>Description:</b> Allows changing the status of a pending request within a department.
     * First, it checks if there is at least one preregistered department ({@link University#oneMinDepartment()}).
     * Second, it checks that at least one of those departments has a pending request ({@link University#oneMinPendingRequest()}).
     * Third, it checks if there is at least one registered leader in case the pending request is accepted ({@link University#oneMinLeader()}).
     * If either of those conditions isn't met, the appropriate message is printed.
     * If both filters are passed, then it displays the departments that have at least one pending request ({@link University#displayDepartmentsPendingRequest()}), where the user can select one from.
     * Then, it displays the pending requests inside this department ({@link University#displayPendingRequests(int)}) so the user can choose one.
     * Next, the system displays the three types of status change the request to ({@link University#displayStatusTypes()}) and the user must choose one.
     * Then, the system proceeds to change the status with {@link University#changeRequestStatus(int, int, int)}.
     * If the status is selected, then it will jump to create a project using {@link #createProject(String, String)}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} array must be initialized.</li>
     *      <li>{@code requests} array must be initialized.</li>
     *      <li>{@code oneMinDepartment()}, {@code oneMinPendingRequest()}, and {@code oneMinLeader()} methods should be in place.</li>
     *      <li>{@code displayDepartmentsPendingRequest()}, {@code displayPendingRequests(int)}, and {@code displayStatusTypes()} methods should be in place.</li>
     *      <li>{@code intResponsibleDepartment}, {@code intRequest}, and {@code intStatusType} must all be ints within the range of the displayed menus.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The status of the selected pending request within the department is changed based on the provided status type.</li>
     *      <li>If the status type is set to 2 (Approved), a project is created for the corresponding request.</li>
     *      <li>If there is not at least one preregistered department, it will ask the user to enter one.</li>
     *      <li>If there is not at least one pending request inside a department, the system will ask the user to enter a request.</li>
     * </ul>
     */
    public void changeRequestStatus(){
        System.out.println("CHANGING THE STATUS OF A REQUEST:");

        if(controller.oneMinDepartment()){
            if(controller.oneMinPendingRequest()){
                if(controller.oneMinLeader()){
                    System.out.println(controller.displayDepartmentsPendingRequest());
                    System.out.print("Enter one of the displayed departments, responsable for the pending request: ");
                    int intResponsibleDepartment = sk.nextInt();
                    sk.nextLine();
    
                    System.out.println(controller.displayPendingRequests(intResponsibleDepartment));
                    System.out.print("Enter the request which you would like to change the status to: ");
                    int intRequest = sk.nextInt();
                    sk.nextLine();
    
                    System.out.println(controller.displayStatusTypes());
                    System.out.print("Enter the one of the status options: ");
                    int intStatusType = sk.nextInt();
                    sk.nextLine();

                    String[] results = controller.changeRequestStatus(intResponsibleDepartment, intRequest, intStatusType);
    
                    System.out.println(results[2]);
    
                    if(intStatusType==2){
                        createProject(results[0], results[1]);
                    }
                } else {
                    System.out.println("There should be at least one registered collaborator in case a request is approved and a leader is needed to be assigned.");
                }
            } else {
                System.out.println("There must be at least one department with a pending request.");
            }            
        } else {
            System.out.println("There must be at least one registered department that holds the requests.");
        }

    }

    //CREATE A PROJECT
    /**
     * <p><b>createProject</b></p>
     * <b>Description:</b> Creates a new project based on the approved request and user input.
     *  This method must be used after a pending request is set to approved {@link #changeRequestStatus()}.
     *  This method starts by asking the type of project (knowledge or improvement) and saves the option.
     *  Then, it displays all the possible leaders (only DTI collaborators) using {@link University#displayDtiCollaborators()}.
     *  Next, displays the possible priorities a project can have ({@link University#displayPriorities()}).
     *  Afterwards, depending on the selected type of project it will ask for additional information:
     *  <ul>
     *      <li> Knowledge type: A menu displaying the possible impacted communities ({@link University#displayImpactCommunities()}) and the types of knowledge projects ({@link University#displayKnowledgeTypes()}).</li>
     *      <li> Improvement type: The system will ask to enter the {@code processName}.</li>
     * </ul>
     * Finally, the method invokes the methods {@link University#createProject(String, int, int, String, String, String)} to create an Improvement project or {@link University#createProject(String, int, int, String, String, int, int)} to create a Knowledge project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code responsibleDepartment} and {@code requestSubject} must be valid strings.</li>
     *      <li>{@code sk} must be initialized to read user input.</li>
     *      <li>{@code controller} must be initialized to access necessary methods.</li>
     *      <li>{@code name} and {@code processCode} must be Strings.</li>
     *      <li>{@code intPriority} and {@code intLeader} must be integers selected from the displayed menus.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A Knowledge or an Improvement project is created based on the provided details.</li>
     *      <li>The project is assigned a type, name, leader, priority, and other attributes based on user input.</li>
     * </ul>
     * 
     * @param responsibleDepartment The name of the responsible department for the project.
     * @param requestSubject The subject of the approved request.
     */
    public void createProject(String responsibleDepartment, String requestSubject){
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

            System.out.println(controller.createProject(name, intPriority, intLeader, responsibleDepartment,  requestSubject, intImpactedCommunity, intKnowledgeType));
        } else {
            System.out.print("Enter the process code of the project: ");
            String processCode = sk.nextLine();

            System.out.println(controller.createProject(name, intPriority, intLeader, responsibleDepartment, requestSubject, processCode));
        }
    }

    //CLOSE A PROJECT
    /**
     * <p><b>closeProject</b></p>
     * <b>Description:</b> Closes a project by setting its close date.
     *  This method checks if there is at least one unclosed project ({@link University#oneMinUnclosedProject()}).
     *  If there are unclosed projects, it displays them ({@link University#displayAllOrUnclosedOrClosedProjects(int)}).
     *  The user selects one of the displayed projects, and the method prompts for the close date, ensuring it's after the registration date.
     *  The close date is parsed from user input and set for the selected project using {@link University#closeProject(int, Calendar)}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code sk} must be initialized to read user input.</li>
     *      <li>{@code controller} must be initialized to access necessary methods.</li>
     *      <li>{@code intProject} must be a valid integer representing the index of the project to be closed.</li>
     *      <li>{@code closeDateString} must be a valid string representing the close date in the format dd/MM/yyyy.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The close date of the selected project is set based on user input.</li>
     *      <li>A message indicating the result of the operation is returned.</li>
     * </ul>
     */
    public void closeProject(){
        System.out.println("CLOSING A PROJECT:");

        if(controller.oneMinUnclosedProject()){
            System.out.println(controller.displayAllOrUnclosedOrClosedProjects(2));
            System.out.print("Enter one of the displayed projects: ");
            int intProject = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.showProjClassifDate(intProject));
            System.out.print("Please enter a close date AFTER the shown registration date/(dd/mm/yyyy): ");
            String closeDateString= sk.nextLine();
            Calendar closeDate = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                closeDate.setTime(sdf.parse(closeDateString));
            } catch (ParseException e) {
                System.out.println("The format was incorrect, use: dd/MM/yyyy.");
                return;
            }
                System.out.println(controller.closeProject(intProject, closeDate));
        } else {
            System.out.println("There must be at least one registered unclosed project in order to close one.");
        }
    }

    //DISPLAY MATRIX
    /**
     * <p><b>displayProjectMatrix</b></p>
     * <b>Description:</b> Displays the project matrix for a selected date, showing the 5 most recent projects assigned to each collaborator. 
     * The method prompts the user to enter a date, validates the date format, and retrieves project information starting from the specified date.
     * If there are no projects ({@link University#oneMinProject()}) or no projects starting from the specified date ({@link University#oneMinDateProject(Calendar)}), appropriate messages are displayed.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>There must be at least one registered project in the system ({@link University#oneMinProject()}).</li>
     *      <li>The date entered by the user must be in the format {@code dd/MM/yyyy}.</li>
     *      <li>The date entered must have projects registered from that date onwards ({@link University#oneMinDateProject(Calendar)}).</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If the date is valid and there are projects from that date onwards, the project matrix is displayed.</li>
     *      <li>If the date is invalid or there are no projects from that date onwards, an appropriate message is displayed.</li>
     * </ul>
     */
    public void displayProjectMatrix(){
        System.out.println("DISPLAYING THE PROJECT MATRIX OF A SELECTED DATE: ");

        if(controller.oneMinProject()){
            System.out.print("Please enter the date to view the 5 most recent projects assigned to each collaborator(dd/mm/yyyy): ");
            String dateString= sk.nextLine();
            Calendar date = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date.setTime(sdf.parse(dateString));
            } catch (ParseException e) {
                System.out.println("The format was incorrect, use: dd/MM/yyyy.");
                return;
            }

            if(controller.oneMinDateProject(date)){
                System.out.println(controller.displayProjectMatrix(date));
                System.out.print("Please enter one of the displayed project codes to access its information: ");
                String id = sk.nextLine();
                accessProjectInfo(id, date);

            } else {
                System.out.println("Starting from the selected day onwards, there are no registered projects.");
            }


        } else {
            System.out.println("There must be at least one registered project to display.");
        }
    }

    //DISPLAY PROJECT INFO
    /**
     * <p><b>accessProjectInfo</b></p>
     * <b>Description:</b> Accesses and displays detailed information of a project. 
     * After viewing the project matrix from the {@link #displayProjectMatrix()} method, the user is prompted to enter a project code. 
     *   If the entered code does not match any of the registered projects ({@link University#searchProject(String)}), a message indicating the nonexistence of the project is shown.
     * The method continuously prompts the user until a valid project code is entered. It will also print the same matrix ({@link University#displayProjectMatrix(Calendar)}) for the user to double check the code.
     * Once a valid code is provided, the detailed information of the corresponding project is displayed using the {@link University#displayProjectInfo(String)} method.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>At least one project must be registered in the system.</li>
     *      <li>The entered code must be a 4-letter String.</li>
     *      <li>This method must be used after the {@link #displayProjectMatrix()} method.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The detailed information of the selected project is displayed.</li>
     *      <li>If the entered code does not match any of the existing projects, a message stating that the project doesn't exist is printed instead and will loop through the matrix again.</li>
     * </ul>
     *
     * @param id The ID of the project to access and display detailed information.
     * @param date The date for which the project matrix is displayed, used for presenting available project codes.
     */
    public void accessProjectInfo(String id, Calendar date){
        System.out.println("SHOWING DETAILED INFORMATION OF A PROJECT");
            boolean loop = true;

            do{
                if(controller.searchProject(id) != null) {
                    System.out.println(controller.displayProjectInfo(id));
                    loop = false;
                } else {
                    System.out.println("The entered project code doesn't exist. Please try again.");
                    System.out.println(controller.displayProjectMatrix(date));
                    System.out.print("Please enter one of the displayed project codes to access its information: ");
                    id = sk.nextLine();
                }
            }while(loop);
    }

    //REVIEW EFFICIENCY OF PROJECTS, COLLABORATORS OR REQUEST
    /**
     * <p><b>reviewEfficiencies</b></p>
     * <b>Description:</b> Prompts the user to review the efficiency of a collaborator, project, or request. 
     *  The method first checks if there is at least one registered leader, project, and request. 
     * If all conditions are met, it displays the available options for reviewing efficiencies and processes the user's selection.
     *  The method will then call the methods to review get the necessary info que see the efficiencies ({@link #reviewLeaderEfficiency(int)}, {@link #reviewProjectEfficiency(int)} and {@link #reviewRequestEfficiency(int)}).
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>At least one leader, project, and request must be registered in the system.</li>
     *      <li>{@code intEfficiency} must be an int between 1 and 3.</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If there is at least one registered leader, project, and request, the method prompts the user to select an option to review efficiencies.</li>
     *      <li>Depending on the user's selection, it calls the corresponding method to review the efficiency of a collaborator, project, or request.</li>
     *      <li>If the precondition is not met, it prints a message indicating the absence of registered leaders, projects, or requests.</li>
     * </ul>
     */
    public void reviewEfficiencies(){
        System.out.println("REVIEWING EFFICIENCY OF A COLLABORATOR, PROJECT OR REQUEST:");

        if(controller.oneMinLeader() && controller.oneMinProject() && controller.oneMinRequest()){
            System.out.println("Efficiencies that can be reviewed:\n\t1. DTI collaborator\n\t2. Project\n\t3. Request");
            System.out.print("Enter one of the displayed options: ");
            int intEfficiency = sk.nextInt();
            sk.nextLine();
    
    
            switch(intEfficiency) {
                case 1:
                    reviewLeaderEfficiency(intEfficiency);
                    break;
                case 2:
                    reviewProjectEfficiency(intEfficiency);
                    break;
    
                case 3:
                    reviewRequestEfficiency(intEfficiency);
                    break;
            
                default:
                    System.out.println("You must choose one of the displayed options.");
                    break;
            }

        } else {
            System.out.println("There must be at least one registered leader, project and request to enter this option.");
        }
    }

    //REVIEW LEADER EFFICIENCY

    public void reviewLeaderEfficiency(int intEfficiency){
        System.out.println("REVIEWING A LEADER'S EFFICIENCY:");
        if(controller.oneMinLeaderWProjects()){
            System.out.println(controller.displayLeadersWProjects());
            int intLeader = sk.nextInt();
            sk.nextLine();
            System.out.println(controller.calculateEfficiency(intEfficiency, intLeader));
        } else {
            System.out.println("There must be at least one DTI collaborator with one assigned project to calculate its efficiency.");
        }
    }

    //REVIEW PROJECT EFFICIENCY
    /**
     * <p><b>reviewProjectEfficiency</b></p>
     * <b>Description:</b> Reviews and displays the efficiency of a selected project. 
     * This method first checks if there is at least one closed project available ({@link University#oneMinClosedProject()}). 
     * If this condition is met, it displays all closed projects and prompts the user to select one ({@link University#displayAllOrUnclosedOrClosedProjects(int)}). 
     * The efficiency of the selected project is then calculated and displayed.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>At least one project must be closed in the system.</li>
     *      <li>{@code intEfficiency} and {@code intProject} must be ints representing a displayed option. </li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If there is at least one closed project, the efficiency of the selected project is displayed.</li>
     *      <li>If no closed projects are available, a message indicating this is printed.</li>
     * </ul>
     *
     * @param intEfficiency The type of efficiency to be calculated (although this parameter is not directly used in the method body, it is passed to the {@code calculateEfficiency} method).
     */
    public void reviewProjectEfficiency(int intEfficiency){
        System.out.println("REVIEWING A PROJECT'S EFFICIENCY:");
        if(controller.oneMinClosedProject()){

            System.out.println(controller.displayAllOrUnclosedOrClosedProjects(3));
            System.out.print("Choose one of the displayed options: ");
            int intProject = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.calculateEfficiency(intEfficiency,intProject));

        } else {
            System.out.println("There must be at least one closed project to calculate its efficiency.");
        }
    }

    //REVIEW REQUEST EFFICIENCY
    /**
     * <p><b>reviewRequestEfficiency</b></p>
     * <b>Description:</b> Reviews and displays the efficiency of a selected request. 
     *  This method first checks if there is at least one classified request available ({@link University#oneMinClassifiedRequest()}).
     * If this condition is met, it displays all classified requests and prompts the user to select one({@link University#displayClassifiedRequests()}). 
     * The efficiency of the selected request is then calculated and displayed.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>At least one request must be classified in the system.</li>
     *      <li>{@code intEfficiency} and {@code intRequest} must be ints representing a displayed option. </li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If there is at least one classified request, the efficiency of the selected request is displayed.</li>
     *      <li>If no classified requests are available, a message indicating this is printed.</li>
     * </ul>
     *
     * @param intEfficiency The type of efficiency to be calculated (although this parameter is not directly used in the method body, it is passed to the {@code calculateEfficiency} method).
     */
    public void reviewRequestEfficiency(int intEfficiency){
        System.out.println("REVIEWING A REQUEST'S EFFICIENCY: ");
        if(controller.oneMinClassifiedRequest()){
            System.out.println(controller.displayClassifiedRequests());
            System.out.print("Choose one of the displayed options: ");
            int intRequest = sk.nextInt();
            sk.nextLine();

            System.out.println(controller.calculateEfficiency(intEfficiency, intRequest));

        } else {
            System.out.println("There must be at least one request with a date of classification to calculate its efficiency.");
        }
    }

    //CREATE BASE DTI COLLABORATORS
    /**
     * <p><b>createBaseDtiCollaborators</b></p>
     * <b>Description:</b> Initializes the system by creating four base DTI collaborators. 
     * This method delegates the creation process to the controller's {@link University#createBaseDtiCollaborators()} method.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The controller must be properly initialized and accessible.</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Four base DTI collaborators are created and added to the system.</li>
     * </ul>
     */
    public void createBaseDtiCollaborators(){
        controller.createBaseDtiCollaborators();
    }

    //GENERATE TEST OBJECTS
    /**
     * <p><b>generateTestObjects</b></p>
     * <b>Description:</b> Generates test objects including departments, requests, and projects. 
     *  This method prints a message indicating the creation of test objects and invokes the controller's {@link University#generateTestObjects()} method to perform the actual generation.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The controller must be properly initialized and accessible.</li>
     *      <li>None of the pregenerated test objects should be added.</li>
     *      <li>The option must only be chosen once to prevent an error.</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Test departments, requests, and projects are created and added to the system.</li>
     *      <li>Prints a message indicating the status of the test object generation process.</li>
     * </ul>
     */
    public void generateTestObjects(){
        System.out.println("CREATING TEST OBJECTS:");
        System.out.println(controller.generateTestObjects());
    }

}