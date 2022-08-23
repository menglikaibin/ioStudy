package com.demo.singleton;

public class Singleton05 {
    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05() {

    }

    public static final Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
