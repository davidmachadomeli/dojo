package com.mercadolibre.dojos;

import java.math.BigDecimal;
import java.util.List;

public class MultipleProductsSale implements IProfitable {

    private List<ISellingProduct> items;
    private SellingPrice sellingPrice;

    MultipleProductsSale(List<ISellingProduct> _items, SellingPrice _sellingPrice) {
        this.items = _items;
        this.sellingPrice = _sellingPrice;
    }

    public Profit profit() {
        return new Profit( this.sellingPrice.subtract(this.itemsTotalCost()) );
    }

    private BigDecimal itemsTotalCost() {
        BigDecimal accumulator = BigDecimal.ZERO;
        for (ISellingProduct i : this.items) {
            accumulator = accumulator.add(i.getTotalCostAmount());
        }
        return accumulator;
    }

}
