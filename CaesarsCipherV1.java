import java.io.File;
import java.io.FileWriter;
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
               int remainingChars = 0;
               int newASCIIIndex = 0;
               int currentASCIIIndex = string.charAt(i);
               // If current character is upper case letter:
               if (currentASCIIIndex >= 65 && currentASCIIIndex <= 90) {
                   // Characters remaining between current char and end of letter range
                   remainingChars = 90 - currentASCIIIndex;
                   System.out.println("remaining characters: " + remainingChars);
                   // If moving `cipher` letters to the right would go beyond current letter range:
                   if (remainingChars < cipher) {
                       // Start counting again from beginning of letter range to get to encrypted character:
                       newASCIIIndex = 65 + (cipher - remainingChars - 1);
                   } else {
                       // Just add cipher to current letter index
                       newASCIIIndex = currentASCIIIndex + cipher;
                   }
                    /*StringBuilder text = new StringBuilder();
                   text.append("a");*/
                   encryptedString += Character.toString(newASCIIIndex); // StringBuilder
               // If current char is lower case letter:
               } else if (currentASCIIIndex >= 97 && currentASCIIIndex <= 122) {
                   // Get number of characters from end of letter range:
                   remainingChars = 122 - currentASCIIIndex;
                   // If we need to move further to the right than letter range:
                   if (remainingChars < cipher) {
                       // continue counting from first letter of current letter range:
                       newASCIIIndex = 97 + (cipher - remainingChars - 1);
                   } else {
                       // Just move `cipher` characters to the right from current letter:
                       newASCIIIndex = currentASCIIIndex + cipher;
                   }

                   encryptedString += Character.toString(newASCIIIndex);
               // If current character is not a letter, do not encrypt, just add it to encryptedString:
               } else {
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

// using ASCII instead of creating own chars array:
   // pros:
   // + not using up extra memory

 /* VERSION 1
        String string = "Hall%oz";
        char[] stringArray = string.toCharArray();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String encryptedString = "";
        int cipher = 3;
        int newPosition;
        // is character
        // is in ascii: compare code to asci code of leter
                // c > 'a'
        //
        // loop
        for (int i = 0; i < string.length(); i++) {
            boolean validChar = false;
            for(char c : chars) {
                if(c == string.charAt(i)) {
                    validChar = true;
                }

            }

            // if alphabetString/chars does not contain current character:
            System.out.println(Arrays.asList(chars));
            System.out.println(Arrays.asList(chars).contains(string.charAt(i)));
//            char currentCharacter = String.valueOf(String.);

            System.out.println("index of #: " + alphabetString.indexOf("#"));
            //            if current char is not in chars:
            // encryptedPW =+ currentChar
            System.out.println(chars);

//          System.out.println(chars.contains(string.charAt(i)));
            System.out.println(Arrays.asList(chars));
            System.out.println(string.charAt(i));

//            System.out.println(Arrays.asList(chars).contains(string.charAt(i)));
            // Get position of current char in string
            int currentPosition = Arrays.binarySearch(chars, stringArray[i]);
            int remainingChars = chars.length - 1 - currentPosition;
            if (remainingChars < cipher) {
                newPosition = cipher - remainingChars - 1;
            } else {
                newPosition = currentPosition + cipher;
            }

            encryptedString += chars[newPosition];
        }

        System.out.println("encrypted string " + encryptedString);
*/

 /*
    string = 'julia'
    chars = ABC...abc to array
    cipher = 3
    encryptedString = ""

    for each char in string:
        get current positions of chars in alphabet/chars
        if remaining letters < cipher:
            new position = cipher - remaining letters
        else:
            position = position + cipher

        encryptedString += chars[newPOsition]

    print encryptedString

     */



    /*
VERSION 2
    Java prints ASCII value of character automaticalluy

    string = "Hal%lO"
              *
    encryptedString = ""
    cipher = 3

    For each character in string:
        currentIndex = get ASCII index of current character
        if current character is upper case (indices 65 - 90):
            remainingCharacters = 90 - currentIndex
            if remainingCharacters < cipher:
                newIndex = 65 + (cipher - remaining - 1)
            else:
                newIndex = 65 + cipher
        else if current character is lower case (indices 97 - 122):
            remainingCharacters = 122 - currentIndex
            if remainingCharacters < cipher:
                newIndex = 97 + (cipher - remaining - 1)
            else:
                newIndex = currentIndex + cipher

        encryptedString += ASCII[newIndex]
     */