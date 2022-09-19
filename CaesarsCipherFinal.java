import java.util.Scanner;
/* 
 * TODO:
 * Use StringBuilder instead of string += character
 * Add file and encrypt it
 */
public class CaesarsCipherFinal {
  public static void main(String[] args) {
    String string = "Hal%lOzZ"; 
    
    Scanner scanner = new Scanner(System.in); // Resource leak: 'scanner' is never closedJava(53687179 - Was bedeutet das?
    System.out.println("Choose a positive or negative integer. No 0.");
    int cipher = scanner.nextInt();
    while (cipher == 0) {
      System.out.println("Please choose a negative or positive integer, but no 0.");
      cipher = scanner.nextInt();
    }

    // Encrypt string
    System.out.println("String to encrypt: " + string + " , cipher: " + cipher);
    String encryptedString = "";
    if (cipher > 0) {
      encryptedString = convertWithPositiveCipher(string, cipher);
      System.out.println("Encrypted string: " + encryptedString);
    } else {
      encryptedString = convertWithNegativeCipher(string, cipher);
      System.out.println("Encrypted string: " + encryptedString);
    }

    // Decrypt string
    // Change algebraic sign of cipher to decrypt string
    String decryptedString = "";
    cipher *= -1;
    if (cipher > 0) {
      decryptedString = convertWithPositiveCipher(encryptedString, cipher);
      System.out.println("Decrypted string: " + decryptedString);
    } else {
      decryptedString = convertWithNegativeCipher(encryptedString, cipher);
      System.out.println("Decrypted string: " + decryptedString);
    }
  }

  static String convertWithPositiveCipher(String string, int cipher) {
    String encryptedString = "";

    for (int i = 0; i < string.length(); i++) {

      if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
        // If moving `cipher` positions to the right would be out of the alphabet range:
        if (string.charAt(i) + cipher > 'Z') {
          encryptedString += (char) (string.charAt(i) - 26 + cipher);
        } else {
          encryptedString += (char) (string.charAt(i) + cipher);
        }

      } else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
        // If moving `cipher` positions to the right would be out of the alphabet range:
        if (string.charAt(i) + cipher > 'z') {
          encryptedString += (char) (string.charAt(i) - 26 + cipher);
        } else {
          encryptedString += (char) (string.charAt(i) + cipher);
        }
      } else {
        // Else if character is not a letter:
         // Add it to encryptedString without encrypting it
        encryptedString += string.charAt(i);
      }
    }
    
    return encryptedString;
  }

  static String convertWithNegativeCipher(String string, int cipher) {
    String encryptedString = "";

    for (int i = 0; i < string.length(); i++) {

      if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
        // If moving `cipher` positions to the left would be out of the alphabet range:
        if (string.charAt(i) + cipher < 'A') {
          encryptedString += (char) (string.charAt(i) + 26 + cipher);
        } else {
          encryptedString += (char) (string.charAt(i) + cipher);
        }

      } else if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
        // If moving `cipher` positions to the left would be out of the alphabet range:
        // cipher is negative, so use addition to move to the left
        if (string.charAt(i) + cipher < 'a') {
          encryptedString += (char) (string.charAt(i) + 26 + cipher);
        } else {
          encryptedString += (char) (string.charAt(i) + cipher);
        }
      } else {
        // Else if character is not a letter:
         // Add it to encryptedString without encrypting it
        encryptedString += string.charAt(i);
      }
    }
    
    return encryptedString;
  }

}

/* 
 * Strategy 1
 * 
 * string = "Hal%lOzZ";
 *           *
 * encryptedString = ""
 * Choose cipher
 * 
 * if cipher > 0:
 *  move to the right in alphabet
 * else if cipher < 0:
 *  move to the left in alphabet
 * 
 * if cipher === 0:
 *  ask user again until cipher !== 0
 * 
 * cipher = 3
 * 
 * // Encrypt with cipher > 0
 * For each character in string:
 *  // No need to write two cases for both upper and lower case letters, 
 * // as we are calculating with the ASCII code directly
 *   if there are fewer than `cipher` characters between current char and end of alphabet:
 *     index of encrypred letter = character - 26 + cipher
 *   else if there are >= `cipher` characters left in alphabet:
 *     index of encrypted letter = character + cipher
 *   
 *   encryptedString += character
 * 
 * return encryptedString 
 * 
 * // Encrypt with cipher < 0:
 * cipher = -3
 * if there are fewer than `cipher` characters between current char and beginning of alphabet:
 *    index of encrypted letter = current char + 26 - cipher
 *  else if there are >= `cipher` characters between current char and beginning of alphabet:
 *    index of encrypted letter = current char + cipher // cipher is negative
 */

