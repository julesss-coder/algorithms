// 876. Middle of the Linked List

// URL: https://leetcode.com/problems/middle-of-the-linked-list/?envType=study-plan&id=level-1

// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

// Constraints:

// The number of nodes in the list is in the range [1, 100].
// 1 <= Node.val <= 100


/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

/* =========== Strategy 1 ============

Summary: Count nodes, go to middle one and return it.

*/
var middleNode = function(head) {
    if (head === null || head.next === null) {
      return head;
    }

    let nodeCounter = 0;
    let current = head;

    while (current !== null) {
      nodeCounter++;
      current = current.next;
    }

    current = head;

    if (nodeCounter % 2 === 0) {
      for (let i = 0; i < nodeCounter / 2; i++) {
        current = current.next;
      }

      return current;
    } else {
      for (let i = 0; i < Math.round(nodeCounter / 2) - 1; i++) {
        current = current.next;
      }

      return current;
    }
};



/* =================== Strategy 2 =======================

Summary: Create all possible heads and return the middle one

*/

var middleNode = function(head) {
  if (head === null || head.next === null) {
    return head;
  }

  let nodesArray = [];

  while (head !== null) {
    nodesArray.push(head);
    head = head.next;
  }

  // Count lists in array and return the middle node
  return nodesArray[Math.trunc(nodesArray.length / 2)];
};


/* =========== Strategy 3 ===========

Summary: Move fast pointer two nodes ahead, slow pointer one node ahead on each iteration. Once fast pointer is at last node or out of bounds, 
slow pointer is at middle node.
*/

/* Observation:
In odd-numbered lists:
  Once `fast` is at last node, `slow` is at middle node. => Loop condition to be fulfilled: fast.next !== null.
In even-numbered lists: 
  Once `fast` goes out of bounds, `slow` is at middle point. => Loop condition to be fulfilled: fast !== null.
*/

var middleNode = function(head) {
  let fast = head;
  let slow = head;

  // Combined condition for odd- and even-numbered lists:
  while (fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
};


