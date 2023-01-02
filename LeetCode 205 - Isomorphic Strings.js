// LeetCode 205 - Isomorphic Strings
// URL: https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1
// Easy

// 5734

// 1124

// Add to List

// Share
// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

// ===================

/*


Strategy 1
--------------------------------------

Summary:

Top-down outline:

s = foo
      *
t = bar
      *

charMap = new Map

for each character in `s`:

  if character is not in map as key:
    add character as key, add character at t[i] as value to charMap
  if character is not in map as value:
    add character as value, add character at t[i] as key to charMap

  if character is key in charMap:
    if value in charMap !== t[i]:
      return false
  else if character is value in charMap:
    if key associated with that value in charMap !== t[i]:
      return false

return true


===========================
Observations:
- What data structure to use for charMap?
- Add characters as two inversed key-value pairs to charMap?
- Or add characters as one key-value pair to charMap and check both sides?
  - Which data structure is best for this?
    - for...in iterates over prototype chain, so use with Object.hasOwn()
        for (const prop in obj) {
          if (Object.hasOwn(obj, prop)) {
            console.log(`obj.${prop} = ${obj[prop]}`);
          }
        }
    - Map is for key-value pairs
      Map.prototype.get()
      Returns the value associated to the passed key, or undefined if there is none.

      Map.prototype.has()
      Returns a boolean indicating whether a value has been associated with the passed key in the Map object or not.

*/

// Implementation

var isIsomorphic = function(s, t) {
  let charMap = new Map();
  
  // a Map contains only unique values
  for (let i = 0; i < s.length; i++) {
    let sChar = s[i];
    let tChar = t[i];
    // if character is not a key OR value in charMap
    if (charMap.get(sChar) === undefined ||
    !Array.from(charMap.values()).includes(sChar)) {
      // add character as key and value
      // duplicate characters will not be added due to Map data structure
      charMap.set(sChar, tChar);
      charMap.set(tChar, sChar);
    } else if (charMap.get(sChar) !== tChar) {
      return false;
      // if character is a value in charMap:
      // What's a simpler solution to this?
    } else if (Array.from(charMap.values()).includes(sChar)) {
      let iterator = charMap.entries();
      let j = 0;
      while (j < charMap.size) {
        let currentPair = iterator.next().value;
        if (currentPair[1] === sChar && currentPair[0] !== tChar) {
          return false;
        }
        j++;
      }
    }
  }
  
  return true;
};
  
