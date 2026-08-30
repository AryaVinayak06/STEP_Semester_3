package string.Week1.class_problems;

import java.util.Scanner;

class ReverseCustomerName {

    // Method to reverse the customer name
    static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();
        char[] reversed = new char[characters.length];

        // Store characters in reverse order
        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }

        // Convert character array back to String
        return new String(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println();
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}