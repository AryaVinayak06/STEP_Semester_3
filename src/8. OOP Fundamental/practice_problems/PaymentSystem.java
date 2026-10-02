
import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            double adjustedAmount = amount;

            if (type.equals("CARD")) {
                adjustedAmount = amount + (amount * 0.02);
            } else if (type.equals("WALLET")) {
                adjustedAmount = amount + (amount * 0.01);
            } else if (type.equals("BANKTRANSFER")) {
                adjustedAmount = amount;
            }

            System.out.printf("%s: %.2f%n", type, adjustedAmount);

            total = total + adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
