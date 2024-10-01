package com.abc;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

   // @Override
    public void postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory) {
        // Cast to BeanDefinitionRegistry to access bean definitions

       /* if (beanFactory instanceof BeanDefinitionRegistry) {
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;

            // Create an XmlBeanDefinitionReader to load additional configurations
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

            // Specify the additional classpath XML configuration resources to load
            Resource resource1 = new ClassPathResource("additional-config-1.xml");
            //Resource resource2 = new ClassPathResource("additional-config-2.xml");

            // Load the additional bean definitions into the registry
            reader.loadBeanDefinitions(resource1);
           // reader.loadBeanDefinitions(resource2);

            System.out.println("Additional bean definitions loaded from XML resources.");
        }*/
        loadAdditionalBeanDefinition(beanFactory);

    }


    public void loadAdditionalBeanDefinition(ConfigurableListableBeanFactory beanFactory){
        DefaultListableBeanFactory beanFactoryA = (DefaultListableBeanFactory) beanFactory;
        //beanFactoryA.setAllowCircularReferences(true);
        // Create an XmlBeanDefinitionReader to load additional configurations
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactoryA);
        // Specify the additional classpath XML configuration resources to load
        Resource resource1 = new ClassPathResource("additional-config-1.xml");
        //Resource resource2 = new ClassPathResource("additional-config-2.xml");
        // Load the additional bean definitions into the registry
        reader.loadBeanDefinitions(resource1);
        // reader.loadBeanDefinitions(resource2);
        System.out.println("Additional bean definitions loaded from XML resources.");
    }

}
