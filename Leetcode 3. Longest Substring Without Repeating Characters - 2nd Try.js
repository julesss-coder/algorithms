// 3. Longest Substring Without Repeating Characters
// Medium

// 27530

// 1183

// Add to List

// Share
// Given a string s, find the length of the longest substring without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

/* 

==========

OBSERVATIONS

Assumption that proved to be wrong:
In example 3, the solution is 'wke'. It could just as well be 'kew'. => Once you find the longest string, you don't cut off the first letter and continue searching for a longer string from the first letter onward. 
- Assumption: They didn't find 'kew'.
- BUT: They could have found it, but not set longest to it, as they already had a longest string of length 3.
- Assumption: They did not check the string starting from `k`:
pww|kew
   *
- BUT why would they not check it?
Imagine if the input was this: 
s = pwwke|wx
       *
longest = wke
They would start a new search AFTER the longest string found so far. BUT the longest substring could be partly contained inside `longest`, plus consist of at least the next letter. 

======*/


/* 
STRATEGY 1

longest = ''
currentLongest = ''

if s.length === 0 || s.length === 1
  return s.length

For each character in string:
  If character does not occur in currentLongest:
    currentLongest += character
    
    If currentLongest > longest:
      longest = currentLongest
  Else if character does occur in currentLongest:
    currentLongest = ''
    currentLongest += character
  
Return longest.length

*/

// IMPLEMENTATION STRATEGY 1  

var lengthOfLongestSubstring = function(s) {
  // longest = ''
  let longest = '';
  // currentLongest = ''
  let currentLongest = '';

  // if s.length === 0 || s.length === 1
  if (s.length === 0 || s.length === 1) {
    return s.length;
  }
  
  // For each character in string:
  for (let i = 0; i < s.length; i++) {
    //   If character does not occur in currentLongest:
    if (currentLongest.includes(s[i]) === false) {
      currentLongest += s[i];
      if (currentLongest.length > longest.length) {
        longest = currentLongest;
      }
    //   Else if character does occur in currentLongest:
    } else if (currentLongest.includes(s[i])) { 
      currentLongest = '';
      currentLongest += s[i];
    }
  }

  return longest.length;   
};

// TRACE IMPLEMENTATION STRATEGY 1 

/* 
s = 'ksdfhfixyztf' // should be fixyzt
                *

longest = fixyzt
currentLongest = f
returns 6

===

s = pwwkew
         *
longest = wke
currentLongest = w

return 3

*/

// STRATEGY 2

// if string length is 0 or 1:
//   return string length

// make a copy of string

// longest = ''
// currentLongest = ''

// For each character in stringCopy:
//   If character does not occur in currentLongest:
//     currentLongest += character

//     If currentLongest > longest:
//     longest = currentLongest
//   Else if character occurs in currentLongest:
//     If character !== left character:
//       Find first occurrence of current character in string
//       Cut off string from 0 to (including) first occurrence of current character
//     Else if character === left character:
//       Cut off substring `currentLongest` from string (i.e. cut off substring with length of currentLongest from beginning of string)
      
//     // start a new search at current letter:
//     currentLongest = ''
//     i = 0
//     currentLongest += character

// Return longest.length

/* 

// ===== TRACE STRATEGY 2 ======

s = 'ksdfhfixyztff' 
copy:
s = 'f' 
     *

longest = hfixyzt
current = f
returns 7


*/

/* 

IMPLEMENTATION STRATEGY 2
*/
var lengthOfLongestSubstring = function(s) {
  // if string length is 0 or 1:
  if (s.length === 0 || s.length === 1) {
    return s.length;
  }
  
  // make a copy of string
  let sCopy = s.slice();
  
  let longest = '';
  let currentLongest = '';
  
  // For each character in stringCopy:
  for (let i = 0; i < sCopy.length; i++) {
    //   If character does not occur in currentLongest:
    if (currentLongest.includes(sCopy[i]) === false) {
      currentLongest += sCopy[i];
  
      if (currentLongest.length > longest.length) {
        longest = currentLongest;
      }
    } else {
      if (sCopy[i] !== sCopy[i - 1]) {
        // Find first occurrence of current character in string
        let firstIndex = sCopy.indexOf(sCopy[i]);
        // Cut off string from 0 to (including) first occurrence of current character
        sCopy = sCopy.substring(firstIndex);
      } else if (sCopy[i] === sCopy[i - 1]) {
        // Cut off substring `currentLongest` from string (i.e. cut off substring with length of currentLongest from beginning of string)
        sCopy = sCopy.substring(currentLongest.length);
      }
  
      // start a new search at current letter:
      currentLongest = '';
      i = 0;
      currentLongest += sCopy[i];
    }
  }

  return longest.length;
}

// ===============

/* 

STRATEGY 3 - BRUTE FORCE (LEET CODE APPROACH 1  )

// Input: s = "pwwkew"
i               *
j               *

longest = ''
substrings = []

Get all substrings:
  For each char i in string:  
    For each char j in string, where j = i:
      Get substring from i to j (inclusive)
      Store substring in substrings

For each substring in substrings:
  // call allUnique(substring):*
  If it has no repeating characters:
    If it is longer than longest:
      longest = current substring

return substring.length

----------
"pwwkew"
 *
* Check if a substring has no repeating characters
function allUnique(substring):
  if substring.length is 0 or 1:
    if substring > longest:
      longest = substring

    return true

  charSet = new Set // or Map? Set, because Set only stores keys, no values, and we only have keys, no values

  For each char in substring:
    If char is not in charSet:
      Add it to charSet
    // If there are repeated characters in substring
    Else if char is in charSet:
      Empty charSet // Set.prototype.clear()
      Return false

  Return true

=======

TRACE STRATEGY 3

// Input: s = "pwwkew"
i                 *
j                 *

longest = ''
substrings = 
p
pw
pww
pwwk
*
pwwke
pwwkew
w
ww
wwk
wwke
wwkew
w
wk
wke
*
wkew
k
ke
kew
e
ew
w

charSet = {
  w
  k
  e

}



*/

// IMPLEMENTATION STRATEGY 3
// When I hit `run code`, it is run with 'abcabcbb', and the result is 'Accepted: Runtime: 87 ms'
// When I hit 'Submit', I get a runtime error. Code takes too long with extremely long input.



var lengthOfLongestSubstring = function(s) {
  let longest = '';
  let substrings = [];

  // Get all substrings:
  //   For each char i in string:  
  for (let i = 0; i < s.length; i++) {
    for (let j = i; j < s.length; j++) {
      let substring = s.substring(i, j + 1);
      substrings.push(substring);
    }
  }
  //     For each char j in string, where j = i:
  //       Get substring from i to j (inclusive)
  //       Store substring in substrings

  // For each substring in substrings:
  substrings.forEach(substring => {
    // If susbtring has only unique characters:
    if (allUnique(substring)) {
      // set longest to the longest substring
      if (substring.length > longest.length) {
        longest = substring; // Actually, we only need the length and not the substring itself
      }
    }
  });

  // console.log(longest);
  return longest.length;
}

function allUnique(substring) {
  if (substring.length === 0 || substring.length === 1) {
    return true;
  }

  // Does it matter that I create a new Set for each substring? Should I reuse the same one instead?
  let charSet = new Set();

  for (let i = 0; i < substring.length; i++) {
    if (charSet.has(substring[i]) ===  false) {
      charSet.add(substring[i]);
    } else {
      return false;
    }
  }

  return true;
}





/* 

TRACE IMPLEMENTATION STRATEGY 3

s = "abcabcbb"
i    *
j     *

let longest = '';
let substrings = [];
a
ab
 *
abc
*
abca
abcab
abcabcb
abcabcbb
b
bc
bca
bcab
bcabcb
bcabcbb

*/


// ==================

/* 

STRATEGY 4 (LEETCODE APPROACH 2 - SLIDING WINDOW)
    012345678
s = pwwkewafg
i   *
j   *

longest = 0
i = 0

map = {}

for each char in string:
  if char is in map, within current window (i <= char <= j):
    // contract the window on the left to start one position after the FIRST occurrence of the duplicate char
    i = map[char] // index of first occurrence of current char
    // Since we moved the window along, now update the duplicate letter in map to its current occurrence
    map[char] = j
  else if char is not in map:
    add key-value pair char-index to map

    // compare length of current substring to longest
    if (j - i) + 1 > longest:
      longest = (j - 1) + 1

return longest

*/

// IMPLEMENTATION STRATEGY 4

var lengthOfLongestSubstring = function(s) {
  let longest = 0;
  let i = 0;
  
  let map = {};
  
  for (let j = 0; j < s.length; j++) {
    //   if char is in map, within current window (i <= char <= j):
    if (map[s[j]] !== undefined && map[s[j]] >= i) {
      // contract the window on the left to start one position AFTER the FIRST occurrence of the duplicate char
      i = map[s[j]] + 1; // index of first occurrence of current char
      // Since we moved the window along, now update the duplicate letter in map to its current occurrence
      map[s[j]] = j;
      //   else if char is not in map, or outside of current window:
    } else if (map[s[j]] === undefined || map[s[j]] < i) {
      //  add key-value pair char-index to map
      map[s[j]] = j;
      // compare length of current substring to longest
      longest = Math.max(longest, ((j - i) + 1));
    }
  }
  
  return longest;
}


