import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Exercises_1 {
    public static void main(String[] args) {
        // Exercise 1.1 - Tell me about yourself
//        int age = 39;
//        String firstName = "Julia";
//        String lastName = "Felberbauer";
//        String dateOfBirth = "05-12-1982";
//        double averageGrade = 2.1;
//        boolean married = false;
//        System.out.println("Age: " + age);
//        System.out.println(String.format("First name: %s\nLast name: %s", firstName, lastName));
//        System.out.println("Date of birth: " + dateOfBirth);
//        System.out.println("Average grade: " + averageGrade);
//        System.out.println("Married: " + married);

        // Exercise 1.2 - Simple Calculations
//        int num1 = 60;
//        int num2 = 78;
//        System.out.printf("%d + %d = %d%n", num1, num2, num1 + num2);
//        System.out.println(String.format("%d + %d = %d", num1, num2, num1 + num2));

        // Aufgabe 1.3 - Arbeiten mit Strings [🤓 Advanced]
//        String message = " Hello World! ";
//        System.out.println("String: " + message);
//        System.out.println("String length: " + message.length());
//        System.out.println("String in uppercase letters: " + message.toUpperCase());
//        System.out.println("String in lower case letters: " + message.toLowerCase());
//        System.out.println("Replace part of string: " + message.replace("world", "CodersBay"));
//        System.out.println("Delete first space: " + message.replaceFirst(" ", ""));
//        // String is offset because the first char is a space
//        System.out.print("Repeat string 15 times: " + (message + "\n").repeat(15));

        // Aufgabe 2.1 Eigenschaften einer Zahl
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter an integer.");
//        int number = scanner.nextInt();
//        int luckyNumber = 5;
//
//        String isRound = number % 10 == 0
//                ? "Number is round."
//                : "Number is not round.";
//        String isEven = number % 2 == 0
//                ? "Number is even."
//                : "Number is odd.";
//        String isLuckyNumber = number == luckyNumber
//                ? "Number is Julia's lucky number."
//                : "Number is not Julia's lucky number.";
//        String isTwoDigitNumber = number >= 10
//                ? "Number is two-digit number."
//                : "Number is one-digit number.";
//
//        System.out.println(isRound);
//        System.out.println(isEven);
//        System.out.println(isLuckyNumber);
//        System.out.println(isTwoDigitNumber);


        // Aufgabe 2.2 Arbeits- oder Freizeit?
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a time in this format: HH:MM, eg. 15:30.");
        // nextLine() or next()?
//        String time = scanner.next();
//
//        int hour = Integer.parseInt(time.substring(0, 2));
//        if (hour == 24) {
//            hour = 0;
//        }
//        int minute = Integer.parseInt(time.substring(3));

        // Course times
//        LocalTime currentTime = LocalTime.of(hour, minute);
//        LocalTime courseStart = LocalTime.of(8, 30);
//        LocalTime courseEnd = LocalTime.of(15, 30);
//        LocalTime beginBreak = LocalTime.of(12, 0);
//        LocalTime endBreak = LocalTime.of(12, 30);
//
//        // Time check
//        if (currentTime.isAfter(courseEnd) || currentTime.isBefore(courseStart)) {
//            System.out.println("Free time!");
//        } else if (currentTime.getHour() == 12) {
//            System.out.println("Lunch break");
//        } else {
//            System.out.println("Time to work!");
//        }


        // Aufgabe: Noten übersetzen
//        Schreibe ein Programm, dass eine Schulnote in numerischer Form (1-5) in seine textuelle Form übersetzt:
//
//        Bei einer 1 wird "Sehr gut" auf die Konsole geschrieben
//        Bei einer 2 wird "Gut" auf die Konsole geschrieben
//        Bei einer 3 wird "Befriedigend" auf die Konsole geschrieben
//        Bei einer 4 wird "Genügend" auf die Konsole geschrieben
//        Bei einer 5 wird "Nicht Gengügend" auf die Konsole geschrieben

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a grade between 1 and 5.");
//        int grade = scanner.nextInt();
//        switch (grade) {
//            case 1:
//                System.out.println("Sehr gut");
//                break;
//            case 2:
//                System.out.println("Gut");
//                break;
//            case 3:
//                System.out.println("Befriedigend");
//                break;
//            case 4:
//                System.out.println("Genuegend");
//                break;
//            case 5:
//                System.out.println("Nicht genuegend");
//                break;
//            default:
//                System.out.println("This grade does not exist.");
//        }

        // Aufgabe: FizzBuzz
//        for (int i = 1; i <= 100 ; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println(String.format("FizzBuzz! (%d)", i));
//            } else if (i % 3 == 0) {
//                System.out.println(String.format("Fizz! (%d)", i));
//            } else if (i % 5 == 0) {
//                System.out.println(String.format("Buzz! (%d)", i));
//            } else {
//                System.out.println(i);
//            }
//        }


        // Aufgabe: Das kleine Einmal-Eins
//        for (int i = 1; i <= 10 ; i++) {
//            System.out.println(String.format("%der Reihe:", i));
//            for (int j = 1; j <= 10; j++) {
//                System.out.println(i * j);
//            }
//            System.out.print("\n");
//        }

        // Aufgabe: Caesar Chiffre
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a text that you would like to encrypt (letters and spaces only).");
//        String string = scanner.nextLine();
//        String encryptedString = "";
//        Random random = new Random();
//        int caesarsCipher = random.nextInt(1, 27);
//        System.out.println("Caesar's cipher: " + caesarsCipher);
//
//        for (int i = 0; i < string.length(); i++) {
//            char currentChar = string.charAt(i);
//            if (currentChar >= 'A' && currentChar <= 'Z') {
//                if (currentChar + caesarsCipher > 'Z') {
//                    encryptedString += Character.toString(currentChar + caesarsCipher - 26);
//                } else {
//                    encryptedString += Character.toString(currentChar + caesarsCipher);
//                }
//            } else if (currentChar >= 'a' && currentChar <= 'z') {
//                if (currentChar + caesarsCipher > 'z') {
//                    encryptedString += Character.toString(currentChar + caesarsCipher - 26);
//                } else {
//                    encryptedString += Character.toString(currentChar + caesarsCipher);
//                }
//            } else {
//                encryptedString += currentChar;
//            }
//        }
//
//        System.out.println("Encrypted string: " + encryptedString);


        // Aufgabe: Berechnung des Maximums
        Scanner scanner = new Scanner(System.in);
        int number;
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter an integer.");
        // Warum nicht mit do-while?
        while (!scanner.hasNext("q") && !scanner.hasNext("Q")) {
            number = scanner.nextInt(); // or nextLine()
            nums.add(number);
            System.out.println("number: " + number);
            System.out.println("Enter an integer.");
        }

        System.out.println(nums);
        Integer max = Collections.max(nums);
        System.out.println("max number: " + max);
        // Aufgabe: Leetspeak
    }
}
