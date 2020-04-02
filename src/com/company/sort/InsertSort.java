package com.company.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);

    }

    public static void insertSort(int[] arr) {
        //第1轮 {101, 34, 119, 1}-> {34,101, 119, 1}

        for (int i = 0; i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            //即待插入的数的前面的数的下标
            int insertIndex = i - 1;

            //1.insertIndex >= 0 保证在给insertVal找插入位置，不越界
            //2.insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入的位置
            //3.所以需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }

            //当退出while循环时，说明插入的位置找到，insertIndex + 1
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+ (i + 1) +"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }


    }
}
