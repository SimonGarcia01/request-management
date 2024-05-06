package model;

public class University {
    //Attributes

    //Relations
    private Collaborator[] collaborators;
    private Department[] departments;

    //Methods

    //Main Methods

    //REGISTER A DTI OR GENERAL COLLABORATOR
    /**
     * <p><b>registerCollaborator</b></p>
     * <b>Description:</b> Registers a collaborator based on the provided information and type.
     * This method checks for duplicate collaborators with the same ID using the {@link #searchCollaborator(String)} method.
     * If there is a duplicate collaborator, it returns a message indicating that the collaborator has already been registered.
     * If there is no duplicate, it checks for available space to register a new collaborator using the {@link #availableCollaborator()} method.
     * If there is no available space, it returns a message indicating that no more collaborators can be registered.
     * If space is available, it creates a new instance of either ImprovementCollaborator  ({@link ImprovementCollaborator#ImprovementCollaborator(String, String, String, String)})or general Collaborator  ({@link Collaborator#Collaborator(String, String, String, String)})based on the provided type.
     * The newly created collaborator is then added to the array of collaborators.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} array must be initialized.</li>
     *   <li>{@code searchCollaborator} and {@code availableCollaborator} methods should be in place.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A collaborator is registered based on the provided information and type, and a message indicating the success or failure of the registration is returned.</li>
     * </ul>
     * 
     * @param intType The type of collaborator (1 for DTI, 2 for general).
     * @param fullName The full name of the collaborator.
     * @param id The ID of the collaborator.
     * @param email The email address of the collaborator.
     * @param extension The extension number of the collaborator.
     * @return A message indicating the success or failure of the registration.
     */
    public String registerCollaborator(int intType, String fullName, String id, String email, String extension){
        String message = "";

        if(searchCollaborator(id) == null){
            int space = availableCollaborator();

            if(space != -1){

                if(intType == 1){
                    collaborators[space] = new ImprovementCollaborator(id, fullName, email, extension);
                    message = "The DTI collaborator has been registered successfully.";
                } else {
                    collaborators[space] = new Collaborator(id, fullName, email, extension);
                    message = "The general collaborator has been registered successfully.";
                }
                
            } else {
                message = "There is no more space to register a collaborator.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //REGISTER A DEPARTMENT

    public String registerDepartment(String internalCode, String name, String address, int intResponsibleCollaborator){

        int space = availableDepartment();

        departments[space] = new Department(address, name, internalCode, intToCollaborator(intResponsibleCollaborator));

        return "The department has been registered successfully.";
    }


    //General Methods ------------------------------------------------------------------------------------------


    //SEARCH FOR A COLLABORATOR
    /**
     * <p><b>searchCollaborator</b></p>
     * <b>Description:</b> Searches for a collaborator with the specified ID.
     * This method iterates through the array of collaborators stored in the university and checks if there is a collaborator with the provided ID.
     * If a collaborator with the matching ID is found, it returns the collaborator object; otherwise, it returns null.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} array must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The collaborator object with the specified ID, if found, is returned; otherwise, null is returned.</li>
     * </ul>
     * 
     * @param id The ID of the collaborator to search for.
     * @return The collaborator object with the specified ID, if found; otherwise, null.
     */
    public Collaborator searchCollaborator(String id){
        Collaborator collaborator = null;

        for(Collaborator instCollaborator : collaborators){
            if(instCollaborator!=null && instCollaborator.getId().equals(id)){
                collaborator = instCollaborator;
            }
        }

        return collaborator;
    }

    //DISPLAY EXISTENT COLLABORATOR

    public String displayCollaborators(){
        String message = "Available collaborators: ";
        int counter = 1;
        boolean loopController = true;

        for(int n = 0; n < collaborators.length && loopController; n++){
            if(collaborators[n] != null){

                message += String.format("\n\t%d. Full name: %s - ID: %s", counter, collaborators[n].getFullName(), 
                collaborators[n].getId());

                counter++;
            } else {
                loopController = false;
            }
        }

        return message;
    }
    
    //INT TO COLLABORATOR

    public Collaborator intToCollaborator(int intResponsibleCollaborator){
        return collaborators[intResponsibleCollaborator -1];
    }

    //AVAILABLE POSiTION TO STORE A COLLABORATOR
    /**
     * <p><b>availableCollaborator</b></p>
     * <b>Description:</b> Determines the index of the next available slot in the array of collaborators.
     * This method iterates through the array of collaborators stored in the university and returns the index of the first null slot found.
     * If no null slot is found, it returns -1, indicating that there is no available space to register a new collaborator.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} array must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The index of the next available slot in the array of collaborators, if found; otherwise, -1 is returned.</li>
     * </ul>
     * 
     * @return The index of the next available slot in the array of collaborators, if found; otherwise, -1.
     */
    public int availableCollaborator(){
        int position = -1;
        boolean loopController = true;

        for(int n = 0; n < collaborators.length && loopController; n++){
            if(collaborators[n]==null){
                position = n;
                loopController = false;
            }
        }

        return position;
    }

    //ATLEAST ONE COLLABORATOR

    public boolean oneMinCollaborator(){
        boolean oneCollaborator = false;

        if(collaborators[0]!=null){
            oneCollaborator = true;
        }

        return oneCollaborator;
    }

    //SEARCH DEPARTMENT
    public Department searchDepartment(String internalCode){
        Department instDepartment = null;

        for(Department department  : departments) {
            if(department != null && department.getInternalCode().equalsIgnoreCase(internalCode)){
                instDepartment = department;
            }
        }

        return instDepartment;
    }
    
    //AVAILABLE POSITION TO STORE A DEPARTMENT
    public int availableDepartment(){
        int position = -1;
        boolean loopController = true;

        for(int n = 0; n < departments.length &&loopController; n++){
            if(collaborators[n]==null){
                position = n;
                loopController = false;
            }
        }

        return position;
    }
    
    //CONSTRUCTOR
    /**
     * <p><b>University</b></p>
     * <b>Description:</b> Constructs a new University object.
     * This constructor initializes the array of collaborators with a fixed size of 1000.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code None}: No preconditions.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>A new University object is created with an array of collaborators initialized to a size of 1000.</li>
     * </ul>
     */
    public University(){
        this.collaborators = new Collaborator[10];
        this.departments = new Department[10];
    }


    //GETTERS AND SETTERS
    /**
     * <p><b>getCollaborators</b></p>
     * <b>Description:</b> Retrieves the array of collaborators stored in the university.
     * 
     * <p><b>Preconditions:</b></p>
     * <ul>
     *   <li>{@code collaborators} array must be initialized.</li>
     * </ul>
     * 
     * <p><b>Postconditions:</b></p>
     * <ul>
     *   <li>The array of collaborators stored in the university is returned.</li>
     * </ul>
     * 
     * @return The array of collaborators stored in the university.
     */
    public Collaborator[] getCollaborators() {
        return collaborators;
    }
    
    
    public Department[] getDepartments(){
        return departments;
    }
}
