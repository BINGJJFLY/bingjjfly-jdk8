package com.wjz.jdk.argsname;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ArgsName {

    public static void main(String[] args) {
        try {
            Method method = ArgsName.class.getMethod("main", String[].class);
            for (Parameter p: method.getParameters()
                 ) {
                System.out.println( "Parameter: " + p.getName() );
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
