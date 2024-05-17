package model;

public enum Priority {
    //Enumeration Literals
    URGENT("Urgent"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    //Attributes
    private final String description;

    //Methods

    //To extract list of descriptions
    /**
     * <p><b>getPriorities</b></p>
     * <b>Description:</b> Retrieves all descriptions associated with the Priority literals in the enumeration.
     * The method loops through each literal, extracts its description, and returns an array holding all descriptions.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The Priority literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A String array containing all descriptions representing the Priority literals is returned.</li>
     * </ul>
     * 
     * @return A String array holding all descriptions representing the Priority literals.
     */
    public static String[] getPriorities() {
        Priority[] types = Priority.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }
    
    //IntToPriority
    /**
     * <p><b>intToPriority</b></p>
     * <b>Description:</b> Converts the selected integer option to a Priority enumeration value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code intPriority} must be an integer between 1 and 4.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A Priority enumeration value is returned based on the selected integer option.</li>
     *   <li>If the selected number is out of bounds it will return a null literal.</li>
     * </ul>
     * 
     * @param intPriority An integer representing the selected option.
     * @return A Priority enumeration value associated with the selected option.
     */
    public static Priority intToPriority(int intPriority){
        Priority priority = null;

        switch (intPriority) {
            case 1:
                priority = URGENT;
                break;
            case 2:
                priority = HIGH;
                break;
            case 3:
                priority = MEDIUM;
                break;
            case 4:
                priority = LOW;
                break;
            default:
                break;
        }

        return priority;
    }

    //PRIORITY TO A LETTER
    public static String priorityToLetter(Priority priority){
        String letter = "";

        switch (priority) {
            case URGENT:
                letter = "U";
                break;

            case HIGH:
                letter = "H";
                break;
            
            case MEDIUM:
                letter = "M";
                break;
            
            case LOW:
                letter = "L";
                break;
        
            default:
                letter = "X";
                break;
        }

        return letter;
    }

    //CONSTRUCTOR
    /**
     * <p><b>Priority</b></p>
     * <b>Description:</b> Initializes the Priority literals with an associated String description.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The {@code description} parameter should be an attribute of the Priority enumeration.</li>
     *   <li>Each literal in Priority must have an associated description.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The literals inside Priority are initialized with associated descriptions.</li>
     * </ul>
     * 
     * @param description A string description associated with the Priority literal.
     */    
    private Priority(String description){
        this.description = description;
    }

    //GETTER AND SETTERS
    /**
     * <p><b>getDescription</b></p>
     * <b>Description:</b> Retrieves the description associated with a Priority literal in the enumeration.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>The Priority literals must have associated descriptions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A string holding the description associated with a Priority literal is returned.</li>
     * </ul>
     * 
     * @return A String containing the description of a Priority literal.
     */
    public String getDescription() {
        return description;
    }
    
}
