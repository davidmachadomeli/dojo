package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CapacityOfAtLeast implements Matcher {

    private Persons persons;

    public CapacityOfAtLeast(Persons persons) {
        this.persons = persons;
    }

    @Override
    public List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        return classrooms
                .stream()
                .map(classroom -> classroom.returnIfHasAtLeastAsManyPersons(this.persons))
                .collect(toList());
    }

}