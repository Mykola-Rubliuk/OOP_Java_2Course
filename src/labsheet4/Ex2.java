package labsheet4;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("The sum of the first 20 positive integers is " + sumOf20Int());
    }

    private static int sumOf20Int() {
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += i;
        }
        return sum;
    }
}
