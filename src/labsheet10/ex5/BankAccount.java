package labsheet10.ex5;

class BankAccount {
    private String owner;
    private int number;
    private static double interestRate;
    private static int count = 0;

    public BankAccount() {
        this("Owner not Available", 0.0);
    }

    public BankAccount(String owner, double interestRate) {
        setNumber();
        setOwner(owner);
        setInterestRate(interestRate);
    }

    public static int getCount() {
        return count;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = ++count;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Owner: " + getOwner() + " Account Number: " + getNumber() + " Interest Rate: " + getInterestRate() + "\n\n";

    }
}
