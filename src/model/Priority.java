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
    public static Priority intToPriority(){
        Priority priority = null;

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
