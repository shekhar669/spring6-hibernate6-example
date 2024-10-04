package com.abc;

public class BeanB {
    private BeanA beanA;

    public BeanB() {
        // No-arg constructor
    }

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }
}
