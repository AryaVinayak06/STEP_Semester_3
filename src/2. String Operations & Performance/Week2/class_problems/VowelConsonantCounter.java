package string.Week2.class_problems;

import java.util.Scanner;

class VowelConsonantCounter {

    // Method to count vowels and consonants
    static void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Convert character to lowercase
            ch = Character.toLowerCase(ch);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }

            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {

                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels +
                " | Consonants: " + consonants);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a book title: ");
        String text = sc.nextLine();

        countVowelsAndConsonants(text);

        sc.close();
    }
}