package ru.ifmo.zuul.generator.customAnnotation.annotations;

import io.dummymaker.annotation.PrimeGen;
import ru.ifmo.zuul.generator.customAnnotation.impl.AgeGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@PrimeGen(AgeGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenAge {
}
