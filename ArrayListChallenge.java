import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* ### ArrayList Challenge:
   Write a program that accepts user inputs as long as the user doesn't hit "Q" (for "Quit").
   Once user quits, print the numbers in the array list and indicate which number is the greatest.
 */

public class ArrayListChallenge {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int maxNumIndex = 0;
        int maxNum = 0; // -Infinity?

        System.out.println("Please enter an integer. Enter Q if you want to quit.");
        String entry = scanner.nextLine();

        while (!entry.equals("Q")) {
            nums.add(Integer.valueOf(entry));
            System.out.println(nums);
            System.out.println("Please enter an integer. Enter Q if you want to quit.");
            entry = scanner.nextLine();
        }

        if (entry.equals("Q")) {
            maxNum = Collections.max(nums);
            System.out.println("maxNum: " + maxNum);
            maxNumIndex = nums.indexOf(maxNum);

            for (int i = 0; i < nums.size(); i++) {
                if (i == maxNumIndex) {
                    System.out.println(String.format("%d %s", nums.get(i), " <== greatest number"));
                } else {
                    System.out.println(nums.get(i));
                }
            }
        }
    }
}
