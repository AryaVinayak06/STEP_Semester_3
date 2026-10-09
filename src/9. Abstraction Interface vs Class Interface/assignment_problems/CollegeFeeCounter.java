
import java.util.Scanner;

abstract class Student {
    String name;
    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    double getTransportFee() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateFee() + getTransportFee();
    }
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000.0;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000.0;
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
            }
        }

        double totalCollected = 0.0;

        for (Student student : students) {
            double fee = student.calculateTotal();

            System.out.printf("%s: %.2f%n", student.name, fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
