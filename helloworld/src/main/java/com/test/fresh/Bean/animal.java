package com.test.fresh.Bean;

import com.test.fresh.Abstract.Action;

/**
 * Created by gxjun on 16-3-26.
 */
public class animal implements Action {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void action() {
        System.out.println("name: ="+name);
    }
}
