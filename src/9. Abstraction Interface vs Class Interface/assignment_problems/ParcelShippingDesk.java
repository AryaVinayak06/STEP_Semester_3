
import java.util.Scanner;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

interface Insurable {
    double calculateInsurance();
}

class Standard extends Parcel {
    Standard(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40.0 + (10.0 * weight) + 50.0;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            switch (types[i]) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, declaredValue);
                    break;

                case "EXPRESS":
                    parcels[i] = new Express(weight, declaredValue);
                    break;

                case "FRAGILE":
                    parcels[i] = new Fragile(weight, declaredValue);
                    break;
            }
        }

        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            double charge = parcels[i].calculateCharge();
            double insurance = parcels[i].calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i], charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
