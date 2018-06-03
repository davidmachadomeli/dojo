package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.conditions.Computers;
import com.mercadolibre.dojo.conditions.Persons;
import com.mercadolibre.dojo.conditions.SquareMeters;
import com.mercadolibre.dojo.conditions.operations.GTE;
import com.mercadolibre.dojo.conditions.operations.HAS;
import com.mercadolibre.dojo.conditions.operations.LT;

public class Classroom implements IClassroom {

    private Label label;
    private ClassroomSpecs specs;

    public Classroom(Label label, Persons persons) {
        this.label = label;
        this.specs = new ClassroomSpecs(persons);
    }

    public Classroom(Label label, Persons persons, SquareMeters squareMeters) {
        this.label = label;
        this.specs = new ClassroomSpecs(persons, squareMeters);
    }

    public Classroom(Label label, Persons persons, SquareMeters squareMeters, Computers computers) {
        this.label = label;
        this.specs = new ClassroomSpecs(persons, squareMeters, computers);
    }

    public Classroom(Label label, Persons persons, Computers computers) {
        this.label = label;
        this.specs = new ClassroomSpecs(persons, computers);
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfMatchesCondition(GTE operator) {
        return operator.returnIfGTEOrElse(this.specs, this, new NoClassroom());
    }

    public IClassroom returnIfMatchesCondition(LT operator) {
        return operator.returnIfLTOrElse(this.specs, this, new NoClassroom());
    }

    public IClassroom returnIfMatchesCondition(HAS operator) {
        return operator.returnIfHasOrElse(this.specs, this, new NoClassroom());
    }

}
