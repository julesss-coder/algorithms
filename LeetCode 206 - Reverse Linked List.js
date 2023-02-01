/*
206. Reverse Linked List
URL: https://leetcode.com/problems/reverse-linked-list/
Problem description: Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

// Creating my own list for testing
// Definition for singly-linked list.
// function ListNode(val, next) {
//   this.val = (val===undefined ? 0 : val)
//   this.next = (next===undefined ? null : next)
// }

// let list = new ListNode(1);
// list.next = new ListNode(2);
// list.next.next = new ListNode(3);
// console.log(list);
// head = list;

var reverseList = function(head) {
  if (head === null) {
    return null;
  }

  if (head.next === null) {
    return head;
  }

// Insert first node value into first node of reversedList
  let reversedList = new ListNode(head.val);

// For each node in list, starting from the second:
  let current = head.next;
  while (current !== null) {
    let newNode = new ListNode(current.val);
    newNode.next = reversedList;
    reversedList = newNode;
    current = current.next;
  }

  return reversedList;
};

/*

PROS
+ Does not change input
CONS
- Too slow. Creating a new list takes a lot of time

*/


// STRATEGY 2
// Summary: Reverse references of given list

var reverseList = function(head) {
  let current = head;
  let previous = null;

  while (current !== null) {
    // Get a second reference to next node
    let tempNext = current.next;
    // Direct the `next` pointer of current node backwards, to previous node
    current.next = previous;
    // Move `previous` pointer to the following node
    previous = current;
    // Move `current` pointer to following node
    current = tempNext;
  }

  // Set head to (what was previously) last node
  head = previous;
  return head;
};

/*
PROS
+ faster than strategy 1
CONS
- slightly harder to understand for the reader
*/



// STRATEGY 3
// Summary: Recursive solution


var reverseList = function(head) {
  // Base case:
  // Once there is only one node left (once we have reached the last node), return that node.
  if (head === null || head.next === null) {
    return head;
  }

  // Recursive call:
  // In order to get to the base case:
    // Pass in the next node in list
  let reversedList = reverseList(head.next);
  // At this point, we have gone down to the base cased and returned the last node from it.
  // `reversedList` now points to the last node in list.

  // Now, we are back in the previous stack frame, where `head` points to the next node on the left.
  // Set the `next` reference of right neighbour of `head` back to `head`, i.e. reverse the list.
  // Keep in mind: `reversedList` still points to the node to the right of the `head` we are working with in the current stack frame.
  // By changing the `next` references as follows, we are also changing them inside `reversedList`, as both `reversedList` and `head` reference the same overall list.
  head.next.next = head;
  // Delete the original `next` reference of current node.
  head.next = null;
  // Return the reversed list to previous stack frame
  return reversedList;
};
