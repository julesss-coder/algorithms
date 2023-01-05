// LeetCode 392 - Is Subsequence

// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false

// ========================

var isSubsequence = function(s, t) {
  // `s` is created from `t` by deleting 0 or more characters from `t`. You cannot create a different string `s` from `t` without deleting any characters, letting `s` remain the same length
  if (s === t && s.length !== t.length) return false;
  // A longer string `s` cannot be created from `t` by deleting 0 or more characters
  if (t.length < s.length) return false;

  let i = 0;
  let j = 0;
  while (i < s.length && j < t.length) {
    if (s[i] === t[j]) {
      i++,
      j++;
    } else {
      j++;
    }
  }

  // If pointer `i` is out of bounds of `s`, all chars in `s` have been found in `t`.
  if (i === s.length) {
    return true;
  // Otherwise, not all chars from `s` were found in `t`.
  } else {
    return false;
  }
};

