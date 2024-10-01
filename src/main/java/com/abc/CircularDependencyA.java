package com.abc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class CircularDependencyA {
    public CircularDependencyA() {

    }
    private CircularDependencyB circB;
    public CircularDependencyB getCircB() {
        return circB;
    }

    public void setCircB(CircularDependencyB circB) {
        this.circB = circB;
    }

}