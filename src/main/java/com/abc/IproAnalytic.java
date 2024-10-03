package com.abc;

import com.abc.analytics.Pipe;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Set;


public class IproAnalytic implements ApplicationContextAware {

    ApplicationContext context;
    public IproAnalytic() {
    }
  /*  private Set<ObjectFactory<Pipe>> pipes;


    public Object getPipes() {
        return pipes.iterator().next().getObject();
    }

    public void setPipes(Set<ObjectFactory<Pipe>> pipes) {
        this.pipes = pipes;
    }*/
    private Set<Pipe> pipes;

    public Set<Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(Set<Pipe> pipes) {
        this.pipes = pipes;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
