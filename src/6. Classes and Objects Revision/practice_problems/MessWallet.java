class MessWallet {

    private double balance;

    MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance. Starting with 0.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Top-up successful: " + amount);
        }
    }

    void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: Amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Deduction rejected: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Deduction successful: " + amount);
        }
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(1000);

        System.out.println("Current Balance: " + wallet.getBalance());

        wallet.topUp(500);
        wallet.deduct(300);
        wallet.deduct(1500);
        wallet.topUp(-100);

        System.out.println("Final Balance: " + wallet.getBalance());
    }
}