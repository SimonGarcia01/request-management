package model;

public class Collaborator {
    //Attributes
    private String id;
    private String fullName;
    private String email;
    private String extension;

    //Relations

    //Methods
    
    //CONSTRUCTOR
    public Collaborator(String id, String fullName, String email, String extension){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.extension = extension;
    }


    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
