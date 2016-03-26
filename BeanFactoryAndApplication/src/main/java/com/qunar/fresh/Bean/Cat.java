package com.qunar.fresh.Bean;

/**
 * Created by gxjun on 16-3-26.
 */
public class Cat {

    public String name;

    public Cat() {

        super();
        System.out.println("Cat is created !");
    }

    public Cat(String name) {
        this.name = name;
        System.out.println("cat is created and name!");
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
