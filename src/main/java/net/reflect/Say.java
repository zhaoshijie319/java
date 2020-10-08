package net.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Say {

    public void say(String methodStr, String name, int age) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //  Method method = this.getClass().getMethod("say" + methodStr, new Class[]{String.class,int.class});              //1
        Method method = this.getClass().getDeclaredMethod("say" + methodStr, new Class[]{String.class, int.class});      //2
        method.invoke(this, new Object[]{name, age});
    }

    public void sayHello(String name, int age) {
        System.out.println("hello " + name + ",I know you are " + age);
    }

    protected void sayHi(String name, int age) {
        System.out.println("hi " + name + ",I know you are " + age);
    }

    private void sayBye(String name, int age) {
        System.out.println("bye " + name + ",I know you are " + age);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        new Say().say("Bye", "name1", 22);
        new Say().say("Hi", "name2", 22);
    }
}