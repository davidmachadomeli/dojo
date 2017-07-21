package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class SellingPrice {

    private BigDecimal amount;

    SellingPrice(BigDecimal _amount) {
        this.amount = _amount;
    }

    public BigDecimal subtract(BigDecimal itemsTotalAmount) {
        return this.amount.subtract(itemsTotalAmount);
    }

}
