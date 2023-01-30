/*
206. Reverse Linked List
URL: https://leetcode.com/problems/reverse-linked-list/
Problem description: Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

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
