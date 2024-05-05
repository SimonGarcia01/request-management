package model;

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
    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }

    //CONSTRUCTOR
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
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Calendar getClassificationDate() {
        return classificationDate;
    }

    public void setClassificationDate(Calendar classificationDate) {
        this.classificationDate = classificationDate;
    }

    public Department getResponsibleDepartment() {
        return responsibleDepartment;
    }

    public void setResponsibleDepartment(Department responsibleDepartment) {
        this.responsibleDepartment = responsibleDepartment;
    }

    public Collaborator getResponsibleCollaborator() {
        return responsibleCollaborator;
    }

    public void setResponsibleCollaborator(Collaborator responsibleCollaborator) {
        this.responsibleCollaborator = responsibleCollaborator;
    }
    
}
