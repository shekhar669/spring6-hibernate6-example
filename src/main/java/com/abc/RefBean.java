package com.abc;

public class RefBean {
    private String name="ref bean";
    private EmployeeExternalDao parent;

    public EmployeeExternalDao getParent() {
        return parent;
    }

    public void setParent(EmployeeExternalDao parent) {
        this.parent = parent;
    }

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
