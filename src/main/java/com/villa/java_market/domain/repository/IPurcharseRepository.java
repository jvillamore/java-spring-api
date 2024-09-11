package com.villa.java_market.domain.repository;

import com.villa.java_market.domain.Purchase;
import java.util.List;
import java.util.Optional;

public interface IPurcharseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientID);
    Purchase save(Purchase purchase);
}
