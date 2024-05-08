package model;

import java.util.ArrayList;

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

    public String changeRequestStatus(int intDepartment, int intSubject, int intStatusType){
        return getDepartmentsPendingRequest().get(intDepartment-1).changeRequestStatus(intSubject, intStatusType);
    }

    //CREATE A KNOWLEDGE PROJECT

    public String createProject(String name, int intPriority, int intLeader, int intResponsibleDepartment,  
    int intRequest, int intImpactedCommunity, int intKnowledgeType){
        Department responsibleDepartment = intToDepartment(intResponsibleDepartment);
        Request acceptedRequest = responsibleDepartment.intToRequest(intRequest);

        ImprovementCollaborator leader = null;
        int counter = 0;

        for(Collaborator collaborator : collaborators){
            if(collaborator instanceof ImprovementCollaborator){
                counter++;
                if(counter == intLeader){
                    leader = (ImprovementCollaborator) collaborator;
                }
            }
        }

        return leader.createProject(name, intPriority, acceptedRequest, intImpactedCommunity, intKnowledgeType);
    }

    //CREATE IMPROVEMENT PROJECT

    public String createProject(String name, int intPriority, int intLeader, int intResponsibleDepartment,  
    int intRequest, String processCode){
        Department responsibleDepartment = intToDepartment(intResponsibleDepartment);
        Request acceptedRequest = responsibleDepartment.intToRequest(intRequest);

        ImprovementCollaborator leader = null;
        int counter = 0;

        for(Collaborator collaborator : collaborators){
            if(collaborator instanceof ImprovementCollaborator){
                counter++;
                if(counter == intLeader){
                    leader = (ImprovementCollaborator) collaborator;
                }
            }
        }

        return leader.createProject(name, intPriority, acceptedRequest, processCode);
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

    //ONE MIN REQUEST
    
    public boolean oneMinRequest(int intDepartment){
        return intToDepartment(intDepartment).oneMinRequest();
    }

    //DISPLAY REQUESTS

    public String displayPendingRequests(int intDepartment){
        String message = "Available pending requests: ";
        int counter = 1;

        ArrayList<Request> pendingRequests = intToDepartment(intDepartment).getPendingRequests();

        for(Request request : pendingRequests){
            message += String.format("\n\t%d. Subject: %s", counter, request.getSubject());
            counter++;
        }

        return message;
    }

    //ONE MIN PENDING REQUEST IN ALL PROGRAM
    public boolean oneMinPendingRequest(){

        for(Department department:departments){
            if(department.oneMinPendingRequest()){
                return true;
            }
        }

        return false;
    }

    //DISPLAY STATUS TYPES
    public String displayStatusTypes(){
        return Department.displayStatusTypes();
    }

    //DISPLAY IMPROVEMENT COLLABORATORS

    public String displayDtiCollaborators(){
        String message = "Available DTI collaborators: ";
        int counter = 1;

        for(Collaborator collaborator : collaborators ){
            if(collaborator instanceof ImprovementCollaborator) {
                message += String.format("\n\t%d. Full name: %s - ID: %s", counter, collaborator.getFullName(), 
                collaborator.getId());
                counter++;
            }
        }

        return message;
    }

    //DISPLAY PRIORITY LEVELS

    public String displayPriorities(){
        return Project.displayPriorities();
    }

    //DISPLAY IMPACTED COMMUNITIES

    public String displayImpactCommunities(){
        return ImprovementCollaborator.displayImpactCommunities();
    }

    //DISPLAY KNOWLEDGE TYPES

    public String displayKnowledgeTypes(){
        return ImprovementCollaborator.displayKnowledgeTypes();
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
