/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this eTemplate file, choose Tools | Templates
 * and open the eTemplate in the editor.
 */
package com.abc;

/**
 *
 * @author ADMIN
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDao {
HibernateTemplate eTemplate;

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
}
