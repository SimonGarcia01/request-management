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
    public Department(String address, String name, String internalCode, Collaborator responsibleCollaborator){
        this.address = address;
        this.name = name;
        this.internalCode = internalCode;
        this.responsibleCollaborator = responsibleCollaborator;
    }



    //GETTERS AND SETTERS
    public String getAddress() {
        return address;
    }

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
