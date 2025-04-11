import java.util.List;
import java.util.Map;

public class Comedians {
    private final String fullName;
    private final String nationality;
    private final String style;
    private final String activeYears;
    private final List<String> famousWorks;
    private final double netWorth;
    private final Map<String, Integer> socialMediaFollowers; // e.g., {"Instagram": 1000000}
    private final boolean isStillActive;
    
    public Comedians(String fullName, String nationality, String style, String activeYears,
                     List<String> famousWorks, double netWorth,
                         Map<String, Integer> socialMediaFollowers, boolean isStillActive) {
        this.fullName = fullName;
        this.nationality = nationality;
        this.style = style;
        this.activeYears = activeYears;
        this.famousWorks = famousWorks;
        this.netWorth = netWorth;
        this.socialMediaFollowers = socialMediaFollowers;
        this.isStillActive = isStillActive;
    }
    
        public String getFullName() {
            return fullName;
        }
        
        public String getNationality() {
            return nationality;
        }
    
        public String getStyle() {
            return style;
        }
    
        public String getActiveYears() {
            return activeYears;
        }
    
        public List<String> getFamousWorks() {
            return famousWorks;
        }
        
        public double getNetWorth() {
            return netWorth;
        }
        
        public Map<String, Integer> getSocialMediaFollowers() {
            return socialMediaFollowers;
        }
        
        public boolean isStillActive() {
            return isStillActive;
        }     
}
