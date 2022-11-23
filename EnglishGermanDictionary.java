/*

=========CONTINUE WITH ADDWORDPAIR()! ================
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

BUGS
- [ ] Get out of loop adding German word
- [ ] Ask for German/English within user choices 1, 2, or 3
TESTS

===============

Create two dictionaries:
    - germanEnglish
    - englishGerman

    // Let user choose between search, add, remove

    // Search function
    get user input
    if user input is German:
        search in germanEnglish
        display corresponding word
    else if user input is English:
        search in englishGerman
        display corresponding word

    // Adding entries
    For each user entry:
        add pair to both dictionaries, in correct order:
        if first word in pair is German:
            add to germanEnglish
        else if first word in pair is English:
            add to englishGerman

    // Removing entries
    If word is English:
        Search in englishGerman
        Get german word
        Remove from germanEnglish
        Remove from englishGerman, using key german word


 */

package com.company;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.*;

public class Main {
    // plavce Scanner here
    public static void main(String[] args) {
        // Variable assignments
        HashMap<String, String> germanEnglish = new HashMap<>();
        HashMap<String, String> englishGerman = new HashMap<>();
        englishGerman.put("cat", "Katze");
        germanEnglish.put("Katze", "cat");
        germanEnglish.put("Hund", "dog");
        englishGerman.put("dog", "Hund");
        String germanWord = "";
        String englishWord = "";
        Scanner scanner = new Scanner(System.in);

        // Ask user input: search / add / remove / quit
        // =========== WHAT HAPPENS WHEN WE EXIT? ============
        System.out.println("Press\n1 to search the dictionary,\n2 to add a word pair,\n3 to remove a word pair,\nQ to exit.");
        String userChoice = scanner.nextLine();

        while (!userChoice.equals("Q")) {
            // search
            if (userChoice.equals("1")) {
                while (!userChoice.equals("Q")) {
                    System.out.println("To search for word, press \n1 to search for a German word or\n2 to search for an English word.\nPress Q to quit.");
                    userChoice = scanner.nextLine();
                    // search German word
                    if (userChoice.equals("1")) {
                        searchWord(germanEnglish);
                    // search English word
                    } else if (userChoice.equals("2")) {
                        searchWord(englishGerman);
                    }

                    System.out.println("To search for word, press \n1 to search for a German word or\n2 to search for an English word.\nPress Q to quit.");
                    userChoice = scanner.nextLine();
                }

            // add
            } else if (userChoice.equals("2")) {
                System.out.println("To add a word pair, press \n1 for German - English or\n2 for English - German.\nPress Q to quit.");
                userChoice = scanner.nextLine();

                if (userChoice.equals("1")) {
                    // add German word
                    addWordPair(germanEnglish);
                } else if (userChoice.equals("2")) {
                    // add English word
                    addWordPair(englishGerman);
                } else {
                    System.out.println("Invalid user input.");
                }

                while (!userChoice.equals("Q")) {
                    addWordPair(germanEnglish, englishGerman, germanWord, englishWord, userChoice);
                }
            // remove
            } else if (userChoice.equals("3")) {
                System.out.println("Removing a word:\nPress 1 to enter the German half of the word pair.\nPress 2 to enter the English half of the word pair.\nPress Q to quit.");
                System.out.println("English - German dictionary: " + Arrays.asList(englishGerman));
                System.out.println("German - English dictionary: " + Arrays.asList(germanEnglish));
                userChoice = scanner.nextLine();

                while (!userChoice.equals("Q")) {
                    removeWordPair(germanEnglish, englishGerman, germanWord, englishWord, userChoice);
                }
            } else {
                System.out.println("Invalid user input.");
            }
        }

        System.out.println("English - German dictionary: " + Arrays.asList(englishGerman));
        System.out.println("German - English dictionary: " + Arrays.asList(germanEnglish));1
    }

    // ======================= CONTINUE HERE =============
    // is the parameter String `userChoice` a declaration of `userChoice`? Or do I have to redeclare it inside `addWordPair`?
    private static void addWordPair(HashMap<String, String> dictionary) {
        // Better to create new scanner for method, or pass in scanner from main()?
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word you would like to add.");
        String word = scanner.nextLine();
        dictionary.putIfAbsent(word, /* add English word, too! */)
        if (userChoice.equals("1")) {
            germanWord = scanner.nextLine();
            System.out.println("Now enter its English translation.");
            englishWord = scanner.nextLine();
            englishGerman.putIfAbsent(englishWord, germanWord);
            germanEnglish.putIfAbsent(germanWord, englishWord);
        } else if (userChoice.equals("2")) {
            System.out.println("Enter the English word you would like to add.");
            englishWord = scanner.nextLine();
            System.out.println("Now enter its German translation.");
            germanWord = scanner.nextLine();
            englishGerman.putIfAbsent(englishWord, germanWord);
            germanEnglish.putIfAbsent(germanWord, englishWord);
        } else {
            System.out.println("Invalid user input.");
        }

        // Add new word pair
        System.out.println("English - German dictionary: " + Arrays.asList(englishGerman));
        System.out.println("German - English dictionary: " + Arrays.asList(germanEnglish));

        System.out.println("To add a word pair, press \n1 for German - English or\n2 for English - German.\nPress Q to quit.");
        userChoice = scanner.nextLine();
        return userChoice;
    }

    private static String removeWordPair(HashMap<String, String> germanEnglish, HashMap<String, String> englishGerman, String germanWord, String englishWord, String userChoice) {
        Scanner scanner = new Scanner(System.in);
        if (userChoice.equals("1")) {
            System.out.println("Enter the German word you would like to remove.");
            germanWord = scanner.nextLine();
            englishWord = germanEnglish.get(germanWord);

            // Does remove() remove both key and value?
            germanEnglish.remove(germanWord);
            englishGerman.remove(englishWord);
        } else if (userChoice.equals("2")) {
            System.out.println("Enter the English word you would like to remove.");
            englishWord = scanner.nextLine();
            germanWord = englishGerman.get(englishWord);

            englishGerman.remove(englishWord);
            germanEnglish.remove(germanWord);
        } else {
            System.out.println("Invalid user input.");
        }

        System.out.println("Word pair successfully removed.");
        System.out.println("English - German dictionary: " + Arrays.asList(englishGerman));
        System.out.println("German - English dictionary: " + Arrays.asList(germanEnglish));

        System.out.println("Removing a word:\nPress 1 to enter the German half of the word pair.\nPress 2 to enter the English half of the word pair.\nPress Q to quit.");
        userChoice = scanner.nextLine();

        System.out.println("English - German dictionary: " + Arrays.asList(englishGerman));
        System.out.println("German - English dictionary: " + Arrays.asList(germanEnglish));
        return userChoice;
    }

    private static void searchWord(HashMap<String, String> dictionary) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search word:");
        String word = scanner.nextLine();
        System.out.println(word + " - " + dictionary.get(word));
    }

}

// replace englishWord, germanWord with 1 var
