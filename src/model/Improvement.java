package model;

public class Improvement extends Project{
    //Atributes
    private String processCode;

    //Relations

    //Methods

    //TO STRING
    /**
     * <p><b>toString</b></p>
     * <b>Description:</b> Generates a string representation of the improvement project, including its details such as name, ID, priority level, leader, registration date, estimated close date, end date, approved request information, and process code.
     * This method is the overridden version of {@link Project#toString()} but adds the information of the process code.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The classification date, estimated close date, and end date must be initialized Calendar objects.</li>
     *      <li>If the project has been closed, the end date must not be null.</li>
     *      <li>The leader must be initialized.</li>
     *      <li>The priority level, approved request, and process code must be initialized and contain valid information.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>Returns a string representation of the improvement project, including its details.</li>
     * </ul>
     * 
     * @return A string representation of the improvement project.
     */
    @Override
    public String toString(){
        return String.format("%s\n\n\tProcessCode: %s", 
        super.toString(), processCode);
    }

    //CONSTRUCTOR
    /**
     * <p><b>Improvement</b></p>
     * <b>Description:</b> Constructs a new improvement and transformation project with the specified name, ID, priority, leader, approved request, and process name.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code name} parameter must be a String representing the name of the improvement and transformation project.</li>
     *      <li>The {@code id} parameter must be a String representing the ID of the improvement and transformation project.</li>
     *      <li>The {@code intPriority} parameter must be an integer representing the priority of the improvement and transformation project (1 for urgent, 2 for high, 3 for medium, and 4 for low).</li>
     *      <li>The {@code leader} parameter must be an ImprovementCollaborator object representing the leader of the improvement and transformation project.</li>
     *      <li>The {@code approvedRequest} parameter must be a Request object representing the approved request associated with the improvement and transformation project.</li>
     *      <li>The {@code processCode} parameter must be a String representing the name of the process associated with the improvement and transformation project.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>A new improvement and transformation project is created with the provided name, ID, priority, leader, approved request, and process name.</li>
     * </ul>
     * 
     * @param name The name of the improvement and transformation project.
     * @param id The ID of the improvement and transformation project.
     * @param intPriority An int which represents the priority level of the improvement and transformation project (1 for urgent, 2 for high, 3 for medium, and 4 for low).
     * @param leader The leader of the improvement and transformation project.
     * @param approvedRequest The approved request associated with the improvement and transformation project.
     * @param processCode The name of the process associated with the improvement and transformation project.
     */
    public Improvement(String name, String id, int intPriority, ImprovementCollaborator leader, 
    Request approvedRequest, String processCode) {
        
        super(name, id, intPriority, leader, approvedRequest);
        
        this.processCode = processCode;
    }


    //GETTERS AND SETTERS
    /**
     * <p><b>getprocessCode</b></p>
     * <b>Description:</b> Retrieves the name of the process associated with the improvement and transformation project.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Improvement} object must not be null.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the process associated with the improvement and transformation project is returned.</li>
     * </ul>
     * 
     * @return The name of the process associated with the improvement and transformation project.
     */
    public String getprocessCode() {
        return processCode;
    }

    /**
     * <p><b>setprocessCode</b></p>
     * <b>Description:</b> Sets the name of the process associated with the improvement and transformation project to the specified value.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *      <li>The {@code Improvement} object must not be null.</li>
     *      <li>The {@code processCode} parameter must be a String.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *      <li>The name of the process associated with the improvement and transformation project is updated to the specified value.</li>
     * </ul>
     * 
     * @param processCode The new name of the process associated with the improvement and transformation project.
     */
    public void setprocessCode(String processCode) {
        this.processCode = processCode;
    }
    
}
