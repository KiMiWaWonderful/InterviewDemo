package com.company.search;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
    }

    //需要先获取一个斐波那契数列
    //非递归方法得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //斐波那契查找 算法，使用非递归
//    public static int fibSearch(int[] a, int key) {
//        int low = 0;
//        int high = a.length - 1;
//        //斐波那契分割数值的下标
//        int k = 0;
//        //存放mid值
//        int mid = 0;
//        //获取到斐波那契数列
//        int f[] = fib();
//        //获取到斐波那契分割数值的下标
//        while (high > f[k] - 1) {
//            k ++;
//        }
//    }
}
