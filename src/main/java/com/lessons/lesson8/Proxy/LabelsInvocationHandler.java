package com.lessons.lesson8.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class LabelsInvocationHandler implements InvocationHandler {
    private String language;

    public LabelsInvocationHandler(String language) {
        this.language=language;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String res = "";
        Key key = method.getAnnotation(Key.class);
        Language[] languages = key.value();
        for (Language methodLanguage : languages) {
            if(methodLanguage.lang().equals(language)){
                res= methodLanguage.value();
                if(args!=null){
                    res = applyArguments(args,res);
                }
            }
//            if(methodLanguage.lang().equals(language)){
//                res= methodLanguage.value();
//            }

        }
        return res;
        //return "${"+method.getName()+"}";

    }

    private String applyArguments(Object args[], String messageFormat) {
        for (int i = 0; i < args.length; i++) {
            messageFormat=messageFormat.replaceAll("\\$"+i, String.valueOf(args[i]));

        }
            return messageFormat;
    }
}
