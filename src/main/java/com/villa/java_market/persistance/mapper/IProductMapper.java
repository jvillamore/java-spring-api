package com.villa.java_market.persistance.mapper;

import com.villa.java_market.domain.Category;
import com.villa.java_market.domain.Product;
import com.villa.java_market.persistance.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Category.class})
public interface IProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target ="productId" ),
            @Mapping(source = "nombre", target ="name" ),
            @Mapping(source = "idCategoria", target ="categoryId" ),
            @Mapping(source = "precioVenta", target ="price" ),
            @Mapping(source = "cantidadStock", target ="stock" ),
            @Mapping(source = "estado", target ="active" ),
            @Mapping(source = "Categoria", target ="category" ),

    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
