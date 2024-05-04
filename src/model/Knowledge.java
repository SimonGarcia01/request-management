package model;

public class Knowledge extends Project{

    //Attributes
    private Community impactedCommunity;
    private KnoledgeType type;

    //Relations

    //Methods

    //CONSTRUCTOR
    public Knowledge(String name, String id, int intPriority, ImprovementCollaborator leader,
    Community impactedCommunity, KnoledgeType type) {
    super(name, id, intPriority, leader);
    this.impactedCommunity = impactedCommunity;
    this.type = type;
    }

    public Community getImpactedCommunity() {
        return impactedCommunity;
    }

    public void setImpactedCommunity(Community impactedCommunity) {
        this.impactedCommunity = impactedCommunity;
    }

    public KnoledgeType getType() {
        return type;
    }

    public void setType(KnoledgeType type) {
        this.type = type;
    }

    //GETTERS AND SETTERS
    
    

    
}
