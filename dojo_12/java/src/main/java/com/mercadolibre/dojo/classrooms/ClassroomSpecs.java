package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.classrooms.specs.*;

public class ClassroomSpecs {

    private Persons personsCapacity;
    private SquareMeters squareMetersCapacity;
    private Computers computers = new NoComputers();
    private BlackBoard blackBoard = new NoBlackBoard();

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this.personsCapacity = personsCapacity;
        this.squareMetersCapacity = squareMetersCapacity;
    }

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity, Computers computers) {
        this(personsCapacity, squareMetersCapacity);
        this.computers = computers;
    }

    public ClassroomSpecs(Persons personsCapacity, SquareMeters squareMetersCapacity, BlackBoard blackBoard) {
        this(personsCapacity, squareMetersCapacity);
        this.blackBoard = blackBoard;
    }

    public IClassroom returnIfGTEPersonsOrElse(Persons persons, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.personsCapacity.gte(persons, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom returnIfGTESquareMetersOrElse(SquareMeters squareMeters, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.squareMetersCapacity.gte(squareMeters, classroomIfMatches, classroomIfDoesNotMatches);
    }

    public IClassroom hasComputersOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return this.computers.hasOrElse(classroomIfHas, classroomIfDoesNotHas);
    }

    public IClassroom hasBlackBoardOrElse(Classroom classroomIfHas, IClassroom classroomIfDoesNotHas) {
        return this.blackBoard.hasOrElse(classroomIfHas, classroomIfDoesNotHas);
    }

    public IClassroom returnIfLTSquareMetersOrElse(SquareMeters squareMeters, Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches) {
        return this.squareMetersCapacity.lt(squareMeters, classroomIfMatches, classroomIfDoesNotMatches);
    }
}
