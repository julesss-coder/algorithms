/*
Problem description

Write a function that takes a string and determines whether it is a 'valid' string of 'words'.

To be valid, then string must meet these requirements:
1. The string can only contain letters and spaces. 
2. 2 words can be separated by no more than one space.
3. Each space must be in between 2 words.
4. Only the first letter in a word can be uppercase.

To solve this problem, you can pretend that you have two functions: `isLetter` and `isUppercaseLetter`. Both will return a Boolean value. 

For example: 
"Abc abc" should produce true
"aBc abc" should produce false
"Abc    abc" should produce false

As always, you should solve these without using any string or array methods.

=====================

Notes: 

Only the first letter of a word CAN be uppercase.
=> Does not mean that the first letter of each word HAS to be uppercase. See first example: "Abc abc" should produce true. In the second 'word', the first letter is lowercase, but it still produces true.
*/

// Strategy

// Summary: Put each character in either one of the categories 'letter' and 'non-letter'. Proceed to check the conditions regarding spaces and uppercase letters.

function isValidWordString(string) {
  for (let i = 0; i < string.length; i++) {
    let char = string[i];
    let leftChar = string[i - 1];
    let rightChar = string[i + 1];

    if (isLetter(char) === false) {
      if (char === " ") {
        // If this space is not between two letters (this includes a space as the first and last character of a string)
        if ((isLetter(leftChar) && isLetter(rightChar)) === false) {
          return false; 
        }
      } else {
        // It is not a letter but also not a space
        return false;
      }
    } else if (isLetter(char) === true) {
      // If it is uppercase, check if it is the first letter of a word
      if (isUppercaseLetter(char) && isLetter(leftChar)) {
          return false;
      }
    }
  }

  return true;
}
