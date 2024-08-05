/*
Problem by Gordon Zhu and Lily Gentner from watchandcode.com
Strategy, Solution by julesss-coder
------------------------------------------------------------
Problem description 

Part 1

Imagine that you're driving back and forth on a road that's n miles long, until you run out of gas. The road starts at mile-marker 0 and ends at mile-marker n.

Given two integers: n (representing the length of the road) and distanceToTravel (representing the number of miles you'll drive before running out of gas), determine where on the road (i.e. which mile marker) you'll stop.
You can assume that you'll start at mile-marker 0.

stoppingPoint(5, 3) should return 3 (because you'll travel 3 miles from mile marker 0).

---
Part 2

Now, imagine that you're driving back and forth on another road with a series of towns along the way. You still want to drive as far as you can, but you don't want to get stuck in between towns. If you ever reach a town and you don't have enough gas to reach the next one, you should stop there. 

Given an integer distanceToTravel, and an array of townLocations (representing the mile marker at which each town is located), return the mile marker of the town where you'll stop. 

You can assume that you'll start at the first town. 

finalTown(15, [0, 10, 14]) should return 14. You can travel from 0 to 14, but not back to 10.
finalTown(27, [0, 10, 14]) should return 10. You can travel from 0 to 14, then 4 miles back to 10. But not back to 0.

Do no use string or array methods. 

*/

/*
Summary: 

Strategy 1:

if n === 0:
  return 0
  
if distanceToTravel === 0:
  return distanceToTravel

if distanceToTravel <= n:
  return distanceToTravel
else if n fits into distanceToTravel an odd number of times: 
  return n - distanceToTravel % n
else if n fits into distanceToTravel an even number of times: 
  return distanceToTravel % n

Time Complexity: O(1)

Space Complexity: O(1)

*/

function stoppingPoint(n, distanceToTravel) {
  if (n === 0) return n;
  if (distanceToTravel === 0) return distanceToTravel;

  let remainingMiles = distanceToTravel % n;

  if (distanceToTravel <= n) {
    return distanceToTravel;
  // if n fits into distanceToTravel an odd number of times: 
  } else if (Math.floor(distanceToTravel / n) % 2 !== 0) {
    return n - remainingMiles;
// if n fits into distanceToTravel an even number of times: 
  } else if (Math.floor(distanceToTravel / n) % 2 === 0) {
    return remainingMiles;
  }
}

/*
===================================
Strategy 2

Eliminate round trips (back and forth) and find remaining distance. Track direction of travel until remaining distance is less than `n` (road length)

// 1 round trip = 2 * n
remainingDistance = distanceToTravel % 2 * n

// After the round trips, we are back at position 0 (on the left)
leftToRight = true

if remainingDistance > n:
  remainingDistance = n - remainingDistance
  leftToRight = false

// determine final mile marker starting from the right (n)
if leftToRight === false:
  return n - remainingDistance
// determine final mile marker starting from the left (position 0)
else if leftToRight === true:
  return remainingDistance
====================================


  */


/*

Strategy for part 2

Summary

Outline

leftToRightDirection = true


For each town in townLocations:
  if leftToRightDirection === true
    nextPath = right town - town

    if distanceToTravel >= nextPath:
      distanceToTravel -= nextPath
        
    else if distanceToTravel < nextPath:
        return index of town
    
    if right town is at end of townLocations:
      leftToRightDirection = false

  // If we are going backwards:
  else if leftToRightDirection === false:
    nextPath = town - left town

    if distanceToTravel >= nextPath:
      distanceToTravel -= nextPath
        
    else if distanceToTravel < nextPath:
        return index of town

    if left town is at beginning of townLocations:
      leftToRightDirection = true



Trace:
leftToRightDirection = false
distanceToTravel = 1
[0, 10, 14]
         *
nextPath = 4

NOTE: Strategy does not take into account that we have to change the direction of iteration once we reach the end/beginning of `townLocations` - find new strategy


*/

function finalTown(distanceToTravel, townLocations) {

}