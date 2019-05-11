package com.madbunny.singleton;

import java.io.Serializable;

/**
 * @author iqbal on 2019-05-09
 * @project DesignPatterns
 *
 * Pro 1. Lazy loading
 * Pro 2. Constructor won't work for Reflection as well if someone tries to make duplicate
 * Pro 3. Thread safe and doesn't blocks threads once the instance is created
 * Pro 4. Atomicity is present only where required.
 * Pro 5. Clone Safe
 * Pro 6. Serialization safe
 *
 * Con 1. This doesn't prevent reflection Field access and modification, since we can't make it final with lazy loading
 */

public class UltimateSingleton implements ISingleton, Serializable {

    private static UltimateSingleton instance = null;

    private UltimateSingleton(){
        if(instance!=null){
            throw new IllegalStateException("Use getInstance");
        }
    }

    public static UltimateSingleton getInstance(){
        if(instance == null){
            synchronized (UltimateSingleton.class) {
                if (instance == null) {
                    instance = new UltimateSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed");
    }

    protected Object readResolve() {
        return instance;
    }
}
