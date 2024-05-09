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

    //DISPLAY PRIORITIES
    /**
     * <p><b>displayPriorities</b></p>
     * <b>Description:</b> Retrieves a string representation of the available levels of priority for projects.
     *  This method retrieves the available priorities using {@link Priority#getPriorities()} and formats them into a string representation.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Priority} class must define the {@code getPriorities()} method to retrieve priorities.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A string representation of the available levels of priority for projects is returned.</li>
     * </ul>
     * 
     * @return A string representation of the available levels of priority for projects.
     */
    public static String displayPriorities(){
        String message = "Levels of priority: ";

        String[] priorities = Priority.getPriorities();

        for(int n = 0; n < priorities.length; n++){
            message += String.format("\n\t%d. %s", (n+1), priorities[n]);
        }
        
        return message;
    }

    //Calculate the estimated close date of the project
    /**
     * <p><b>calcEstCloseDate</b></p>
     * <b>Description:</b> Calculates the estimated close date of a project based on its classification date and priority.
     * <ul>
     *      <li>{@code intPriority 1} = Urgent. It must be delivered in less than 5 days</li>
     *      <li>{@code intPriority 2} = High. It must be delivered in less than 10 days</li>
     *      <li>{@code intPriority 3} = Medium. It must be delivered in less than 30 days</li>
     *      <li>{@code intPriority 4} = Low. It must be delivered in less than 60 days</li>
     * </ul>
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code classificationDate} parameter must be a Calendar object representing the classification date of the accepted request.</li>
     *      <li>The {@code intPriority} parameter must be an integer representing the priority of the project (int between1  and 4).</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The estimated close date of the project is calculated based on its classification date and priority.</li>
     * </ul>
     * 
     * @param classificationDate The classification date of the accepted request.
     * @param intPriority The priority of the project (1 for urgent, 2 for high, 3 for medium, and 4 for low).
     * @return The estimated close date of the project.
     */
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

    //Calculate Efficiency
    public double calculateEfficiency(){
        double efficiency = -1;

        return efficiency;
    }

    //CONSTRUCTOR
    /**
     * <p><b>Project</b></p>
     * <b>Description:</b> Constructs a new Project object with the specified name, ID, priority, leader, and approved request.
     *  The priority of the project is set changing the selected int to a priority level using {@link Priority#intToPriority(int)}.
     *  Then, utilizing the classification date extracted from the approvedReques using {@link Request#getClassificationDate()}, and the intPriority option selected, an estimated close date is calculated ({@link #calcEstCloseDate(Calendar, int)}).
     *  Finally, the related request realted to the project is saved inside the project too.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code name} parameter must be a String representing the name of the project.</li>
     *      <li>The {@code id} parameter must be a String representing the ID of the project.</li>
     *      <li>The {@code intPriority} parameter must be an integer representing the priority of the project (1 for urgent, 2 for high, 3 for medium, and 4 for low).</li>
     *      <li>The {@code leader} parameter must be an ImprovementCollaborator object representing the leader of the project.</li>
     *      <li>The {@code approvedRequest} parameter must be a Request object representing the approved request associated with the project.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new Project object is created with the provided name, ID, priority, leader, and approved request.</li>
     *      <li>The project priority is set  using the {@link Priority#intToPriority(int)} method to change the int option to an actual Priority level.</li>
     *      <li>The classification date of the project is set to the classification date of the approved request, obtained using the {@link Request#getClassificationDate()} method.</li>
     *      <li>The estimated close date of the project is calculated based on its classification date and priority, using the {@link #calcEstCloseDate(Calendar, int)} method.</li>
     * </ul>
     * 
     * @param name The name of the project.
     * @param id The ID of the project.
     * @param intPriority The priority of the project (1 for urgent, 2 for high, 3 for medium, and 4 for low).
     * @param leader The leader of the project.
     * @param approvedRequest The approved request associated with the project.
     */
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
    /**
     * <p><b>getName</b></p>
     * <b>Description:</b> Retrieves the name of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the project is returned.</li>
     * </ul>
     * 
     * @return The name of the project.
     */
    public String getName() {
        return name;
    }

    /**
     * <p><b>setName</b></p>
     * <b>Description:</b> Sets the name of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code name} parameter must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param name The new name of the project.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p><b>getId</b></p>
     * <b>Description:</b> Retrieves the ID of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The ID of the project is returned.</li>
     * </ul>
     * 
     * @return The ID of the project.
     */
    public String getId() {
        return id;
    }

    /**
     * <p><b>setId</b></p>
     * <b>Description:</b> Sets the ID of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code id} parameter must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The ID of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param id The new ID of the project.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p><b>getPriorityLevel</b></p>
     * <b>Description:</b> Retrieves the priority level of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The priority level of the project is returned.</li>
     * </ul>
     * 
     * @return The priority level of the project.
     */
    public Priority getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * <p><b>setPriorityLevel</b></p>
     * <b>Description:</b> Sets the priority level of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code priorityLevel} parameter must be a Priority object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The priority level of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param priorityLevel The new priority level of the project.
     */
    public void setPriorityLevel(Priority priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * <p><b>getLeader</b></p>
     * <b>Description:</b> Retrieves the leader of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The leader of the project is returned.</li>
     * </ul>
     * 
     * @return The leader of the project (ImprovementCollaborator).
     */
    public ImprovementCollaborator getLeader() {
        return leader;
    }

    /**
     * <p><b>setLeader</b></p>
     * <b>Description:</b> Sets the leader of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code leader} parameter must be an ImprovementCollaborator object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The leader of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param leader The new leader of the project.
     */
    public void setLeader(ImprovementCollaborator leader) {
        this.leader = leader;
    }

    /**
     * <p><b>getApprovedRequest</b></p>
     * <b>Description:</b> Retrieves the approved request associated with the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The approved request associated with the project is returned.</li>
     * </ul>
     * 
     * @return The approved request associated with the project.
     */
    public Request getApprovedRequest() {
        return approvedRequest;
    }

    /**
     * <p><b>setApprovedRequest</b></p>
     * <b>Description:</b> Sets the approved request associated with the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code approvedRequest} parameter must be a Request object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The approved request associated with the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param approvedRequest The new approved request associated with the project.
     */
    public void setApprovedRequest(Request approvedRequest) {
        this.approvedRequest = approvedRequest;
    }

    /**
     * <p><b>getEstimatedCloseDate</b></p>
     * <b>Description:</b> Retrieves the estimated close date of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The estimated close date of the project is returned.</li>
     * </ul>
     * 
     * @return The estimated close date of the project.
     */
    public Calendar getEstimatedCloseDate() {
        return estimatedCloseDate;
    }

    /**
     * <p><b>setEstimatedCloseDate</b></p>
     * <b>Description:</b> Sets the estimated close date of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code estimatedCloseDate} parameter must be a Calendar object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The estimated close date of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param estimatedCloseDate The new estimated close date of the project.
     */
    public void setEstimatedCloseDate(Calendar estimatedCloseDate) {
        this.estimatedCloseDate = estimatedCloseDate;
    }

    /**
     * <p><b>getClassificationDate</b></p>
     * <b>Description:</b> Retrieves the classification date of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The classification date of the project is returned.</li>
     * </ul>
     * 
     * @return The classification date of the project.
     */
    public Calendar getClassificationDate() {
        return classificationDate;
    }

    /**
     * <p><b>setClassificationDate</b></p>
     * <b>Description:</b> Sets the classification date of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code classificationDate} parameter must be a Calendar object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The classification date of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param classificationDate The new classification date of the project.
     */
    public void setClassificationDate(Calendar classificationDate) {
        this.classificationDate = classificationDate;
    }

    /**
     * <p><b>getEndDate</b></p>
     * <b>Description:</b> Retrieves the end date of the project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The end date of the project is returned.</li>
     * </ul>
     * 
     * @return The end date of the project.
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * <p><b>setEndDate</b></p>
     * <b>Description:</b> Sets the end date of the project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Project} object must not be null.</li>
     *      <li>The {@code endDate} parameter must be a Calendar object.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The end date of the project is updated to the specified value.</li>
     * </ul>
     * 
     * @param endDate The new end date of the project.
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
    
}
