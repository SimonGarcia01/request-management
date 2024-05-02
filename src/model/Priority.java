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
    
    //IntToPriority
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


     //CONSTRUCTOR
    private Priority(String description){
        this.description = description;
    }

    //GETTER AND SETTERS
    public String getDescription() {
        return description;
    }
    
}
