// 15. 3Sum
// Medium

// 21089

// 1964

// Add to List

// Share
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
 

// Constraints:

// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105


/* 
KNOBS


STRATEGY 1

Input: nums = [-1,0,1,2,-1,-4]
i                     *
j                           *
k                           *

tripletMap = {
  [-1, 0, -1],
  [-1, 2, -1]
}

i = 0
j = i + 1
k = j + 1

for each number at i in nums, except the last two:
  for each number at j in nums, except the last one:
    sum = nums[i] + nums[j] // 1
    for each number at k in nums:
      missingNumber = 0 - sum; // 1
      if nums (after j) contains missingNumber:
        triplet = triplet [num[i], num[j], num[k]]
        sort triplet in ascending order
        convert triplet to JSON
        // Check if triplet with identical numbers is already in tripletSet
        If tripletsSet does not contain triplet:
          add triplet [num[i], num[j], num[k]] to tripletsSet

        break;


TRACE

nums = [0,1,1]
i       *
j         *
k           *


i = 0
j = i + 1
k = j + 1

tripletSet = {}

sum = 1
missingNumber = -1

----------

nums = [6, 0, -3, -4, 3, -6, 5, 1, 1, 1, -6]
i          *
j                                     *
k                                         *

tripletSet = {
  [-6, 0, 6]
  [-3, 0, 3]
}

sum = 2
missingNumber = -2

*/

// IMPLEMENTATION

var threeSum = function(nums) {
  let tripletMap = {};
  let sum;
  let missingNumber;
  let triplet;

  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      sum = nums[i] + nums[j];
      for (let k = j + 1; k < nums.length; k++) {
        missingNumber = 0 - sum;
        if (nums[k] === missingNumber) {
          triplet = [nums[i], nums[j], nums[k]].sort((a, b) => a - b);
          triplet = JSON.stringify(triplet);
          if (!tripletMap[triplet]) {
            tripletMap[triplet] = true;
          }
          
          break;
        }
      }
    }
  }

  // returns array of JSON data, should return array of arrays
  return Object.keys(tripletMap);
};