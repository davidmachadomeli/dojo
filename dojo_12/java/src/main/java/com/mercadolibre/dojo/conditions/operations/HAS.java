package com.mercadolibre.dojo.conditions.operations;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;

public interface HAS {

    IClassroom returnIfHasOrElse(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches);

}
