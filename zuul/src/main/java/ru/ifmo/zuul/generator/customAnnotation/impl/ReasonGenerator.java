package ru.ifmo.zuul.generator.customAnnotation.impl;

import io.dummymaker.bundle.IBundle;
import io.dummymaker.generator.IGenerator;
import ru.ifmo.zuul.generator.Bundles.BundleReasons;

public class ReasonGenerator implements IGenerator<String>{
    private final IBundle<String> bundle = new BundleReasons();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
