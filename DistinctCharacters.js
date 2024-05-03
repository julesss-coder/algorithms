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
*/

function distinctCharacterCount(string) {
  if (string === "") return 0;

  const distinctChars = {};
  let charCount = 0;

  for (let i = 0; i < string.length; i++) {
    let character = string[i];
    if (!distinctChars[character]) { // undefined or null?
      distinctChars[character] = character; // Don't assign it a falsy value, otherwise the check above will always return false 
    }
  }

  for (let string in distinctChars) {
    charCount++;
  }

  return charCount;
}
// ===================================

function distinctCharacterCountV2(string) {
  if (string === "") return 0;

  const distinctChars = [];
  let foundChar = false;

  for (let i = 0; i < string.length; i++) {
    let character = string[i];
    
    // Check if character is in `distinctChars`
    for (let j = 0; j < distinctChars.length; j++) {
      if (distinctChars[j] === character) {
        foundChar = true;
        break;
      }
    } 

    if (foundChar === false) {
      distinctChars[distinctChars.length] = character;
    } else {
      foundChar = false;
    }
  }

  return distinctChars.length;
}


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
