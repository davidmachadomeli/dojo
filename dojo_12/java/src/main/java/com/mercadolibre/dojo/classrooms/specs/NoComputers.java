package com.mercadolibre.dojo.classrooms.specs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

public class NoComputers extends Computers {

    @Override
    public IClassroom hasOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return classroomIfDoesNotHas;
    }

}
