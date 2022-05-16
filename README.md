# goldX

Order book is a datastructure that supports following operations

Add an order : O(logN)
getMin : O(1) / returns a head node of a doubly linkedlist in sorted order.
getMax: O(1) / returns a head node of a doubly linkedlist in sorted order.
delete an order : O(logN)

The implementation is a combination of a NavigableMap & a Doubly linked list.

Sell Order :

When a sell order comes, the matching engine queries the BUY Order book for all top buy orders with price > the incoming sell order price sorted by the price. 
If there is enough buy orders, the matching is found 
    1) The corresponding orders are removed from the Order book
    2) Executions are stored in the Database.
    If there are no matchings found, the engine will check if price falls under the 1% of the current price.
        1) If so, the sell order gets executed.
        2) Executions are stored in the Database.
        
Remaining quantity if any, will be added to the Sell order book.

Vice versa for a BUY order.

Buy Order Book (TreeMap)
orderId		time	price	intent		quantity
2		2	11	buy		10
4		4	10	buy		4
1		1	10	buy		11
3		3	9	buy		9

TreeMap for Buy Order book
9:[3] 
10:[1,4]
11:[2] 
Doubly linked list of the Buy Order book will be 9<=>10<=>11



Sell Order Book (TreeMap)
orderId		time	price	intent		quantity
7		7	9	Sell		9
8		8	10	Sell		8
5		5	12	Sell		12
6		6	14	Sell		1

TreeMap for Buy Order book, 
Format: price:[List of Order IDs]
9:[7] 
10:[8]
12:[5]
14:[6] 
Doubly linked list of the Buy Order book will be 9<=>10<=>12<=>14
