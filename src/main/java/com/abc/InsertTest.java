package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.abc.analytics.EmployeeService;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InsertTest {
public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    String [] arr={"childapplicationContext.xml"};

    AbstractApplicationContext context2 =
            new ClassPathXmlApplicationContext(arr, false, context);

    CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor= new CustomBeanFactoryPostProcessor();
    context2.addBeanFactoryPostProcessor(customBeanFactoryPostProcessor);
    context2.refresh();

    SessionFactory factory=(SessionFactory) context2.getBean("mysessionFactory");

    EmployeeService empService=(EmployeeService)context2.getBean("empService");
    List<Employee> empList= new ArrayList<>();
    for (int i=0;i<10;i++) {
        Employee e = new Employee();
        //e.setId(251);
        e.setName("Kishore"+i +" ran"+ new Random().nextInt());
        e.setSalary(8011000);
        empList.add(e);
    }
      empService.evaluate(empList,5);
      List<?> empl = empService.getEmployees();
       for(Object eobj:empl)
        {
            Employee etmp = (Employee)eobj;
            System.out.println(etmp.getName()+" "+etmp.getSalary());
        }

}

}


