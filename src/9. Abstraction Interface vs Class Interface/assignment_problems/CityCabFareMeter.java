
import java.util.Scanner;

abstract class Cab {
    double km;
    static final double MIN_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateFare();

    double getFare() {
        return Math.max(calculateFare(), MIN_FARE);
    }
}

interface NightService {
    double NIGHT_CHARGE = 0.20;

    double calculateNightFare();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateFare() {
        return km * 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateFare() {
        return km * 14.0;
    }

    public double calculateNightFare() {
        return getFare() * (1.0 + NIGHT_CHARGE);
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateFare() {
        return km * 18.0;
    }

    public double calculateNightFare() {
        return getFare() * (1.0 + NIGHT_CHARGE);
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double km = sc.nextDouble();
            times[i] = sc.next();

            switch (types[i]) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;

                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;

                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
            }
        }

        double total = 0.0;

        for (int i = 0; i < n; i++) {
            if (times[i].equals("NIGHT")
                    && !(cabs[i] instanceof NightService)) {
                System.out.println(
                    types[i] + ": night service not available");
                continue;
            }

            double fare;

            if (times[i].equals("NIGHT")) {
                fare = ((NightService) cabs[i]).calculateNightFare();
            } else {
                fare = cabs[i].getFare();
            }

            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
