package com.test.context;

public class TestContext {

    private static ThreadLocal<Context> contextThreadLocal = new ThreadLocal<>();

    public static void init() {
        contextThreadLocal.set(new Context());
    }

    public static void clear() {
        contextThreadLocal.remove();
    }

     public static Context getContext(){
        return contextThreadLocal.get();

    }
}
