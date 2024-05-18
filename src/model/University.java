package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class University {
    //Attributes

    //Relations
    private ArrayList<Collaborator> collaborators;
    private ArrayList<Department> departments;

    //Methods

    //Main Methods --------------------------------------------------------------------------------------------

    //REGISTER A DTI OR GENERAL COLLABORATOR
    /**
     * <p><b>registerCollaborator</b></p>
     * <b>Description:</b> Registers a collaborator based on the provided information and type.
     * This method checks for duplicate collaborators with the same ID using the {@link #searchCollaborator(String)} method.
     * If there is a duplicate collaborator, it returns a message indicating that the collaborator has already been registered.
     * If there is no duplicate, it creates a new instance of either ImprovementCollaborator or general Collaborator based on the provided type.
     * The newly created collaborator is then added to the list of collaborators.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} list must be initialized.</li>
     *   <li>{@code searchCollaborator} method should be in place.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A collaborator is registered based on the provided information and type, and a message indicating the success or failure of the registration is returned.</li>
     * </ul>
     * 
     * @param intType The type of collaborator (1 for DTI, 2 for general).
     * @param fullName The full name of the collaborator.
     * @param id The ID of the collaborator.
     * @param email The email address of the collaborator.
     * @param extension The extension number of the collaborator.
     * @return A message indicating the success or failure of the registration.
     */
    public String registerCollaborator(int intType, String fullName, String id, String email, String extension){
        String message = "";

        if(searchCollaborator(id) == null){

            if(intType == 1){
                collaborators.add(new ImprovementCollaborator(id, fullName, email, extension));
                message = "The DTI collaborator has been registered successfully.";
            } else {
                collaborators.add(new Collaborator(id, fullName, email, extension));
                message = "The general collaborator has been registered successfully.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //REGISTER A DEPARTMENT
    /**
     * <p><b>registerDepartment</b></p>
     * <b>Description:</b> Registers a new department in the university system with the provided internal code, name, address, and responsible collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code internalCode}, {@code name}, and {@code address} must be valid strings.</li>
     *      <li>{@code departments} list must be initialized.</li>
     *      <li>{@code intResponsibleCollaborator} must be a valid index representing the responsible collaborator in the list of available collaborators.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new department is registered in the university system with the provided internal code, name, address, and responsible collaborator.</li>
     *      <li>If there is available space in the {@code departments} list, the new department is added to the list.</li>
     * </ul>
     * 
     * @param internalCode The internal code of the department.
     * @param name The name of the department.
     * @param address The address of the department.
     * @param intResponsibleCollaborator The index of the responsible collaborator in the list of available collaborators.
     * @return A message indicating the success of the department registration.
     */
    public String registerDepartment(String internalCode, String name, String address, int intResponsibleCollaborator){
        departments.add(new Department(address, name, internalCode, intToCollaborator(intResponsibleCollaborator)));
        return "The department has been registered successfully.";
    }

    //REGISTER A REQUEST
    /**
     * <p><b>registerRequest</b></p>
     * <b>Description:</b> Registers a new request with the specified subject, description, responsible department, and responsible collaborator.
     * This method delegates the registration process to the {@link Department#registerRequest(String, String, Collaborator)} method of the responsible department.
     *  This method will convert the intResponsibleCollaborator to a Collaborator and the intResponsibleDepartment to a Department.
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code subject} must be a valid string representing the subject of the request.</li>
     *      <li>{@code description} must be a valid string representing the description of the request.</li>
     *      <li>{@code intResponsibleDepartment} must be a valid index representing the responsible department.</li>
     *      <li>{@code intResponsibleCollaborator} must be a valid index representing the responsible collaborator.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new request is registered with the specified subject, description, responsible department, and responsible collaborator, and a message indicating the success of the registration is returned.</li>
     * </ul>
     * 
     * @param subject The subject of the request.
     * @param description The description of the request.
     * @param intResponsibleDepartment The index of the responsible department.
     * @param intResponsibleCollaborator The index of the responsible collaborator.
     * @return A message indicating the success of the request registration.
     */
    public String registerRequest(String subject, String description, int intResponsibleDepartment, int intResponsibleCollaborator){
        Department responsibleDepartment = intToDepartment(intResponsibleDepartment);
        Collaborator responsibleCollaborator = intToCollaborator(intResponsibleCollaborator);
        return responsibleDepartment.registerRequest(subject, description, responsibleCollaborator);
    }

    //CHANGE THE STATUS OF A REQUEST
    /**
     * <p><b>changeRequestStatus</b></p>
     * <b>Description:</b> Changes the status of a pending request within a department based on user input.
     *  This method retrieves the pending request from the department specified by {@code intDepartment} and invokes the {@link Department#changeRequestStatus(int, int)} method on it.
     *  The method uses {@link #getDepartmentsPendingRequest()} in order to get the array of departments that have a pending requiest and then extract the actual one using the {@code intDepartment}.
     *  Finally it invokes the {@link Department#changeRequestStatus(int, int)} to enter the department and change the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code intDepartment}, {@code intSubject}, and {@code intStatusType} must be valid integers.</li>
     *      <li>{@code getDepartmentsPendingRequest()} method must return a list of departments with pending requests.</li>
     *      <li>The department index ({@code intDepartment}) must be within the range of available departments.</li>
     *      <li>The subject index ({@code intSubject}) must be within the range of pending requests in the specified department.</li>
     *      <li>The status type index ({@code intStatusType}) must be within the range of available status types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The status of the selected pending request within the department is changed based on the provided status type.</li>
     *      <li>The method returns a message indicating the internal code of the department, the subject of the request and the result of the status change.</li>
     * </ul>
     * 
     * @param intDepartment The index of the department containing the pending request.
     * @param intSubject The index of the pending request within the specified department.
     * @param intStatusType The index representing the new status type for the request.
     * @return A string array containing the internal code of the department, the subject of the request, and the message indicating the result of the status change.
     */
    public String[] changeRequestStatus(int intDepartment, int intSubject, int intStatusType){
        return getDepartmentsPendingRequest().get(intDepartment-1).changeRequestStatus(intSubject, intStatusType);
    }

    //CREATE A KNOWLEDGE PROJECT
    /**
     * <p><b>createProject</b></p>
     * <b>Description:</b> Creates a new Knowledge project based on the approved request and user input.
     *  This method retrieves the accepted request using both the responsible department's internal code and the subject of the accepted request.
     *  It first searches for the department using its internal code ({@link #searchDepartment(String)})  and then searches for the request within that department using its subject ({@link Department#searchRequest(String)}).
     *  After obtaining the accepted request, it identifies the leader of the project from the list of improvement collaborators({@link #getImproveCollaborators()})
     *  Once the leader is identified, it invokes the {@link ImprovementCollaborator#createProject(String, int, Request, int, int)} method on the leader object to create the Knowledge project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code collaborators} list must be initialized and contain collaborators.</li>
     *      <li>{@code intPriority}, {@code intLeader}, {@code intImpactedCommunity}, and {@code intKnowledgeType} must be ints from the displayed menus.</li>
     *      <li>The department's internal code ({@code responsibleDepartment}) must be a valid String identifier for the department.</li>
     *      <li>The request subject ({@code requestSubject}) must be a valid String subject for an accepted request.</li>
     *      <li>{@code intLeader} must represent a valid index corresponding to an {@code ImprovementCollaborator}.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A Knowledge project is created based on the provided details.</li>
     *      <li>The project is assigned a name, priority, and other attributes based on user input.</li>
     *      <li>The project leader is assigned based on the selected leader index.</li>
     *      <li>The method returns a message indicating the result of the project creation.</li>
     * </ul>
     * 
     * @param name The name of the project.
     * @param intPriority The priority level of the project.
     * @param intLeader The index of the leader within the list of collaborators.
     * @param responsibleDepartment The internal code of the responsible department for the project.
     * @param requestSubject The subject of the accepted request.
     * @param intImpactedCommunity The index representing the impacted community for the project (applicable for knowledge type projects).
     * @param intKnowledgeType The index representing the type of knowledge project.
     * @return A message indicating the result of the project creation.
     */
    public String createProject(String name, int intPriority, int intLeader, String responsibleDepartment,  
    String requestSubject, int intImpactedCommunity, int intKnowledgeType){

        Request acceptedRequest = searchDepartment(responsibleDepartment).searchRequest(requestSubject);

        ImprovementCollaborator leader = getImproveCollaborators().get(intLeader-1);

        return leader.createProject(name, intPriority, acceptedRequest, intImpactedCommunity, intKnowledgeType);
    }

    //CREATE IMPROVEMENT PROJECT
    /**
     * <p><b>createProject</b></p>
     * <b>Description:</b> Creates a new Improvement project based on the approved request and user input.
     *  This method retrieves the accepted request by searching for the responsible department using its internal code ({@link #searchDepartment(String)}) and then searching for the request within that department using its subject ({@link Department#searchRequest(String)}).
     *  It then retrieves the leader of the project from the list of improvement collaborators using {@link #getImproveCollaborators()}.
     *  Once the leader is identified, it invokes the {@link ImprovementCollaborator#createProject(String, int, Request, String)} method on the leader object to create the Improvement project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code collaborators} list must be initialized and contain collaborators.</li>
     *      <li>{@code intPriority}, {@code intLeader}, and {@code intResponsibleDepartment} must be valid integers.</li>
     *      <li>{@code processCode} must be a String.</li>
     *      <li>The department's internal code ({@code responsibleDepartment}) must be a valid String identifier for the department.</li>
     *      <li>The request subject ({@code requestSubject}) must be a valid String subject for an accepted request.</li>
     *      <li>{@code intLeader} must represent a valid index corresponding to an {@code ImprovementCollaborator}.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>An Improvement project is created based on the provided details.</li>
     *      <li>The project is assigned a name, priority, and other attributes based on user input.</li>
     *      <li>The project leader is assigned based on the selected leader index.</li>
     *      <li>The method returns a message indicating the result of the project creation.</li>
     * </ul>
     * 
     * @param name The name of the project.
     * @param intPriority The priority level of the project.
     * @param intLeader The index of the leader within the list of improvement collaborators.
     * @param responsibleDepartment The internal code of the responsible department for the project.
     * @param requestSubject The subject of the accepted request.
     * @param processCode The process code of the project.
     * @return A message indicating the result of the project creation.
     */
    public String createProject(String name, int intPriority, int intLeader, String responsibleDepartment,  
    String requestSubject, String processCode){

        Request acceptedRequest = searchDepartment(responsibleDepartment).searchRequest(requestSubject);

        ImprovementCollaborator leader = getImproveCollaborators().get(intLeader-1);;

        return leader.createProject(name, intPriority, acceptedRequest, processCode);
    }

    //CLOSE A PROJECT
    /**
     * <p><b>closeProject</b></p>
     * <b>Description:</b> Closes a project by setting its end date.
     *  This method ensures that the entered close date is later than the registration date of the project({@link #isEnteredDateLaterThanClassification(int, Calendar)}).
     *  If the close date is valid, it sets the end date of the project to the provided close date.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code intProject} must be a valid index representing the project to be closed.</li>
     *      <li>{@code closeDate} must be a valid {@code Calendar} object representing the close date.</li>
     *      <li>The close date must be later than the registration date of the project.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The end date of the selected project is set to the provided close date.</li>
     *      <li>A message indicating the result of the operation is returned.</li>
     * </ul>
     * 
     * @param intProject The index of the project to be closed.
     * @param closeDate The close date to be set for the project.
     * @return A message indicating the result of the project closure.
     */
    public String closeProject(int intProject, Calendar closeDate){
        String message = "";

        if(isEnteredDateLaterThanClassification(intProject, closeDate)) {
            Project project = getUnclosedProjects().get(intProject-1);
            project.setEndDate(closeDate);
            message = "The project was closed successfully.";
        } else {
            message = "The selected date must be later than the registration date of the project. Try again.";
        }

        return message;
    }

    //DISPLAY PROJECT MATRIX

    public String displayProjectMatrix(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(date.getTime());

        String message = "\nConsulted date: " + formattedDate + "\n";

        ArrayList<Project[]> last5Projects = new ArrayList<>();

        for (ImprovementCollaborator dtiCollaborator : getImproveCollaborators()) {
            last5Projects.add(dtiCollaborator.getDateProjects(date));
        }

        // Define the fixed widths for each column
        int nameWidth = 20;
        int projectWidth = 30; // Width for one project details

        for (Project[] projects : last5Projects) {
            if (projects[0] != null) {
                String leaderName = projects[0].getLeader().getFullName();
                message += String.format("%-" + nameWidth + "s|", leaderName);

                // Prepare project details
                for (int i = 0; i < projects.length; i++) {
                    if (i < projects.length && projects[i] != null) {
                        Project project = projects[i];
                        SimpleDateFormat estimateDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String estimateDate = estimateDateFormat.format(project.getEstimatedCloseDate().getTime());
                        String projectDetails = project.getId() + " - " + Priority.priorityToLetter(project.getPriorityLevel()) + " - " + estimateDate;

                        int padding = (projectWidth - projectDetails.length()) / 2;
                        message += String.format("%" + padding + "s%-" + (projectWidth - padding) + "s|", "", projectDetails);
                    } else {
                        message += String.format("%-" + projectWidth + "s|", "");
                    }
                }
                message += "\n";
            }
        }

        return message;
    }


    //CALCULATE EFFICIENCY

    public String calculateEfficiency(int intEfficiency, int intSelection){
        String message = "";

        return message;
    }

    //CREATE BASE DTI COLLABORATOR

    public void createBaseDtiCollaborators(){
        registerCollaborator(1, "Simon Garcia", "1006231911", "ssimonggarciaazz@gmail.com", "911");
        registerCollaborator(1, "Diana Brand", "1006110769", "diniBr@gmail.com", "135");
        registerCollaborator(1, "Liliana Franco", "315523535", "lfranco@icesi.edu.co", "642");
        registerCollaborator(1, "Alejandro Londoño", "1107838593", "alejandrolonber25@gmail.com", "666");
    }

    //GENERATE TEST OBJECTS

    public String generateTestObjects(){

        registerDepartment("001", "Transformation and Improvement Office", "AA1", 1);
        registerDepartment("002", "Admitions Office", "AA0", 2);

        registerRequest("Improve Elevator", "The elevator is slow", 1, 1);
        registerRequest("Broken Chair", "Fix the broken chair", 2, 2);
        registerRequest("Flunky lightswitch", "The switch doesn't work", 1, 3);
        registerRequest("Active learning", "Include more online classes", 1, 4);
        registerRequest("Leaking sink", "The bathroom sink is leaking", 2, 3);
        registerRequest("No parking space", "Add more parking spaces", 1, 2);
        registerRequest("Trashcan on fire", "Must put out the fire", 2, 2);

        changeRequestStatus(1, 1, 2);
        createProject("Improve Elevator", 1, 1, "001", "Improve Elevator", "111");

        changeRequestStatus(2, 1, 2);
        createProject("Broken Chair", 2, 2, "002", "Broken Chair", 3, 1);

        changeRequestStatus(1, 1, 2);
        createProject("Flunky lightswitch", 3, 3, "001", "Flunky lightswitch", "333");

        changeRequestStatus(1, 1, 2);
        createProject("Active Learning", 4, 4, "001", "Active Learning", 1, 3);

        changeRequestStatus(2, 1, 2);
        createProject("Leaking sink", 2, 2, "002", "Leaking sink", "666");

        changeRequestStatus(1, 1, 2);
        createProject("No parking space", 3, 3, "001", "No parking space", "999");

        changeRequestStatus(1, 1, 2);
        createProject("Trashcan on fire", 1, 2, "002", "Trashcan on fire", "WIU WIU WIU!");

        return "The test objects have been created successfully.";
    }



    //General Methods ------------------------------------------------------------------------------------------


    //SEARCH FOR A COLLABORATOR
    /**
     * <p><b>searchCollaborator</b></p>
     * <b>Description:</b> Searches for a collaborator with the specified ID.
     * This method iterates through the array of collaborators stored in the university and checks if there is a collaborator with the provided ID.
     * If a collaborator with the matching ID is found, it returns the collaborator object; otherwise, it returns null.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The collaborator object with the specified ID, if found, is returned; otherwise, null is returned.</li>
     * </ul>
     * 
     * @param id The ID of the collaborator to search for.
     * @return The collaborator object with the specified ID, if found; otherwise, null.
     */
    public Collaborator searchCollaborator(String id){
        Collaborator collaborator = null;

        for(Collaborator instCollaborator : collaborators){
            if(instCollaborator!=null && instCollaborator.getId().equals(id)){
                collaborator = instCollaborator;
            }
        }

        return collaborator;
    }

    //DISPLAY EXISTING COLLABORATORS
    /**
     * <p><b>displayCollaborators</b></p>
     * <b>Description:</b> Generates a message listing the available collaborators with their full names and IDs.
     *  The system loops along all the collaborators and extracts their full name and Id and is added to the list.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code collaborators} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message holding a numbered list of the available collaborators with their full names and IDs is generated.</li>
     * </ul>
     * 
     * @return A message listing the available collaborators with their full names and IDs.
     */
    public String displayCollaborators(){
        String message = "Available collaborators: ";
        int counter = 1;

        for(Collaborator collaborator : collaborators){

            message += String.format("\n\t%d. Full name: %s - ID: %s", counter, collaborator.getFullName(), 
            collaborator.getId());
            counter++;

        }

        return message;
    }
    
    //INT TO COLLABORATOR
    /**
     * <p><b>intToCollaborator</b></p>
     * <b>Description:</b> Retrieves the collaborator corresponding to the provided index.
     * The index must be related to the list created by {@link #displayCollaborators()}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code collaborators} list must be initialized.</li>
     *      <li>{@code intResponsibleCollaborator} must be a valid index representing the collaborator.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The collaborator corresponding to the provided index is retrieved.</li>
     * </ul>
     * 
     * @param intResponsibleCollaborator The index of the collaborator in the list of available collaborators.
     * @return The collaborator corresponding to the provided index.
     */
    public Collaborator intToCollaborator(int intResponsibleCollaborator){
        return collaborators.get(intResponsibleCollaborator-1);
    }

    //ATLEAST ONE COLLABORATOR
    /**
     * <p><b>oneMinCollaborator</b></p>
     * <b>Description:</b> Checks if there is at least one saved collaborator in the system.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code collaborators} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns {@code true} if there are no collaborators saved in the system; otherwise, returns {@code false}.</li>
     * </ul>
     * 
     * @return {@code true} if there are no collaborators saved in the system; otherwise, {@code false}.
     */
    public boolean oneMinCollaborator(){
        return !collaborators.isEmpty();
    }

    //GET ONLY THE DTI COLLABORATORS
    /**
     * <p><b>getImproveCollaborators</b></p>
     * <b>Description:</b> Retrieves a list of improvement collaborators from the list of all collaborators.
     *  This method iterates through the list of collaborators and selects those that are instances of {@link ImprovementCollaborator}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code collaborators} list must be initialized and contain collaborators.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>An ArrayList of improvement collaborators is generated from the list of all collaborators.</li>
     *      <li>The method returns a list containing only improvement collaborators.</li>
     * </ul>
     * 
     * @return An ArrayList containing improvement collaborators.
     */
    public ArrayList <ImprovementCollaborator> getImproveCollaborators(){
        ArrayList<ImprovementCollaborator> leaders = new ArrayList<>();

        for(Collaborator collaborator:collaborators){
            if(collaborator instanceof ImprovementCollaborator){
                leaders.add((ImprovementCollaborator) collaborator);
            }
        }

        return leaders;
    }

    //ONE MIN DTI COLLABORATOR
    /**
     * <p><b>oneMinLeader</b></p>
     * <b>Description:</b> Checks if there is at least one improvement collaborator available to lead a project.
     *  This method checks if the list of improvement collaborators is not empty using {@link #getImproveCollaborators()}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code getImproveCollaborators()} method must return a list of improvement collaborators.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns true if there is at least one improvement collaborator available to lead a project; otherwise, returns false.</li>
     * </ul>
     * 
     * @return true if there is at least one improvement collaborator available to lead a project; otherwise, returns false.
     */
    public boolean oneMinLeader(){
        if(!getImproveCollaborators().isEmpty()){
            return true;
        }
        return false;
    }

    //ONE MIN LEADER WITH PROJECT()

    public boolean oneMinLeaderWProjects(){

        ArrayList<ImprovementCollaborator> dtiCollaborators = getImproveCollaborators();

        for(ImprovementCollaborator dtiCollaborator : dtiCollaborators){
            //CONTINUAR LUEGO DE PREGUNTA
        }

        return false;
    }

    //DISPLAY LEADERS WITH PROJECTS IN MONTH???

    public String displayLeadersWProjects(){
        String message = "Available leaders:";

        return message;
    }


    //SEARCH DEPARTMENT
    /**
     * <p><b>searchDepartment</b></p>
     * <b>Description:</b> Searches for a department with the specified internal code.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} list must be initialized.</li>
     *      <li>{@code internalCode} must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If a department with the provided internal code is found, the department object is returned; otherwise, {@code null} is returned.</li>
     * </ul>
     * 
     * @param internalCode The internal code of the department to search for.
     * @return The department object with the specified internal code, if found; otherwise, {@code null}.
     */
    public Department searchDepartment(String internalCode){
        Department instDepartment = null;

        for(Department department  : departments) {
            if(department != null && department.getInternalCode().equalsIgnoreCase(internalCode)){
                instDepartment = department;
            }
        }

        return instDepartment;
    }
    
    //ATLEAST ONE DEPARTMENT
    /**
     * <p><b>oneMinDepartment</b></p>
     * <b>Description:</b> Checks if there is at least one department saved in the system.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} array must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns {@code true} if there is at least one saved department in the system; otherwise, returns {@code false}.</li>
     * </ul>
     * 
     * @return {@code true} if there is at least one saved department in the system; otherwise, {@code false}.
     */
    public boolean oneMinDepartment(){
        return !departments.isEmpty();
    }

    //DISPLAY EXISTING DEPARMENTS
    /**
     * <p><b>displayDepartments</b></p>
     * <b>Description:</b> Generates a message listing the available departments with their names and internal codes.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} array must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message listing the available departments with their names and internal codes is generated.</li>
     * </ul>
     * 
     * @return A message listing the available departments with their names and internal codes.
     */
    public String displayDepartments(){
        String message = "Available departments: ";
        int counter = 1;

        for(Department department : departments){

            message += String.format("\n\t%d. Name: %s - Internal Code: %s", counter, department.getName(), 
            department.getInternalCode());
            counter++;

        }

        return message;
    }
    
    //DISPLAY DEPARTMENTS WITH AT LEAST ONE PENDING REQUEST
    /**
     * <p><b>displayDepartmentsPendingRequest</b></p>
     * <b>Description:</b> Generates a message displaying the available departments with pending requests.
     *  This method invokes the {@link #getDepartmentsPendingRequest()} method to retrieve the list of departments with pending requests.
     *  It then iterates through the list of pending departments to generate a formatted message containing each department's name and internal code.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code getDepartmentsPendingRequest()} method must return a list of departments with pending requests. Can't contain any null.</li>
     *      <li>The {@code getName()} and {@code getInternalCode()} methods must be implemented in the {@link Department} class to retrieve department details.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A formatted message displaying the available departments with pending requests is generated.</li>
     *      <li>The message contains the name and internal code of each department.</li>
     * </ul>
     * 
     * @return A message displaying the available departments with pending requests.
     */
    public String displayDepartmentsPendingRequest(){
        String message = "Available departments with pending requests: ";
        int counter = 1;

        ArrayList<Department> pendingDepartments = getDepartmentsPendingRequest();

        for(Department department : pendingDepartments){

            message += String.format("\n\t%d. Name: %s - Internal Code: %s", counter, department.getName(), 
            department.getInternalCode());
            counter++;

        }

        return message;
    }

    //GET DEPARTMENTS WITH PENDING REQUESTS
    /**
     * <p><b>getDepartmentsPendingRequest</b></p>
     * <b>Description:</b> Retrieves a list of departments with pending requests.
     *  This method iterates through the list of departments and selects those that have at least one pending request using the {@link Department#oneMinPendingRequest()} method.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code departments} list must be initialized and contain departments.</li>
     *      <li>The {@code oneMinPendingRequest()} method must be implemented in the {@link Department} class to check for pending requests.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>An ArrayList of departments with pending requests is generated from the list of all departments.</li>
     *      <li>The method returns a list containing only departments with pending requests.</li>
     * </ul>
     * 
     * @return An ArrayList containing departments with pending requests.
     */
    public ArrayList<Department> getDepartmentsPendingRequest(){
        ArrayList<Department> pendingDepartments = new ArrayList<>();

        for(Department department:departments){
            if(department.oneMinPendingRequest()){
                pendingDepartments.add(department);
            }
        }

        return pendingDepartments;
    }

    //INT TO DEPARTMENT
    /**
     * <p><b>intToDepartment</b></p>
     * <b>Description:</b> Retrieves the department corresponding to the provided index.
     * The index must be related to the list created by {@link #displayDepartments()}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} array must be initialized.</li>
     *      <li>{@code intDepartment} must be a valid index representing the department.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The department corresponding to the provided index is retrieved.</li>
     * </ul>
     * 
     * @param intDepartment The index of the department in the list of available departments.
     * @return The department corresponding to the provided index.
     */
    public Department intToDepartment(int intDepartment){
        return departments.get(intDepartment-1);
    }

    //SEARCH REQUEST
    /**
     * <p><b>isDuplicateRequest</b></p>
     * <b>Description:</b> Checks if there is a duplicate request with the same subject in the specified department.
     * This method delegates the check to the {@link Department#isDuplicateRequest(String)} method of the corresponding department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code intResponsableDepartment} must be a valid index representing the department.</li>
     *      <li>{@code subject} must be a string representing the subject of the request.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns {@code true} if there is a duplicate request with the same subject in the specified department; otherwise, returns {@code false}.</li>
     * </ul>
     * 
     * @param intResponsableDepartment The index of the responsible department.
     * @param subject The subject of the request to check for duplication.
     * @return {@code true} if there is a duplicate request with the same subject in the specified department; otherwise, {@code false}.
     */
    public boolean isDuplicateRequest(int intResponsableDepartment, String subject){
        Department department = intToDepartment(intResponsableDepartment);
        return department.isDuplicateRequest(subject);
    }

    //DISPLAY REQUESTS
    /**
     * <p><b>displayPendingRequests</b></p>
     * <b>Description:</b> Generates a message displaying the available pending requests within the specified department.
     *  This method invokes the {@link #getDepartmentsPendingRequest()} method to retrieve the list of departments with pending requests.
     *  It then retrieves the pending requests from the specified department using the provided index ({@link Department#getPendingRequests()}).
     *  Finally, it iterates through the list of pending requests to generate a formatted message containing each request's subject.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code getDepartmentsPendingRequest()} method must return a list of departments with pending requests.</li>
     *      <li>The department index ({@code intDepartment}) must be within the range of available departments with pending requests.</li>
     *      <li>The {@code getPendingRequests()} method must be implemented in the {@link Department} class to retrieve pending requests.</li>
     *      <li>The {@code getSubject()} method must be implemented in the {@link Request} class to retrieve request details.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A formatted message displaying the available pending requests within the specified department is generated.</li>
     *      <li>The message contains the subject of each pending request.</li>
     * </ul>
     * 
     * @param intDepartment The index of the department to display pending requests for.
     * @return A message displaying the available pending requests within the specified department.
     */
    public String displayPendingRequests(int intDepartment){
        String message = "Available pending requests: ";
        int counter = 1;

        ArrayList<Request> pendingRequests = getDepartmentsPendingRequest().get(intDepartment-1).getPendingRequests();

        for(Request request : pendingRequests){
            message += String.format("\n\t%d. Subject: %s", counter, request.getSubject());
            counter++;
        }

        return message;
    }

    //GET ALL REQUESTS

    public ArrayList<Request>  getAllRequests(){
        ArrayList<Request> allRequests = new ArrayList<>();

        for(Department department : departments){
            allRequests.addAll(department.getRequests());
        }

        return allRequests;
    }

    //GET CLASSIFIED REQUESTS

    public ArrayList<Request> getClassifiedRequests(){
        ArrayList<Request> classifiedRequests = new ArrayList<>();

        for(Request request : getAllRequests()){
            if(request.getClassificationDate() != null){
                classifiedRequests.add(request);
            }
        }

        return classifiedRequests;
    }

    //ONE MIN REQUEST

    public boolean oneMinRequest(){
        if(!getAllRequests().isEmpty()){
            return true;
        }
        
        return false;
    }

    //ONE MIN CLASSIFIED REQUEST

    public boolean oneMinClassifiedRequest(){
        if(!getClassifiedRequests().isEmpty()){
            return true;
        }

        return false;
    }

    //DISPLAY CLASSIFIED REQUESTS
    
    public String displayClassifiedRequests(){
        String message = "Available requests:";

        ArrayList<Request> requests = getClassifiedRequests();

        for(int n = 0; n < requests.size(); n++){
            message += String.format("\n\t%d. Subject: %s - Department: %s / Interal code: %s", (n+1), requests.get(n).getSubject(), 
            requests.get(n).getResponsibleDepartment().getName(), requests.get(n).getResponsibleDepartment().getInternalCode());
        }

        return message;
    }

    //ONE MIN PENDING REQUEST IN ALL PROGRAM
    /**
     * <p><b>oneMinPendingRequest</b></p>
     * <b>Description:</b> Checks if at least one department has pending requests.
     *  This method iterates through the list of departments and checks if at least one department has pending requests using the {@link Department#oneMinPendingRequest()} method.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code departments} list must be initialized and contain departments.</li>
     *      <li>The {@code oneMinPendingRequest()} method must be implemented in the {@link Department} class to check for pending requests.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The method returns {@code true} if at least one department has pending requests; otherwise, it returns {@code false}.</li>
     * </ul>
     * 
     * @return {@code true} if at least one department has pending requests; otherwise, {@code false}.
     */
    public boolean oneMinPendingRequest(){

        for(Department department:departments){
            if(department.oneMinPendingRequest()){
                return true;
            }
        }

        return false;
    }

    //DISPLAY STATUS TYPES
    /**
     * <p><b>displayStatusTypes</b></p>
     * <b>Description:</b> Retrieves a message displaying the available status types for requests.
     *  This method invokes the {@link Department#displayStatusTypes()} method to retrieve a message containing the available status types for requests.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code displayStatusTypes()} method must be implemented in the {@link Department} class to provide a message with available status types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message containing the available status types for requests is retrieved and returned.</li>
     * </ul>
     * 
     * @return A message containing the available status types for requests.
     */
    public String displayStatusTypes(){
        return Department.displayStatusTypes();
    }

    //DISPLAY IMPROVEMENT COLLABORATORS
    /**
     * <p><b>displayDtiCollaborators</b></p>
     * <b>Description:</b> Generates a message displaying the available DTI collaborators.
     *  This method invokes the {@link #getImproveCollaborators()} method to retrieve a list of improvement collaborators.
     *  It then iterates through the list of improvement collaborators to generate a formatted message containing each collaborator's full name and ID.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code getImproveCollaborators()} method must return a list of improvement collaborators.</li>
     *      <li>The {@code getFullName()} and {@code getId()} methods must be implemented in the {@link ImprovementCollaborator} class to retrieve collaborator details.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A formatted message displaying the available DTI collaborators is generated.</li>
     *      <li>The message contains the full name and ID of each DTI collaborator.</li>
     * </ul>
     * 
     * @return A message displaying the available DTI collaborators.
     */
    public String displayDtiCollaborators(){
        String message = "Available DTI collaborators: ";

        ArrayList<ImprovementCollaborator> leaders = getImproveCollaborators();

        for(int n = 0; n < leaders.size(); n++){
                message += String.format("\n\t%d. Full name: %s - ID: %s", (n+1), leaders.get(n).getFullName(), 
                leaders.get(n).getId());
            }

        return message;
    }

    //DISPLAY PRIORITY LEVELS
    /**
     * <p><b>displayPriorities</b></p>
     * <b>Description:</b> Retrieves a message displaying the available priority levels for projects.
     *  This method invokes the {@link Project#displayPriorities()} method to retrieve a message containing the available priority levels for projects.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code displayPriorities()} method must be implemented in the {@link Project} class to provide a message with available priority levels.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message containing the available priority levels for projects is retrieved.</li>
     *      <li>The message is returned to the caller.</li>
     * </ul>
     * 
     * @return A message containing the available priority levels for projects.
     */
    public String displayPriorities(){
        return Project.displayPriorities();
    }

    //DISPLAY IMPACTED COMMUNITIES
    /**
     * <p><b>displayImpactCommunities</b></p>
     * <b>Description:</b> Retrieves a message displaying the available impact communities for projects.
     *  This method invokes the {@link ImprovementCollaborator#displayImpactCommunities()} method to retrieve a message containing the available impact communities for projects.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code displayImpactCommunities()} method must be implemented in the {@link ImprovementCollaborator} class to provide a message with available impact communities.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message containing the available impact communities for projects is retrieved and returned.</li>
     * </ul>
     * 
     * @return A message containing the available impact communities for projects.
     */
    public String displayImpactCommunities(){
        return ImprovementCollaborator.displayImpactCommunities();
    }

    //DISPLAY KNOWLEDGE TYPES
    /**
     * <p><b>displayKnowledgeTypes</b></p>
     * <b>Description:</b> Retrieves a message displaying the available knowledge types projects.
     *  This method invokes the {@link ImprovementCollaborator#displayKnowledgeTypes()} method to retrieve a message containing the available knowledge types for projects.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code displayKnowledgeTypes()} method must be implemented in the {@link ImprovementCollaborator} class to provide a message with available knowledge types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message containing the available knowledge types projects is retrieved and returned.</li>
     * </ul>
     * 
     * @return A message containing the available knowledge types projects.
     */
    public String displayKnowledgeTypes(){
        return ImprovementCollaborator.displayKnowledgeTypes();
    }

    //ONE MIN CLOSED PROJECT

    public boolean oneMinClosedProject(){
        
        if(!getClosedProjects().isEmpty()) {
            return true;
        }

        return false;
    }

    //ONE MIN UNCLOSED PROJECT
    /**
     * <p><b>oneMinUnclosedProject</b></p>
     * <b>Description:</b> Checks if there is at least one unclosed project in the system.
     * This method relies on the {@link #getUnclosedProjects()} method to retrieve the list of unclosed projects.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of unclosed projects must be initialized and contain projects.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns true if there is at least one unclosed project; otherwise, returns false.</li>
     * </ul>
     * 
     * @return True if there is at least one unclosed project; otherwise, false.
     */
    public boolean oneMinUnclosedProject(){
        if(!getUnclosedProjects().isEmpty()){
            return true;
        }

        return false;
    }

    //ONE MIN PROJECT
    /**
     * <p><b>oneMinProject</b></p>
     * <b>Description:</b> Checks if there is at least one project registered in the system.
     *  The system gathers all the projects using {@link #getAllProjects()} and then checks if ther ArrayList is empty o not.
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of all projects must be initialized and contain projects.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns true if there is at least one registered project; otherwise, returns false.</li>
     * </ul>
     * 
     * @return True if there is at least one registered project; otherwise, false.
     */
    public boolean oneMinProject(){ 
        if(!getAllProjects().isEmpty()){
            return true;
        }

        return false;
    }

    //ONE MIN PROJECT BASED ON DATE

    public boolean oneMinDateProject(Calendar date){
        if(!getDateProject(date).isEmpty()){
            return true;
        }

        return false;
    }

    //GET ALL PROJECTS
    /**
     * <p><b>getAllProjects</b></p>
     * <b>Description:</b> Retrieves all projects led by improvement collaborators in the system.
     * This method collects projects led by each improvement collaborator using the {@link #getImproveCollaborators()} and {@link ImprovementCollaborator#getLedProjects()} methods.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of {@code improvement collaborators} must be initialized and contain collaborators.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns an ArrayList containing all projects led by improvement collaborators.</li>
     * </ul>
     * 
     * @return An ArrayList containing all projects led by improvement collaborators.
     */
    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projects = new ArrayList<>();

        for(ImprovementCollaborator dtiCollaborator : getImproveCollaborators()){
            projects.addAll(dtiCollaborator.getLedProjects());
        }

        return projects;
    }

    //GET UNCLOSED PROJECTS
    /**
     * <p><b>getUnclosedProjects</b></p>
     * <b>Description:</b> Retrieves all unclosed projects in the system.
     * This method utilizes the {@link #getAllProjects()} method to obtain a list of all projects in the system.
     * It then iterates through each project, checking if its end date is null to determine if it is unclosed.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of all projects must be initialized and contain projects.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns an ArrayList containing all unclosed projects in the system.</li>
     * </ul>
     * 
     * @return An ArrayList containing all unclosed projects in the system.
     */
    public ArrayList<Project> getUnclosedProjects(){
        ArrayList<Project> allProjects = getAllProjects();
        ArrayList<Project> unclosedProjects = new ArrayList<>();

        for(Project project:allProjects){
            if(project.getEndDate()==null){
                unclosedProjects.add(project);
            }
        }

        return unclosedProjects;
    }

    //GET CLOSED PROJECTS
    
    public ArrayList<Project> getClosedProjects(){
        ArrayList<Project> allProjects = getAllProjects();
        ArrayList<Project> closedProjects = new ArrayList<>();

        for(Project project:allProjects){
            if(project.getEndDate()!=null){
                closedProjects.add(project);
            }
        }

        return closedProjects;
    }

    //GET PROJECTS BASED ON DATE

    public ArrayList<Project> getDateProject(Calendar date){
        ArrayList<Project> dateProjects = new ArrayList<>();
        
        for(Project project : getAllProjects()){
            if(project.getClassificationDate().compareTo(date)>=0){
                dateProjects.add(project);
            }

        }

        return dateProjects;
    }

    //DISPLAY ALL, UNCLOSED OR CLOSED PROJECTS CHECKEARRRRRR
    /**
     * <p><b>displayAllOrUnclosedProjects</b></p>
     * <b>Description:</b> Generates a formatted message displaying either all projects or only unclosed projects in the system,
     * based on the specified group.
     * This method utilizes the {@link #getAllProjects()} and {@link #getUnclosedProjects()} methods to obtain the list of projects,
     * depending on the specified group.
     * It then iterates through each project in the list, formatting its name and ID, and appending it to the message.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>If {@code intGroup} is 1, the list of all projects must be initialized and contain projects.</li>
     *      <li>If {@code intGroup} is 2, the list of unclosed projects must be initialized and contain projects.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a formatted message displaying either all projects or only unclosed projects, based on the specified group.</li>
     * </ul>
     * 
     * @param intGroup An integer representing the group of projects to display (1 for all projects, 2 for unclosed projects).
     * @return A formatted message displaying either all projects or only unclosed projects, based on the specified group.
     */
    public String displayAllOrUnclosedOrClosedProjects(int intGroup){
        String message = "Available projects: ";
        int counter = 1;
        ArrayList <Project> projectList = new ArrayList<>();

        if(intGroup==1){
            projectList = getAllProjects();
        } else if(intGroup == 2) {
            projectList = getUnclosedProjects();
        } else if(intGroup == 3) {
            projectList = getClosedProjects();
        }

        for(Project project : projectList){
            message += String.format("\n\t%d. Project name: %s - ID: %s", counter, project.getName(), 
            project.getId());
            counter++;
        }

        return message;
    }

    //SHOW THE DATE OF CLASSIFICATION OF THE SELECTED PROJECT
    /**
     * <p><b>showProjClassifDate</b></p>
     * <b>Description:</b> Retrieves and formats the classification date of a specified unclosed project.
     * This method utilizes the {@link #getUnclosedProjects()} method to obtain a list of all unclosed projects,
     * then retrieves the project at the specified index.
     * It formats the classification date of the project and returns it as a string.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of unclosed projects must be initialized and contain projects (can't be a {@code null})</li>
     *      <li>{@code intProject} must be a valid index corresponding to an unclosed project.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a formatted string indicating the classification date of the specified project.</li>
     * </ul>
     * 
     * @param intProject The index of the project for which to show the classification date.
     * @return A string indicating the classification date of the specified project.
     */
    public String showProjClassifDate(int intProject){

        Project project = getUnclosedProjects().get(intProject-1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(project.getClassificationDate().getTime());

        return String.format("The registration date of the project is: %s", formattedDate);
    }

    //MAKE SURE THE ENTERED DATE IS LATER THAN THE REGISTRATION DATE OF THE PROJECT
    /**
     * <p><b>isEnteredDateLaterThanClassification</b></p>
     * <b>Description:</b> Checks if the entered date is later than the classification date of a specified project.
     * This method retrieves the classification date of the specified project using the {@link Project#getClassificationDate()} method.
     * It compares the entered date with the classification date and returns true if the entered date is later, false otherwise.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of all projects must be initialized and contain projects.</li>
     *      <li>{@code intProject} must be a valid index corresponding to a project in the system.</li>
     *      <li>{@code enteredDate} must be a valid Calendar object representing the entered date.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns true if the entered date is later than the classification date of the specified project; otherwise, returns false.</li>
     * </ul>
     * 
     * @param intProject The index of the project to compare the entered date with.
     * @param enteredDate The entered date to compare with the classification date of the project.
     * @return True if the entered date is later than the classification date of the project; otherwise, false.
     */
    public boolean isEnteredDateLaterThanClassification(int intProject, Calendar enteredDate) {
        Project project = getAllProjects().get(intProject - 1);

        Calendar classificationDate = project.getClassificationDate();

        return enteredDate.getTimeInMillis() > classificationDate.getTimeInMillis();
    }

    //DISPLAY PROJECT INFO
    /**
     * <p><b>displayProjectInfo</b></p>
     * <b>Description:</b> Retrieves and displays detailed information of a specified project.
     * This method retrieves the project at the specified index using the {@link #getAllProjects()} method,
     * then calls its {@link Project#toString()} method to obtain its detailed information.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The list of all projects must be initialized and contain projects (There must be no {@code null} or empty array)</li>
     *      <li>{@code intProject} must be a valid index corresponding to a project in the system.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a string containing detailed information of the specified project.</li>
     * </ul>
     * 
     * @param intProject The index of the project for which to display detailed information.
     * @return A string containing detailed information of the specified project.
     */
    public String displayProjectInfo(int intProject){
        return getAllProjects().get(intProject-1).toString();
    }

    //CONSTRUCTOR
    /**
     * <p><b>University</b></p>
     * <b>Description:</b> Constructs a new University object with empty lists of collaborators and departments.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code None}: No preconditions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new University object is created with empty lists of collaborators and departments.</li>
     * </ul>
     */
    public University(){
        this.collaborators = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    //GETTERS AND SETTERS
    /**
     * <p><b>getCollaborators</b></p>
     * <b>Description:</b> Retrieves the list of collaborators stored in the university.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The list of collaborators stored in the university is returned.</li>
     * </ul>
     * 
     * @return The list of collaborators stored in the university.
     */
    public ArrayList<Collaborator> getCollaborators() {
        return collaborators;
    }
    
    /**
     * <p><b>getDepartments</b></p>
     * <b>Description:</b> Retrieves the list of departments stored in the university.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code departments} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns the list of departments stored in the university.</li>
     * </ul>
     * 
     * @return The list of departments stored in the university.
     */
    public ArrayList<Department> getDepartments(){
        return departments;
    }
}
