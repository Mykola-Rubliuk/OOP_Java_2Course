package labsheet3;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question = "Please enter thw weight of person %d: ";
        int index = 0;
        double weight, totalWeight = 0, avgWeight = 0, maxWeight = 0,
                minWeight = Double.POSITIVE_INFINITY, percentageMoreEqual80 = 0;
        while (index < 5) {
            System.out.printf(question, index + 1);
            weight = scanner.nextDouble();
            totalWeight += weight;

            if (weight > maxWeight) maxWeight = weight;
            if (weight < minWeight) minWeight = weight;
            if (weight >= 80) percentageMoreEqual80++;

            index++;
        }
        System.out.println("""
                ===========================
                
                       Program Results
                
                ===========================""");
        System.out.printf("Average weight: %.2fkg\n", totalWeight / index);
        System.out.printf("Percentage >= 80kg: %.2f%%\n", percentageMoreEqual80 / index * 100);
        System.out.printf("Heaviest weight: %.2fkg\n", maxWeight);
        System.out.printf("Lightest weight: %.2fkg\n", minWeight);

    }
}
