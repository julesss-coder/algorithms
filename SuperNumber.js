/*


Part 1
Given an array of positive numbers, determine whether it contains a "Super Number", that is: a number that's larger than all of the *other* numbers *combined*.
If there is, return that number. Else, return null.

For example: superNumber([5, 1, 1, 1]) should return 5.
superNumber([4,4]) should return null.
===================

List of strategies:
1) Get sum of array. For each number, is number > (sum - number)
2) Find largest number and its position. Sum everything except largest. Compare sum with largest.
3) Track largestSoFar. Track sum excluding largestSoFar. Compare largestSoFar with sum.
4) Best approach, combining strategy 1 with 2 and 3 (that are based on the fact that only the largest number is a candidate for the super number): Find sum. Find largest. Check if largest > (sum - largest).
5) Works, but worst design: Find sum. Find largest. Check if largest > (sum / 2). The thought behind it: The super number is like a shareholder that holds more than half of the shares. That is how you can find it.

===================
*/

// Strategy 1
// Summary: Get sum of array. For each number, is number > (sum - number)
function superNumber1(numbers) {
  if (numbers.length === 0 || numbers.length === 1) {
    return null;
  }

  let currentSuperNumber = null;
  let allNumsSum = 0;

  for (let i = 0; i < numbers.length; i++) {
    allNumsSum += numbers[1];
  }

  for (let i = 0; i < numbers.length; i++) {
    let currentNumber = numbers[i];
    if (currentNumber > allNumsSum - currentNumber) {
      currentSuperNumber = currentNumber;
    }
  }

  return currentSuperNumber;
}

/*============================================================================================================
Strategy 2: Find largest number and its position. Sum everything except largest. Compare sum with largest.
-------------------------------------------------------------------------------------------------------------*/

function superNumber2(numbers) {
  if (numbers.length === 0 || numbers.length === 1) {
    return null;
  }

  let largest = -Infinity;
  let indexOfLargest = null;
  
  for (let i = 0; i < numbers.length; i++) {
    if (numbers[i] > largest) {
      largest = numbers[i];
      indexOfLargest = i;
    }
  }

  console.log("largest: ", largest);

  let sumExceptLargest = 0;
  for (let i = 0; i < numbers.length; i++) {
    if (i !== indexOfLargest) {
      sumExceptLargest += numbers[i];
    }
  }

  console.log("sumExceptLargest: ", sumExceptLargest);

  if (largest > sumExceptLargest) {
    return largest;
  } else {
    return null;
  }
}

/* ============================================================================================================
// Strategy 3: Track largestSoFar. Track sum excluding largestSoFar. Compare largestSoFar with sum.
---------------------------------------------------------------------------------------------------------------*/
function superNumber3(numbers) {
  if (numbers.length === 0 || numbers.length === 1) {
    return null;
  }

  let largestSoFar = numbers[0];
  let sumExceptLargest = 0;

  for (let i = 1; i < numbers.length; i++) {
    let currentNumber = numbers[i];

    if (currentNumber > largestSoFar) {
      sumExceptLargest += largestSoFar;
      // Reset largestSoFar to the new largest number just found:
      largestSoFar = currentNumber;
    } else {
      sumExceptLargest += currentNumber;
    } 
  }

  if (largestSoFar > sumExceptLargest) {
    return largestSoFar;
  } else {
    return null;
  }
}

/* ==========================================================================================================
Strategy 4: Find sum. Find largest. Check if largest > (sum - largest).
-------------------------------------------------------------------------------------------------------------*/

function superNumber4(numbers) {
  if (numbers.length === 0 || numbers.length === 1) {
    return null;
  }

  let numbersSum = 0;
  let largest = -Infinity;

  for (let i = 0; i < numbers.length; i++) {
    numbersSum += numbers[i];
    if (numbers[i] > largest) {
      largest = numbers[i];
    }
  }

  if (largest > (numbersSum - largest)) {
    return largest;
  } else {
    return null;
  }
}

/* ===========================================================================================================
Strategy 5: Find sum. Find largest. Check if largest > (sum / 2). The thought behind it: The super number is like a shareholder that holds more than half of the shares. This is how you can find if there is a "majority shareholder number" in the `numbers` array.
--------------------------------------------------------------------------------------------------------------*/

function superNumber5(numbers) {
  if (numbers.length === 0 || numbers.length === 1) {
    return null;
  }

  let numbersSum = 0;
  let largest = -Infinity;

  for (let i = 0; i < numbers.length; i++) {
    numbersSum += numbers[i];
    if (numbers[i] > largest) {
      largest = numbers[i];
    }
  }

  // The super number is like a shareholder that holds more than half of the shares. This is how you can find if there is a "majority shareholder number" in the `numbers` array.
  if (largest > (numbersSum / 2)) {
    return largest;
  } else {
    return null;
  }
}

/* ============================================================================================================
Part 2
----------------------------------------------------------------------------------------------------------------
Given an array of positive numbers, determine whether there is one number that's at least twice as big as each of the other numbers.
If there is, return that number. If there isn't, return null.

For example:
twiceAsBigNumber([3, 1, 1]) should return 3
twiceAsBigNumber([10, 4, 3, 4, 3]) should return 10
twiceAsBigNumber([10, 9]) should return null
----------------------------------------------------------------------------------------------------------------*/

/* ===========================================================================================================
Strategy 1: Compare each number to the others. Track if current number is >= twice as big as EACH other number.
--------------------------------------------------------------------------------------------------------------*/

function twiceAsBigNumber1(numbers) {
  let twiceAsBigNumber = null;
  
  for (let i = 0; i < numbers.length; i++) {
    let isTwiceAsBig = true;
    let number = numbers[i];
    for (let j = 0; j < numbers.length; j++) {
      if (j !== i) {
        if (number < numbers[j] * 2) {
          isTwiceAsBig = false;
          break;
        }
      }
    }
    
    if (isTwiceAsBig === true) {
      twiceAsBigNumber = number;
    }
  }

  return twiceAsBigNumber;
}

/* ===========================================================================================================
Strategy 2: Compare largest with second largest. (If largest occurs twice, secondLargest === largest!)
--------------------------------------------------------------------------------------------------------------*/

function twiceAsBigNumber2(numbers) {
  let largest = -Infinity;
  let secondLargest = -Infinity;

  for (let i = 0; i < numbers.length; i++) {
    if (numbers[i] > largest) {
      secondLargest = largest;
      largest = numbers[i];
    } else if (numbers[i] > secondLargest) {
      secondLargest = numbers[i];
    }
  }

  if (largest >= (secondLargest * 2)) {
    return largest;
  } else {
    return null;
  }
}
