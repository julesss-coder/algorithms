// 15. 3Sum
// URL: https://leetcode.com/problems/3sum/ 
// Medium

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 // ========= DRAFT ===========
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
