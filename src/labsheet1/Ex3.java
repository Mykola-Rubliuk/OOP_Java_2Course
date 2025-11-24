package labsheet1;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the total number of ounces: ");
        int ounces = scan.nextInt();
        scan.nextLine();

        int lbs = ounces / 16;
        int oz = ounces - lbs * 16;

        System.out.printf("%d lbs is equivalent to %d lbs %d oz", ounces, lbs, oz);

    }
}
