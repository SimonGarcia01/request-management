package model;
import java.util.ArrayList;
import java.util.Random;

public class ImprovementCollaborator extends Collaborator implements EfficiencyCalculable {
    //Attributes

    //Relations
    private ArrayList<Project> ledProjects;

    //Methods
    
    //CREATE A KNOWEDGE PROJECT
    /**
     * <p><b>createProject</b></p>
     * <b>Description:</b> Creates a new knowledge management project based on the provided details.
     *  This method generates a unique ID for the project using {@link #generateRandomUniqueCode()}.
     *  It then creates a new knowledge management project with the given name, priority, collaborator as leader, accepted request, impacted community, and knowledge type.
     *  The project is added to the list of led projects ({@code ledProjects}).
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code ledProjects} list must be initialized.</li>
     *      <li>{@code acceptedRequest} must not be null.</li>
     *      <li>{@code intPriority}, {@code intImpactedCommunity}, and {@code intKnowledgeType} must be valid integers form the displayed values.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new knowledge management project is created based on the provided details.</li>
     *      <li>The project is assigned a unique ID, name, priority, leader, accepted request, impacted community, and knowledge type.</li>
     *      <li>The project is added to the list of led projects.</li>
     *      <li>A message indicating the successful registration of the project is returned.</li>
     * </ul>
     * 
     * @param name The name of the project.
     * @param intPriority The priority level of the project.
     * @param acceptedRequest The accepted request for the project.
     * @param intImpactedCommunity The index representing the impacted community for the project.
     * @param intKnowledgeType The index representing the type of knowledge project.
     * @return A message indicating the successful registration of the knowledge management project.
     */
    public String createProject(String name, int intPriority, Request acceptedRequest, int intImpactedCommunity, int intKnowledgeType){
        String id = generateRandomUniqueCode();

        ledProjects.add(new Knowledge(name, id, intPriority, this, acceptedRequest, intImpactedCommunity, intKnowledgeType));

        return "The knowledge management project has been registered successfully.";
    }

    public String createProject(String name, int intPriority, Request acceptedRequest, String processCode){
        String id = generateRandomUniqueCode();

        ledProjects.add(new Improvement(name, id, intPriority, this, acceptedRequest, processCode));

        return "The transformation and improvement project has been registered successfully.";
    }

    //SEARCH PROJECT
    public Project searchProject(String id){
        Project searchedProject = null;

        for(Project project : ledProjects){
            if(project.getId().equals(id)){
                searchedProject = project;
            }
        }

        return searchedProject;
    }
    
    //DISPLAY IMPACTED COMMUNITIES

    public static String displayImpactCommunities(){
        return Knowledge.displayImpactCommunities();
    }

    //DISPLAY KNOWLEDGE TYPES

    public static String displayKnowledgeTypes(){
        return Knowledge.displayKnowledgeTypes();
    }

    //GENERATE RANDOM CODE

    public String generateRandomUniqueCode() {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code = "";
        Random random = new Random();
        do{
            for (int i = 0; i < 4; i++) {
                int randomIndex = random.nextInt(allowedChars.length());
                code += allowedChars.charAt(randomIndex);
            }
        }while(searchProject(code)!=null);
        
        return code;
    }

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
