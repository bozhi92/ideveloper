package com.hubbleadvance.utils.ideveloper.demo.thread;

public class ThreadB implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            ThreadMain.p();
            System.out.println(Thread.currentThread().getName()+",num="+ThreadMain.num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void exe() {
        for (int i=0;i<10;i++) {
            ThreadMain.num--;
            System.out.println(Thread.currentThread().getName()+",num="+ThreadMain.num);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
