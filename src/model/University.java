package model;

public class University {
    //Attributes

    //Relations
    private Collaborator[] collaborators;

    //Methods

    //CONSTRUCTOR
    public University(){
        this.collaborators = new Collaborator[1000];
    }


    //GETTERS AND SETTERS
    public Collaborator[] getCollaborators() {
        return collaborators;
    }
    
}
