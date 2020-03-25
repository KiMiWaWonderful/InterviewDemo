package com.company.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 可重入的读写锁
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.err.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.err.println(Thread.currentThread().getName()+"\t 写入完成：");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成："+result);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    public void clearMap(){
        map.clear();
    }
}

/**
 * @author doinb
 *  独占锁(写锁)/共享锁(读锁)/互斥锁
 *
 * 独占锁：值该锁一次只能被一个线程所持有。对ReentrantLock和Synchronized而言都是独占锁。
 * 共享锁：值该锁可被多个线程所持有。
 * 对ReentrantReadWriteLock其读锁是共享锁，其写锁是独占锁。
 * 读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。
 *  总结：
 *   读-读能共存
 *   读-写不能共存
 *   写-写不能共存
 *
 *   写操作：原子+独占，整个过程必须是一个完整的统一体，中间不允许被分割，被打断。
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        // 写操作
        for (int i = 1; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.put(tempInt+"", tempInt+"");
            },String.valueOf(i)).start();
        }

        // 读操作
        for (int i = 1; i < 5; i++) {
            final int tempInt = i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }
    }
}
