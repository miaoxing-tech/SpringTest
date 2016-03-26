package com.qunar.fresh.server;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gxjun on 16-3-26.
 */
public class Main {

    public static void main(String [] args){

        //当我们实例化beans.xml　该文件中配置的bean实例化
    //    ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml") ;


        BeanFactory fb = new XmlBeanFactory( new ClassPathResource("Beans.xml"));

        //当我们调用getBean时，Bean才会被实例化,延时话

        fb.getBean("gxjun");
    }
}
