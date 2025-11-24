package labsheet1;

public class FormattingVariables {
    public static void main(String[] args) {
        String country1 = "Ireland";
        String country2 = "United Kingdom";

        int population1 = 7026636;
        int population2 = 68138484;

        float popDen1 = 82.20f;
        float popDen2 = 270.70f;

        System.out.printf("%-20s%-16s%s\n%-20s%-16s%s\n%-20s%-16s%.2f\n%-20s%-16s%.2f", "Name", "Population", "Pop Density", "----", "----------", "-----------",
                country1, population1, popDen1, country2, population2, popDen2);

    }
}
