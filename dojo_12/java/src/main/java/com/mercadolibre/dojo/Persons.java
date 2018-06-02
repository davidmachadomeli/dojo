package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.IClassroom;

public class Persons {

    private Integer quantityOfPersons;

    public Persons(Integer quantityOfPersons) {
        this.quantityOfPersons = quantityOfPersons;
    }

    public IClassroom gte(Persons persons, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return persons.gte(this.quantityOfPersons, classroomIfGTE, classroomIfNotGTE);
    }

    public IClassroom gte(Integer quantityOfPersons, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return quantityOfPersons >= this.quantityOfPersons ? classroomIfGTE : classroomIfNotGTE;
    }

}
