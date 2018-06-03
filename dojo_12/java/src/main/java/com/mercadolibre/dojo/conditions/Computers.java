package com.mercadolibre.dojo.conditions;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.conditions.operations.HAS;

public class Computers implements HAS {

    @Override
    public IClassroom returnIfHasOrElse(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return specs.hasComputersOrElse(classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom hasOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return classroomIfHas;
    }

}
