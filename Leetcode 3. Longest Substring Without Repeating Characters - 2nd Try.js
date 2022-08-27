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


// STRATEGY 1 - BRUTE FORCE (LEET CODE APPROACH 1  )

// Input: s = "pwwkew"
// i               *
// j               *

// longest = ''
// substrings = []

// Get all substrings:
//   For each char i in string:  
//     For each char j in string, where j = i:
//       Get substring from i to j (inclusive)
//       Store substring in substrings

// For each substring in substrings:
//   // call allUnique(substring):*
//   If it has no repeating characters:
//     If it is longer than longest:
//       longest = current substring

// return substring.length



// * Check if a substring has no repeating characters
// function allUnique(substring):
//   if substring.length is 0 or 1:
//     if substring > longest:
//       longest = substring

//     return true

//   charSet = new Set // or Map? Set, because Set only stores keys, no values, and we only have keys, no values

//   For each char in substring:
//     If char is not in charSet:
//       Add it to charSet
//     // If there are repeated characters in substring
//     Else if char is in charSet:
//       Empty charSet // Set.prototype.clear()
//       Return false

//   Return true

// =======

// TRACE STRATEGY 1

// Input: s = "pwwkew"
// i                 *
// j                 *

// longest = ''
// substrings = 
// p
// pw
// pww
// pwwk
// *
// pwwke
// pwwkew
// w
// ww
// wwk
// wwke
// wwkew
// w
// wk
// wke
// *
// wkew
// k
// ke
// kew
// e
// ew
// w

// charSet = {
//   w
//   k
//   e

// }



// IMPLEMENTATION STRATEGY 1

// When I hit `run code`, it is run with 'abcabcbb', and the result is 'Accepted: Runtime: 87 ms'
// When I hit 'Submit', I get a runtime error. Code takes too long with extremely long input.

var lengthOfLongestSubstring = function(s) {
  let longest = '';
  let substrings = [];

  // Get all substrings:
  for (let i = 0; i < s.length; i++) {
    for (let j = i; j < s.length; j++) {
      let substring = s.substring(i, j + 1);
      substrings.push(substring);
    }
  }

  substrings.forEach(substring => {
    if (allUnique(substring)) {
      if (substring.length > longest.length) {
        longest = substring; // Actually, we only need the length and not the substring itself
      }
    }
  });

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
STRATEGY 2 - SLIDING WINDOW APPROACH (LEETCODE APPROACH 2)


currentLongest = 0
longest = 
map = {}
j = 0 // j = window start

for each char in string:
  if char not in map: 
    add char and char index to map
    currentLongest++
  else if char is in map:
    if char index in map is within window (>= i, <= j):
      // contract window from the left, until after index of duplicate char in map
      j = (index of current char in map) + 1
    else if char index in map is outside window:
      currentLongest++
  
  update index of current char in map
  if currentLongest > longest:
    longest = currentLongest
*/

// IMPLEMENTATION STRATEGY 2
var lengthOfLongestSubstring = function(s) {
  let currentLongest = 0;
  let longest = 0;
  let map = {};
  let j = 0; // window begins at j, ends at i

  for (let i = 0; i < s.length; i++) {
    if (map[s[i]] === undefined) {
      currentLongest++;
    } else {
      // if current char is within window between j and i:
      if (map[s[i]] >= j && map[s[i]] <= i) {
        // contract window on left side until after previous occurence of duplicate character
        j = map[s[i]] + 1;
        currentLongest = i - j + 1;
      } else {
        currentLongest++;
      }
    }

    map[s[i]] = i;
    longest = Math.max(currentLongest, longest);
  }

  return longest;
};

// Best result for several submissions of same code on LeetCode:
// 987 / 987 test cases passed.
// Status: Accepted
// Runtime: 112 ms
// Memory Usage: 48.5 MB
