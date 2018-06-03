package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.classroomSpecs.ClassroomSpec;
import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.classroomSpecs.Persons;
import com.mercadolibre.dojo.classroomSpecs.SquareMeters;

public class Classroom implements IClassroom {

    private Label label;
    private Persons personsCapacity;
    private SquareMeters squareMetersCapacity;

    public Classroom(Label label, Persons personsCapacity) {
        this.label = label;
        this.personsCapacity = personsCapacity;
    }

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this(label, personsCapacity);
        this.squareMetersCapacity = squareMetersCapacity;
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfHasAtLeastAsMany(ClassroomSpec specToMatch) {
        return specToMatch.returnIfHasAtLeastAsMany(this);
    }

    public IClassroom returnIfHasAtLeastAsManyPersons(Persons personsToMatch) {
        return this.personsCapacity.gte(personsToMatch, this, new NoClassroom());
    }

    public IClassroom returnIfHasAtLeastAsManySquareMeters(SquareMeters squareMetersToMatch) {
        return this.squareMetersCapacity.gte(squareMetersToMatch, this, new NoClassroom());
    }

}
