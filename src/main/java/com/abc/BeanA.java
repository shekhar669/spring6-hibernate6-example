package com.abc;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import com.abc.analytics.Pipe;

@Component
public class BeanA implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    private Set<Pipe> beanBSet;

  /*  public Set<Pipe> getBeanBSet() {
        return beanBSet;
    }

    public void setBeanBSet(Set<Pipe> beanBSet) {
        this.beanBSet = beanBSet;
    }*/

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Set<Pipe> getBeanBSet() {
        if (beanBSet == null) {
            beanBSet = applicationContext.getBean("beanBSet", Set.class);
        }
        return beanBSet;
    }
}
