/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this eTemplate file, choose Tools | Templates
 * and open the eTemplate in the editor.
 */
package com.abc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class EmployeeDao {

	SessionFactory mysessionFactory;

	public SessionFactory getMysessionFactory() {
		return mysessionFactory;
	}

	public void setMysessionFactory(SessionFactory mysessionFactory) {
		this.mysessionFactory = mysessionFactory;
	}

public void saveEmployee(Employee e){
	mysessionFactory.getCurrentSession().persist(e);
}

public void updateEmployee(Employee e){
	mysessionFactory.getCurrentSession().merge(e);
}


public void deleteEmployee(Employee e){
	mysessionFactory.getCurrentSession().remove(e);
}


public List<?> queryEmployee(){
	List<?> el = mysessionFactory.getCurrentSession().createQuery("FROM Employee",Employee.class).list();
        return el;
}

	public void saveEmployeesInBatches(List<Employee> employees, int batchSize) {
		Session session = mysessionFactory.getCurrentSession();
		int count = 0;
		for (Employee employee : employees) {
			session.persist(employee);
			count++;
			if (count % batchSize == 0) {
				session.flush();
				session.clear();
			}
		}
	}
}
