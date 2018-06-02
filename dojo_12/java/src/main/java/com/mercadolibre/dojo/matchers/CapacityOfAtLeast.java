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
    public IClassroom returnIfMatchesOrElse(Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return classroomIfMatches.returnIfHasAtLeastAsManyPersonsOrElse(this.persons, classroomIfDoesNotMatches);
    }
}
