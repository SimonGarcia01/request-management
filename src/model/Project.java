package model;

import java.util.Calendar;

public abstract class Project implements EfficiencyCalculable{
    //Attributes
    private String name;
    private String id;
    private Priority priorityLevel;
    private Calendar estimatedCloseDate;
    private Calendar classificationDate;
    private Calendar endDate;
    

    //Relations
    private ImprovementCollaborator leader;
    private Request approvedRequest;

    //Methods
    
    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }

    //Calculate the estimated close date of the project
    public static Calendar calcEstCloseDate(Calendar classificationDate, int intPriority){
        Calendar estimatedCloseDate = Calendar.getInstance();

        estimatedCloseDate.setTimeInMillis(classificationDate.getTimeInMillis());

        switch (intPriority) {
            case 1:
                estimatedCloseDate.add(Calendar.DAY_OF_MONTH, 5);
                break;
            case 2:
                estimatedCloseDate.add(Calendar.DAY_OF_MONTH, 10);
                break;
            case 3:
                estimatedCloseDate.add(Calendar.DAY_OF_MONTH, 30);
                break;
            case 4:
                estimatedCloseDate.add(Calendar.DAY_OF_MONTH, 60);
                break;
            default:
                break;
        }

        return estimatedCloseDate;
    }

    //CONSTRUCTOR
    public Project(String name, String id, int intPriority, ImprovementCollaborator leader,
    Request approvedRequest){
        this.name = name;
        this.id = id;

        this.priorityLevel = Priority.intToPriority(intPriority);    

        this.leader = leader;
        this.approvedRequest = approvedRequest;
        
        this.classificationDate = approvedRequest.getClassificationDate();

        this.estimatedCloseDate = calcEstCloseDate(classificationDate, intPriority);
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

    public Request getApprovedRequest() {
        return approvedRequest;
    }

    public void setApprovedRequest(Request approvedRequest) {
        this.approvedRequest = approvedRequest;
    }

    public Calendar getEstimatedCloseDate() {
        return estimatedCloseDate;
    }

    public void setEstimatedCloseDate(Calendar estimatedCloseDate) {
        this.estimatedCloseDate = estimatedCloseDate;
    }

    public Calendar getClassificationDate() {
        return classificationDate;
    }

    public void setClassificationDate(Calendar classificationDate) {
        this.classificationDate = classificationDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
    
}
