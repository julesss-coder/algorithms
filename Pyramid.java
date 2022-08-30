/*
Pyramide:

Es soll eine Pyramide mit lauter großen "X" dargestellt werden.
Beginne bei der Spitze mit einem X
In der nächsten Zeile werden 2 neue X auf jeder Seite hinzugefügt.
Getrennt sind die X durch ein einzelnes Leerzeichen.
Bestimme am Anfang eine Variable z, die die Anzahl an Zeilen ausgibt (im Bild: 4). Dein Programm soll auch z.B. mit 1 Zeile oder mit 10 funktionieren (egal welchen Wert die Variable z annimmt!)

Ausgabe in der Konsole:

                X
              X X X
            X X X X X
          X X X X X X X
---
OBSERVATIONS
-

KNOBS
- Order of steps:
    a) create string first, then log it to console
    b) create each line and log it right away, until pyramid done

STRATEGY 1
Summary: Create square of 'x' and spaces, mirror it and leave out the second vertical mirror axis // Beschissene Beschreibung, muss noch überarbeitet werden

Top-down outline:

pyramid = ''
lines = z
numberOfX = 1

for each line in lines:
    add (lines - numberOfX) spaces
    add (2 * numberOfX - 1) 'x'es
    add (lines - numberOfX) spaces
    add line break
    numberOfX++

Log pyramid to console

========

Pyramid with spaces between each X

pyramid = ''
lines = 5
numberOfX = 1

for each line in lines:
    add 2 * (lines - numberOfX) spaces
    // add 'x'es:
    if numberOfX == 1:
        add 1 x
    else:
        add (2 * numberOfX) 'X ' (X with space)
        add one 'X'
    add 2 * (lines - numberOfX) spaces
    add line break
    numberOfX++

Log pyramid to console

 */

public class Pyramid {
    public static void main(String[] args) {
        String pyramid = "";
        int lines = 7;
        int numberOfX = 1; // 3

        for (int i = 0; i < lines; i++) {
            pyramid += " ".repeat(2 * (lines - numberOfX));
            if (numberOfX == 1) {
                pyramid += "X";
            } else {
                pyramid += "X ".repeat((numberOfX * 2) - 2);
                pyramid += "X";
            }
            pyramid += " ".repeat(2 * (lines - numberOfX));
            pyramid += "\n";
            numberOfX++;
        }

        System.out.println(pyramid);
    }
}

//============
/*

Variation: Upside down pyramid

**Observations:**
Lines stay the same
numberOfX changes
To change order of lines -> start with numberOfX = lines
decrement
*/

// VERSION 1: Completely symmetrical (even the spaces)
public class PyramidUpsideDown {
    public static void main(String[] args) {
        String pyramid = "";
        int lines = 4;
        int numberOfX = lines;

        for (int i = 0; i < lines; i++) {
            pyramid += " ".repeat(2 * (lines - numberOfX));
            if (numberOfX == 1) {
                pyramid += "X";
            } else {
                pyramid += "X ".repeat((numberOfX * 2) - 2);
                pyramid += "X";
            }
            pyramid += " ".repeat(2 * (lines - numberOfX));
            pyramid += "\n";
            numberOfX--;
        }

        System.out.println(pyramid);
    }
}

/*===

TRACE

lines = 3
numberOfX = 0

X.X.X.X.X\n
..X.X.X..\n
....X....\n
*/

// VERSION 2: Only necessary spaces
public class PyramidUpsideDown {
    public static void main(String[] args) {
        String pyramid = "";
        int lines = 4;
        int numberOfX = lines;

        for (int i = 0; i < lines; i++) {
            pyramid += " ".repeat(2 * (lines - numberOfX));
            pyramid += "X ".repeat((numberOfX * 2) - 1);
            pyramid += "\n";
            numberOfX--;
        }

        System.out.println(pyramid);
    }
}

/*

Output:
X X X X X X X 
  X X X X X 
    X X X 
      X 
      
 */

