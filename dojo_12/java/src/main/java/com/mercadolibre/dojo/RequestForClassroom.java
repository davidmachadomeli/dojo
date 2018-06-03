package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;
import com.mercadolibre.dojo.matchers.Matcher;

import java.util.List;

public class RequestForClassroom {

    private Matcher matcher;

    public RequestForClassroom(Matcher matcher) {
        this.matcher = matcher;
    }

    public IClassroom searchMatchingFrom(List<Classroom> classrooms) {
        return this.matcher.returnListOfMatchingClassrooms(classrooms)
                .stream()
                .reduce(new NoClassroom(), Challenger::challenge);
    }

}
