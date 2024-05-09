/*

# Problem description
Given a list of numbers, determine if they are evenly spaced. (i.e. if the numerical gap between all numbers is the same);

# Observations:
- Numbers might not be ascending

# Edge cases

- Empty list - no spaces to compare
- List with one element - no spaces to compare
- List with two elements - only one space, so no comparison possible, but all numbers are evenly spaced in this case

==================================================================
# STRATEGY 1

# Summary
Get first gap and compare it to the following gaps

------------------------------------------------------------------

#Outline

initialGap = absolute value of (first number - second number);
currentGap = null;

For each number in list, starting from the second one, except the last:
	currentGap = absolute value of (currentNumber - rightNumber); // or rightNumber - currentNumber, distance is the same
		
	if currentGap !== initialGap:
		return false

Return true

==================================================================

# STRATEGY 2:
Compare three numbers at the same time, always moving on only one index so the two "wings" overlap on one gap
If both gaps are always equal, it means they are all the same
Else, they are not all equal

*/

// Code for strategy 1
function checkNumberSpaces(numbersList) {
  // If there are no spaces to compare:
  if (numbersList.length === 0 || numbersList.length === 1) return false; 

  // If there is only one space, then all numbers in list are spaced evenly:
  if (numbersList.length === 2) return true;

  const initialGap = Math.abs(numbersList[0] - numbersList[1]);
  let currentGap;

  for (let i = 1; i < numbersList.length - 1; i++) {
    currentGap = Math.abs(numbersList[i] - numbersList[i + 1]);

    if (currentGap !== initialGap) {
      return false;
    }
  }

  return true;
}