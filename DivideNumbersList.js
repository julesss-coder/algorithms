/*
Problem description
Write a process that considers a list of numbers and determines whether there is a point where the list could be divided in two such that the numbers in each part have the same sum.

For example:
[1, 1, 2] should produce true.
[1, 2, 1] should produce false.

Problem by Lily & Gordon from watchandcode.com, meeting on 30 May 2024.

*/

// Strategy: Get sum. For each number in numbers, add it to left sum and compare left sum to right sum.

function divideNumbersList(numbers) { 
    if (numbers.length <= 1) {
        return false;
    }

    let sum = 0;
    for (let i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }

    let leftSum = 0;
    for (let i = 0; i < numbers.length; i++) {
        leftSum += numbers[i]; 
        if (leftSum === sum - leftSum) {
            return true;
        }
    }

    return false;
}

// Time complexity: O(n) where n is numbers.length
// Space complexity: O(1)