package model;
import java.util.ArrayList;

public class ImprovementCollaborator extends Collaborator implements EfficiencyCalculable {
    //Attributes

    //Relations
    private ArrayList<Project> ledProjects;

    //Methods

    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }

    //CONSTRUCTOR
    /**
     * <p><b>ImprovementCollaborator</b></p>
     * <b>Description:</b> Constructs a new ImprovementCollaborator object with the provided information.
     * This constructor initializes the ImprovementCollaborator object with the provided ID, full name, email, and extension.
     * Additionally, it initializes the ArrayList of led projects.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code id}, {@code fullName}, {@code email}, and {@code extension} parameters must be of type String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new ImprovementCollaborator object is created with the provided ID, full name, email, and extension.</li>
     *   <li>An ArrayList of led projects is initialized.</li>
     * </ul>
     * 
     * @param id The ID of the collaborator.
     * @param fullName The full name of the collaborator.
     * @param email The email address of the collaborator.
     * @param extension The extension number of the collaborator (optional).
     */

    public ImprovementCollaborator(String id, String fullName, String email, String extension){
        super(id, fullName, email, extension);
        
        this.ledProjects = new ArrayList<>();
    }

    //GETTERS AND SETTERS

    //No need for set LedProjects since there is a method to add them
    /**
     * <p><b>getLedProjects</b></p>
     * <b>Description:</b> Retrieves the list of projects led by the DTI collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The list of projects led by the DTI collaborator is returned.</li>
     * </ul>
     * 
     * @return The list of projects led by the DTI collaborator.
     */

    public ArrayList<Project> getLedProjects() {
        return ledProjects;
    }
    
}
