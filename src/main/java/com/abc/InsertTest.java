/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc;

/**
 *
 * @author shekhar
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import com.jillesvangurp.springdepend.SpringDependencyAnalyzer;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class InsertTest {
public static void main(String[] args) {
	
	//Resource r=new ClassPathResource("applicationContext.xml");
	//BeanFactory factory=new XmlBeanFactory(r);

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    String [] arr={"childapplicationContext.xml"};

    AbstractApplicationContext context2 =
            new ClassPathXmlApplicationContext(arr, false, context);

    CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor= new CustomBeanFactoryPostProcessor();
    context2.addBeanFactoryPostProcessor(customBeanFactoryPostProcessor);
    context2.refresh();
    SessionFactory factory=(SessionFactory) context2.getBean("mysessionFactory");

    System.out.println("Session Factory### " + factory);

    for (String name: context.getBeanDefinitionNames()){
        System.out.println("parent context@@"+ name);
    }

    for (String name: context2.getBeanDefinitionNames()){
        System.out.println("child context@@"+ name);
    }

    EmployeeExternalDao dao=(EmployeeExternalDao)context2.getBean("empEx");
    CircularDependencyA exta=(CircularDependencyA)context2.getBean("cira");
    System.out.println("ext" +exta);
    IproAnalytic IproAnalytic=(IproAnalytic)context2.getBean("iproSolutionAnalytic");
    System.out.println("IproAnalytic###############" +IproAnalytic.getPipes());

    Employee e=new Employee();
	//e.setId(251);
	e.setName("Kishore"+ new Random().nextInt());
	e.setSalary(8011000);
	//dao.saveEmployee(e);
	//dao.updateEmployee(e);
      List<?> empl = dao.queryEmployee();
        
        for(Object eobj:empl)
        {
            Employee etmp = (Employee)eobj;
            System.out.println(etmp.getName()+" "+etmp.getSalary());
        }

}

}


