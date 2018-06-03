package com.mercadolibre.dojo.matchers;

import com.mercadolibre.dojo.classroomSpecs.ClassroomSpec;
import com.mercadolibre.dojo.classrooms.Classroom;
import com.mercadolibre.dojo.classrooms.IClassroom;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CapacityOfAtLeast implements Matcher {

    private ClassroomSpec spec;

    public CapacityOfAtLeast(ClassroomSpec spec) {
        this.spec = spec;
    }

    @Override
    public List<IClassroom> returnListOfMatchingClassrooms(List<Classroom> classrooms) {
        return classrooms
                .stream()
                .map(classroom -> classroom.returnIfHasAtLeastAsMany(this.spec))
                .collect(toList());
    }

}
