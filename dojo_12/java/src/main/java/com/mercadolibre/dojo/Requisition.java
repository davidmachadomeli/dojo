package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.matchers.Matcher;

import java.util.List;

public class Requisition {

    private Matcher matcher;

    public Requisition(Matcher matcher) {
        this.matcher = matcher;
    }

    public IClassroom searchMatchingClassroomFrom(List<Classroom> classrooms) {
        return this.matcher.returnListOfMatchingClassrooms(classrooms)
                .stream()
                .reduce(new NoClassroom(), Challenger::challenge);
    }

}
