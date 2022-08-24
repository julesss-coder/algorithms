// 20. Valid Parentheses

// Problem statement:

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

// =========================

// Knobs

// - iterate over pairs of characters, or single characters?
// - if pairs: only iterate over each part of a pair once? i.e. over each character once?
// - Use the parentheses or their Unicode numbers?
// - Are nested brackets allowed? YESSS! My initial strategy gave a wrong answer for input "{[]}"
//   - Are nested brackets allowed as part of whole string, or - if nested brackets occur - would the whole string consist of nested brackets? ie. "{[]}()" would not be possible?
// - In case of nested brackets: start iterating from the middle, or from the beginning and end?
// - direction of iteration?
// - uneven number of parentheses allowed?
// - order of brackets in map: ) : (, or ( : )
// - using Map() or object

// Edge cases: empty string, one bracket input, more opening than closing brackets (or the other way around) while length is even, odd number of brackets, nested brackets, mix of nested and paired brackets
// '', '}', '}}'


// =========================

// Observations

// There are three cases that start a pair of valid parentheses: (, [ and {. A pair that starts with closing parentheses is not valid. We have to return false for all cases that are not these three.
// Subproblems: Finding out which case we have. Then checking if the following parenthesis is the matching one.
// Parentheses come in pairs: always compare two, then the next two, etc.
// opening and closing brackets; round, square and curly brackets

// (){}[): Wenn erste und letzte Klammer ein Paar sind, und man den Rest noch nicht kennt: (....), kann es entweder paired (){}() oder nested ({[]}) sein.
// ABER wenn die erste und zweite Klammer ein Paar sind ()...), kann es nicht nested sein, denn die zweite Klammer ist zu, müsste aber offen sein, um Teil eines nested Array zu sein. ==> Erst auf paired überprüfen, denn dann kann man gleich nested ausschließen. ==> Schneller.

// Ich habe die Problembeschreibung nicht aufmerksam genug durchgelesen. Da steht, die Klammern müssen in der richtigen Ordnung geschlossen werden. D.h. verschachtelte Klammern sind erlaubt. Das heißt auch, dass eine Mischung aus einfachen und verschachtelten Klammern erlaubt ist!!! Darauf kam ich erst nach ein paar Tagen!!

// Die verschachtelten Klammern müssen nicht am Anfang und Ende beginnen. Auch so ein Fall ist möglich: ({})[]


// WAS ICH GELERNT HABE:
// Die Problemebschreibung aufmerksam lesen. Nicht davon ausgehen, dass ich das Problem verstehe!

/* Auf Basis der Problembeschreibung sind einfache und verschachtelte Klammern erlaubt: 

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.

--> Überprüfen: Wird die Klammer vom gleichen Klammertyp geschlossen?
--> Überprüfen: Steht die schließende Klammer an der richtigen Stelle?

Was für eine Klammer ist die derzeitige Klammer?
    - öffnende {, [, (
      Wenn die Klammer eine von {, [, ( ist, 
        wenn die rechte Klammer das entsprechende Gegenstück ist
      Ansonsten (wenn die rechte Klammer ein anderes Gegenstück, oder eine öffnende Klammer ist)
    - schließende }, ], )  

Was für eine Klammer muss die schließende Klammer sein?
Wo steht die schließende Klammer?

Wenn die zweite Klammer nicht das Gegenstück der ersten ist, kann sie immer noch eine verschachtelte Klammer sein.

======================================

Strategy 3:

Summary: Delete every valid pair of adjacent brackets to see if invalid pairs remain

Top-down outline
// To be able to delete single strings by their index
Turn input string into array, `stringArray`.

If stringArray.length is odd:
  return false

For each string in stringArray (loop without increment)
  If string is an opening bracket and right string is a closing bracket of the same type as string:
    Delete string and right string
    // Go back to beginning of stringArray to see if there are valid pairs now
    i = 0
  Else
    i++

/* ------------------------------------------------- */

// Code: Strategy 3, v1:

function getValidParenthesesPairs(s) {
  // Turn input string into an array to be able to delete array elements by their indices
  var stringArray = s.split("");

  // If there is an odd number of parentheses, the input string does not consist of pairs of parentheses only, and is thus invalid.
  if (stringArray.length % 2 !== 0) {
    return false;
  }

  // Delete pairs found. Only go to next index when you don't find a pair at current index.
  for (var i = 0; i < stringArray.length;) {
    // If the current and the right parentheses are a valid pair:
    if ((stringArray[i] === "{" && stringArray[i + 1] === "}") || (stringArray[i] === "(" && stringArray[i + 1] === ")") || (stringArray[i] === "[" && stringArray[i + 1] === "]")) {
      // Remove the pair
      stringArray.splice(i, 2);
      // To deal with nested pairs of parentheses, go back to the beginning of stringArray to check if there are more pairs now, after having deleted the current one.
      i = 0;
    // If the current and the right parentheses are not a valid pair, skip to the next index.
    } else {
      i++; 
    }
  }

  // If no parentheses remain after all valid pairs have been removed, s contained only valid pairs and is therefore a valid input string.
  if (stringArray.length === 0) {
    return true;
  // If parentheses remain, they are not of the same type and/or not in the correct order, or not an opening and a closing one. Hence, s is not a valid input string.
  } else {
    return false;
  }
}

/* ------------- */

/* Result:
Runtime: 154 ms
Memory Usage: 40 MB
*/

/* ===========================================================*/

/* 
Strategy 4

Summary: Create a map of valid brackets pairs. Check each bracket in string against it.
*/

// Strategy 4, Code v1: Using a Map object

function isStringValid(s) {
  // If string is empty, return false.
  if (s.length === 0) {
    return false;
  }

  // If s.length is odd, s does not consist of bracket pairs only.
  // Test: Does checking for length === 1 increase speed?
  if (s.length % 2 !== 0) {
    return false
  }

  // Create a reference map of all valid brackets pairs.
  var bracketsMap = new Map();
  bracketsMap.set('(', ')')
             .set('[', ']')
             .set('{', '}');
  // Create an array to keep track of the open brackets found in the string.
  var openBracketsSoFar = [];

  // Go through each bracket in the string
  for (var i = 0; i < s.length; i++) {
    // If bracket is open
    if (bracketsMap.has(s[i])) {
      // Store this open bracket so that you can later find its closing counterpart
      openBracketsSoFar.push(s[i]);
    // If bracket is closed
    } else { 
      // If you have not come across an open bracket so far, this means that the input string starts with a closed bracket, and is thus invalid. 
      if (openBracketsSoFar.length === 0) {
        return false;
      }
      // If complement of current closed bracket is not the same as previousOpenBracket, they are not a valid pair.
      var previousOpenBracket = openBracketsSoFar.pop();
      if (bracketsMap.get(previousOpenBracket) !== s[i]) {
        return false;
      }
    }
  }

  // If input string is even, but consisting of more open than closed brackets*, '[[[]', openBracketSoFar would be greater than 0, string would be invalid
  // * If input string consisted of more closed than open brackets, the second if condition would return false.
  return (openBracketsSoFar.length === 0);  
}

// -------------------

// Result:
// Runtime: 136 ms
// Memory Usage: 38.4 MB


// ==========================================================================================

// MEINE SCHNELLSTE LÖSUNG:
// Strategy 4, Code v2:
function isStringValid(s) {
  // If string is empty, return false.
  if (s.length === 0) {
    return false;
  }

  // If s.length is odd, s does not consist of bracket pairs only.
  // Test: Does checking for length === 1 increase speed? Result: No, it doesn't!!
  // if (s.length === 1) {
  //   return false;
  // }

  if (s.length % 2 !== 0) {
    return false
  }

  // Create a reference map of all valid brackets pairs.
  var bracketsMap = {
    '(': ')',
    '[': ']',
    '{': '}'
  };

  // Create an array to keep track of the open brackets found in the string.
  var openBracketsSoFar = [];

  // Go through each bracket in the string
  for (var i = 0; i < s.length; i++) {
    // If bracket is open 
    // If bracket is a key in bracketMap
    if (bracketsMap[s[i]]) {
      // Store this open bracket so that you can later find its closing counterpart
      openBracketsSoFar.push(s[i]);
    // If bracket is closed
    } else { 
      // If you have not come across an open bracket so far, this means that the input string starts with a closed bracket, and is thus invalid. 
      if (openBracketsSoFar.length === 0) {
        return false;
      }
      // If complement of current closed bracket is not the same as previousOpenBracket, they are not a valid pair.
      var previousOpenBracket = openBracketsSoFar.pop();
      if (bracketsMap[previousOpenBracket] !== s[i]) {
        return false;
      }
    }
  }

  // If input string is even, but consisting of more open than closed brackets*, '[[[]', openBracketSoFar would be greater than 0, string would be invalid
  // * If input string consisted of more closed than open brackets, the second if condition would return false.
  return (openBracketsSoFar.length === 0);  
}


/*-------------------------------------------------*/
// Result: 
// Runtime: 75 ms - meine schnellste Lösung!
// Memory Usage: 38.8 MB

//==========================================================

// Strategy 4, Code v3: Mapping brackets the other way around: closed first, open second; using object
function isStringValid(s) {
  // If string is empty, return false.
  if (s.length === 0) {
    return false;
  }

  // If s.length is odd, s does not consist of bracket pairs only.
  if (s.length % 2 !== 0) {
    return false
  }

  // Create a reference map of all valid brackets pairs.
  var bracketsMap = {
    ')': '(',
    ']': '[',
    '}': '{'
  };

  // Create an array to keep track of the open brackets found in the string.
  var openBracketsSoFar = [];

  for (var i = 0; i < s.length; i++) {
    // See if current bracket in string is a key in bracketsMap, or undefined:
    var currentBracket = bracketsMap[s[i]];
     // if bracket is open, i.e. if bracketsMap[s[i]] does not exist (is undefined):
    if (currentBracket === undefined) {
      openBracketsSoFar.push(s[i]);
    // if bracket is closed, i.e. if bracketsMap[s[i]] exists:
    } else {
      if (openBracketsSoFar.length === 0) {
        return false;
      }
      // if bracket is not closing bracket for latest open bracket:
      if (currentBracket !== openBracketsSoFar.pop()) {
        return false;
      }
    }
  }
  
  // if there are remaining open brackets, the input string is invalid.
  return openBracketsSoFar.length === 0;
}

/* -------------------------------*/

// Runtime: 191 ms, faster than 5.24% of JavaScript online submissions for Valid Parentheses.
// Memory Usage: 37.9 MB, less than 99.93% of JavaScript online submissions for Valid Parentheses.

/* 
 * Fragen:
 * Warum ist der Code in Strategy 4, Code v2 mit Objekt schneller als mit Map? Liegt das überhaupt daran, oder an anderen Teilen des Codes?