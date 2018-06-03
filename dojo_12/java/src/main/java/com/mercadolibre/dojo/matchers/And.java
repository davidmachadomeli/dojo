package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class And implements Matcher {

    private List<Matcher> matchers;

    public And(Matcher... matchers) {
        this.matchers = asList(matchers);
    }

    @Override
    public List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        final List<List<IClassroom>> listOfClassrooms = this.getListOfListOfClassroomsFromMatchers(classrooms);
        return new ArrayList<>(this.getIntersectionOfListOfListOfClassroomsThatMatched(listOfClassrooms));
    }

    private Set<IClassroom> getIntersectionOfListOfListOfClassroomsThatMatched(List<List<IClassroom>> listOfClassrooms) {
        final Set<IClassroom> intersectionSet = new HashSet<>();
        intersectionSet.addAll(this.findFirstClassroomsMatchesOrElseEmptyList(listOfClassrooms));
        listOfClassrooms.forEach(x -> intersectionSet.retainAll(new HashSet<>(x)));
        return intersectionSet;
    }

    private List<List<IClassroom>> getListOfListOfClassroomsFromMatchers(List<Classroom> classrooms) {
        return this.matchers
                .stream()
                .map(matcher -> matcher.returnListOfMatchingClassrooms(classrooms))
                .collect(toList());
    }

    private List<IClassroom> findFirstClassroomsMatchesOrElseEmptyList(List<List<IClassroom>> listOfClassrooms) {
        return listOfClassrooms
                .stream()
                .findFirst()
                .orElse(new ArrayList<>());
    }

}
