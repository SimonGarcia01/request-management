package model;

public class ImprovementCollaborator extends Collaborator implements EfficiencyCalculable {
    //Attributes

    //Relations
    private Project[] ledProjects;

    //Methods

    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }


    //CONSTRUCTOR
    public ImprovementCollaborator(String id, String fullName, String email, String extension){
        super(id, fullName, email, extension);
        
        this.ledProjects = new Project[1000];
    }

    //GETTERS AND SETTERS

    public Project[] getLedProjects() {
        return ledProjects;
    }
    
}
