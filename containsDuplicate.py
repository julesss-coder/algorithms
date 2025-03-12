# Leetcode 217. Contains Duplicate

# URL: https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=xi4ci4ig

# Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

# Example 1:

# Input: nums = [1,2,3,1]

# Output: true

# Explanation:

# The element 1 occurs at the indices 0 and 3.

# Example 2:

# Input: nums = [1,2,3,4]

# Output: false

# Explanation:

# All elements are distinct.

# Example 3:

# Input: nums = [1,1,1,3,3,4,3,2,4,2]

# Output: true

 

# Constraints:

# 1 <= nums.length <= 105
# -109 <= nums[i] <= 109

# =======================
from collections import Counter

nums = [1, 2, 4, 5, 1]

# Version 1
def containsDuplicate(nums):
    for num in nums:
        if nums.count(num) > 1:
            return True
    
    return False

print(containsDuplicate(nums))

# Version 2
def containsDuplicateV2(nums):
    if len(nums) <= 1:
        return False
    
    nums_set = set(nums)
    if len(nums) > len(nums_set):
        return True
    else:
        return False

print(containsDuplicateV2(nums))

#  Version 3
def containsDuplicateV3(nums):
    counter = Counter(nums)
    
    for value in counter.values():
        if value > 1:
            return True
        
        return False
        
containsDuplicateV3(nums)