package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;
import com.mercadolibre.dojo.classrooms.NoClassroom;

public interface Matcher {

    IClassroom findIfMatchesOrElse(Classroom classroom, NoClassroom noClassroom);

}
