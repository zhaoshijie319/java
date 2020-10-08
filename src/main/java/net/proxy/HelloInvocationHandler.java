package net.proxy;

import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler {
    private Object obj;

    public HelloInvocationHandler(Object obj) {
        this.obj = obj;
    }

    public void invoke(Object proxy, Method method) {
        System.out.println("Before Hello World!");
        try {
            method.invoke(obj, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After Hello World!");
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        HelloWorld helloWorldImpl = new HelloWorldImpl();
        InvocationHandler ih = new HelloInvocationHandler(helloWorldImpl);
        HelloWorld helloWorld = (HelloWorld) ProxyVersion_2.newProxyInstance(HelloWorld.class, ih);
        System.out.println("动态生成代理耗时：" + (System.currentTimeMillis() - start) + "ms");
        helloWorld.print();
        System.out.println();
    }
}