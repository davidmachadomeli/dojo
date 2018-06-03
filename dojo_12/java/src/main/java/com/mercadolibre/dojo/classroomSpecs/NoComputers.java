package com.mercadolibre.dojo.classroomSpecs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

public class NoComputers extends Computers {

    public IClassroom hasComputersOrElse(Classroom classroom, NoClassroom noClassroom) {
        return noClassroom;
    }

}
