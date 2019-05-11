package com.madbunny.singleton;

/**
 * @author iqbal on 2019-05-09
 * @project DesignPatterns
 *
 * <b>Bill Pugh Singleton Implementation:</b>
 * Prior to Java5, memory model had a lot of issues and above methods caused failure in certain scenarios in
 * multithreaded environment. So, Bill Pugh suggested a concept of inner static classes to use for singleton.
 *
 */
public class SuperUltimateSingleton implements ISingleton {

    /**
     * Pros :
     * 1. Lazy loaded
     * 2. Reflection safe constructor
     * 3. Thread safe and non blocking
     * 4. Atomicity is not required - BEST BEAUTY OF THIS ONE
     * */
    private SuperUltimateSingleton(){
        if(BillPughSingleton.INSTANCE != null){
            throw new IllegalStateException("Use Get Instance");
        }
    }

    /**
     * When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when
     * loading the class. Inner class is created only when getInstance() method is called. So it may seem like
     * eager initialization but it is lazy initialization.
     * */
    private static class BillPughSingleton {
        private static final SuperUltimateSingleton INSTANCE = new SuperUltimateSingleton();
    }

    public static SuperUltimateSingleton getInstance(){
        return BillPughSingleton.INSTANCE;
    }

    /**
     * Pro 5. Clone Safe
     * */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed");
    }

    /**
     * Pro 6. Serialization safe
     * */
    protected Object readResolve() {
        return BillPughSingleton.INSTANCE;
    }
}
