// URL: https://leetcode.com/problems/merge-two-sorted-lists/

// Problem description: You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

var mergeTwoLists = function(list1, list2) {
  // list1 and list2 are the heads of their respective lists
  if (list1 === null && list2 === null) {
    return null;
  } 

  let sortedList = new ListNode();
  // `head` will be empty. Only used as access point.
  let head = sortedList;

  while (list1 !== null && list2 !== null) {
    if (list1.val < list2.val) {
      sortedList.next = new ListNode(list1.val);
      list1 = list1.next;
    } else {
      sortedList.next = new ListNode(list2.val);
      list2 = list2.next;
    }
    sortedList = sortedList.next;
  }

  if (list1 === null && list2 !== null) {
    sortedList.next = list2;
  } else if (list1 !== null && list2 === null) {
    sortedList.next = list1;
  }

  // As `head` is empty, `head.next` is the first node with a valid value and is therefore returned.
  return head.next;
};
