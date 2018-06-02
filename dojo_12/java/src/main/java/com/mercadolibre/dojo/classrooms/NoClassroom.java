package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.matchers.Matcher;

public class NoClassroom implements IClassroom {

    private Label label;

    public NoClassroom() {
        this.label = new Label("No hay aula disponible");
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return challengerObject;
    }
}
