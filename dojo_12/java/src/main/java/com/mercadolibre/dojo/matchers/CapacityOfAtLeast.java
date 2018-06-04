package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.matchers.operations.GTE;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CapacityOfAtLeast implements Matcher {

    private GTE operator;

    public CapacityOfAtLeast(GTE operator) {
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