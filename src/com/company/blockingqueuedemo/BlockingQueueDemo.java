package com.company.blockingqueuedemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 集合的高级类
 * ## ArrayBlockingQueue: 由数组结构组成的有界阻塞队列。 --线程池底层使用
 * ## LinkedBlockingDeque: 由链表结构组成的有界（但大小默认值为Integer.MAX_VALUE）阻塞队列。--线程池底层使用，慎用，因为有界范围太大。
 * PriorityBlockingQueue: 支持优先排序的无界阻塞队列。
 * DelayQueue: 使用优先级队列实现的延迟无界阻塞队列。
 * ## SynchronousQueue: 不储存元素的阻塞队列，也即单个元素的队列。 --线程池底层使用
 * LinkedTransferQueue: 由链表结构组成的无界阻塞队列。
 * LinkedBlockingQueue: 由链表结构组成的双向阻塞队列。
 *
 * BlockingQueue核心方法：
 *  抛出异常组：add(e), remove() element()
 *  特殊值：offer(e), poll(), peek()
 *  阻塞：put(), take()
 *  超时-折中，温柔的版本： offer(e, time, unit), poll(time, unit)
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /*
        //阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
       // blockingQueue.put("d");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        */

        /*
        //成功返回true 失败抛出异常
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
         */

        /*
        //成功返回true 失败返回false
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

        System.out.println(blockingQueue.peek()); // 探测器，探测最顶端元素
        System.out.println(blockingQueue.poll()); // 取出队列中的元素
        System.out.println(blockingQueue.poll()); // 取出队列中的元素
        System.out.println(blockingQueue.poll()); // 取出队列中的元素
        System.out.println(blockingQueue.poll()); // 取出队列中的元素,没有为null
        */

        /*
        //超时-折中，温柔的版本： offer(e, time, unit), poll(time, unit)
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
         */
    }
}
