package com.abc;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeExternalDao {
   private Set<RefBean> pipes= new HashSet<>();
    HibernateTemplate eTemplate;

    public EmployeeExternalDao() {
    }

    public SessionFactory getMysessionFactory() {
        return mysessionFactory;
    }

    public void setMysessionFactory(SessionFactory mysessionFactory) {
        this.mysessionFactory = mysessionFactory;
    }

    SessionFactory mysessionFactory;


    @Transactional(readOnly=false)
    public void saveEmployee(Employee e){
        mysessionFactory.getCurrentSession().persist(e);
    }

    @Transactional(readOnly=false)
    public void updateEmployee(Employee e){
        mysessionFactory.getCurrentSession().merge(e);
    }

    @Transactional(readOnly=false)
    public void deleteEmployee(Employee e){
        mysessionFactory.getCurrentSession().remove(e);
    }

  @Transactional(readOnly=false)
    public List<?> queryEmployee(){
        List<?> el = mysessionFactory.getCurrentSession().createQuery("FROM Employee",Employee.class).list();
        return el;
    }

    public Set<RefBean> getPipes() {
        return pipes;
    }

    public void setPipes(Set<RefBean> pipes) {
        this.pipes = pipes;
    }
}
