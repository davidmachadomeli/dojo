package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;

import java.util.Objects;

public class NoClassroom implements IClassroom {

    private Label label;

    public NoClassroom() {
        this.label = new Label("No hay aula disponible");
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return challengerObject;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof NoClassroom)) {
            return false;
        }

        final NoClassroom noClassroom = (NoClassroom) o;
        return Objects.equals(label, noClassroom.label);
    }

}
