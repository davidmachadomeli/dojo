package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

public interface Matcher {

    IClassroom returnIfMatchesOrElse(Classroom classroomIfMatches, IClassroom classroomIfDoesNotMatches);

}
