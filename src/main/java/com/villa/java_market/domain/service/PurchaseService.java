package com.villa.java_market.domain.service;

import com.villa.java_market.domain.Purchase;
import com.villa.java_market.domain.repository.IPurcharseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private IPurcharseRepository _purchaseRepository;

    public List<Purchase> getAll(){
        return _purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getPurchaseByClient(String clientId ){
        return _purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase)
    {
        return _purchaseRepository.save(purchase);
    }
}

