package com.test.fresh.server;

import com.test.fresh.Bean.animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gxjun on 16-3-26.
 */
public class Talk{

    public  static  void main(String[] args){

        ApplicationContext  ac  = new ClassPathXmlApplicationContext("/spring-bean.xml");
        animal an = (animal) ac.getBean("gxjun");
        an.action();
    }

 }
