package model;

public class Knowledge extends Project{

    //Attributes
    private Community impactedCommunity;
    private KnowledgeType type;

    //Relations

    //Methods

    //CONSTRUCTOR
    public Knowledge(String name, String id, int intPriority,  ImprovementCollaborator leader,
    Request approvedRequest, int intImpactedCommunity, int intType) {
    super(name, id, intPriority, leader, approvedRequest);
    this.impactedCommunity = Community.intToCommunity(intImpactedCommunity);
    this.type = KnowledgeType.intToKnowledgeType(intType);
    }

    //GETTERS AND SETTERS
    public Community getImpactedCommunity() {
        return impactedCommunity;
    }

    public void setImpactedCommunity(Community impactedCommunity) {
        this.impactedCommunity = impactedCommunity;
    }

    public KnowledgeType getType() {
        return type;
    }

    public void setType(KnowledgeType type) {
        this.type = type;
    }
    
}
