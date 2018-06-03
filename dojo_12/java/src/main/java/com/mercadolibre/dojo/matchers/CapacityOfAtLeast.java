package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CapacityOfAtLeast implements Matcher {

    private Persons persons;

    public CapacityOfAtLeast(Persons persons) {
        this.persons = persons;
    }

    @Override
    public Set<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        return classrooms
                .stream()
                .map(classroom -> classroom.returnIfHasAtLeastAsManyPersons(this.persons))
                .collect(Collectors.toSet());
    }

}
