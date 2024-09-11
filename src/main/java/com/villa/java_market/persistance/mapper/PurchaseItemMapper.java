package com.villa.java_market.persistance.mapper;

import com.villa.java_market.domain.PurchaseItem;
import com.villa.java_market.persistance.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "state"),

    })
    PurchaseItem toPurcharseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
