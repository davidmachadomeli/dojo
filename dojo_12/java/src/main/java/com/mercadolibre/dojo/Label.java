package com.mercadolibre.dojo;

import java.util.Objects;

public class Label {

    private String labelName;

    public Label(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
//        if (!(o instanceof Label)) {
//            return false;
//        }

        final Label label = (Label) o;
        return Objects.equals(labelName, label.labelName);
    }

}
