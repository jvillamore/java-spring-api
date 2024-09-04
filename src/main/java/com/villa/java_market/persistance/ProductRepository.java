package com.villa.java_market.persistance;

import com.villa.java_market.domain.Product;
import com.villa.java_market.domain.repository.IProductRepository;
import com.villa.java_market.persistance.crud.IProductoCrudRepository;
import com.villa.java_market.persistance.entity.Producto;
import com.villa.java_market.persistance.mapper.IProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    private IProductoCrudRepository _productRepository;
    private IProductMapper _productMapper;


    @Override
    public List<Product> getAll() {
        var result = (List<Producto>) _productRepository.findAll();
        return _productMapper.toProducts(result);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        var result =  _productRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(_productMapper.toProducts(result));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        var result =  _productRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return result.map(prod->_productMapper.toProducts(prod));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return _productRepository.findById(productId).map(prod-> _productMapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        var producto= _productMapper.toProducto(product);
        return _productMapper.toProduct((_productRepository.save(producto)));
    }

    @Override
    public void delete(int productId) {
        _productRepository.deleteById(productId);
    }
}
