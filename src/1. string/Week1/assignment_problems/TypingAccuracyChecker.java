package string.Week1.assignment_problems;

class TypingAccuracyChecker {

    void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position "
                    + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch)
                    + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {
        TypingAccuracyChecker obj = new TypingAccuracyChecker();

        String original1 = "hello world";
        String typed1 = "hello worlt";
        obj.checkTypingAccuracy(original1, typed1);

        String original2 = "coding";
        String typed2 = "coding";
        obj.checkTypingAccuracy(original2, typed2);
    }
}