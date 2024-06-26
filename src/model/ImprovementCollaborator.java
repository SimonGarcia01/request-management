package model;
import java.util.ArrayList;
import java.util.Random;
import java.util.Calendar;

public class ImprovementCollaborator extends Collaborator {
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
     *      <li>{@code name} must be a String.</li>
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

    //CREATE AN IMPROVEMENT KNOWLEDGE
    /**
     * <p><b>createProject</b></p>
     * <b>Description:</b> Creates a new transformation and improvement project based on the provided details.
     *  This method generates a unique ID for the project using {@link #generateRandomUniqueCode()}.
     *  It then creates a new improvement project with the given name, priority, collaborator as leader, accepted request, and process code.
     *  The project is added to the list of led projects ({@code ledProjects}).
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code ledProjects} list must be initialized.</li>
     *      <li>{@code acceptedRequest} must not be null.</li>
     *      <li>{@code name} and {@code processCode} must be a String.</li>
     *      <li>{@code intPriority} must be a valid integer.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new transformation and improvement project is created based on the provided details.</li>
     *      <li>The project is assigned a unique ID, name, priority, leader, accepted request, and process code.</li>
     *      <li>The project is added to the list of led projects.</li>
     *      <li>A message indicating the successful registration of the project is returned.</li>
     * </ul>
     * 
     * @param name The name of the project.
     * @param intPriority The priority level of the project.
     * @param acceptedRequest The accepted request for the project.
     * @param processCode The process code for the improvement project.
     * @return A message indicating the successful registration of the transformation and improvement project.
     */
    public String createProject(String name, int intPriority, Request acceptedRequest, String processCode){
        String id = generateRandomUniqueCode();

        ledProjects.add(new Improvement(name, id, intPriority, this, acceptedRequest, processCode));

        return "The transformation and improvement project has been registered successfully.";
    }

    //Calculate Efficiency
    /**
     * <p><b>calculateEfficiency</b></p>
     * <b>Description:</b> Calculates and returns the efficiency of the collaborator based on the number of projects 
     * closed within a specified month. The efficiency is calculated as the percentage of projects that were closed 
     * within the given month out of the total projects led by the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The input date must be a valid `Calendar` object representing the first day of the month.</li>
     *      <li>The collaborator must have a list of led projects initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns the efficiency as a percentage of projects closed within the specified month.</li>
     * </ul>
     * 
     * @param date The `Calendar` object representing the first day of the month for which efficiency is to be calculated.
     * @return The efficiency of the collaborator as a percentage.
     */
    public double calculateEfficiency(Calendar date){

        double closedProjectCounter = 0;

        Calendar limitDate = (Calendar) date.clone();

        limitDate.add(Calendar.DAY_OF_MONTH,30);

        for(Project project : ledProjects) {
            if(project.getEndDate() != null && project.getEndDate().compareTo(date)>=0 && project.getEndDate().compareTo(limitDate) <0){
                closedProjectCounter ++;
            }
        }

        double efficiency = (closedProjectCounter/ledProjects.size())*100;

        return efficiency;
    }

    //GET DATE PROJECTS
    /**
     * <p><b>getDateProject</b></p>
     * <b>Description:</b> Retrieves a list of projects that were classified on or after the specified date.
     * This method iterates through the list of projects led by the collaborator and checks if each project's 
     * classification date is on or after the given date. Projects meeting this criterion are added to a new list 
     * which is then returned.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The input date must be a valid `Calendar` object representing the comparison date.</li>
     *      <li>The collaborator must have a list of led projects initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a list of projects classified on or after the specified date.</li>
     * </ul>
     * 
     * @param date The `Calendar` object representing the date to compare the projects' classification dates against.
     * @return A list of `Project` objects classified on or after the specified date.
     */
    public ArrayList<Project> getDateProject(Calendar date){
        ArrayList<Project> dateProjects = new ArrayList<>();
        
        for(Project project : ledProjects){
            if(project.getClassificationDate().compareTo(date)>=0){
                dateProjects.add(project);
            }

        }

        return dateProjects;
    }

    //COUNT PROJECTS
    /**
     * <p><b>countProjects</b></p>
     * <b>Description:</b> Counts and returns the number of projects led by this collaborator.
     * This method simply returns the size of the `ledProjects` list, which contains all projects led by the collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The collaborator must have a list of led projects initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns the number of projects led by the collaborator.</li>
     * </ul>
     * 
     * @return The number of projects led by the collaborator.
     */
    public int countProjects(){
        return ledProjects.size();
    }

    //GET DATE PROJECTS
    /**
     * <p><b>getOrganizedDateProjects</b></p>
     * <b>Description:</b> Retrieves up to 5 projects led by the collaborator, starting from the specified date. 
     * Projects are selected based on their estimated close date and priority, with the earliest and highest priority projects being preferred.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code date} parameter must be a valid and initialized {@code Calendar} object.</li>
     *      <li>The collaborator must have a list of led projects.</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns an array of up to 5 projects starting from the specified date, ordered by estimated close date and priority.</li>
     * </ul>
     *
     * @param date The {@code Calendar} object representing the date to start retrieving projects from.
     * @return An array of {@code Project} objects representing the up to 5 most recent projects starting from the specified date.
     */
    public Project[] getOrganizedDateProjects(Calendar date) {
        Project[] dateProjects = new Project[5];
        int[] selectedIndices = {-1, -1, -1, -1, -1};
        boolean projectsLeft = true;

        for (int ranking = 0; ranking < 5 && projectsLeft; ranking++) {
            Project bestProject = null;
            int bestIndex = -1;
    
            for (int n = 0; n < ledProjects.size(); n++) {
                if (selectedIndices[0] != n && selectedIndices[1] != n && selectedIndices[2] != n && selectedIndices[3] != n && selectedIndices[4] != n) {
                    Project currentProject = ledProjects.get(n);
                    if (currentProject.getEstimatedCloseDate().compareTo(date) >= 0 && (bestProject == null || (currentProject.getEstimatedCloseDate().compareTo(bestProject.getEstimatedCloseDate()) <= 0 && getPriorityValue(currentProject.getPriorityLevel()) < getPriorityValue(bestProject.getPriorityLevel())))) {
                        bestProject = currentProject;
                        bestIndex = n;
                    }
                }
            }
            
            if(bestProject != null){
                dateProjects[ranking] = bestProject;
                selectedIndices[ranking] = bestIndex;
            } else {
                projectsLeft = false;
            }
        }
    
        return dateProjects;
    }

    //CHANGE PRIORITY TO A SINGLE DIGIT FOR CLASSIFICATION
    /**
     * <p><b>getPriorityValue</b></p>
     * <b>Description:</b> Converts a {@code Priority} enum to its corresponding integer value. 
     * The priority values are defined as follows:
     * <ul>
     *      <li>{@code URGENT} - 1</li>
     *      <li>{@code HIGH} - 2</li>
     *      <li>{@code MEDIUM} - 3</li>
     *      <li>{@code LOW} - 4</li>
     * </ul>
     * If the priority is not recognized, a default value of 5 is returned.
     *
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code priority} parameter must be a valid {@code Priority} enum value.</li>
     * </ul>
     *
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns the integer value corresponding to the specified priority.</li>
     * </ul>
     *
     * @param priority The {@code Priority} enum value to convert.
     * @return An integer representing the priority value.
     */
    public int getPriorityValue(Priority priority) {
        switch (priority) {
            case URGENT: return 1;
            case HIGH: return 2;
            case MEDIUM: return 3;
            case LOW: return 4;
            default: return 5;
        }
    }
    
    //SEARCH PROJECT
    /**
     * <p><b>searchProject</b></p>
     * <b>Description:</b> Searches for a project in the list of led projects based on the provided ID.
     *  This method iterates through the list of led projects ({@code ledProjects}) to find the project with the specified ID.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code ledProjects} list must be initialized.</li>
     *      <li>{@code id} must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>If a project with the specified ID is found in the list of led projects, it is returned.</li>
     *      <li>If no project with the specified ID is found, {@code null} is returned.</li>
     * </ul>
     * 
     * @param id The ID of the project to search for.
     * @return The project with the specified ID if found, otherwise {@code null}.
     */
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
    /**
     * <p><b>displayImpactCommunities</b></p>
     * <b>Description:</b> Retrieves a string representation of the available impact communities for knowledge projects.
     *  This method delegates to the {@link Knowledge#displayImpactCommunities()} method to get the list of impact communities.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} class must define the {@code displayImpactCommunities()} method to retrieve impact communities.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A string representation of the available impact communities for knowledge projects is returned.</li>
     * </ul>
     * 
     * @return A string representation of the available impact communities for knowledge projects.
     */
    public static String displayImpactCommunities(){
        return Knowledge.displayImpactCommunities();
    }

    //DISPLAY KNOWLEDGE TYPES
    /**
     * <p><b>displayKnowledgeTypes</b></p>
     * <b>Description:</b> Retrieves a string representation of the available knowledge types for knowledge projects.
     *  This method delegates to the {@link Knowledge#displayKnowledgeTypes()} method to get the list of knowledge types.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} class must define the {@code displayKnowledgeTypes()} method to retrieve knowledge types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A string representation of the available knowledge types for knowledge projects is returned.</li>
     * </ul>
     * 
     * @return A string representation of the available knowledge types for knowledge projects.
     */
    public static String displayKnowledgeTypes(){
        return Knowledge.displayKnowledgeTypes();
    }

    //GENERATE RANDOM CODE
    /**
     * <p><b>generateRandomUniqueCode</b></p>
     * <b>Description:</b> Generates a random unique code for identifying projects.
     *  This method generates a random code consisting of four alphanumeric characters from the set of allowed characters.
     *  It ensures that the generated code is unique by checking if a project with the same code already exists using {@link #searchProject(String)}.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code ledProjects} list must be initialized.</li>
     *      <li>The {@code searchProject} method must be implemented to search for projects by code.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A random unique code is generated and returned.</li>
     * </ul>
     * 
     * @return A random unique code for identifying projects.
     */
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
