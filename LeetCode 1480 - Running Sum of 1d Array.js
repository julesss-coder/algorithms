// 1480. Running Sum of 1d Array
// URL: https://leetcode.com/problems/running-sum-of-1d-array/

// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

// ===================================================

// My solution

var runningSum = function(nums) {
    let runningSum = [];
    let sum = 0;
    
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        runningSum.push(sum);
}
    
    return runningSum;
};