// URL: https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan&id=level-1

/*
list1: 1 - 1 - 8 - 9  null
                      *
list2: 2 - 3 - 4 - 5 - 10 null
                          *

mergedList = {1, 1, 2, 3, 4, 5, 8, 9, 10 }

if list1 || list2 is empty:
  mergedList = the non-empty list

node1 = list1.head
node2 = list2.head

while node1 !== null && node2 !== null:
  if node1.value > node2.value:
    add node2 to mergedList
    node2 = node2.next
  if node1.value < node2.value:
    add node1 to mergedList
    node1 = node1.next
  if node1.value === node2.value
    add node1 to mergedList
    add node2 to mergedList
    node1 = node1.next
    node2 = node2.next

if (node1.value !== null):
  add node1.value to mergedList
  node1 = node1.next
else if (node2.value !== null):
  add node2.value to mergedList
  node2 = node2.next

return mergedList


*/