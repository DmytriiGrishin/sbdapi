package ru.ifmo.zuul.generator.customAnnotation.impl;

import io.dummymaker.bundle.IBundle;
import io.dummymaker.generator.IGenerator;
import ru.ifmo.zuul.generator.Bundles.BundleGender;

public class GenderGenerator implements IGenerator<String> {

        private final IBundle<String> bundle = new BundleGender();

        @Override
        public String generate() {
                return bundle.getRandom();
        }

}
