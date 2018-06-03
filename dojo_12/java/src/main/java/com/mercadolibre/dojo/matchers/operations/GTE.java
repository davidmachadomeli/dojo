package com.mercadolibre.dojo.matchers.operations;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;

public interface GTE {

    IClassroom gte(ClassroomSpecs specs, Classroom classroomIfMatchs, IClassroom classroomIfDoesNotMatches);

}
