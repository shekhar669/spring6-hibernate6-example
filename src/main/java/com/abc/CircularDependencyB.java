package com.abc;

import org.springframework.context.annotation.Lazy;

public class CircularDependencyB {

    private CircularDependencyA circA;

    public CircularDependencyB( ) {

    }
    public CircularDependencyA getCircA() {
        return circA;
    }

    public void setCircA(CircularDependencyA circA) {
        this.circA = circA;
    }


}
