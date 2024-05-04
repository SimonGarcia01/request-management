package model;

public class University {
    //Attributes

    //Relations
    private Collaborator[] collaborators;

    //Methods

    //Register a DTI collaborator
    /**
     * <p><b>registerCollaborator</b></p>
     * <b>Description:</b> Registers a DTI collaborator based on the provided information.
     * This method checks for duplicate collaborators with the same ID using the {@link #searchCollaborator(String)} method.
     * If there is a duplicate collaborator, it returns a message indicating that the collaborator has already been registered.
     * If there is no duplicate, it checks for available space to register a new collaborator using the {@link #availableCollaborator()} method.
     * If there is no available space, it returns a message indicating that no more collaborators can be registered.
     * If space is available, it creates a new instance of the ImprovementCollaborator class and initializes it with the provided information.
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
     *   <li>A DTI collaborator is registered based on the provided information, and a message indicating the success or failure of the registration is returned.</li>
     * </ul>
     * 
     * @param fullName The full name of the collaborator.
     * @param id The ID of the collaborator.
     * @param email The email address of the collaborator.
     * @param extension The extension number of the collaborator.
     * @param numberImplementedImprovements The number of improvements implemented by the collaborator.
     * @param numberLedProjects The number of projects led by the collaborator.
     * @return A message indicating the success or failure of the registration.
     */

    public String registerCollaborator(String fullName, String id, String email, String extension, 
    int numberImplementedImprovements, int numberLedProjects){
        String message = "";

        if(searchCollaborator(id) == null){
            int space = availableCollaborator();

            if(space != -1){
                collaborators[space] = new ImprovementCollaborator(id, fullName, email, extension, numberImplementedImprovements, numberLedProjects);
                message = "The DTI collaborator has been registered successfully.";
            } else {
                message = "There is no more space to register a collaborator.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //Register a general collaborator
    public String registerCollaborator(String fullName, String id, String email, String extension){
        String message = "";

        if(searchCollaborator(id) == null){
            int space = availableCollaborator();

            if(space != -1){
                collaborators[space] = new Collaborator(id, fullName, email, extension);
                message = "The general collaborator has been registered successfully.";
            } else {
                message = "There is no more space to register a collaborator.";
            }

        }else{
            message = "A collaborator with that Id has already been registered.";
        }

        return message;
    }

    //search collaborator
        /**
    * <p><b>searchProf</b></p>
    * <b>Description:</b> Searches for a professor with the specified first and last name.
    * This method iterates through the array of professors stored in the univesity and checks if there is a professor with the provided first and last name.
    * If a professor with matching first and last names is found, it sets the flag {@code existProfessor} to true; otherwise, it remains false.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code professors} array must be initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A boolean value indicating whether a professor with the specified first and last name exists or not is returned.</li>
    * </ul>
    * 
    * @param firstName The first name of the professor to search for.
    * @param lastName The last name of the professor to search for.
    * @return {@code boolean} informing if a professor with the specified first and last name exists.
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

    //Available position for a collaborator
        /**
    * <p><b>availableProf</b></p>
    * <b>Description:</b> Finds the index of the first available slot in the professors array to register a new professor.
    * This method iterates through the array of professors stored in the controller and returns the index of the first null element, indicating an available slot to register a new professor.
    * If no available slot is found, it returns -1.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code professors} array must be initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The index of the first available slot to register a new professor is returned.</li>
    * </ul>
    * 
    * @return The index of the first available slot to register a new professor, or -1 if no slot is available.
    */
    public int availableCollaborator(){
        int position = -1;

        for(int n = 0; n < collaborators.length; n++){
            if(collaborators[n]==null){
                position = n;
            }
        }

        return position;
    }

    //CONSTRUCTOR
        /**
    * <p><b>University</b></p>
    * <b>Description:</b> Constructs a new University object.
    * This constructor initializes the array of professors with a fixed size of 50.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
    *   <li>{@code None}: No preconditions.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>A new University object is created with an array of professors initialized to a size of 50.</li>
    * </ul>
    */
    public University(){
        this.collaborators = new Collaborator[1000];
    }


    //GETTERS AND SETTERS
    /**
    * <p><b>getProfessors</b></p>
    * <b>Description:</b> Retrieves the array of professors.
    * This method returns the array of professors stored in the  University.
    * 
    * <p><b>Preconditions:</b></p>
    * <ul>
        *   <li>{@code professors} array must be initialized.</li>
    * </ul>
    * 
    * <p><b>Postconditions:</b></p>
    * <ul>
    *   <li>The array of professors is returned.</li>
    * </ul>
    * 
    * @return The array of professors.
    */
    public Collaborator[] getCollaborators() {
        return collaborators;
    }
    
}
