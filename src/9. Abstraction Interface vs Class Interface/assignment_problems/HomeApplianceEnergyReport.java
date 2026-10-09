
import java.util.Scanner;

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

interface SaverMode {
    double SAVER_FACTOR = 0.75;

    double calculateSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    public double calculateSaverUnits() {
        return calculateUnits() * SAVER_FACTOR;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    public double calculateSaverUnits() {
        return calculateUnits() * SAVER_FACTOR;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] saver = new boolean[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            double hours = sc.nextDouble();

            saver[i] = false;

            if (sc.hasNext()) {
                // Read SAVER only if it is on this input line.
                // This implementation assumes each input record
                // contains either two or three tokens per line.
            }

            switch (names[i]) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;

                case "AC":
                    appliances[i] = new AC(hours);
                    break;

                case "TV":
                    appliances[i] = new TV(hours);
                    break;

                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
            }
        }

        sc.close();
    }
}
