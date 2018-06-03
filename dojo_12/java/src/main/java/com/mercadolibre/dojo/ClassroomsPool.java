package com.mercadolibre.dojo;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

public class ClassroomsPool {

    public ClassroomsPool(Classroom... classrooms) {

    }

    public IClassroom searchClassroomFor(RequestForClassroom requestForClassroom) {
        return new NoClassroom();
    }

}
