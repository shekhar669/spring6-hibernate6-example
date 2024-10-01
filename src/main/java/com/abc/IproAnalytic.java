package com.abc;

import org.springframework.beans.factory.ObjectFactory;

import java.util.Map;
import java.util.Set;


public class IproAnalytic {
    public IproAnalytic() {
    }
    private Set<ObjectFactory<Pipe>> pipes;


    public Object getPipes() {
        return pipes.iterator().next().getObject();
    }

    public void setPipes(Set<ObjectFactory<Pipe>> pipes) {
        this.pipes = pipes;
    }
}
