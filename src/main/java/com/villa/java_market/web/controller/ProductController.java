package com.villa.java_market.web.controller;

import com.villa.java_market.domain.Product;
import com.villa.java_market.domain.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService _productService;

    @GetMapping()
    @Operation(summary = "Obtiene todos los productos")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(_productService.getAll(), HttpStatus.OK)  ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return _productService.getProduct(productId)
        .map(prod->new ResponseEntity<>(prod,HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return _productService.getByCategory(categoryId)
                .map(prod->new ResponseEntity<>(prod,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Product>  save(@RequestBody Product product){
        return new ResponseEntity<>(_productService.save(product), HttpStatus.CREATED) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        var result=  _productService.delete(productId);
        if(result)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
