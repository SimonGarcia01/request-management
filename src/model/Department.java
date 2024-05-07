package model;
import java.util.ArrayList;

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
