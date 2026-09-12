import java.util.Arrays;

public class PlacementEngine {

    // Encapsulated data members
    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public PlacementEngine(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility rule
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined CGPA and coding-score rule
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Composite score
    double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }

    // Sort by composite score in descending order
    public int compareTo(PlacementEngine other) {
        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    // Shortlist and rank candidates
    static String shortlistAndRank(PlacementEngine[] candidates) {

        int count = 0;

        // Count eligible candidates
        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa,
                           candidates[i].codingScore)) {
                count++;
            }
        }

        // Create shortlisted array
        PlacementEngine[] shortlisted = new PlacementEngine[count];

        int index = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa,
                           candidates[i].codingScore)) {

                shortlisted[index] = candidates[i];
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        // Create output
        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result + (i + 1) + ". "
                   + shortlisted[i].name
                   + " (" + shortlisted[i].getCompositeScore() + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PlacementEngine[] candidates = {
            new PlacementEngine("Aisha", 8.2, 40),
            new PlacementEngine("Rohit", 6.8, 65),
            new PlacementEngine("Meena", 6.0, 90),
            new PlacementEngine("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}