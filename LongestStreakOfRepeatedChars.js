/*

charMap = {}
currentLongestStreak = 0

For each char in string:
  If char not in charMap && char === left char:
    charMap[char] = 2
  Else if char in charMap && char === leftChar:
    charMap[char]++
  // Same letter as before, but a new, possibly longer streak is found:
  Else if char in charMap && char !== leftChar:
    currentLongestStreak = charMap[char]
    delete charMap[char]

  Get largest number in charMap
  if largest number in charMap > currentLongestStreak:
    return currentLongestStreak
  else
    return largest number in charMap

*/

// Edge case: hellooolll

function longestStreak(string) {
  let charMap = {};
  let currentLongestStreak = 0;

  for (let i = 0; i < string.length; i++) {
    if (charMap[string[i]] === undefined && string[i] !== string[i - 1]) {

    }
  }
}