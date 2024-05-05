package model;

public enum Community {
            //Enumeration  Literals
            STUDENT("Student"),
            PROFESSOR("Professor"),
            ADMINISTRATIVE("Administrative");
        
            //Attributes
            private final String description;
        
            //Methods
        
            //Extract list of descriptions
            public static String[] getCommunity() {
                Community[] types = Community.values();
                String[] descriptions = new String[types.length];
                for (int i = 0; i < types.length; i++) {
                    descriptions[i] = types[i].getDescription();
                }
                return descriptions;
            }
        
            //intToKnowledType
            public static Community intToCommunity(int intCommunity){
                Community Community= null;
        
                switch (intCommunity) {
                    case 1:
                        Community = STUDENT;
                        break;
                    case 2:
                        Community = PROFESSOR;
                        break;
                    case 3:
                        Community = ADMINISTRATIVE;
                        break;
                    default:
                        break;
                }
        
                return Community;
            }
        
        
            //CONSTRUCTOR
            private Community(String description){
                this.description = description;
            }
        
        
            //GETTERS
            public String getDescription() {
                return description;
            }
}
