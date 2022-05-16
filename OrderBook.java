package com.iamtrk.scratchpad.goldx;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class OrderBook {
    //Core order book data structure is a NavigableMap with Key as the limit price & values as a list of Limit orders.
    //There is a doubly linked list on top of NavigableMap which gives a O(1) iterator of the limit orders in sorted order.
    static NavigableMap<GoldXLimit, List<GoldXOrder>> map = new TreeMap<>((g1, g2) -> {
        if(g1.price > g2.price) return -1;
        else if(g1.price < g2.price) return 1;
        else return 0;
    });

    public static void main(String[] args) {
        add();

        GoldXLimit first = map.firstEntry().getKey();
        while (first != null) {
            System.out.println(first.price);
            first = first.next;
        }
    }

    public static void addGoldXOrder(GoldXLimit goldXLimit, GoldXOrder goldXOrder) {
        map.computeIfAbsent(goldXLimit, k-> new LinkedList<>()).add(goldXOrder);
    }
    // Adds 1000 orders to the order book.
    public static void add() {
        Random random = new Random();
        for (int i=0; i<1000; i++) {
            String userId = RandomStringUtils.randomAlphanumeric(5);
            long time = System.currentTimeMillis();
            int weight = random.nextInt(100);
            double price = random.nextDouble();

            GoldXOrder goldXOrder = new GoldXOrder(userId, OrderAction.BUY, time, weight, price);
            GoldXLimit goldXLimit = new GoldXLimit(goldXOrder.price);

            addGoldXOrder(goldXLimit, goldXOrder);

            // Updating the doubly linked list to make sure the doubly linked list is in sorted Order
            GoldXLimit next = map.higherKey(goldXLimit);
            GoldXLimit prev = map.lowerKey(goldXLimit);

            if(next!=null) {
                goldXLimit.next = next;
                next.prev = goldXLimit;
            }
            if(prev!=null) {
                goldXLimit.prev = prev;
                prev.next = goldXLimit;
            }
        }
    }
}
