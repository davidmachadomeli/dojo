package com.mercadolibre.dojos;

public class UnitSale implements IProfitable {

    private ISellingProduct sellingProduct;
    private SellingPrice sellingPrice;

    UnitSale(ISellingProduct _sellingProduct, SellingPrice _sellingPrice) {
        this.sellingProduct = _sellingProduct;
        this.sellingPrice = _sellingPrice;
    }

    public Profit profit() {
        return new Profit(this.sellingPrice.subtract(this.sellingProduct.getTotalCostAmount()));
    }

}
