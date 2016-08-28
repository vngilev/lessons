package com.lessons.lesson8.Proxy;

import javax.activation.MailcapCommandMap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Proxy;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Language{
    String lang();
    String value();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Key {
    Language[] value();
}



interface Labels{
    // select count(1) from person where person.name like '%:name%'
   // int getCountOfPersonWithNameLikeAndBirthDateBetween();
    @Key({
            @Language(lang = "ru", value = "Логин"),
            @Language(lang = "en", value = "Login")
    })
    String username();

    @Key({
            @Language(lang = "ru", value = "Где мои деньги, $0?"),
            @Language(lang = "en", value = "Where is my money, $0?")
    })
    String getMyNoneyBro(String bro);

}
/**
 * Created by 1 on 27.08.2016.
 */
public class TestProxy {

    public static void main(String[] args) {
        Labels ruLabels = getLabels("ru");
        Labels enLabels = getLabels("en");

        System.out.println(ruLabels.username());
        System.out.println(enLabels.username());
        System.out.println(ruLabels.getMyNoneyBro("Иван"));
        System.out.println(enLabels.getMyNoneyBro("Ivan"));
    }

    private static Labels getLabels(String language){
        return (Labels) Proxy.newProxyInstance(TestProxy.class.getClassLoader(),
                new Class<?>[]{Labels.class},
                new LabelsInvocationHandler(language));
    }

}
