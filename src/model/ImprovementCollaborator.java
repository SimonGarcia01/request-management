package model;

public class ImprovementCollaborator extends Collaborator implements EfficiencyCalculable {
    //Attributes
    private int numberImplementedImprovements;
    private int numberLedProjects;

    //Relations
    private Project[] ledProjects;

    //Methods
    public double calculateEfficiency(){
        double efficiency = 0;
        return efficiency;
    }


    //CONSTRUCTOR
    public ImprovementCollaborator(String id, String fullName, String email, String extension,
    int numberImplementedImprovements, int numberLedProjects){
        super(id, fullName, email, extension);
        
        this.numberImplementedImprovements = numberImplementedImprovements;
        this.numberLedProjects = numberLedProjects;
        this.ledProjects = new Project[1000];
    }

    //GETTERS AND SETTERS
    public int getNumberImplementedImprovements() {
        return numberImplementedImprovements;
    }


    public void setNumberImplementedImprovements(int numberImplementedImprovements) {
        this.numberImplementedImprovements = numberImplementedImprovements;
    }


    public int getNumberLedProjects() {
        return numberLedProjects;
    }


    public void setNumberLedProjects(int numberLedProjects) {
        this.numberLedProjects = numberLedProjects;
    }


    public Project[] getLedProjects() {
        return ledProjects;
    }
    
}
