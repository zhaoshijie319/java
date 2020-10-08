package net.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void getMethodDeclaration(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("MethodDeclaration in " + clazz.getName());
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
        }
    }

    public static void getMethod(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        System.out.println("Method in " + clazz.getName());
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ReflectionUtils.getMethod(Say.class);
        ReflectionUtils.getMethodDeclaration(Say.class);
    }
}