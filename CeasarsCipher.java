   public class CeasarsCipher {
       public static void main(String[] args) {
           String string = "Kdo%oRcC"; // "Hal%lOzZ"; // "Hal%lOzZ";
           int cipher = 3;
           // to encrypt:
           // Wie rufe ich eine Funktion auf?
           // System.out.println(convert("hello", 3));
           // call convert
           // to decrypt:
           // change sign of cipher
           // call convert

       }


   public static void convert(String string, int cipher) {
       String encryptedString = "";
       if (cipher > 0) {
           for (int i = 0; i < string.length(); i++) {
               int remainingChars = 0;
               int newASCIIIndex = 0;
               int currentASCIIIndex = string.charAt(i);
               if (currentASCIIIndex >= 65 && currentASCIIIndex <= 90) {
                   remainingChars = 90 - currentASCIIIndex;
                   if (remainingChars < cipher) {
                       newASCIIIndex = 65 + (cipher - remainingChars - 1);
                   } else {
                       newASCIIIndex = currentASCIIIndex + cipher;
                   }

                   encryptedString += Character.toString(newASCIIIndex);
               } else if (currentASCIIIndex >= 97 && currentASCIIIndex <= 122) {
                   remainingChars = 122 - currentASCIIIndex;
                   if (remainingChars < cipher) {
                       newASCIIIndex = 97 + (cipher - remainingChars - 1);
                   } else {
                       newASCIIIndex = currentASCIIIndex + cipher;
                   }

                   encryptedString += Character.toString(newASCIIIndex);
               } else {
                   encryptedString += string.charAt(i);
               }
           }

           System.out.println(encryptedString);

       } else if (cipher < 0) {
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
           System.out.println(encryptedString);
       } else {
           System.out.println("No encryption: " + string);
       }
   }
    // Encrypt the password

}

    // Decrypt the encrypted string
    // change sign of cipher and run this function

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