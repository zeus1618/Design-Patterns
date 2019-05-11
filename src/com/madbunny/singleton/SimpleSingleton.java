package com.madbunny.singleton;

/**
 * @author iqbal on 2019-05-08
 * @project DesignPatterns
 *
 * This is the simplest form of single ton
 * Features -
 * 1. Private instance and Constructor
 * 2. Eager Loading
 *
 * Ways to break
 * 1. Reflection
 * 2. Serialization with file write and read
 * 3. Cloning
 * 4. instance is shared between threads but not volatile
 *
 */

public class SimpleSingleton implements ISingleton{

    private static SimpleSingleton instance = new SimpleSingleton();

    private SimpleSingleton(){

    }

    public static SimpleSingleton getInstance(){
        return instance;
    }
}
