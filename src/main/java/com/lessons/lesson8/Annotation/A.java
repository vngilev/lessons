package com.lessons.lesson8.Annotation;

import java.lang.reflect.Method;


public class A {


    @Format(value = "Value", fieldname = "type")
    public static void print(Object object) throws Exception {
        Method printMethod = A.class.getMethod("print", Object.class);
        Format annotation = printMethod.getAnnotation(Format.class);
        String fieldName =annotation.fieldname();
        Method getterMethod = object.getClass().getMethod(getGetterNameForField(fieldName));
        Object value = getterMethod.invoke(object);
        System.out.println("PRINTER:");
        if(value==null){
            throw new IllegalArgumentException("no value for field "+ fieldName);
        }

        System.out.println(value.toString());
    }

    private static String getGetterNameForField(String fieldName) {
        return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    }
}
