package labsheet14.exercise1;

public final class SelfEmployedWorker extends Employee {
    private double estimatedIncome;

    public SelfEmployedWorker(String name, String lastName) {
        super(name, lastName);
        setEstimatedIncome();
    }

    @Override
    public String toString() {
        return "SelfEmployed Worker's name " + super.toString();
    }
    public void setEstimatedIncome() {
        this.estimatedIncome = (int)(Math.random() * 400) + 500;
    }

    public double earnings() {
        return estimatedIncome;
    }
}
