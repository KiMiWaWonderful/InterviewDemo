package com.company.concurrent;

import java.util.concurrent.CountDownLatch;

import static com.company.concurrent.CountryEnum.getCountryEnum;

//减法
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
      //  closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"国，被灭");
                countDownLatch.countDown();
            },getCountryEnum(i)).start();
        }
        // 等待，减少数字达到0，放行。
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t **************秦帝国，统一华夏");
    }


    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDownLatch.countDown();
            }, "thread" + String.valueOf(i)).start();
        }
        // 等待，减少数字达到0，放行。
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t **************班长最后关门走人");
    }
}
