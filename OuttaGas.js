/*

Problem description (by Gordon Zhu and Lily Gentner from watchandcode.com):

Part 1

Imagine that you're driving back and forth on a road that's n miles long, until you run out of gas. The road starts at mile-marker 0 and ends at mile-marker n.

Given two integers: n (representing the length of the road) and distanceToTravel(representing the number of miles you'll drive before running out of gas), determine where on the road (i.e. which mile marker) you'll stop.
You can assum that you'll start at mile-marker 0.

stoppingPoint(5, 3) should return 3 (because you'll travel 3 miles from mile marker 0).

*/

/*
Summary: 

Strategy:

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
