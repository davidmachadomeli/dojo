package com.mercadolibre.dojo.classroomSpecs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

public class Computers implements ClassroomSpec {

    @Override
    public IClassroom returnIfMatchesCondition(Classroom classroom) {
        return classroom.hasComputers();
    }

    public IClassroom hasComputersOrElse(Classroom classroom, NoClassroom noClassroom) {
        return classroom;
    }

}
