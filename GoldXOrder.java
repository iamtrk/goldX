
package com.iamtrk.scratchpad.goldx;

public class GoldXOrder {
    String userId;
    OrderAction action;
    long time;
    int weight;
    double price;

    public GoldXOrder(String userId, OrderAction action, long time, int weight, double price) {
        this.userId = userId;
        this.action = action;
        this.time = time;
        this.weight = weight;
        this.price = price;
    }
}
