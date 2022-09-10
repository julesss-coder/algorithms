public class Rhombus {
    /*
    ******* VERSION 1 Rhombus offset by one position *******

        lines = 4
        numberOfX = lines // unchanging
        numberOfSpaces = lines - 1 // changes
        rhombus = ''

        for each line in lines:
            rhombus += ' ' * numberOfSpaces
            rhombus += lines * 'X ' // X with space
            rhombus += \n
            numberOfSpaces--
    */
    /*
    public static void main(String[] args) {
        String rhombus = "";
        int lines = 4;
        int numberOfSpaces = lines - 1;

        for (int i = 0; i < lines; i++) {
            rhombus += " ".repeat(numberOfSpaces);
            rhombus += "X ".repeat(lines);
            rhombus += "\n";
            numberOfSpaces--;
        }

        System.out.println(rhombus);
    }
    */

    /* ***VERSION 2: Rhombus offset by two positions*******
    
    lines = 4
    numberOfX = lines // unchanging
    // numberOfSpaces = lines + 2 // changes // 0
    rhombus = ''

    for each line in lines:
        rhombus += ' ' * numberOfSpaces
        rhombus += lines * 'X ' // X with space
        rhombus += \n
        numberOfSpaces -= 2
     */
  
    public static void main(String[] args) {
        String rhombus = "";
        int lines = 4;
        int numberOfSpaces = lines + 2;

        for (int i = 0; i < lines; i++) {
            rhombus += " ".repeat(numberOfSpaces);
            rhombus += "X ".repeat(lines);
            rhombus += "\n";
            numberOfSpaces -= 2;
        }

        System.out.println(rhombus);
    }

}

/*
  Output: 
      X X X X 
    X X X X 
  X X X X 
X X X X 
 */
