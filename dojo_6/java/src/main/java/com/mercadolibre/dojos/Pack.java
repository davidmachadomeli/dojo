package com.mercadolibre.dojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pack implements ISellingProduct {

    private Integer quantity;
    private Cost cost;

    Pack(Integer _quantity, Cost _cost) {
        this.quantity = _quantity;
        this.cost = _cost;
    }

    public BigDecimal getTotalCostAmount() {
        return this.cost.getAmmount().divide(new BigDecimal(this.quantity));
    }

    public List<ISellingProduct> getItems(Integer quantity) {
        List<ISellingProduct> items = new ArrayList<ISellingProduct>();
        for (int i = 0; i < quantity; i++) {
            items.add(this.createItem());
        }
        return items;
    }

    private Item createItem() {
        return new Item( new Cost( this.getTotalCostAmount() ) );
    }

}
