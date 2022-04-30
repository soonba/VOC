package com.voc.voc.domain;


import com.voc.voc.adapter.out.persistence.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Supplier {

    SupplierId supplierId;
    String vendorName;
    String managerName;
    String managerNumber;


    public Supplier(SupplierEntity supplierEntity) {
        this.supplierId = new SupplierId(supplierEntity.getId());
        this.vendorName = supplierEntity.getVendorName();
        this.managerName = supplierEntity.getManagerName();
        this.managerNumber = supplierEntity.getManagerNumber();
    }

    public SupplierEntity toEntity() {
        return SupplierEntity.builder()
                .id(this.supplierId.getId())
                .vendorName(this.vendorName)
                .managerName(this.managerName)
                .managerNumber(this.managerNumber)
                .build();
    }

    @AllArgsConstructor
    @Getter
    public static class SupplierId {
        Long id;
    }
}
