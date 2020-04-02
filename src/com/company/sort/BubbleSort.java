package com.company.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,20};
        bubbleSort(arr);
        //System.out.println(Math.pow(10,18));
    }

    public static void bubbleSort(int[] arr) {
        //第一趟排序，将最大的数排在最后
        int temp = 0;
        //标识变量，表示是否进行过交换
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if(arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            System.out.println("第"+ (i + 1) +"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));

            //在一趟排序中，一次交换都没有发生
            if(!flag) {
                break;
            }else {
                //重置flag，进行下次判断
                flag = false;
            }
        }
    }
}
