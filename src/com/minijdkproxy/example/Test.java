package com.minijdkproxy.example;

public class Test {

    public static void main(String[] args) throws Throwable {
        Man man = new AwsomeMan();
        MyHandler myHandler = new MyHandler(man);
        Man proxyMan = (Man) MyProxy.newProxyInstance(
                new MyClassLoader("C:\\GitHub\\minijdkproxy\\src\\com\\minijdkproxy\\example",
                        "com.minijdkproxy.example"),
                Man.class, myHandler);

        System.out.println(proxyMan.getClass().getName());

        proxyMan.findObject();

    }
}
