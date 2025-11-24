package labsheet10.ex4;

class BankAccount {
    private String owner;
    private int number;
    private static double interestRate;

    public BankAccount() {
        this("Owner not Available", 0, 0.0);
    }

    public BankAccount(String owner, int number, double interestRate) {
        this.number = number;
        this.owner = owner;
        BankAccount.interestRate = interestRate;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    @Override
    public String toString(){
        return "Owner: " + getOwner() + " Account Number: " + getNumber() + " Interest Rate: " + getInterestRate() + "\n\n";

    }
}
