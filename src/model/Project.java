package model;

public class Project {
    //Attributes
    private String name;
    private String id;
    private Priority priorityLevel;
    private ImprovementCollaborator leader;

    //Relations

    //Methods

    //CONSTRUCTOR
    public Project(String name, String id, int intPriority, ImprovementCollaborator leader){
        this.name = name;
        this.id = id;
        this.priorityLevel = Priority.intToPriority(intPriority);
        this.leader = leader;
        
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Priority getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Priority priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public ImprovementCollaborator getLeader() {
        return leader;
    }

    public void setLeader(ImprovementCollaborator leader) {
        this.leader = leader;
    }

    
}
