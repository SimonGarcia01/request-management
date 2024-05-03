package model;

public class University {
    //Attributes

    //Relations
    private Collaborator[] collaborators;

    //Methods

    //Register a DTI collaborator
    public String registerCollaborator(String fullName, String id, String email, String extension,
    int numberImplementedImprovements, int numberLedProjects){

        String message = "";

        return message;
    }

    //Register a general collaborator
    public String registerCollaborator(String fullName, String id, String email, String extension){

        String message = "";

        return message;
    }

    //CONSTRUCTOR
    public University(){
        this.collaborators = new Collaborator[1000];
    }


    //GETTERS AND SETTERS
    public Collaborator[] getCollaborators() {
        return collaborators;
    }
    
}
