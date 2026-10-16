import java.util.Scanner;

public class AttendanceSummary {

    static void attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                streak++;

                if (streak > longestStreak) {
                    longestStreak = streak;
                }
            } else {
                streak = 0;
            }
        }

        System.out.println("Present: " + present +
                           ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        attendanceSummary(days);

        sc.close();
    }
}