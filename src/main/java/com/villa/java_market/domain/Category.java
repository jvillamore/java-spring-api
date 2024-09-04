package com.villa.java_market.domain;

import lombok.Getter;
import lombok.Setter;

public class Category {

    @Getter @Setter
    private int categoryId;

    @Getter @Setter
    private String category;

    @Getter @Setter
    private boolean active;
}
