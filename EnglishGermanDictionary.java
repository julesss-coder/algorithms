/*

Aufgabe: Wörterbuch
===================================
Erstelle ein Programm welches ein Wörterbuch zum Übersetzen von Wörtern zwischen Englisch und Deutsch implementiert (bi-direktional).
Es soll folgende Funktionalitäten umfassen:
- [ ] Hinzufügen eines neuen Wort-Paars (Englisch und Deutsch)
- [ ] Entfernen eines Wort-Paars aus dem Wörterbuch
Um diese Aufgabe zu lösen ist das Map Interface gut geeignet.

===================================

 */
package com.company;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, String> germanEnglish = new HashMap<>();
        HashMap<String, String> englishGerman = new HashMap<>();
        englishGerman.put("cat", "Katze");
        germanEnglish.put("Katze", "cat");
        germanEnglish.put("Hund", "dog");
        englishGerman.put("dog", "Hund");

        // Ask user input: search / add / remove / quit
        System.out.println("English - German dictionary: " + List.of(englishGerman));
        System.out.println("German - English dictionary: " + List.of(germanEnglish));
        System.out.println("Press\n1 to search the dictionary,\n2 to add a word pair,\n3 to remove a word pair,\nQ to exit.");
        String userChoice = scanner.nextLine();

        while (!userChoice.equals("Q")) {
            // search
            if (userChoice.equals("1")) {
                while (!userChoice.equals("Q")) {
                    System.out.println("To search for word, press \n1 to search for a German word or\n2 to search for an English word.\nPress Q to quit.");
                    userChoice = scanner.nextLine();
                    if (userChoice.equals("1")) {
                        searchWord(germanEnglish);
                    } else if (userChoice.equals("2")) {
                        searchWord(englishGerman);
                    }
                }

            // add
            } else if (userChoice.equals("2")) {
                while(!userChoice.equals("Q")) {
                    System.out.println("To add a word pair, press \n1 for German - English or\n2 for English - German.\nPress Q to quit.");
                    userChoice = scanner.nextLine();

                    if (userChoice.equals("1")) {
                        addWordPair(englishGerman, germanEnglish, userChoice);
                    } else if (userChoice.equals("2")) {
                        addWordPair(englishGerman, germanEnglish, userChoice);
                    }
                }

            // remove
            } else if (userChoice.equals("3")) {
                while (!userChoice.equals("Q")) {
                    System.out.println("Removing a word:\nPress 1 to enter the German half of the word pair.\nPress 2 to enter the English half of the word pair.\nPress Q to quit.");
                    System.out.println("English - German dictionary: " + List.of(englishGerman));
                    System.out.println("German - English dictionary: " + List.of(germanEnglish));

                    userChoice = scanner.nextLine();
                    if (!userChoice.equals("Q")) {
                        removeWordPair(germanEnglish, englishGerman, userChoice);
                    }
                }
            } else {
                System.out.println("Invalid user input.");
            }
        }

        System.out.println("English - German dictionary: " + List.of(englishGerman));
        System.out.println("German - English dictionary: " + List.of(germanEnglish));
    }

    // ======================= CONTINUE HERE =============
    // is the parameter String `userChoice` a declaration of `userChoice`? Or do I have to redeclare it inside `addWordPair`?
    private static void addWordPair(HashMap<String, String> englishGerman, HashMap<String, String> germanEnglish, String userChoice) {
        String germanWord;
        String englishWord;

        if (userChoice.equals("1")) {
            System.out.println("Enter the German word you would like to add.");
            germanWord = scanner.nextLine();
            System.out.println("Now enter its English translation.");
            englishWord = scanner.nextLine();
            germanEnglish.putIfAbsent(germanWord, englishWord);
            englishGerman.putIfAbsent(englishWord, germanWord);
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

        System.out.println("English - German dictionary: " + List.of(englishGerman));
        System.out.println("German - English dictionary: " + List.of(germanEnglish));
    }

    private static void removeWordPair(HashMap<String, String> germanEnglish, HashMap<String, String> englishGerman, String userChoice) {
        String germanWord;
        String englishWord;
        if (userChoice.equals("1")) {
            System.out.println("Enter the German word you would like to remove.");
            germanWord = scanner.nextLine();
            if (germanEnglish.containsKey(germanWord)) {
                englishWord = germanEnglish.get(germanWord);
                germanEnglish.remove(germanWord);
                englishGerman.remove(englishWord);
                System.out.println("Word pair successfully removed.");
            } else {
                System.out.println("This word is not in the dictionary.");
            }

        } else if (userChoice.equals("2")) {
            System.out.println("Enter the English word you would like to remove.");
            englishWord = scanner.nextLine();
            if (englishGerman.containsKey(englishWord)) {
                germanWord = englishGerman.get(englishWord);
                englishGerman.remove(englishWord);
                germanEnglish.remove(germanWord);
                System.out.println("Word pair successfully removed.");
            } else {
                System.out.println("This word is not in the dictionary.");
            }
        }

        System.out.println("English - German dictionary: " + List.of(englishGerman));
        System.out.println("German - English dictionary: " + List.of(germanEnglish));
    }

    private static void searchWord(HashMap<String, String> dictionary) {
        System.out.println("Enter search word:");
        String word = scanner.nextLine();
        if (dictionary.containsKey(word)) {
            System.out.println(word + " - " + dictionary.get(word));
        } else {
            System.out.println("This word is not in the dictionary.");
        }
    }

}

