# goldX
Basic order book implementation. Add Order & getMax logic is implemented.
Order book is a datastructure that supports following operations

    1) Add an order : O(logN)

    2) getMin : O(1) / returns a head node of a doubly linkedlist in sorted order.

    3) getMax: O(1) / returns a head node of a doubly linkedlist in sorted order.

    4) delete an order : O(logN)
    

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
