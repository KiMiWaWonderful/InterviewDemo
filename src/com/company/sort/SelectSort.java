package com.company.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSOrt(arr);
    }

    public static void selectSOrt(int[] arr) {
        //第1轮
        //原始的数组：101, 34, 119, 1
        //第一轮排序： 1,34,119,101

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                //换成<则是从大到小排序
                if(min > arr[j]) { //说明假定的最小值并不是最小
                    //重置min
                    min = arr[j];
                    //重置minIndex
                    minIndex = j;

                }
            }

            //将最小值，放在arr[0],即交换
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第"+ (i + 1) +"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }

    }
}
