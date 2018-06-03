package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.Challenger;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class Or implements Matcher {

    private List<Matcher> matchers;

    public Or(Matcher... matchers) {
        this.matchers = asList(matchers);
    }

    @Override
    public List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        return singletonList(
                this.getListOfListOfClassroomsFromMatchers(classrooms)
                        .stream()
                        .flatMap(Collection::stream)
                        .reduce(new NoClassroom(), Challenger::challenge)
        );
    }

    private List<List<IClassroom>> getListOfListOfClassroomsFromMatchers(List<Classroom> classrooms) {
        return this.matchers
                .stream()
                .map(matcher -> matcher.returnListOfMatchingClassrooms(classrooms))
                .collect(toList());
    }

}
