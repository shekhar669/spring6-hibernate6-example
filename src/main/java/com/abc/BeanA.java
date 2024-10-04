package com.abc;

import java.util.Set;

public class BeanA {
    private Set<BeanB> beanBSet;

    public BeanA() {
        // No-arg constructor
    }

    public Set<BeanB> getBeanBSet() {
        return beanBSet;
    }

    public void setBeanBSet(Set<BeanB> beanBSet) {
        this.beanBSet = beanBSet;
    }
}
