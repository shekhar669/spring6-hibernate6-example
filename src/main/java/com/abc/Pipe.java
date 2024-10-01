package com.abc;

import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;

public class Pipe {
    private String sourceTypeName;

    public Pipe() {
    }


    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }
}
