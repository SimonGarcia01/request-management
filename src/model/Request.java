package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Request {
    //Attributes
    private String subject;
    private String description;
    private StatusType status;
    private Calendar registrationDate;
    private Calendar classificationDate;

    //Relations
    private Department responsibleDepartment;
    private Collaborator responsibleCollaborator;

    //Methods
    
    //DISPLAY STATUS TYPES
    /**
     * <p><b>displayStatusTypes</b></p>
     * <b>Description:</b> Retrieves a string representation of the available status types for requests.
     *  This method retrieves the available status types using {@link StatusType#getStatusTypes()} and formats them into a string representation.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code StatusType} class must define the {@code getStatusTypes()} method to retrieve status types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A string representation of the available status types for requests is returned.</li>
     * </ul>
     * 
     * @return A string representation of the available status types for requests.
     */
    public static String displayStatusTypes(){
        String message = "Available status types:";

        String[] statusTypes = StatusType.getStatusTypes();

        for(int n = 0; n < statusTypes.length; n++){
            message += String.format("\n\t%d. %s", (n+1), statusTypes[n]);
        }
        
        return message;
    }

    //TOSTRING
    
    @Override
    public String toString (){
        SimpleDateFormat dateFormatRegistration = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDateRegistration = dateFormatRegistration.format(registrationDate.getTime());

        SimpleDateFormat dateFormatClassification = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formattedDateClassification = classificationDate != null ? dateFormatClassification.format(classificationDate.getTime()) : "The request is pending.";

        return String.format("\n\t\tSubject: %s\n\t\tDescription: %s\n\t\tStatus: %s\n\t\tRegistration Date: %s\n\t\tClassification Date: %s\n\t\tResponsible Department: \n\t\t\tName: %s\n\t\t\tInternal Code: %s\n\t\tResponsible Collaborator: \n\t\t\tFull Name: %s\n\t\t\tID: %s",
            subject, description, status.getDescription(), formattedDateRegistration, formattedDateClassification, responsibleDepartment.getName(), responsibleDepartment.getInternalCode(), responsibleCollaborator.getFullName(), responsibleCollaborator.getId());
    }

    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }

    //CONSTRUCTOR
    /**
     * <p><b>Request</b></p>
     * <b>Description:</b> Constructs a new Request object with the specified subject, description, responsible department, and responsible collaborator.
     *  The method , by default, also sets the registration date to the current one and the status is set to pending.
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code subject} parameter must be a String.</li>
     *      <li>The {@code description} parameter must be a String.</li>
     *      <li>The {@code responsibleDepartment} parameter must be a Department object.</li>
     *      <li>The {@code responsibleCollaborator} parameter must be a Collaborator object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new Request object is created with the provided subject, description, responsible department, and responsible collaborator.</li>
     *      <li>The status of the request is set to pending.</li>
     *      <li>The registration date of the request is set to the current date and time.</li>
     * </ul>
     * 
     * @param subject The subject of the request.
     * @param description The description of the request.
     * @param responsibleDepartment The department responsible for handling the request.
     * @param responsibleCollaborator The collaborator responsible for the request.
     */
    public Request(String subject, String description, Department responsibleDepartment, 
    Collaborator  responsibleCollaborator){
        this.subject  = subject;
        this.description = description;

        this.responsibleDepartment = responsibleDepartment;
        this.responsibleCollaborator = responsibleCollaborator;

         //Set the status to pending at the moment of creation
        this.status = StatusType.intToStatus(1);    

        //Set the registrationDate to the one at the moment of registration
        this.registrationDate = Calendar.getInstance();
    }

    //GETTERS AND SETTERS
    /**
     * <p><b>getSubject</b></p>
     * <b>Description:</b> Retrieves the subject of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The subject of the request is returned.</li>
     * </ul>
     * 
     * @return The subject of the request.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * <p><b>setSubject</b></p>
     * <b>Description:</b> Sets the subject of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code subject} parameter must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The subject of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param subject The new subject of the request.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * <p><b>getDescription</b></p>
     * <b>Description:</b> Retrieves the description of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The description of the request is returned.</li>
     * </ul>
     * 
     * @return The description of the request.
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p><b>setDescription</b></p>
     * <b>Description:</b> Sets the description of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code description} parameter must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The description of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param description The new description of the request.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <p><b>getStatus</b></p>
     * <b>Description:</b> Retrieves the status of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The status of the request is returned.</li>
     * </ul>
     * 
     * @return The status of the request.
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * <p><b>setStatus</b></p>
     * <b>Description:</b> Sets the status of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code status} parameter must be a valid StatusType.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The status of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param status The new status of the request.
     */
    public void setStatus(StatusType status) {
        this.status = status;
    }

    /**
     * <p><b>getRegistrationDate</b></p>
     * <b>Description:</b> Retrieves the registration date of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The registration date of the request is returned.</li>
     * </ul>
     * 
     * @return The registration date of the request.
     */
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * <p><b>setRegistrationDate</b></p>
     * <b>Description:</b> Sets the registration date of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code registrationDate} parameter must be a Calendar object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The registration date of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param registrationDate The new registration date of the request.
     */
    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * <p><b>getClassificationDate</b></p>
     * <b>Description:</b> Retrieves the classification date of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The classification date of the request is returned.</li>
     * </ul>
     * 
     * @return The classification date of the request.
     */
    public Calendar getClassificationDate() {
        return classificationDate;
    }

    /**
     * <p><b>setClassificationDate</b></p>
     * <b>Description:</b> Sets the classification date of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code classkificationDate} parameter must be a Calendar object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The classification date of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param classificationDate The new classification date of the request.
     */
    public void setClassificationDate(Calendar classificationDate) {
        this.classificationDate = classificationDate;
    }

    /**
     * <p><b>getResponsibleDepartment</b></p>
     * <b>Description:</b> Retrieves the responsible department of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible department of the request is returned.</li>
     * </ul>
     * 
     * @return The responsible department of the request.
     */
    public Department getResponsibleDepartment() {
        return responsibleDepartment;
    }

    /**
     * <p><b>setResponsibleDepartment</b></p>
     * <b>Description:</b> Sets the responsible department of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code responsibleDepartment} parameter must be a Department object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible department of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param responsibleDepartment The new responsible department of the request.
     */
    public void setResponsibleDepartment(Department responsibleDepartment) {
        this.responsibleDepartment = responsibleDepartment;
    }

    /**
     * <p><b>getResponsibleCollaborator</b></p>
     * <b>Description:</b> Retrieves the responsible collaborator of the request.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible collaborator of the request is returned.</li>
     * </ul>
     * 
     * @return The responsible collaborator of the request.
     */
    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    /**
     * <p><b>setResponsibleCollaborator</b></p>
     * <b>Description:</b> Sets the responsible collaborator of the request to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Request} object must not be null.</li>
     *      <li>The {@code responsibleCollaborator} parameter must be a Collaborator object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The responsible collaborator of the request is updated to the specified value.</li>
     * </ul>
     * 
     * @param responsibleCollaborator The new responsible collaborator of the request.
     */
    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }
    
}
