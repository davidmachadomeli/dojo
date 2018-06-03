package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.classroomSpecs.*;
import com.mercadolibre.dojo.Label;

public class Classroom implements IClassroom {

    private Label label;
    private Persons personsCapacity;
    private SquareMeters squareMetersCapacity;
    private Computers computers = new NoComputers();

    public Classroom(Label label, Persons personsCapacity) {
        this.label = label;
        this.personsCapacity = personsCapacity;
    }

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this(label, personsCapacity);
        this.squareMetersCapacity = squareMetersCapacity;
    }

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity, Computers computers) {
        this(label, personsCapacity);
        this.squareMetersCapacity = squareMetersCapacity;
        this.computers = computers;
    }

    public Classroom(Label label, Persons persons, Computers computers) {
        this(label, persons);
        this.computers = computers;
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfMatchesCondition(ClassroomSpec specToMatch) {
        return specToMatch.returnIfMatchesCondition(this);
    }

    public IClassroom returnIfHasAtLeastAsManyPersons(Persons personsToMatch) {
        return this.personsCapacity.gte(personsToMatch, this, new NoClassroom());
    }

    public IClassroom returnIfHasAtLeastAsManySquareMeters(SquareMeters squareMetersToMatch) {
        return this.squareMetersCapacity.gte(squareMetersToMatch, this, new NoClassroom());
    }

    public IClassroom hasComputers() {
        return this.computers.hasComputersOrElse(this, new NoClassroom());
    }
}
