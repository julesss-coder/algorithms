// 876. Middle of the Linked List

// URL: https://leetcode.com/problems/middle-of-the-linked-list/?envType=study-plan&id=level-1

// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

// Constraints:

// The number of nodes in the list is in the range [1, 100].
// 1 <= Node.val <= 100

// ----------------------------------------------

// Observations

// Knobs

// Edge cases

// ----------------------------------------------

/*
Strategy 1

Summary:

Top-down outline:

if head === null || head.next === null:
  return head

nodeCounter = 0

while current !== null:
  nodeCounter++
  current = current.next

current = head

if nodeCounter % 2 === 0:
  nodeCounter/2 times:
    current = current.next
  
  return current
else:
  Math.round(nodeCounter/2) - 1 times:
    current = current.next
  
  return current
*/

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

// Implementation

// Creating my own list for testing
function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}

let list = new ListNode(1);
list.next = new ListNode(2);
list.next.next = new ListNode(3);
console.log(list);
head = list;


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


// -----------

// LeetCode approach 1


// Creating my own list for testing
function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}

let list = new ListNode(1);
list.next = new ListNode(2);
list.next.next = new ListNode(3);
console.log(list);
head = list;

var middleNode = function(head) {
  // Add in checks for empty list and list with one head

  // Put head in an array
  let A = [head];
  // While we are not at last node in list:
  while (A[A.length - 1].next != null)
      // Add currentNode.next to array
      A.push(A[A.length - 1].next);
  // Return the middle node
  return A[Math.trunc(A.length / 2)];
};