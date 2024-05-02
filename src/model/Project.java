package model;

public class Project {
    //Attributes
    private String name;
    private String id;
    private Priority priorityLevel;
    private ImprovementCollaborator leader;

    //Relations

    //Methods
    public Project(String name, String id, int intPriority, ImprovementCollaborator leader){
        this.name = name;
        this.id = id;
        this.priorityLevel = Priority.intToPriority(intPriority);
        this.leader = leader;
        
    }
}
