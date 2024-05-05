package model;

public class Improvement extends Project{
    //Atributes
    private String processName;



    //Relations

    //Methods

    //CONSTRUCTOR
    public Improvement(String name, String id, int intPriority, ImprovementCollaborator leader, 
    Request approvedRequest, String processName) {
        super(name, id, intPriority, leader, approvedRequest);
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
