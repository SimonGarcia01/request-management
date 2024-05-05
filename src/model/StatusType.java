package model;

public enum StatusType {
    //Enumeration  Literals
    PENDING("Pending"),
    APPROVED("Approved"),
    DENIED("Denied");

    //Attributes
    private final String description;

    //Methods

    //Extract list of descriptions
    /**
     * <p><b>getStatusTypes</b></p>
     * <b>Description:</b> Retrieves all descriptions associated with the StatusType literals in the enumeration.
     * The method loops through each literal, extracts its description, and returns an array holding all descriptions.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The StatusType literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A String array containing all descriptions representing the StatusType literals is returned.</li>
     * </ul>
     * 
     * @return A String array holding all descriptions representing the StatusType literals.
     */
    public static String[] getStatusTypes() {
        StatusType[] types = StatusType.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //intToStatusType
    /**
     * <p><b>intToStatusType</b></p>
     * <b>Description:</b> Converts the selected integer option to a StatusType enumeration value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code intStatus} must be an integer between 1 and 3.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A StatusType enumeration value is returned based on the selected integer option.</li>
     *   <li>If the selected number is out of bounds it will return a null literal.</li>
     * </ul>
     * 
     * @param intStatus An integer representing the selected option.
     * @return A StatusType enumeration value associated with the selected option.
     */
    public static StatusType intToStatus(int intStatus){
        StatusType status= null;

        switch (intStatus) {
            case 1:
                status = PENDING;
                break;
            case 2:
                status = APPROVED;
                break;
            case 3:
                status = DENIED;
                break;
            default:
                break;
        }

        return status;
    }


    //CONSTRUCTOR
    /**
     * <p><b>StatusType</b></p>
     * <b>Description:</b> Initializes the StatusType literals with an associated String description.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code description} parameter should be an attribute of the StatusType enumeration.</li>
     *   <li>Each literal in StatusType must have an associated description.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The literals inside StatusType are initialized with associated descriptions.</li>
     * </ul>
     * 
     * @param description A string description associated with the StatusType literal.
     */   
    private StatusType(String description){
        this.description = description;
    }


    //GETTERS
    /**
     * <p><b>getDescription</b></p>
     * <b>Description:</b> Retrieves the description associated with a StatusType literal in the enumeration.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The StatusType literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A string holding the description associated with a StatusType literal is returned.</li>
     * </ul>
     * 
     * @return A String containing the description of a StatusType literal.
     */
    public String getDescription() {
        return description;
    }
    
}
