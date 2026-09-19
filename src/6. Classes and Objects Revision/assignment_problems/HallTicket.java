class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create Priya's hall ticket
        HallTicket priya = new HallTicket("Priya", 0);

        // Point another variable to the same object
        HallTicket copy = priya;

        // Change seat number through copy
        copy.seatNumber = 45;

        // Create a separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print results
        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));
    }
}