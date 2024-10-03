package com.abc.analytics;

import com.abc.IproAnalytic;

public class Pipe {
    private IproAnalytic source;

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

    public IproAnalytic getSource() {
        return source;
    }

    public void setSource(IproAnalytic source) {
        this.source = source;
    }
}
