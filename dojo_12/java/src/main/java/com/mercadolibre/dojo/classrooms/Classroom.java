package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.classrooms.specs.Persons;
import com.mercadolibre.dojo.classrooms.specs.SquareMeters;
import com.mercadolibre.dojo.matchers.operations.GTE;

public class Classroom implements IClassroom {

    private ClassroomSpecs specs;

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this.specs = new ClassroomSpecs(personsCapacity, squareMetersCapacity);
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfHasAtLeastAsMany(GTE conditionToMatch) {
        return conditionToMatch.gte(this.specs, this, new NoClassroom());
    }

}
