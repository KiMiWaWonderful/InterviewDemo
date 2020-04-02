package com.company.sort;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748,14,214};
    }

    public static void radixSort(int[] arr) {

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数组的时候，数据溢出，则每个一维数组（桶）大小定位arr.length
        //3.基数排序是使用空间换时间
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，定义一个一维数组来记录每个桶每次放入的数据个数
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //第1轮（对每个元素的个位进行排序处理）
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] % 10;
            //放入对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序（一维数组的下标一次取出数据，放入原来数组）
        int index = 0;
        //遍历每一桶，并将桶中数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，放入原数组
            if(bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index] = bucket[k][l];
                }
            }
        }
    }
}
