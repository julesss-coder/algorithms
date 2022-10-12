import java.util.Scanner;

public class Exercises_2 {
    public static void main(String[] args) {

        // Glass empty/full
//        Scanner scanner = new Scanner(System.in);
//        int milliliters;
//        String glassState = null;
//        do {
//            System.out.println("How many milliliters of water are there in your glass? Enter up to 250.");
//            milliliters = Integer.parseInt(scanner.nextLine());
//        } while (milliliters > 250 || milliliters < 0);
//
//        if (milliliters == 125) {
//            glassState = "half full";
//        } else if (milliliters == 250) {
//            glassState = "full";
//        } else if (milliliters == 0) {
//            glassState = "empty";
//        } else {
//            glassState = "not full anymore";
//        }
//
//        System.out.printf("The glass is %s.%n", glassState);

        // Quadratic equations
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an integer.");
//
//        int a = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter another integer.");
//        int b = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter another integer.");
//        int c = Integer.parseInt(scanner.nextLine());
//        int discriminant = b^2 - 4 * a * c;
//        int solutions;
//
//        if (discriminant > 0) {
//            solutions = 2;
//        } else if (discriminant < 0) {
//            solutions = 0;
//        } else {
//            solutions = 1;
//        }
//
//        System.out.printf("Number of solutions for this equation: %d", solutions);

        // While and do-while loops
//        int i = 1;
//        while (i <= 50) {
//            System.out.println(i);
//            i++;
//        }
//
//        int j = 1;
//        do {
//            System.out.println(j);
//            j++;
//        } while (j <= 50);

        // Push-ups: 3 sets with 10 push-ups each
        for (int i = 1; i < 4; i++) {
            System.out.printf("Round %d:", i);
            for (int j = 1; j < 11; j++) {
                System.out.printf("Push-up number %d ", j);
            }
            System.out.print("\n");
        }
    }
}
