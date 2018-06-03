package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;

import static java.util.Arrays.asList;

public class ClassroomsPool {

    private List<Classroom> availableClassrooms;

    public ClassroomsPool(Classroom... availableClassrooms) {
        this.availableClassrooms = asList(availableClassrooms);
    }

    public IClassroom searchClassroomFor(RequestForClassroom requestForClassroom) {
        return requestForClassroom.searchMatchingFrom(this.availableClassrooms);
    }

}
