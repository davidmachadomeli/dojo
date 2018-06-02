package com.mercadolibre.dojo.classrooms;

import com.mercadolibre.dojo.Label;
import com.mercadolibre.dojo.Persons;
import com.mercadolibre.dojo.matchers.Matcher;

public class Classroom implements IClassroom {

    private Label label;
    private Persons personsCapacity;

    public Classroom(Label label, Persons personsCapacity) {
        this.label = label;
        this.personsCapacity = personsCapacity;
    }

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return this;
    }

    public IClassroom returnIfMatchesOrElse(Matcher matcher, IClassroom classroomIfDoesNotMatches) {
        return matcher.returnIfMatchesOrElse(this, classroomIfDoesNotMatches);
    }

    public IClassroom returnIfHasAtLeastAsManyPersonsOrElse(Persons personsToMatch, IClassroom classroomIfDoesNotMatches) {
        return this.personsCapacity.gte(personsToMatch, this, classroomIfDoesNotMatches);
    }

}
