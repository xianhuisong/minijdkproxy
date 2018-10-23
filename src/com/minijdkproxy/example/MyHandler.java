package com.minijdkproxy.example;

import java.lang.reflect.Method;

public class MyHandler implements MyInvocationHandler {

    private Man man;

    public MyHandler(Man man) {
        this.man = man;
    }

    public void before() {
        System.out.println("before invoke()");
    }

    public void after() {
        System.out.println("after invoke()");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(man, null);
        after();
        return obj;
    }
}
