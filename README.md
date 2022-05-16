# goldX

Order book is a datastructure that supports following operations

Add an order : O(logN)
getMin : O(1) / returns a head node of a doubly linkedlist in sorted order.
getMax: O(1) / returns a head node of a doubly linkedlist in sorted order.
delete an order : O(logN)

The implementation is a combination of a NavigableMap & a Doubly linked list.
