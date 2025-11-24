package labsheet3;

public class Ex6 {
    public static void main(String[] args) {
        int year = 1;
        String taskQuestion = "Balance at the end of year %d is EUR %.2f\n";
        double balance = 100_000;

        while (balance >= 12_000) {
            balance += balance * 0.03 - 12000;
            System.out.printf(taskQuestion, year, balance);
            year++;
        }
    }
}
