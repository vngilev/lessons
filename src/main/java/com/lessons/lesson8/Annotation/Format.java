package com.lessons.lesson8.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Format {
    /**
     * Formater CLASS NAME
     */
    String value();

    String fieldname();
    boolean fullDescription() default true;


}
