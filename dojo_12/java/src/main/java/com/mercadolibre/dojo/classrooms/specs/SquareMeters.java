package com.mercadolibre.dojo.classrooms.specs;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.ClassroomSpecs;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.matchers.operations.GTE;
import com.mercadolibre.dojo.matchers.operations.LT;

public class SquareMeters implements GTE, LT {

    private Integer quantity;

    public SquareMeters(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public IClassroom gte(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return specs.returnIfGTESquareMetersOrElse(this, classroomIfMatches, classroomIfDoesNotMatches);
    }

    @Override
    public IClassroom lt(ClassroomSpecs specs, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return specs.returnIfLTSquareMetersOrElse(this, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom gte(SquareMeters squareMetersToMatch, IClassroom classroomIfGTE, IClassroom classroomIfNotGTE) {
        return this.quantity >= squareMetersToMatch.quantity ? classroomIfGTE : classroomIfNotGTE;
    }

    public IClassroom lt(SquareMeters squareMetersToMatch, Classroom classroomIfLT, IClassroom classroomIfNotLT) {
        return this.quantity < squareMetersToMatch.quantity ? classroomIfLT : classroomIfNotLT;
    }

}
