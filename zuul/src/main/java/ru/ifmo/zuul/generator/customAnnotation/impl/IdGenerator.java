package ru.ifmo.zuul.generator.customAnnotation.impl;

import io.dummymaker.generator.IGenerator;

import java.util.Random;

public class IdGenerator implements IGenerator<Integer>{
    @Override
    public Integer generate() {
        int maxNumber = 2000000;

        Random r = new Random();
        return r.nextInt(maxNumber)+1;
    }
}
