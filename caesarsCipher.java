import java.util.Arrays;

public class CeasarsCipher {
    public static void main(String[] args) {
        String string = "Julia";
        char[] stringArray = string.toCharArray();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        String encryptedString = "";
        int cipher = 3;
        int newPosition;

        for (int i = 0; i < string.length(); i++) {
            int position = Arrays.binarySearch(chars, stringArray[i]);
            int remainingChars = chars.length - 1 - position;
            if (remainingChars < cipher) {
                newPosition = cipher - remainingChars;
            } else {
                newPosition = position + cipher;
            }
            encryptedString += chars[newPosition];
        }

        System.out.println("encrypted string " + encryptedString);


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

    }
}
