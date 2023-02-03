/*
142. Linked List Cycle II
URL: https://leetcode.com/problems/linked-list-cycle-ii/?envType=study-plan&id=level-1

================== Strategy 1 ====================
Summary: Map visited nodes and check if tail's `next` reference points to one of them

*/
// Previous attempts based on going to the last node and checking its reference failed because obviously I cannot find the end if there isn't one...

var detectCycle = function(head) {
  // Check for empty list and list with one node and no cycle
  if (head === null || head.next === null) {
    return null;
  }

  // Check for list with one node and cycle
  // This case is covered in while loop, but if this case applies, this check saves us the work of creating a new Set object.
  if (head.next === head) {
    return head;
  }
  
  // I chose Set because it can take object references as values and only takes one value per entry
  let visitedNodes = new Set();

  while (head !== null) {
    visitedNodes.add(head);

    if (visitedNodes.has(head.next)) {
      return head.next;
    }

    head = head.next;
  }

  return null;
};
