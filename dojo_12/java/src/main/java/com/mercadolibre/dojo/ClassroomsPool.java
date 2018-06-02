package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;

import static java.util.Arrays.asList;

public class ClassroomsPool {

    private List<Classroom> classrooms;

    public ClassroomsPool(Classroom... classrooms) {
        this.classrooms = asList(classrooms);
    }

    public IClassroom searchClassroomFor(Requisition requisition) {
        return requisition.searchMatchingClassroomFrom(this.classrooms);
    }

}
