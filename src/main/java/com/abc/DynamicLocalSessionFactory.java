package com.abc;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;

public class DynamicLocalSessionFactory extends LocalSessionFactoryBean {
   private BasicDataSource basicDataSource;
    private HibernateTransactionManager transactionManager;
    @Override
    public void afterPropertiesSet() throws IOException{
       this.setDataSource(basicDataSource);
       super.afterPropertiesSet();
    }
    @Override
    public SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
       return  sfb.buildSessionFactory();
    }


    public HibernateTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    public void setBasicDataSource(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}
