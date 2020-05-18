package com.lch;

public class Singleton {
    private Singleton() {
	System.out.prinln("Well done");
    }

    private static volatile Singleton singleton = null;

    public static Singleton getInstance() {

        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
