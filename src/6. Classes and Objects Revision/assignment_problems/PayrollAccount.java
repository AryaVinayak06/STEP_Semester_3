class PayrollAccount {

    private double basicSalary;
    private double bonus;

    // Constructor
    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Negative basic salary. Starting with 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    // Credit bonus
    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be greater than 0.");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: Percentage must be between 0 and 100.");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Get net salary
    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}