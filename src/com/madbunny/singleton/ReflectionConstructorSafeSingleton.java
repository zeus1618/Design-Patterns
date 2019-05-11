package com.madbunny.singleton;

/**
 * @author iqbal on 2019-05-08
 * @project DesignPatterns
 *
 * Reflection can be used to break singleton pattern in ways with constructor access or/and instance field access
 * Pros -
 * 1. Private instance and constructor
 * 2. Lazy Loading
 * 3. Reflection safety of constructor
 *
 * Ways to break
 * 1. Reflection safety of field not present
 * 2. Serialization with file write and read
 * 3. Cloning
 * 4. instance is shared between but not volatile
 * 5. Multi-Threads
 **/

public class ReflectionConstructorSafeSingleton implements ISingleton {
    private static ReflectionConstructorSafeSingleton instance;

    private ReflectionConstructorSafeSingleton() throws IllegalAccessException {
        if(instance != null){
            throw new IllegalAccessException("Access object using getInstance() method only");
        }
    }

    public static ReflectionConstructorSafeSingleton getInstance(){
        if(instance == null){
            try {
                instance =  new ReflectionConstructorSafeSingleton();
            } catch (IllegalAccessException e) {
                instance = null;
                getInstance();
            }
        }
        return instance;
    }
}
