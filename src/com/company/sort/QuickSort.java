package com.company.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;
        //中轴值
        int pivot = arr[(left + right) / 2];
        //临时变量，交换时使用
        int temp = 0;

        //让比pivot小的放左边，大的放右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot的值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            //在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果l >= r说明pivot的左右两的值，已经按照左边全部是小于等于pivot的值，右边全部是大于等于pivot的值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完后，发现这个arr[l] == pivot，前移
            if(arr[l] == pivot) {
                r -= 1;
            }

            //交换完后，发现这个arr[r] == pivot，后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l == r，必须l++ r--，否则栈溢出
        if(l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
