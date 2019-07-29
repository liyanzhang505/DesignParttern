package com.singleton;

public class MylogSingleton {

    private static final MylogSingleton instance = new MylogSingleton();
    private MylogSingleton() {}
    
    public static MylogSingleton getInstance() {
        return instance;
    }
    
    public static void print(String message) {
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        
        MylogSingleton mylog1= MylogSingleton.getInstance();
        mylog1.print("abc");
        MylogSingleton mylog2= MylogSingleton.getInstance();
        mylog2.print("def");
        
    }
}
