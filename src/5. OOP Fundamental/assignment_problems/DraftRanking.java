import java.util.Arrays;

public class DraftRanking {

    // Encapsulated data members
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public DraftRanking(String name, int matchesPlayed,
                        double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Established player rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Newer player rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Compare by batting average in descending order
    public int compareTo(DraftRanking other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Draft and rank players
    static String draftAndRank(DraftRanking[] players) {

        // First count draftable players
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        // Create array containing only draftable players
        DraftRanking[] draftable = new DraftRanking[count];

        int index = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[index] = players[i];
                index++;
            }
        }

        // Sort using compareTo()
        Arrays.sort(draftable);

        // Create output
        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result + (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        DraftRanking[] players = {
            new DraftRanking("Virat", 15, 48.0, false),
            new DraftRanking("Rahul", 7, 55.0, false),
            new DraftRanking("Sameer", 3, 60.0, false),
            new DraftRanking("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}