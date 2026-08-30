package string.Week2.class_problems;

import java.util.Scanner;

class FileExtensionValidator {

    static String validateFileExtension(String filename) {

        // Find the last dot
        int dotPosition = filename.lastIndexOf('.');

        // Check if there is no extension
        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract the extension
        String extension = filename.substring(dotPosition + 1);

        // Check accepted extensions
        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        System.out.println(validateFileExtension(filename));

        sc.close();
    }
}