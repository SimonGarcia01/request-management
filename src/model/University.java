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

        if(searchCollaborator(id) == null){
            int space = availableCollaborator();

            if(space != -1){
                collaborators[space] = new ImprovementCollaborator(id, fullName, email, extension, numberImplementedImprovements, numberLedProjects);
                message = "The DTI collaborator has been registered successfully.";
            } else {
                message = "There is no more space to register a collaborator.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //Register a general collaborator
    public String registerCollaborator(String fullName, String id, String email, String extension){
        String message = "";

        if(searchCollaborator(id) == null){
            int space = availableCollaborator();

            if(space != -1){
                collaborators[space] = new Collaborator(id, fullName, email, extension);
                message = "The general collaborator has been registered successfully.";
            } else {
                message = "There is no more space to register a collaborator.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //search collaborator
    public Collaborator searchCollaborator(String id){
        Collaborator collaborator = null;

        for(Collaborator instCollaborator : collaborators){
            if(instCollaborator!=null && instCollaborator.getId().equals(id)){
                collaborator = instCollaborator;
            }
        }

        return collaborator;
    }

    //Available position for a collaborator
    public int availableCollaborator(){
        int position = -1;

        for(int n = 0; n < collaborators.length; n++){
            if(collaborators[n]==null){
                position = n;
            }
        }

        return position;
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
