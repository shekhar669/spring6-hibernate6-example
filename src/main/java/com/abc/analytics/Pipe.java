package com.abc.analytics;

import com.abc.BeanA;
import com.abc.IproAnalytic;

public class Pipe {
    private BeanA source;


    public Pipe() {
    }

    private String sourceTypeName;
    private String sinkTypeName;

    public String getSinkTypeName() {
        return sinkTypeName;
    }

    public void setSinkTypeName(String sinkTypeName) {
        this.sinkTypeName = sinkTypeName;
    }

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }


    public BeanA getSource() {
        return source;
    }

    public void setSource(BeanA source) {
        this.source = source;
    }
}
