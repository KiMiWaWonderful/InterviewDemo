package com.company.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//class MyThread implements Runnable {
//
//    @Override
//    public void run() {
//
//    }
//}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("-----come in Callable-------");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask, "AA");
        t1.start();
    }
}
