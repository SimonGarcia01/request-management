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
    /**
     * <p><b>ImprovementCollaborator</b></p>
     * <b>Description:</b> Constructs a new ImprovementCollaborator object with the provided information.
     * This constructor initializes the ImprovementCollaborator object with the provided ID, full name, email, and extension.
     * Additionally, it initializes the array of led projects with a fixed size of 1000.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code id}, {@code fullName}, {@code email} and {@code extension} parameters must be Strings.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new ImprovementCollaborator object is created with the provided ID, full name, email, and extension.</li>
     *   <li>An array of led projects is initialized with a size of 1000.</li>
     * </ul>
     * 
     * @param id The ID of the collaborator.
     * @param fullName The full name of the collaborator.
     * @param email The email address of the collaborator.
     * @param extension The extension number of the collaborator (optional).
     */
    public ImprovementCollaborator(String id, String fullName, String email, String extension){
        super(id, fullName, email, extension);
        
        this.ledProjects = new Project[1000];
    }

    //GETTERS AND SETTERS

    //No need for set LedProjects since there is a method to add them
    /**
     * <p><b>getLedProjects</b></p>
     * <b>Description:</b> Retrieves the array of projects led by the DTI collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code collaborator} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The array of projects led by the collaborator is returned.</li>
     * </ul>
     * 
     * @return The array of projects led by the DTI collaborator.
     */
    public Project[] getLedProjects() {
        return ledProjects;
    }
    
}
