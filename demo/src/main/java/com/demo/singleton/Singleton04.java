package com.demo.singleton;

public class Singleton04 {
    private static Singleton04 instance = null;

    static {
        instance = new Singleton04();
    }

    private Singleton04() {

    }

    public Singleton04 getInstance() {
        return instance;
    }
}
