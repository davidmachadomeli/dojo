package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class Cost {

    private BigDecimal ammount;

    Cost(BigDecimal _amount) {
        this.ammount = _amount;
    }

    public BigDecimal getAmmount() {
        return this.ammount;
    }

}
