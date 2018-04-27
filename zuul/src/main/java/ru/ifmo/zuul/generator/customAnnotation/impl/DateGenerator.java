package ru.ifmo.zuul.generator.customAnnotation.impl;

import io.dummymaker.generator.IGenerator;

import java.util.Random;

public class DateGenerator implements IGenerator<Integer> {

    @Override
    public Integer generate() {
        int maxNumber = 55;

        Random r = new Random();
        return r.nextInt(maxNumber)+1;
    }
}
