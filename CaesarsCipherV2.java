import java.util.Scanner;

public class CaesarsCipherV2 {
    public static void main(String[] args) {
           /*File source = new File("source.txt");
           FileWriter fileWriter = new FileWriter(source, true);*/
        String string = "Hal%lOzZ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer that is not 0.");
        int cipher = scanner.nextInt();
        System.out.println("Your string will be encrypted with cipher " + cipher);

        while (cipher == 0) {
            System.out.println("Please choose an integer that is not 0.");
        }

        String encrypted = "";
        // encrypt string:
        if (cipher > 0) {
            encrypted = convertWithPositiveCipher(string, cipher);
            System.out.println("Encrypted string: " + encrypted);
        } else if (cipher < 0) {
            // decrypt string:
            // change algebraic sign of cipher
            encrypted = convertWithNegativeCipher(string, cipher);
            System.out.println("Encrypted string: " + encrypted);
        }

        // decrypt string:
        String decrypted = "";
        // Change algebraic sign of cipher:
        cipher *= -1;
        if (cipher > 0) {
            decrypted = convertWithPositiveCipher(encrypted, cipher);
            System.out.println("Decrypted string: " + decrypted);
        } else if (cipher < 0) {
            decrypted = convertWithNegativeCipher(encrypted, cipher);
            System.out.println("Decrypted string: " + decrypted);
        }
    }

    static String convertWithPositiveCipher(String string, int cipher) {
        String encryptedString = "";
        for (int i = 0; i < string.length(); i++) {
            int newASCIIIndex = 0;
            int currentASCIIIndex = string.charAt(i);
            // If current character is upper case letter:
            if (currentASCIIIndex >= 65 && currentASCIIIndex <= 90) {
                if (currentASCIIIndex + cipher <= 'Z') {
                    newASCIIIndex += cipher;
                    System.out.println("NewASCIIIndex: " + newASCIIIndex);
                } else if (currentASCIIIndex + cipher > 'Z') {
                    newASCIIIndex = newASCIIIndex - 26 + cipher;
                    System.out.println("NewASCIIIndex: " + newASCIIIndex);
                }
                    /*StringBuilder text = new StringBuilder();
                   text.append("a");*/
                encryptedString += Character.toString(newASCIIIndex); // StringBuilder
                // If current char is lower case letter:
            } else if (currentASCIIIndex >= 97 && currentASCIIIndex <= 122) {
                if (currentASCIIIndex + cipher <= 'z') {
                    newASCIIIndex += cipher;
                    System.out.println("NewASCIIIndex: " + newASCIIIndex);
                } else if (currentASCIIIndex + cipher > 'z') {
                    newASCIIIndex = newASCIIIndex - 26 + cipher;
                    System.out.println("NewASCIIIndex: " + newASCIIIndex);
                }

                encryptedString += Character.toString(newASCIIIndex);
            } else {
                // If current character is not a letter, do not encrypt, just add it to encryptedString:
                encryptedString += string.charAt(i);
            }
        }

        return encryptedString;
    }

    static String convertWithNegativeCipher(String string, int cipher) {
        String encryptedString = "";
        for (int i = 0; i < string.length(); i++) {
            int remainingChars = 0;
            int newASCIIIndex = 0;
            int currentASCIIIndex = string.charAt(i);
            if (currentASCIIIndex >= 65 && currentASCIIIndex <= 90) {
                remainingChars = currentASCIIIndex - 65;
                // turn cipher to positive number
                if (remainingChars < Math.abs(cipher)) {
                    // turn cipher to positive number
                    newASCIIIndex = 90 - (Math.abs(cipher) - remainingChars - 1);
                } else {
                    newASCIIIndex = currentASCIIIndex + cipher;
                }

                encryptedString += Character.toString(newASCIIIndex);
            } else if (currentASCIIIndex >= 97 && currentASCIIIndex <= 122) {
                remainingChars = currentASCIIIndex - 97;
                if (remainingChars < Math.abs(cipher)) {
                    newASCIIIndex = 122 - (Math.abs(cipher) - remainingChars - 1);
                } else {
                    newASCIIIndex = currentASCIIIndex + cipher;
                }

                encryptedString += Character.toString(newASCIIIndex);
            } else {
                encryptedString += string.charAt(i);
            }
        }

        return encryptedString;
    }
}

