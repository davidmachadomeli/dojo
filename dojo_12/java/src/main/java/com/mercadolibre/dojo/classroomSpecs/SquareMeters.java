package com.mercadolibre.dojo.classroomSpecs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

public class SquareMeters implements ClassroomSpec {

    private Integer quantity;

    public SquareMeters(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public IClassroom returnIfMatchesCondition(Classroom classroom) {
        return classroom.returnIfHasAtLeastAsManySquareMeters(this);
    }

    public IClassroom gte(SquareMeters squareMetersToMatch, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return this.quantity >= squareMetersToMatch.quantity ? classroomIfGTE : classroomIfNotGTE;
    }

}
