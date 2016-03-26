package com.qunar.fresh.server;

import com.qunar.fresh.Abstarct.Animal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gxjun on 16-3-26.
 */
public class Main {

    public static  void main(String [] args){

        ApplicationContext ac  = new ClassPathXmlApplicationContext("/Beans.xml");
        Animal an = (Animal) ac.getBean("Cat");

        an.say();
        an.changeType();
        an = (Animal) ac.getBean("Dog");
        an.say();
        an.changeType();
    }

}
