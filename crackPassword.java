// Niklas: Das Passwort über Zufallszahlen zu erraten, beinhaltet die Möglichkeit, dass es nie erraten wird.
// Die Aufgabe verlangt aber eine Brute Force-Lösung, d.h. dass alle Möglichkeiten durchprobiert werden.
// 0000
// für jede Stelle im Passwort:
    // jedes Zeichen aus possibleChars einsetzen
/*
0001
0002
...
0010
0020
 */

import java.util.Random;

public class CrackThePassword {
    public static void main(String[] args) {
        // You can put any characters into a char array and split it by using .toCharArray()
        char [] possibleChars = "0123456789".toCharArray(); //!§$%&/()=?".toCharArray(); //!§$%&/()=?".toCharArray();
        String password = "";

        // Generate password, length 4
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int randomInt = random.nextInt(possibleChars.length);
            password += possibleChars[randomInt];
        }

        String guess = "";
        // Generate random password `guess` and check if it === password
        int counter = 0;
        while (guess.equals(password) == false)  {
            guess = "";
            for (int i = 0; i < password.length(); i++) {
                Random random = new Random();
                int randomInt = random.nextInt(possibleChars.length);
                guess += possibleChars[randomInt];
                counter++;
            }
            System.out.println("guess: " + guess);
        }
        System.out.println("versuche: " + counter);

        System.out.println("Generated password: " + password);
        System.out.println("guess: " + guess);
        System.out.println("guess == password: " + guess.equals(password));
    }
}

