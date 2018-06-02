package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.IClassroom;

public class Persons {

    private Integer quantity;

    public Persons(Integer quantity) {
        this.quantity = quantity;
    }

    public IClassroom gte(Persons personsToMatch, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return this.quantity >= personsToMatch.quantity ? classroomIfGTE : classroomIfNotGTE;
    }

}
