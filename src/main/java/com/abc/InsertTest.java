/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

/**
 *
 * @author ADMIN
 */
import java.util.List;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertTest {
public static void main(String[] args) {
	
	//Resource r=new ClassPathResource("applicationContext.xml");
	//BeanFactory factory=new XmlBeanFactory(r);

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    String [] arr={"childapplicationContext.xml"};

    AbstractApplicationContext context2 =
            new ClassPathXmlApplicationContext(arr, false, context);

    context2.addBeanFactoryPostProcessor(new CustomBeanFactoryPostProcessor());

    context2.refresh();
    SessionFactory factory=(SessionFactory) context2.getParent().getBean("mysessionFactory");

    System.out.println("Session Factory### " + factory);

    for (String name: context2.getBeanDefinitionNames()){
        System.out.println("names@@"+ name);
    }

    EmployeeExternalDao dao=(EmployeeExternalDao)context2.getBean("empEx");
	
	Employee e=new Employee();
	//e.setId(251);
	e.setName("Kishore3");
	e.setSalary(8011000);
	
	dao.saveEmployee(e);
	//dao.updateEmployee(e);
        
        List<?> empl = dao.queryEmployee();
        
        for(Object eobj:empl)
        {
            Employee etmp = (Employee)eobj;
            
            System.out.println(etmp.getName()+" "+etmp.getSalary());
        }
}
}
