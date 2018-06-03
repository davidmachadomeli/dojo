package com.mercadolibre.dojo.conditions;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.conditions.operations.GTE;

public class Persons implements GTE {

    private Integer quantity;

    public Persons(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public IClassroom returnIfGTEOrElse(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return specs.returnIfHasAtLeastAsManyPersons(this, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom gte(Persons personsToMatch, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return this.quantity >= personsToMatch.quantity ? classroomIfGTE : classroomIfNotGTE;
    }

}
