package com.hubbleadvance.utils.ideveloper.demo.thread;

public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            ThreadMain.p();
            System.out.println(this.getName()+",num="+ThreadMain.num);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }     
    }
}
