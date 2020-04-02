package com.company.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
    }

    //交换法
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;

        for (int gap = arr.length; gap > 0; gap /= 2) {
            //第一轮排序
            //第一轮排序是将10个数据分成了5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有(按实际情况)个元素），步长gap
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第"+ (++count) +"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }
    }

    //对交换法进行优化：移位法
    public static void shellSort2(int[] arr) {
        int count = 0;

        //增量gap，并逐步缩小增量
        for (int gap = arr.length; gap > 0 ; gap /= 2) {
            //从第gap个元素，逐个对其所在的组 进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    //退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }

            System.out.println("第"+ (++count) +"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
