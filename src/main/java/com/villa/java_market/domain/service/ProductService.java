package com.villa.java_market.domain.service;

import com.villa.java_market.domain.Product;
import com.villa.java_market.domain.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository _productRepository;

    public List<Product> getAll(){
        return _productRepository.getAll();
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return _productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return _productRepository.getScarseProducts(quantity);
    }

    public Optional<Product> getProduct(int productId){
        return  _productRepository.getProduct(productId);
    }

    public Product save(Product product){
        return _productRepository.save(product);
    }

    public boolean delete(int productId){
        if(getProduct(productId).isPresent()){
            _productRepository.delete(productId);
            return true;
        }
        return  false;
        /*
        return getProduct(productId).map(prod->
        {
            _productRepository.delete(productId);
            return true;
        }).orElse(false);
        */
    }

}
