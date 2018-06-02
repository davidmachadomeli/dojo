package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.matchers.Matcher;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Requisition {

    private Matcher matcher;

    public Requisition(Matcher matcher) {
        this.matcher = matcher;
    }

    public IClassroom searchMatchingClassroomFrom(List<Classroom> classrooms) {
        return this.classroomsAvailableForRequisition(classrooms)
                .stream()
                .reduce(new NoClassroom(), Challenger::challenge);
    }

    private List<IClassroom> classroomsAvailableForRequisition(List<Classroom> classrooms) {
        return classrooms
                .stream()
                .map(classroom -> classroom.returnIfMatchesOrElse(this.matcher, new NoClassroom()))
                .collect(toList());
    }

}
