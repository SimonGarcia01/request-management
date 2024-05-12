package model;

public class Knowledge extends Project{

    //Attributes
    private Community impactedCommunity;
    private KnowledgeType type;

    //Relations

    //DISPLAY IMPACTED COMMUNITIES
    /**
     * <p><b>displayImpactCommunities</b></p>
     * <b>Description:</b> Retrieves a string representation of the available impact communities for knowledge projects.
     *  This method retrieves the available impact communities using {@link Community#getCommunityTypes()} and formats them into a string representation.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Community} class must define the {@code getCommunityTypes()} method to retrieve community types.</li>
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
        String message = "Possible impacted communities:";

        String[] communities = Community.getCommunityTypes();

        for(int n = 0; n < communities.length; n++){
            message += String.format("\n\t%d. %s", (n+1), communities[n]);
        }
        
        return message;
    }
    
    //DISPLAY KNOWLEDGE TYPES
    /**
     * <p><b>displayKnowledgeTypes</b></p>
     * <b>Description:</b> Retrieves a string representation of the available types of knowledge projects.
     *  This method retrieves the available knowledge types using {@link KnowledgeType#getKnowledgeTypes()} and formats them into a string representation.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code KnowledgeType} class must define the {@code getKnowledgeTypes()} method to retrieve knowledge types.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A string representation of the available types of knowledge projects is returned.</li>
     * </ul>
     * 
     * @return A string representation of the available types of knowledge projects.
     */
    public static String displayKnowledgeTypes(){
        String message = "Available types of knowledge projets:";

        String[] knowledgeTypes = KnowledgeType.getKnowledgeTypes();

        for(int n = 0; n < knowledgeTypes.length; n++){
            message += String.format("\n\t%d. %s", (n+1), knowledgeTypes[n]);
        }
        
        return message;
    }

    //TO STRING
    /**
     * <p><b>toString</b></p>
     * <b>Description:</b> Generates a string representation of the knowledge project, including its details such as name, ID, priority level, leader, registration date, estimated close date, end date, approved request information, impacted community, and project type.
     *  This method is the overriden version of {@link Project#toString()} but adds the info of the impacted community and the type of knowledge project.
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The classification date, estimated close date, and end date must be initialized Calendar objects.</li>
     *      <li>If the project has been closed, the end date must not be null.</li>
     *      <li>The leader must be initialized.</li>
     *      <li>The priority level, approved request, impacted community, and project type must be initialized and contain valid information.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a string representation of the knowledge project, including its details.</li>
     * </ul>
     * 
     * @return A string representation of the knowledge project.
     */
    @Override
    public String toString(){
        return String.format("%s\n\n\tImpacted Community: %s\n\tProject Type: %s", 
        super.toString(), impactedCommunity.getDescription(), type.getDescription());
    }

    //CONSTRUCTOR
    /**
     * <p><b>Knowledge</b></p>
     * <b>Description:</b> Constructs a new Knowledge object with the specified name, ID, priority, leader, approved request, impacted community, and type.
     *  The intImpactedCommunity is changed to a Community using {@link Community#intToCommunity(int)}.
     *  The intType  is changed into a type of KnowledgeType project using {@link KnowledgeType#intToKnowledgeType(int)}
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code name} parameter must be a String representing the name of the knowledge.</li>
     *      <li>The {@code id} parameter must be a String representing the ID of the knowledge.</li>
     *      <li>The {@code intPriority} parameter must be an integer representing the priority of the knowledge (1 for urgent, 2 for high, 3 for medium, and 4 for low).</li>
     *      <li>The {@code leader} parameter must be an ImprovementCollaborator object representing the leader of the knowledge.</li>
     *      <li>The {@code approvedRequest} parameter must be a Request object representing the approved request associated with the knowledge.</li>
     *      <li>The {@code intImpactedCommunity} parameter must be an integer representing the impacted community of the knowledge (1 for Students, 2 for Professors, 3 for Administrative).</li>
     *      <li>The {@code intType} parameter must be an integer representing the type of knowledge (1 for Standarization, 2 for  Documentations, 3 for Optimization).</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new Knowledge object is created with the provided name, ID, priority, leader, approved request, impacted community, and type.</li>
     * </ul>
     * 
     * @param name The name of the knowledge.
     * @param id The ID of the knowledge.
     * @param intPriority  The int which represents a level of priority of the Knowledge project .
     * @param leader The leader of the knowledge.
     * @param approvedRequest The approved request associated with the knowledge.
     * @param intImpactedCommunity The int which represents an impacted community of the knowledge.
     * @param intType The int which represents a type of knowledge  project.
     */
    public Knowledge(String name, String id, int intPriority,  ImprovementCollaborator leader,
    Request approvedRequest, int intImpactedCommunity, int intType) {
    
        super(name, id, intPriority, leader, approvedRequest);

        this.impactedCommunity = Community.intToCommunity(intImpactedCommunity);
        this.type = KnowledgeType.intToKnowledgeType(intType);
    }

    //GETTERS AND SETTERS
    /**
     * <p><b>getImpactedCommunity</b></p>
     * <b>Description:</b> Retrieves the impacted community associated with the knowledge project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The impacted community associated with the knowledge is returned.</li>
     * </ul>
     * 
     * @return The impacted community associated with the knowledge project.
     */
    public Community getImpactedCommunity() {
        return impactedCommunity;
    }

    /**
     * <p><b>setImpactedCommunity</b></p>
     * <b>Description:</b> Sets the impacted community associated with the knowledge project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} object must not be null.</li>
     *      <li>The {@code impactedCommunity} parameter must be a Community object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The impacted community associated with the knowledge project is updated to the specified value.</li>
     * </ul>
     * 
     * @param impactedCommunity The new impacted community associated with the knowledge project.
     */
    public void setImpactedCommunity(Community impactedCommunity) {
        this.impactedCommunity = impactedCommunity;
    }

    /**
     * <p><b>getType</b></p>
     * <b>Description:</b> Retrieves the type of knowledge project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The type of knowledge projectis returned.</li>
     * </ul>
     * 
     * @return The type of knowledge project.
     */
    public KnowledgeType getType() {
        return type;
    }

    /**
     * <p><b>setType</b></p>
     * <b>Description:</b> Sets the type of knowledge to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Knowledge} object must not be null.</li>
     *      <li>The {@code type} parameter must be a KnowledgeType object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The type of knowledge is updated to the specified value.</li>
     * </ul>
     * 
     * @param type The new type of knowledge.
     */
    public void setType(KnowledgeType type) {
        this.type = type;
    }
    
}
