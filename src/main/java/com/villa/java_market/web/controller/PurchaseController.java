package com.villa.java_market.web.controller;

import com.villa.java_market.domain.Purchase;
import com.villa.java_market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService _purchaseService;

    @GetMapping()
    @Operation(summary = "Obtener todas las compras")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(_purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    @Operation(summary = "Obtener las compras por cliente")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Purchase>> getByClientId(@PathVariable("clientId") String clientId){
        return _purchaseService.getPurchaseByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    @Operation(summary = "Creación de una compra")
    @ApiResponse(responseCode = "201", description = "Creación de una compra con sus productos")
    public ResponseEntity<Purchase> Save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(_purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
