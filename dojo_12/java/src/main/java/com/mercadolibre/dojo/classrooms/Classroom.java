package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.classrooms.specs.BlackBoard;
import com.mercadolibre.dojo.classrooms.specs.Computers;
import com.mercadolibre.dojo.classrooms.specs.Persons;
import com.mercadolibre.dojo.classrooms.specs.SquareMeters;
import com.mercadolibre.dojo.matchers.operations.GTE;
import com.mercadolibre.dojo.matchers.operations.HAS;

public class Classroom implements IClassroom {

    private Label label;
    private ClassroomSpecs specs;

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity) {
        this.label = label;
        this.specs = new ClassroomSpecs(personsCapacity, squareMetersCapacity);
    }

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity, Computers computers) {
        this.label = label;
        this.specs = new ClassroomSpecs(personsCapacity, squareMetersCapacity, computers);
    }

    public Classroom(Label label, Persons personsCapacity, SquareMeters squareMetersCapacity, BlackBoard blackBoard) {
        this.label = label;
        this.specs = new ClassroomSpecs(personsCapacity, squareMetersCapacity, blackBoard);
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfMatchesCondition(GTE conditionToMatch) {
        return conditionToMatch.gte(this.specs, this, new NoClassroom());
    }

    public IClassroom returnIfMatchesCondition(HAS operator) {
        return operator.returnIfHasOrElse(this.specs, this, new NoClassroom());
    }

}
