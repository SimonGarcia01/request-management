package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Department {
    //Attributes
    private String address;
    private String name;
    private String internalCode;

    //Relations
    private Collaborator responsibleCollaborator;
    private ArrayList<Request> requests;

    //Methods

    //REGISTER REQUEST
    /**
 * <p><b>registerRequest</b></p>
 * <b>Description:</b> Registers a new request within the department with the specified subject, description, and responsible collaborator.
 * 
 * <p><b>Preconditions:</b></p>
 * <ul>
 *      <li>{@code subject} must be a valid string representing the subject of the request.</li>
 *      <li>{@code description} must be a valid string representing the description of the request.</li>
 *      <li>{@code responsibleCollaborator} must be a valid instance of {@link Collaborator} representing the responsible collaborator.</li>
 * </ul>
 * 
 * <p><b>Postconditions:</b></p>
 * <ul>
 *      <li>A new request is registered within the department with the specified subject, description, and responsible collaborator.</li>
 *      <li>The newly created request is added to the list of requests associated with the department. The department itself is also saved withing the request.</li>
 *      <li>A message indicating the success of the request registration is returned.</li>
 * </ul>
 * 
 * @param subject The subject of the request.
 * @param description The description of the request.
 * @param responsibleCollaborator The responsible collaborator for the request.
 * @return A message indicating the success of the request registration.
 */
    public String registerRequest(String subject, String description, Collaborator responsibleCollaborator){
        Request newRequest = new Request(subject, description, this, responsibleCollaborator);
        requests.add(newRequest);

        return "The request has been saved successfully.";
    }

    //CHANGE REQUEST STATUS
    /**
     * <p><b>changeRequestStatus</b></p>
     * <b>Description:</b> Changes the status of a pending request within the department based on user input.
     *  This method retrieves the pending request from the list of pending requests ({@link #getPendingRequests()})and sets its status based on the provided status type.
     *  If the status type indicates approval or denial, the method also sets the classification date for the request.
     *  If the request is set to pending it will only return that the status has been left untouched.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code intSubject} and {@code intStatusType} must be valid integers.</li>
     *      <li>The department must have pending requests in its list of pending requests.</li>
     *      <li>The request index ({@code intSubject}) must be within the range of pending requests.</li>
     *      <li>The status type index ({@code intStatusType}) must be a number between 1 and 3.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The status of the selected pending request within the department is changed based on the provided status type.</li>
     *      <li>If the status type indicates approval or denial, the classification date for the request is set to the current date and time.</li>
     *      <li>If the status type is left as pending, it will only return a message.</li>
     *      <li>A message indicating the result of the status change is returned.</li>
     * </ul>
     * 
     * @param intSubject The index of the pending request within the department's list of pending requests.
     * @param intStatusType The index representing the new status type for the request.
     * @return A message indicating the result of the status change.
     */
    public String[] changeRequestStatus(int intSubject, int intStatusType){
        String[] results = new String[3];
        
        String message = "";
        
        Request request = getPendingRequests().get(intSubject-1);

        request.setStatus(StatusType.intToStatus(intStatusType));

        if(intStatusType == 2){
            request.setClassificationDate(Calendar.getInstance());
            message = "The status has been changed to approved."; 
        } else if(intStatusType == 3) {
            request.setClassificationDate(Calendar.getInstance());
            message = "The status has been changed to denied."; 
        } else {
            message = "The status has been left pending.";
        }

        results[0] = this.internalCode;
        results[1] = request.getSubject();
        results[2] = message;

        return results;
    }

    //IS DUPLICATE REQUEST
    /**
     * <p><b>isDuplicateRequest</b></p>
     * <b>Description:</b> Checks if there is a duplicate request with the specified subject within the department.
     *  Uses the method {@link #searchRequest(String)} in order to check if there is a duplicate or not.
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code subject} must be a valid string representing the subject of the request.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns {@code true} if there is a duplicate request with the specified subject within the department; otherwise, returns {@code false}.</li>
     * </ul>
     * 
     * @param subject The subject of the request to check for duplication.
     * @return {@code true} if there is a duplicate request with the specified subject within the department; otherwise, {@code false}.
     */
    public boolean isDuplicateRequest(String subject){
        boolean isDuplicate = false;

        if(searchRequest(subject)!=null){
            isDuplicate = true;
        }
    
        return isDuplicate;
    }

    //SEARCH REQUEST
    /**
     * <p><b>searchRequest</b></p>
     * <b>Description:</b> Searches for a request with the specified subject within the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>{@code subject} must be a valid string representing the subject of the request.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If a request with the provided subject is found within the department, the request object is returned; otherwise, {@code null} is returned.</li>
     * </ul>
     * 
     * @param subject The subject of the request to search for.
     * @return The request object with the specified subject, if found; otherwise, {@code null}.
     */
    public Request searchRequest(String subject){
        Request searchedRequest = null;

        for(Request request : requests){
            if(request.getSubject().equalsIgnoreCase(subject)) {
                searchedRequest = request;
            }
        }

        return searchedRequest;
    }

    //ONE MIN PENDING REQUEST
    /**
     * <p><b>oneMinPendingRequest</b></p>
     * <b>Description:</b> Checks if there is at least one pending request in the department awaiting approval.
     *  This method iterates through the list of requests in the department and checks if any request has a status indicating that it is pending approval.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code requests} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The method returns {@code true} if there is at least one pending request in the department awaiting approval (status type 1), otherwise it returns {@code false}.</li>
     * </ul>
     * 
     * @return {@code true} if there is at least one pending request in the department awaiting approval, {@code false} otherwise.
     */
    public boolean oneMinPendingRequest(){
        
        if(!getPendingRequests().isEmpty()){
            return true;
        }

        return false;
    }

    //GET PENDING REQUEST ONLY
    /**
     * <p><b>getPendingRequests</b></p>
     * <b>Description:</b> Retrieves a list of pending requests awaiting approval in the department.
     *  This method iterates through the list of requests in the department and adds those with a status indicating that they are pending approval to the list of pending requests.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code requests} list must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A list of pending requests awaiting approval in the department is retrieved.</li>
     *      <li>The list contains requests with a status indicating that they are pending approval (status type 1 with {@link StatusType#intToStatus(int)}).</li>
     * </ul>
     * 
     * @return A list of pending requests awaiting approval in the department.
     */
    public ArrayList<Request> getPendingRequests(){
        ArrayList<Request> pendingRequests = new ArrayList<>();

        for(Request request : requests){
            if(request.getStatus() == StatusType.intToStatus(1)){
                pendingRequests.add(request);
            }
        }

        return pendingRequests;
    }

    //GET STRING WITH ALL STATUS TYPES
    /**
     * <p><b>displayStatusTypes</b></p>
     * <b>Description:</b> Retrieves a message displaying the available status types for requests.
     *  This method delegates the task of generating the message to the {@link Request#displayStatusTypes()} method in the {@link Request} class.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@link Request} class must implement the {@link Request#displayStatusTypes()} method to provide a message with available status types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A message containing the available status types for requests is retrieved and returned.</li>
     * </ul>
     * 
     * @return A message containing the available status types for requests.
     */
    public static String displayStatusTypes(){
        return Request.displayStatusTypes();
    }

    //CONSTRUCTOR
    /**
     * <p><b>Department</b></p>
     * <b>Description:</b> Constructs a new Department object with the specified address, name, internal code, and responsible collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code address}, {@code name}, and {@code internalCode} parameters must be of type String.</li>
     *      <li>The {@code responsibleCollaborator} parameter must be an instance of Collaborator.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new Department object is created with the provided address, name, internal code, and responsible collaborator.</li>
     *   <li>The Department object is also initialized with an empty ArrayList of Requests.</li>
     * </ul>
     * 
     * @param address The address of the department.
     * @param name The name of the department.
     * @param internalCode The internal code of the department.
     * @param responsibleCollaborator The collaborator responsible for the department.
     */

    public Department(String address, String name, String internalCode, Collaborator responsibleCollaborator){
        this.address = address;
        this.name = name;
        this.internalCode = internalCode;

        this.responsibleCollaborator = responsibleCollaborator;
        this.requests = new ArrayList<>();
    }

    //GETTERS AND SETTERS
    /**
     * <p><b>getAddress</b></p>
     * <b>Description:</b> Retrieves the address of the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The address of the department is returned.</li>
     * </ul>
     * 
     * @return The address of the department.
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p><b>setAddress</b></p>
     * <b>Description:</b> Sets the address of the department to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     *      <li>The {@code address} parameter must be a  String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The address of the department is updated to the specified value.</li>
     * </ul>
     * 
     * @param address The new address of the department.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <p><b>getName</b></p>
     * <b>Description:</b> Retrieves the name of the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the department is returned.</li>
     * </ul>
     * 
     * @return The name of the department.
     */
    public String getName() {
        return name;
    }

    /**
     * <p><b>setName</b></p>
     * <b>Description:</b> Sets the name of the department to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     *      <li>The {@code name} parameter must be  String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the department is updated to the specified value.</li>
     * </ul>
     * 
     * @param name The new name of the department.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p><b>getInternalCode</b></p>
     * <b>Description:</b> Retrieves the internal code of the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The internal code of the department is returned.</li>
     * </ul>
     * 
     * @return The internal code of the department.
     */
    public String getInternalCode() {
        return internalCode;
    }

    /**
     * <p><b>setInternalCode</b></p>
     * <b>Description:</b> Sets the internal code of the department to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     *      <li>The {@code internalCode} parameter must be a string.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The internal code of the department is updated to the specified value.</li>
     * </ul>
     * 
     * @param internalCode The new internal code of the department.
     */
    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    /**
     * <p><b>getResponsibleCollaborator</b></p>
     * <b>Description:</b> Retrieves the responsible collaborator of the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible collaborator of the department is returned.</li>
     * </ul>
     * 
     * @return The responsible collaborator of the department.
     */
    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    /**
     * <p><b>setResponsibleCollaborator</b></p>
     * <b>Description:</b> Sets the responsible collaborator of the department to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     *      <li>The {@code responsibleCollaborator} parameter must be a Collaborator object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible collaborator of the department is updated to the specified value.</li>
     * </ul>
     * 
     * @param responsibleCollaborator The new responsible collaborator of the department.
     */
    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }

    //No need for a setRequests since they are added by other method
    /**
     * <p><b>getRequests</b></p>
     * <b>Description:</b> Retrieves the list of requests associated with the department.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Department} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The ArrayList of requests associated with the department is returned.</li>
     * </ul>
     * 
     * @return The ArrayList of requests associated with the department.
     */
    public ArrayList<Request> getRequests() {
        return requests;
    }
    
}
