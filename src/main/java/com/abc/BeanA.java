package com.abc;

import java.util.Set;
import com.abc.analytics.Pipe;

public class BeanA {
    private Set<Pipe> beanBSet;

    public BeanA() {
        // No-arg constructor
    }

    public Set<Pipe> getBeanBSet() {
        return beanBSet;
    }

    public void setBeanBSet(Set<Pipe> beanBSet) {
        this.beanBSet = beanBSet;
    }
}
