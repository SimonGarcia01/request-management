package model;

public class Collaborator {
    //Attributes
    private String id;
    private String fullName;
    private String email;
    private String extension;

    //Relations

    //Methods
    
    //CONSTRUCTOR
    /**
    * Constructs a new general Collaborator object with the provided ID, full name, email, and extension.
    * 
    * This constructor initializes the Collaborator object with the provided information.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>The {@code id}, {@code fullName}, {@code email}, and {@code extension} parameters must be Strings.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A new general Collaborator object is created with the provided ID, full name, email, and extension (optional).</li>
    * </ul>
    * 
    * @param id The ID of the collaborator.
    * @param fullName The full name of the collaborator.
    * @param email The email address of the collaborator.
    * @param extension The extension number of the collaborator (optional).
    */
    public Collaborator(String id, String fullName, String email, String extension){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.extension = extension;
    }


    //GETTERS AND SETTERS
    
    /**
     * <p><b>getId</b></p>
     * <b>Description:</b> Retrieves the ID of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code id} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The ID of the collaborator is returned as a String.</li>
     * </ul>
     * 
     * @return The ID of the collaborator.
     */
    public String getId() {
        return id;
    }

    /**
     * <p><b>setId</b></p>
     * <b>Description:</b> Sets the ID of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code id} must be a valid String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The ID of the collaborator is updated.</li>
     * </ul>
     * 
     * @param id The ID to set for the collaborator.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p><b>getFullName</b></p>
     * <b>Description:</b> Retrieves the full name of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code fullName} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The full name of the collaborator is returned as a String.</li>
     * </ul>
     * 
     * @return The full name of the collaborator.
     */
    public String getFullName() {
        return fullName;
    }
    
    /**
     * <p><b>setFullName</b></p>
     * <b>Description:</b> Sets the full name of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code fullName} must be a valid String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The full name of the collaborator is updated.</li>
     * </ul>
     * 
     * @param fullName The full name to set for the collaborator.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * <p><b>getEmail</b></p>
     * <b>Description:</b> Retrieves the email address of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code email} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The email address of the collaborator is returned as a String.</li>
     * </ul>
     * 
     * @return The email address of the collaborator.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p><b>setEmail</b></p>
     * <b>Description:</b> Sets the email address of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code email} must be a valid String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The email address of the collaborator is updated.</li>
     * </ul>
     * 
     * @param email The email address to set for the collaborator.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p><b>getExtension</b></p>
     * <b>Description:</b> Retrieves the extension number of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code extension} must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The extension number of the collaborator is returned as a String.</li>
     * </ul>
     * 
     * @return The extension number of the collaborator.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * <p><b>setExtension</b></p>
     * <b>Description:</b> Sets the extension number of the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     *   <li>The {@code extension} must be a valid String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The extension number of the collaborator is updated.</li>
     * </ul>
     * 
     * @param extension The extension number to set for the collaborator.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

}
