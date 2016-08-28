package com.lessons.lesson8.Annotation;

public class TestAnnotations {

    public static void main(String[] args) throws Exception {
        Truck truck = new Truck(1, "MERSEDES", 20);
        try {
            new A().print(truck);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
