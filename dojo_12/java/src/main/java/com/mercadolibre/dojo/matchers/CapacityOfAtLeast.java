package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

public class CapacityOfAtLeast implements Matcher {

    private Persons persons;

    public CapacityOfAtLeast(Persons persons) {
        this.persons = persons;
    }

    @Override
    public IClassroom findIfMatchesOrElse(Classroom classroom, NoClassroom noClassroom) {
        return classroom.returnIfHasAtLeastPersonsOrElse(persons, noClassroom);
    }
}
