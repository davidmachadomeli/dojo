package com.mercadolibre.dojo.classroomSpecs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

public class Persons implements ClassroomSpec {

    private Integer quantity;

    public Persons(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public IClassroom returnIfMatchesCondition(Classroom classroom) {
        return classroom.returnIfHasAtLeastAsManyPersons(this);
    }

    public IClassroom gte(Persons personsToMatch, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return this.quantity >= personsToMatch.quantity ? classroomIfGTE : classroomIfNotGTE;
    }
}
