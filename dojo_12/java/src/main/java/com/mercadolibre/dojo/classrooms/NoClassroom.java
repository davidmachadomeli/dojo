package com.mercadolibre.dojo.classrooms;

public class NoClassroom implements IClassroom {

    public NoClassroom() {}

    @Override
    public IClassroom challenge(IClassroom challengerObject) {
        return challengerObject;
    }

}
