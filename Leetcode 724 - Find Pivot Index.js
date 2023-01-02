// 724. Find Pivot Index
// URL: https://leetcode.com/problems/find-pivot-index/?envType=study-plan&id=level-1

// =======================================================================
// VERSION 1

var pivotIndex = function(nums) {
  if (nums.length === 1) return nums[0];
  
  let leftSum = 0;
  let rightSum = nums.slice(1).reduce((acc, cur) => acc + cur);
  
  for (let i = 0; i < nums.length; i++) {
    // For index 0, leftSum and rightSum are the values given above
    if (i !== 0) {
      leftSum += nums[i - 1];
      rightSum -= nums[i];
    }

    // No need to check for last position, as rightSum will result in 0 anyway after subtracting last number
      
    if (leftSum === rightSum) return i;
  }
  
  return -1;
};

// ========================================================================

// VERSION 2: IMPROVED VERSION AFTER LOOKING AT SIMPLER CODE EXAMPLE ON LEETCODE
// URL: https://leetcode.com/submissions/detail/869553580/


var pivotIndex = function(nums) {
  if (nums.length === 1) return nums[0];
  
  let leftSum = 0;
  let rightSum = nums.reduce((acc, cur) => acc + cur);
  
  for (let i = 0; i < nums.length; i++) {
    rightSum -= nums[i];
    if (leftSum === rightSum) return i;
    leftSum += nums[i];
  }
  
  return -1;
};

