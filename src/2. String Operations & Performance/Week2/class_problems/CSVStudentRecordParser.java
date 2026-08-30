package string.Week2.class_problems;

import java.util.Scanner;

class CSVStudentRecordParser {

    // Method to parse the CSV student record
    static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        // Check whether exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println("Name: " + name +
                " | Roll No: " + rollNumber +
                " | Dept: " + department);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}