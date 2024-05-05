package model;

public enum Community {
    //Enumeration  Literals
    STUDENT("Student"),
    PROFESSOR("Professor"),
    ADMINISTRATIVE("Administrative");

    //Attributes
    private final String description;

    //Methods

    //Extract list of descriptions
    /**
     * <p><b>getCommunityTypes</b></p>
     * <b>Description:</b> Retrieves all descriptions associated with the Community literals in the enumeration.
     * The method loops through each literal, extracts its description, and returns an array holding all descriptions.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The Community literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A String array containing all descriptions representing the Community literals is returned.</li>
     * </ul>
     * 
     * @return A String array holding all descriptions representing the Community literals.
     */
    public static String[] getCommunityTypes() {
        Community[] types = Community.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //intToKnowledType
    /**
     * <p><b>intToCommunity</b></p>
     * <b>Description:</b> Converts the selected integer option to a Community enumeration value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code intCommunity} must be an integer between 1 and 3.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A Community enumeration value is returned based on the selected integer option.</li>
     *   <li>If the selected number is out of bounds it will return a null literal.</li>
     * </ul>
     * 
     * @param intCommunity An integer representing the selected option.
     * @return A Community enumeration value associated with the selected option.
     */
    public static Community intToCommunity(int intCommunity){
        Community Community= null;

        switch (intCommunity) {
            case 1:
                Community = STUDENT;
                break;
            case 2:
                Community = PROFESSOR;
                break;
            case 3:
                Community = ADMINISTRATIVE;
                break;
            default:
                break;
        }

        return Community;
    }


    //CONSTRUCTOR
    /**
     * <p><b>Community</b></p>
     * <b>Description:</b> Initializes the Community literals with an associated String description.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code description} parameter should be an attribute of the Community enumeration.</li>
     *   <li>Each literal in Community must have an associated description.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The literals inside Community are initialized with associated descriptions.</li>
     * </ul>
     * 
     * @param description A string description associated with the Community literal.
     */  
    private Community(String description){
        this.description = description;
    }


    //GETTERS
    /**
     * <p><b>getDescription</b></p>
     * <b>Description:</b> Retrieves the description associated with a Community literal in the enumeration.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The Community literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A string holding the description associated with a Community literal is returned.</li>
     * </ul>
     * 
     * @return A String containing the description of a Community literal.
     */
    public String getDescription() {
        return description;
    }
}
