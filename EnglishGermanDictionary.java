/*
Aufgabe: Wörterbuch
=====================================
ADD:
- [ ] search function
- [ ] create two dictionaries: English-German, German-English to make removing words faster
    - [ ] Remove word pair from both dictionaries

===================================
AUFGABE 
Erstelle ein Programm welches ein Wörterbuch zum Übersetzen von Wörtern zwischen Englisch und Deutsch implementiert (bi-direktional).
Es soll folgende Funktionalitäten umfassen:
- [ ] Hinzufügen eines neuen Wort-Paars (Englisch und Deutsch)
- [ ] Entfernen eines Wort-Paars aus dem Wörterbuch
Um diese Aufgabe zu lösen ist das Map Interface gut geeignet.
- [ ] add option to quit removing word pairs
TESTS

 */

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("cat", "Katze");
        dictionary.put("dog", "Hund");
        String germanWord = "";
        String englishWord = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("To add a word pair, press \n1 for German - English or\n2 for English - German.\nPress Q to quit.");
        String userChoice = scanner.nextLine();

        // Let user add word pairs
        while (!userChoice.equals("Q")) {
            if (userChoice.equals("1")) {
                System.out.println("Enter the German word you would like to add.");
                germanWord = scanner.nextLine();
                System.out.println("Now enter its English translation.");
                englishWord = scanner.nextLine();
                dictionary.putIfAbsent(englishWord, germanWord);
            } else if (userChoice.equals("2")) {
                System.out.println("Enter the English word you would like to add.");
                englishWord = scanner.nextLine();
                System.out.println("Now enter its German translation.");
                germanWord = scanner.nextLine();
                dictionary.putIfAbsent(englishWord, germanWord);
            } else {
                System.out.println("Invalid user input.");
            }

            // Add new word pair
            System.out.println("Dictionary: " + Arrays.asList(dictionary));

            System.out.println("To add a word pair, press \n1 for German - English or\n2 for English - German.\nPress Q to quit.");
            userChoice = scanner.nextLine();
        }

        // Let user remove word pairs
        System.out.println("Removing a word:\nPress 1 to enter the German half of the word pair.\nPress 2 to enter the English half of the word pair.\nPress Q to quit.");
        userChoice = scanner.nextLine();
        while (!userChoice.equals("Q")) {
            if (userChoice.equals("1")) {
                System.out.println("Enter the German word you would like to remove.");
                germanWord = scanner.nextLine();
                Set entrySet = dictionary.entrySet();
                for (Object entry : entrySet) {
                    ArrayList<String> wordPair = new ArrayList<>(Arrays.asList(entry.toString().split("=")));
                    if (wordPair.get(1).equals(germanWord)) {
                        englishWord = wordPair.get(0);
                    }
                }
            } else if (userChoice.equals("2")) {
                System.out.println("Enter the English word you would like to remove.");
                englishWord = scanner.nextLine();
            } else {
                System.out.println("Invalid user input.");
            }

            // Removes the word if present. If word does not exist, nothing is removed.
            dictionary.remove(englishWord);
            System.out.println("Word pair successfully removed.");
        }

        System.out.println(Arrays.asList(dictionary));
    }
}
