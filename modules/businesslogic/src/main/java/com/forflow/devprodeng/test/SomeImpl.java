package com.forflow.devprodeng.test;

import javax.inject.Singleton;

@Singleton
public class SomeImpl implements SomeAPI{
    @Override
    public String importantBusinessCalculation() {
        return "This is the result";
    }
}
