// URL: https://leetcode.com/problems/two-sum/

// Problem statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// -----------------------------------------

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].


// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]


// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 
// ===========================================

// KNOBS

// Observations / discoveries

// Simpler subproblems

// Without a computer

// ===========================================

/* Strategy 1

 [1, 2, 5, 7, 3], target = 7
i    *
j       *
i = 0: 7 - 1 = 6
       missingNumber = 6
       
i = 1, 7 - 2 = 5
      missingNumber = 5
      2 + 5 = 7
      return [i, j]

 [3, 3, 2], target = 6
i *
j    *

i = 0, missingNumber = 3

 [3, 2, 4], target = 6
i    *
j       *   
i = 0, missingNumber = 3
i = 1, missingNumber = 4


For each index i in nums:
  // Find the integer that would sum up to target with current integer
  missingInteger = target - nums[i]
  For each index j in nums, starting at index i + 1:
    If nums[j] === missingInteger:
      Return [i, j]

Pros:
+ conceptually clear

Cons:
- Ambiguous whether we iterate over elements or indices.
- We would not need to iterate over the last element in the i loop, as it will be checked in the j loop. However, not iterating over it would confuse the reader.

----------------------------

Code */

function twoSum(nums, target) {
  for (var i = 0; i < nums.length; i++) {
    // Find the integer that would sum up to target with current integer
    var missingInteger = target - nums[i];
    for (var j = i + 1; j < nums.length; j++) {
      if (nums[j] === missingInteger) {
        return [i, j];
      }
    }
  }
}

/* Was passiert am letzten Index i?
Erwartung: Dann hat man den letzen in der inneren Schleife schon einmal durchgecheckt. 
j < nums.length - 1?
 
1, 2, 3, 3, target 6
    


========================

For each integer in nums:
  // Find the integer that would sum up to target with current integer
  missingInteger = target - currentInteger
  For each integer in nums, starting at the one after currentInteger
    If integer === missingInteger:
      Return [index of currentInteger, index of missingInteger]

Pros:
+ It is clearer to iterate over elements, than over indices
+ Conceptually clear

Cons:
- One might confuse currentInteger and integer. Ambiguous.
- Return statement too long when indices aren't referred to by letters
      

==============================================

Strategy 2

For each index i in nums:
  For each index j in nums, starting from index i + 1:
    If nums[i] + nums[j] === target:
      Return [i, j]


*/

function twoSum(nums, target) {
  // Go through each integer in the array
  for (var i = 0; i < nums.length - 1; i++) {
    for (var j = i + 1; j < nums.length; j++) {
      // Go through the rest of the integers, and check if adding them to current integer sums up to target
      if (nums[i] + nums[j] === target) {
        return [i, j];
      }
    }
  }
}

/*
=================================

Strategy 3

Add each integer and its index to a lookup table, `integerMap`:
For each integer in nums:
  Set integer as key, index as value 

For each integer in nums:
  `missingInteger` = target - integer
  If missingInteger is in integerMap and its index is not the one of current integer:
    Return [i, integerMap.missingInteger]

*/

function twoSum(nums, target) {
  // Add each integer and its index to a lookup table, `integerMap`:
  // For each integer in nums:
  var integerMap = new Map();
  for (var i = 0; i < nums.length; i++) {
    integerMap.set(nums[i], i);
  }
  //   Set integer as key, index as value 

  // For each integer in nums:
  for (var i = 0; i < nums.length; i++) {
    var missingInteger = target - nums[i];
    if (integerMap.has(missingInteger) && integerMap.get(missingInteger) !== i) {
      return [i, integerMap.get(missingInteger)];
    }
  }
  //   `missingInteger` = target - integer
  //   If missingInteger is in integerMap and its index is not the one of current integer:
  //     Return [i, integerMap.missingInteger]
}

// Funktiniert nicht mit Arrays mit zwei gleichen Zahlen, z.Bsp. [3, 2, 3], da in der Map der value beim gleichnamigen Eintrag ersetzt wird, sobald man über die zweite der beiden gleichen Zahlen iteriert.

/*
================================================

Strategy 4

Top-down outline: 

Create new Map object, `integerMap`.

For each integer in nums:
  missingInteger = target - integer
  If missingInteger is not in integerMap:
    Add integer and its index to integerMap
  Else if missingInteger is in integerMap:
    Return [i, index of missingInteger]

Code:
*/

function twoSum(nums, target) {
  var integerMap = new Map(); 
  for (var i = 0; i < nums.length; i++) {
    var missingInteger = target - nums[i];
    if (integerMap.has(missingInteger) === false) {
      integerMap.set(nums[i], i);
    } else {
      return [i, integerMap.get(missingInteger)];
    }
  }
}

/*
======================================================

Eine der schnellsten Lösungen von Leetcode, mit meinen Kommentaren für mein besseres Verständnis:*/


function twoSum(nums, target) {
  const numMap = {};
  const length = nums.length

  // Wir tragend die missingIntegers in der Map ein, und schauen bei jedem Arrayelement, ob es schon in der Map existiert. Sobald wir zu einem Arrayelement kommen, das schon in der Map exisitiert, heißt das, dass wir das Gegenstück (missingInteger) zu einem der vorher vorkommenden Elemente gefunden haben, d.h. wir haben unser Zahlenpaar.
  for (let i = 0; i < length; i++) {
    // Indem man prüft, ob ein Index größer als -1 ist, überprüft man, ob ein Element überhaupt existiert.
    // key value pair in numMap: missing number - index of array element that adds up to target
      if (numMap[nums[i]] > -1) return [numMap[nums[i]], i];
      else numMap[target - nums[i]] = i;
  }
}

/*
Pros: 
+ schnell, laut LeetCode

Cons:
- extrem verwirrend. Man muss um die Ecke denken.
    
  