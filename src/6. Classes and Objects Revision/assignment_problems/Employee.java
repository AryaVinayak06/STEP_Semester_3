class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print employee profile
    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        // Permanent employee
        Employee e1 = new Employee("E-101", "Divya", 65000);

        // Intern
        Employee e2 = new Employee("E-102", "Arjun");

        // Print profiles
        e1.printProfile();
        e2.printProfile();
    }
}