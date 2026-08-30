package string.Week2.assignment_problems;

class LibraryISBNNormalizerValidator {

    String normalizeCode(String raw) {
        raw = raw.trim();

        String publisher = raw.substring(0, 3).toUpperCase();
        String remaining = raw.substring(3);

        return publisher + remaining;
    }

    String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: non-letter publisher code";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(code.substring(0, 3))
              .append("] YEAR: ")
              .append(code.substring(3, 7))
              .append(" | CATALOG: ")
              .append(code.substring(7));

        return result.toString();
    }

    public static void main(String[] args) {

        LibraryISBNNormalizerValidator obj =
                new LibraryISBNNormalizerValidator();

        String rawCode = " abC2024123456 ";

        String normalizedCode = obj.normalizeCode(rawCode);

        System.out.println(obj.validateAndFormat(normalizedCode));
    }
}