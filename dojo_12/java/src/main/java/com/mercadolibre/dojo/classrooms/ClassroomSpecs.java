package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.classrooms.specs.Persons;
import com.mercadolibre.dojo.classrooms.specs.SquareMeters;

public class ClassroomSpecs {

    private Persons personsCapacity;
    private SquareMeters squareMetersCapacity;

    public ClassroomSpecs(Persons personsCapacity) {
        this.personsCapacity = personsCapacity;
    }

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this.personsCapacity = personsCapacity;
        this.squareMetersCapacity = squareMetersCapacity;
    }

    public IClassroom returnIfGTEPersonsOrElse(Persons persons, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.personsCapacity.gte(persons, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom returnIfGTESquareMetersOrElse(SquareMeters squareMeters, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.squareMetersCapacity.gte(squareMeters, classroomIfMatches, classroomIfDoesNotMatches);
    }

}
