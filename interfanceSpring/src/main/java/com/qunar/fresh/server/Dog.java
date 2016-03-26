package com.qunar.fresh.server;

import com.qunar.fresh.Abstarct.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gxjun on 16-3-26.
 */
public class Dog implements Animal {
    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(Cat.class);
    }

    private String name;
    private String saywhats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaywhats() {
        return saywhats;
    }

    public void setSaywhats(String saywhats) {
        this.saywhats = saywhats;
    }

    @Override
    public void changeType() {
        //logic
        logger.info(String.format("change to Cat"));
    }

    @Override
    public void say() {

        logger.info(String.format("name = %s   say = %s", name, saywhats));
    }
}
