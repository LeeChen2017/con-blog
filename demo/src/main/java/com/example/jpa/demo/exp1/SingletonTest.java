package com.example.jpa.demo.exp1;

public class SingletonTest {

    public static void main(String[] args) {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        LazySingleton lazySingleton2 = LazySingleton.getInstance();
//
//        System.out.println(lazySingleton == lazySingleton2);

        new Thread(()->{
            LazySingleton lz1 = LazySingleton.getInstance();
            System.out.println(lz1);
        }).start();

        new Thread(()->{
            LazySingleton lz2 = LazySingleton.getInstance();
            System.out.println(lz2);
        }).start();
    }
}

/**
 * 懒汉单例模式
 */
class LazySingleton {

    private static LazySingleton instance  = new LazySingleton();

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    return new LazySingleton();
                }
            }
        }
        return instance;
    }

}
