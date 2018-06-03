package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.conditions.*;

public class ClassroomSpecs {

    private Persons personsCapacity;
    private SquareMeters squareMetersCapacity;
    private Computers computers = new NoComputers();

    public ClassroomSpecs(Persons personsCapacity) {
        this.personsCapacity = personsCapacity;
    }

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this(personsCapacity);
        this.squareMetersCapacity = squareMetersCapacity;
    }

    public ClassroomSpecs(Persons personsCapacity, Computers computers) {
        this(personsCapacity);
        this.computers = computers;
    }

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity, Computers computers) {
        this(personsCapacity, squareMetersCapacity);
        this.computers = computers;
    }

    public IClassroom hasComputersOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return this.computers.hasOrElse(classroomIfHas, classroomIfDoesNotHas);
    }

    public IClassroom returnIfHasAtLeastAsManyPersons(Persons personsToMatch, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.personsCapacity.gte(personsToMatch, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom returnIfHasAtLeastAsManySquareMeters(SquareMeters squareMetersToMatch, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.squareMetersCapacity.gte(squareMetersToMatch, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom returnIfHasLessThanAsManySquareMeters(SquareMeters squareMetersToMatch, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.squareMetersCapacity.lt(squareMetersToMatch, classroomIfMatches, classroomIfDoesNotMatches);
    }

}
