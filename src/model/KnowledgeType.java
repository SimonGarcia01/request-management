package model;

public enum KnowledgeType {
    //Enumeration  Literals
    STANDARIZATION("Standarization"),
    DOCUMENTATION("Documentation"),
    OPTIMIZATION("Optimization");

    //Attributes
    private final String description;

    //Methods

    //Extract list of descriptions
    /**
     * <p><b>getKnowledgeTypes</b></p>
     * <b>Description:</b> Retrieves all descriptions associated with the KnowledgeType literals in the enumeration.
     * The method loops through each literal, extracts its description, and returns an array holding all descriptions.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The KnowledgeType literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A String array containing all descriptions representing the KnowledgeType literals is returned.</li>
     * </ul>
     * 
     * @return A String array holding all descriptions representing the KnowledgeType literals.
     */
    public static String[] getKnowledgeTypes() {
        KnowledgeType[] types = KnowledgeType.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //intToKnowledType
    /**
     * <p><b>intToKnowledgeType</b></p>
     * <b>Description:</b> Converts the selected integer option to a KnowledgeType enumeration value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code intKnowledgeType} must be an integer between 1 and 3.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A KnowledgeType enumeration value is returned based on the selected integer option.</li>
     *   <li>If the selected number is out of bounds it will return a null literal.</li>
     * </ul>
     * 
     * @param intKnowledgeType An integer representing the selected option.
     * @return A KnowledgeType enumeration value associated with the selected option.
     */
    public static KnowledgeType intToKnowledgeType(int intKnowledgeType){
        KnowledgeType knowledgeType= null;

        switch (intKnowledgeType) {
            case 1:
                knowledgeType = STANDARIZATION;
                break;
            case 2:
                knowledgeType = DOCUMENTATION;
                break;
            case 3:
                knowledgeType = OPTIMIZATION;
                break;
            default:
                break;
        }

        return knowledgeType;
    }


    //CONSTRUCTOR
    /**
     * <p><b>KnowledgeType</b></p>
     * <b>Description:</b> Initializes the KnowledgeType literals with an associated String description.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code description} parameter should be an attribute of the KnowledgeType enumeration.</li>
     *   <li>Each literal in KnowledgeType must have an associated description.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The literals inside KnowledgeType are initialized with associated descriptions.</li>
     * </ul>
     * 
     * @param description A string description associated with the KnowledgeType literal.
     */  
    private KnowledgeType(String description){
        this.description = description;
    }


    //GETTERS
    /**
     * <p><b>getDescription</b></p>
     * <b>Description:</b> Retrieves the description associated with a KnowledgeType literal in the enumeration.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The KnowledgeType literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A string holding the description associated with a KnowledgeType literal is returned.</li>
     * </ul>
     * 
     * @return A String containing the description of a KnowledgeType literal.
     */
    public String getDescription() {
        return description;
    }
}
