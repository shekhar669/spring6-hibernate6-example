package com.abc;

import java.util.Set;

public class PipeManager {
    private Pipe pipe1;

    public PipeManager() {
    }

    private Set<Pipe> pipes;

    // Getter and Setter for pipe1
    public Pipe getPipe1() {
        return pipe1;
    }

    public void setPipe1(Pipe pipe1) {
        this.pipe1 = pipe1;
    }

    // Getter and Setter for pipes (if needed)
    public Set<Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(Set<Pipe> pipes) {
        this.pipes = pipes;
    }

}
