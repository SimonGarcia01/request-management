package model;

public class Improvement extends Project{
    //Atributes
    private String processName;



    //Relations

    //Methods

    //CONSTRUCTOR
    public Improvement(String name, String id, int intPriority, ImprovementCollaborator leader, String processName) {
        super(name, id, intPriority, leader);
        this.processName = processName;
    }


    //GETTERS AND SETTERS
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
    
}
