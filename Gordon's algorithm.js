/*
PROBLEM:
Write a function that takes a string that may or may not contain 0s and 1s, and return the number of 0s that are within two steps of a 1.

Example: 
'1000' => 2 (because the third 0 is 3 steps away from the only 1)
'0001' => 2 (because the first 0 is 3 steps away from the only 1)

SOURCE: Gordon Zhu, "Beginners struggle with this easy question (zeros within two steps)", URL: https://www.youtube.com/watch?v=WBXixmMvC-U

==================================

STRATEGY 1:
Summary: Check two places to both sides of each 1 and keep track of checked part of array

if string.length <= 1:
    return 0

count = 0
indexOfLastZero = -1

For each 1 in string:
    if left number is 0 && 0's index > indexOfLastZero:
        count++
        indexOfLastZero = 0's index

    if number two places to the left is 0 && 0's index > indexOfLastZero:
        count++
        indexOfLastZero = 0's index

    if right number is 0 && 0's index > indexOfLastZero:
        count++
        indexOfLastZero = 0's index

    if number two places to the right is 0 && 0's index > indexOfLastZero:
        count++
        indexOfLastZero = 0's index

Return count
--------------------------------
Pros:
+ Intuitive
Cons:
- Longer that strategy 2
- Introduces an extra variable

================================

STRATEGY 2
Summary: Check each 0 for 1s two places to the right and left

If string.length <= 1:
    Return 0

count = 0

For each 0 in string:
    If left or 2nd left number is a 1:
        // Count this 0:    
        count++
    If right or 2nd right number is a 1:
        count++

Return count

--------------------------------
Pros:
+ short

Cons: 
- Slightly unintuitive, might require a comment

================================

What I did vs. the ideal approach
Strategy 2 is the ideal approach. I went for strategy 1 at first, because it felt intuitive to view the problem from the perspective of the 1s. I did not think of viewing it from the perspective of the 0s, or thought that it would make no difference - I'm not sure. 
How could I correct this mistake?
Try to find all the "knobs" of the problem and how they can be turned. Whether to view the problem from the perspective of the 1s or the 0s would have been a knob, for example.
*/