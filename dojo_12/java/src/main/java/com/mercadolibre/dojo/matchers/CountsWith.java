package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.conditions.operations.HAS;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CountsWith implements Matcher {

    private HAS operator;

    public CountsWith(HAS operator) {
        this.operator = operator;
    }

    @Override
    public List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        return classrooms
                .stream()
                .map(classroom -> classroom.returnIfMatchesCondition(this.operator))
                .collect(toList());
    }
}
