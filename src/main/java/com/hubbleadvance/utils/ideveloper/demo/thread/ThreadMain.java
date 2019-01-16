package com.hubbleadvance.utils.ideveloper.demo.thread;

public class ThreadMain {
    public static int num = 100;
    
    public static synchronized void p() {
        num = num -1;
    }
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("t_a");
        a.start();
        ThreadB b = new ThreadB();
        Thread t = new Thread(b, "t_b");
        t.start();
    }
}
