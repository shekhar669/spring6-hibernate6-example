package com.abc;

public class RefBean {
    private String name="ref bean";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RefBean() {
    }

    public RefBean(String name) {
        this.name = name;
    }
}
