package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;

public interface Matcher {

    List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms);

}
