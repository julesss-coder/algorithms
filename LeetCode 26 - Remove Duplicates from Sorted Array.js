// 26. Remove Duplicates from Sorted Array
// URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Problem description 

// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.

// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

 

// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// nums is sorted in non-decreasing order.
//=============================================

/* STRATEGY 1
nums = [0,1,2,3,4,_,_,_,_,_]
                * *
[0,1,2,3,4,_,_,_,_,_]
         * *
k = 5

while right element is a number (and not "_" which I added for each deleted number):
  if current number === right number:
    remove current number
    add "_" to end of nums
    stay at index i
  else if current number !== right number:
    i++

// once right element is not a number:
  k = last value of i + 1

return [k, nums]
*/

var removeDuplicates = function(nums) {
  var i = 0;
  // while right element is a number (and not "_" which I added for each deleted number):
  while (typeof nums[i + 1] === 'number') {
    // if current number === right number:
    if (nums[i] === nums[i + 1]) {
      // remove current number
      nums.splice(i, 1);
      // add in character to replace duplicate number and keep nums length the same
      nums.push("_");
    } else {
      i++;
    }
  }

  // Return the amount of numbers after removing duplicates
  return k = i + 1;
};

/* schreibe das ganze als rekursive funktion*/

/*
STRATEGY 2

Ich mache zu viel Arbeit: ich muss nur die einzigartigen Zahlen nach vorne ins Array holen und sie aufsteigend sortiert lassen. Ich muss die Duplikate nicht ersetzen, und ich muss keine Zahlen löschen. Das habe ich in Strategie 1 gemacht, aber das ist nicht gefragt. Die problem description sagt ausdrücklich: if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Allerdings sagt sie auch: Remove the duplicates in place.

// Input: nums = [0,1,2,3,4,2,2,3,3,4]
                        *           *
// Input: nums = [0,1,2,3,4,2,2,3,3,4]
                          *           * 
schau dir eine Zahl an
schicke eine Späher aus der die nächsthöhere, einzigartige Zahl findet


// edge case: if nums === 1
if nums.length === 1
  return 1

pointer: index 0
seeker: index 1
// until seeker reaches end of nums
while seeker < nums.length:
  if nums[pointer] === nums[seeker]:
    // send seeker to next index:
    seeker++
  else if nums[pointer] !== nums[seeker]:
    // found the next biggest unique number!
    // replace number to the right of nums[pointer] with the number found
    nums[pointer + 1] = nums[seeker]
    // go to next number to seek the next biggest unique number
    pointer++
    seeker++

return pointer + 1

*/

var removeDuplicates = function(nums) {
  if (nums.length === 1) {
    return 1;
  }

  var pointer = 0;
  var seeker = 1;
  while (seeker < nums.length) {
    if (nums[pointer] === nums[seeker]) {
      seeker++;
    } else {
      nums[pointer + 1] = nums[seeker];
      pointer++;
      seeker;
    }
  }

  return pointer + 1;
};

/* Strategy 2, V2:
for loop verwenden, da sie den seeker sowieso automatisch eins weiter schickt, und das in der while Schleife in beiden Fällen passieren muss*/

var removeDuplicates = function(nums) {
  if (nums.length === 0) {
    return 0;
  }
  
  if (nums.length === 1) {
    return 1;
  }

  var pointer = 0;
  for (var seeker = 1; seeker < nums.length; seeker++) {
    if (nums[pointer] !== nums[seeker]) {
      nums[pointer + 1] = nums[seeker];
      pointer++;
    }
  }

  return pointer + 1;
};