/*
Given 2 strings: `string` and `ending`, return a Boolean value indicating whether `string` ends with `ending`.

For example:
endsWith("hello", "o") should return true
endsWith("hello", "oo") should return false

*/

/*

===========================

STRATEGY 1

If ending.length === 0:
  Return true

If string.length === 0 || ending.length > string.length
  Return false

x = ending.length

For each character in `string`, starting from the last, to position `string.length - x` (inclusive):
  If character === character at same position in `ending`, counting from the last character of `ending`:
    continue
  Else:
    Return false

Return true

===========================

TRACE

Example 1:
string = hello, ending = oo

x = 2
string.length - x = 3
---x
hello
   *
oo
*

EDGE CASES
string = ""
ending = ""
ending.length > string.length


===========================
TODOS
- [x] Code solution
- [ ] Add time complexity
- [ ] Add space complexity
*/


// Version 1: Iterate backwards through `string` and `ending`, comparing the character at the current position
function endsWith(string, ending) {
  if (ending.length === 0) { // 1 instruction
    return true; // this will run only in the best-case scenario. We determine time complexity for the worst-case scenario, so this instruction is not counted
  }

  if (ending.length > string.length) { // 1 instruction
    return false; // not counted, see not above
  }

  // `i` is the number of steps from the end of both `string` and `ending`
  for (let i = 0; i < ending.length ; i++) { // runs ending.length - 1 times 
    if (string[string.length - 1 - i] !== ending[ending.length - 1 - i]) { // 1 instruction
      return false;
    }
  }
  
  return true; // 1 instruction
}

// Time complexity: 
// 1 + 1 + (ending.length - 1) * 1 + 1 
// = 3 + (n - 1) // throw away lower term
// = (n - 1) / throw away lower term
// = O(n), where n = ending.length

// ===============================================
// Version 2: Track current index in `string` and `ending` separately and compare their values

function endsWith2(string, ending) {
  if (ending.length === 0) { // 1 instruction
    return true;
  }

  if (ending.length > string.length) { // 1 instruction
    return false;
  }

  let stringIndex = string.length - 1; // 1 instruction

  for (let i = ending.length - 1; i >= 0; i--) { // runs ending.length times
    if (ending[i] !== string[stringIndex]) { // 1 instruction
      return false; 
    }

    stringIndex--; // 1 instruction
  }

  return true; // 1 instruction
}

/*
Time complexity:
1 + 1 + 1 + ending.length * 2 + 1
= 4 + ending.length * 2 // drop lower term
= ending.length * 2 // drop coefficient
= O(n), with n = ending.length
*/