package com.villa.java_market.persistance;

import com.villa.java_market.domain.Purchase;
import com.villa.java_market.domain.repository.IPurcharseRepository;
import com.villa.java_market.persistance.crud.CompraCrudRepository;
import com.villa.java_market.persistance.entity.Compra;
import com.villa.java_market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPurcharseRepository {
    @Autowired
    private CompraCrudRepository _compraCrudRespository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) _compraCrudRespository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientID) {
        return _compraCrudRespository.findByIdCliente((clientID)).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra  = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(_compraCrudRespository.save((compra)));

    }
}
