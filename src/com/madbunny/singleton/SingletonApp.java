package com.madbunny.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author iqbal on 2019-05-08
 * @project DesignPatterns
 */
public class SingletonApp {
    public static void main (String[] args){
        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        ReflectionConstructorSafeSingleton reflectionConstructorSafeSingleton = ReflectionConstructorSafeSingleton.getInstance();
        UltimateSingleton ultimateSingleton = UltimateSingleton.getInstance();
        SuperUltimateSingleton superUltimateSingleton = SuperUltimateSingleton.getInstance();

        testAll(simpleSingleton, SimpleSingleton.class);
        testAll(reflectionConstructorSafeSingleton, ReflectionConstructorSafeSingleton.class);
        testAll(ultimateSingleton, UltimateSingleton.class);
        testAll(superUltimateSingleton, SuperUltimateSingleton.class);
    }

    public static void testAll(ISingleton singleton, Class singletonClass){
        System.out.println("\n\nTest for : " + singletonClass.getSimpleName() );
        System.out.println("Passed reflectionConstructorTest : " + reflectionConstructorTest(singleton, singletonClass));
        System.out.println("Passed reflectionConstructorAndVariableTest : " + reflectionConstructorAndVariableTest(singleton, singletonClass));
    }

    public static boolean reflectionConstructorTest(ISingleton singleton, Class singletonClass){
        ISingleton singleton1 = null;
        try {
            Constructor constructor = singletonClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton1 = (ISingleton) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
        }

        return singleton1 == null || singleton.hashCode() == singleton1.hashCode();

    }

    public static boolean reflectionConstructorAndVariableTest(ISingleton singleton, Class singletonClass){
        ISingleton singleton1 = null;
        try {
            Field instance = singletonClass.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, null);

            Constructor constructor = singletonClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton1 = (ISingleton) constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
//            e.printStackTrace();
        }

        return singleton1 == null || singleton.hashCode() == singleton1.hashCode();

    }

    public static boolean threadSafetyTest(ISingleton singleton, Class singletonClass){
        //TODO :
        return false;
    }

    public static boolean serializationSafetyTest(ISingleton singleton, Class singletonClass){
        //TODO :
        return false;
    }

    public static boolean cloneSafeTest(ISingleton singleton, Class singletonClass){
        //TODO :
        return false;
    }

}
