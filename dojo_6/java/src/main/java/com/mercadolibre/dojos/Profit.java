package com.mercadolibre.dojos;

import java.math.BigDecimal;
import java.util.Objects;

public class Profit {

    private BigDecimal value;

    Profit(BigDecimal _value) {
        this.value = _value;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Profit)) {
            return false;
        }
        Profit otherProfit = (Profit) o;
        return Objects.equals(this.getValue(), otherProfit.getValue());
    }


}
