/*

- [ ] Time complexity
- [ ] Space complexity

Part 1
Given a string, return the number of distinct characters that appear in that string.

For example:
distinctCharacterCount("aaaabbbbbaabbab") should return 2 (a, b).
distinctCharacterCount("abc abc abc") should return 4 (a, b, c, space)

Part 2
Given 2 strings, return the number of distinct characters that appear in both strings

For example:
sharedCharacterCount("goo", "goodbye") should return 2 (g, o)


Notes 
You should solve both of these problems using only 'FoundationScript' (i.e. no built in string or array methods)
*/

/*
=================
PART 1 - STRATEGY

distinctChars = {}

for each character in string:
  If distinctChars[character] === undefined:
    distinctChars[character]

Count object keys and return // Iterate over object


------------

If string === ""  return 0

distinctChars = []

for each character in string:
  If character is not in distinctChars: // iterate over distinctChars
    Add it

return distinctChars.length

=========================
// ** PART 1 **
*/
// VERSION 1 - better time complexity than version 2

// Summary: Count the first occurrence of each character

function distinctCharacterCount(string) {
  if (string === "") return 0; // if-statement: 1 instruction; I can only count 1 return statement in the function, so I count the one for the worst-case scenario (the last one)

  const distinctChars = {}; // 1 instruction
  let charCount = 0; // 1 instruction
  
  for (let i = 0; i < string.length; i++) { // string.length times
    let character = string[i]; // 1 instruction
    // If character is not in distinctChars, add it.
    if (distinctChars[character] === undefined) { // 1 instruction
      distinctChars[character] = character; // 1 instruction
      // It does not matter which value is assigned to distinctChars[character], as all strings will be forced to a truthy value in the above if condition. 
      charCount++; // 1 instruction
    }
  }

  return charCount;// 1 instruction
}

/* Time complexity:
Counting the number of instructions:
3 + string.length * 4 + 1
= 4 + 4 * n (string.length)
=> drop lower term and coefficient
=> time complexity is O(n) (n being string.length)
--------------------------

Space Complexity:
Counting memory units:
1 for the function call
1 for string (a memory address)
1 for distinctChars
1 for charCount
1 for i
1 for character
string.length for each property added to distinctChars (in worst-case scenario)
1 for char
= 7 + n (string.length)
=> drop lower term
=> Space complexity: O(n)
--------------------------

*/
// ===================================
// VERSION 2 (worse time complexity than version 1)

// function distinctCharacterCountV2(string) {
//   if (string === "") return 0;  // 1

//   const distinctChars = []; //1
//   let foundChar = false; //1

//   for (let i = 0; i < string.length; i++) { // string.length times
//     let character = string[i]; // 1

//     // Check if character is in `distinctChars`
//     for (let j = 0; j < distinctChars.length; j++) { // distinctChar.length times
//       if (distinctChars[j] === character) { // 1
//         foundChar = true; // 1
//         break; // I don't count this, as I am looking at the worst case scenario, where the last character in distinctChars is equal to character.
//       }
//     }

//     if (foundChar === false) { // 1
//       distinctChars[distinctChars.length] = character; // 1
//     } else { // not counting this, as it is the same amount of instructions as the first condition, and will not run if the first one runs
//       foundChar = false;
//     }
//   }

//   return distinctChars.length; // 1
// }

/*
Time complexity: 
1 + 1 + 1 + n * (1 + (n * (1 + 1) + 1 + 1) + 1
= 4 + n * (3 + 2n)
= 4 + 3n + 2n^2
=> drop all but biggest term
=> Time complexity: O(n^2)
--------------------------

Space complexity:
Counting memory units:
1 for string
1 for distinctChars
1 for foundChar
1 for 1
string.length, 
  - for each string created
  - for each j
  - for each property added to distinctChars

4 + n * 3
=> Space complexity: O(n)
*/


/*
TRACE VERSION 2

"aaaabbbbbaabbab"
               *
distinctChars = ["a", "b" ]
                       *
foundChar = false
character = b

returns 2

----

string = "abc abc"
              *
distinctChars = ["a", "b", "c", " "]
                            *
foundChar = false
character = " "

return 4
*/

/*
Part 2
Given 2 strings, return the number of distinct characters that appear in both strings

For example:
sharedCharacterCount("goo", "goodbye") should return 2 (g, o)



*/

function sharedCharacterCount(string1, string2) {
  let distinctCharsInBothStrings = 0;
  const distinctChars = {};
  
  // Find the distinct characters in string1 first
  for (let i = 0; i < string1.length; i++) {
    let char = string1[i];
    if (distinctChars[char] === undefined) {
      distinctChars[char] = true;
    }
  }

  // Check if each distinct character found in string1 is found in string2, as well. If so, mark each as found.
  for (let i = 0; i < string2.length; i++) {
    let char = string2[i];
    if (distinctChars[char] === true && distinctChars[char] !== "found in both strings") {
      distinctChars[char] = "found in both strings";
      distinctCharsInBothStrings++;
    }
  }

  return distinctCharsInBothStrings;
}
