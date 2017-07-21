package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class Item implements ISellingProduct {

    private Cost cost;

    Item(Cost _cost) {
        this.cost = _cost;
    }

    public BigDecimal getTotalCostAmount() {
        return this.cost.getAmmount();
    }

}
