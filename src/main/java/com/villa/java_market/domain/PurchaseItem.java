package com.villa.java_market.domain;

import lombok.Getter;
import lombok.Setter;

public class PurchaseItem {

    @Getter
    @Setter
    private int productId;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private double total;

    @Getter
    @Setter
    private boolean state;

}
