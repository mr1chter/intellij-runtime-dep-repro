package com.forflow.devprodeng.test;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.ejb.Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Weld weld = new Weld();
        System.out.println("java classpath: " + System.getProperty("java.class.path"));

//        Main.class.getClassLoader().loadClass("com.forflow.devprodeng.test.SomeAPI");
//        System.out.println("loaded SomeAPI");
//        Main.class.getClassLoader().loadClass("com.forflow.devprodeng.test.SomeImpl");
//        System.out.println("loaded SomeImpl");

        weld.addBeanDefiningAnnotations(Singleton.class);
        try (WeldContainer weldContainer = weld.initialize()) {
            SomeAPI someAPIImplementation = weldContainer.instance().select(SomeAPI.class).get();
            System.out.println("This is important: " + someAPIImplementation.importantBusinessCalculation());
        }
    }
}