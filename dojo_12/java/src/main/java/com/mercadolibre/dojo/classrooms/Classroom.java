package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.Persons;

public class Classroom implements IClassroom {

    private Label label;
    private Persons personsCapacity;

    public Classroom(Label label, Persons personsCapacity) {
        this.label = label;
        this.personsCapacity = personsCapacity;
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfHasAtLeastAsManyPersons(Persons personsToMatch) {
        return this.personsCapacity.gte(personsToMatch, this, new NoClassroom());
    }

}
