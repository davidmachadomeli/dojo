package com.mercadolibre.dojo.classroomSpecs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

public interface ClassroomSpec {

    IClassroom returnIfHasAtLeastAsMany(Classroom classroom);

}
