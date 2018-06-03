package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;
import java.util.Set;

public interface Matcher {

    Set<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms);

}
