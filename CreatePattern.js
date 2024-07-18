/*

Problem description:

Write a function that exhibits this behaviour:
 f("0123") -> "0010120123"
 f("abc") -> "aababc"

===========

Strategy 1
-----------

Summary: For each character in input, add all characters up to and including the current one, to the output string.


time complexity: (O(n^2)), where n = i
space complexity: O(n), where n = i 
*/

function createPattern(input) {
  if (input.length === 0) {
    return "";
  }

  let output = "";

  for (let i = 0; i < input.length; i++) {
    let j = 0;
    while (j <= i) {
      output += input[j];
      j++;
    }
  }

  return output;
}


/*

===========
Strategy 2
----------

Outline: 

output = ""
currentString = input

input.length times:
  output = currentString + output
  currentString = currentString - last char

return output

*/

// Summary: Add input string to start of output string. Remove last element of input string. Repeat these two steps until input string is empty. 

function createPattern2(input) {
  if (input.length === 0) return "";

  let output = "";
  let currentString = input;

  // input.length times:
  for (let i = 0; i < input.length; i++) {
    output = currentString + output;
    currentString = currentString.slice(0, currentString.length - 1);
  }

  return output;
}

// time complexity: O(n^2)
// space complexity: O(n^2)

// If array and string methods are not allowed, loop through input initially and turn into array. Create currentStringArray. Return output. 


