package model;

public enum StatusType {
    //Enumeration  Literals
    PENDING("Pending"),
    APPROVED("Approved"),
    DENIED("Denied");

    //Attributes
    private final String description;

    //Methods

    //Extract list of descriptions
    public static String[] getStatusTypes() {
        StatusType[] types = StatusType.values();
        String[] descriptions = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            descriptions[i] = types[i].getDescription();
        }
        return descriptions;
    }

    //intToStatusType
    public static StatusType intToStatus(int intStatus){
        StatusType status= null;

        switch (intStatus) {
            case 1:
                status = PENDING;
                break;
            case 2:
                status = APPROVED;
                break;
            case 3:
                status = DENIED;
                break;
            default:
                break;
        }

        return status;
    }


    //CONSTRUCTOR
    private StatusType(String description){
        this.description = description;
    }


    //GETTERS
    public String getDescription() {
        return description;
    }
    
}
