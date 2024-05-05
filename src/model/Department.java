package model;

public class Department {
    //Attributes
    private String address;
    private String name;
    private String internalCode;

    //Relations
    private Collaborator responsibleCollaborator;
    private Request[] requests;

    //Methods

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
     *   <li>The Department object is also initialized with an empty array of Requests.</li>
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
        this.requests = new Request[1000];

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }

    public Request[] getRequests() {
        return requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }
    
}
