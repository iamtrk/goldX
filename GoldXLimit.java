
package com.iamtrk.scratchpad.goldx;

import java.util.LinkedList;
import java.util.List;

public class GoldXLimit {
    double price;
    GoldXLimit next;
    GoldXLimit prev;
    List<GoldXOrder> orderList = new LinkedList<>();

    public GoldXLimit(double price) {
        this.price = price;
    }
}
