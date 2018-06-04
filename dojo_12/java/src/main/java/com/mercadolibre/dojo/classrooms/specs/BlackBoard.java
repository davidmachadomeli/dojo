package com.mercadolibre.dojo.classrooms.specs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.matchers.operations.HAS;

public class BlackBoard implements HAS {

    @Override
    public IClassroom returnIfHasOrElse(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return specs.hasBlackBoardOrElse(classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom hasOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return classroomIfHas;
    }

}