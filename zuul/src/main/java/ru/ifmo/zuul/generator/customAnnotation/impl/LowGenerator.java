package ru.ifmo.zuul.generator.customAnnotation.impl;

import io.dummymaker.bundle.IBundle;
import io.dummymaker.generator.IGenerator;
import ru.ifmo.zuul.generator.Bundles.BundleLows;

public class LowGenerator implements IGenerator<String> {
    private final IBundle<String> bundle = new BundleLows();

    @Override
    public String generate() {
        return bundle.getRandom();
    }
}
