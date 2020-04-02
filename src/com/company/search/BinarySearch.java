package com.company.search;

import java.util.ArrayList;
import java.util.List;

//使用二分查找的前提：数组有序
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,19,89,1000,1000,1000,1234};
        System.out.println(binarySearch(arr, 0, arr.length-1,88));
        System.out.println(binarySearch2(arr, 0, arr.length-1,1000));
    }

    //arr:数组
    //left:左边的索引
    //right:右边的索引
    //findVal:要找的值
    //如果找到就返回下标，没有找到就返回-1
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //当left > right时，说明递归整个数组，但是没有找到
        if(left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) { //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        }else if(findVal < midVal) { //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }

    //如何找到一个有序数组中有多个相同的数值时，如何将所有的数组都查找到
    //如果有多个，按照上面的方法，将返回最右边那个的索引
    /*
        思路分析：
        1.找到mid索引值，不要马上返回
        2.向mid的左边扫描，将所有满足1000元素的下标，加入到ArrayList
        3.向mid的右边扫描，将所有满足1000元素的下标，加入到ArrayList
        4.将ArrayList返回
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        //当left > right时，说明递归整个数组，但是没有找到
        if(left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal > midVal) { //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        }else if(findVal < midVal) { //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();

            //向mid的左边扫描，将所有满足1000元素的下标，加入到ArrayList
            int temp = mid - 1;
            while (true) {
                //退出
                if(temp < 0 || arr[temp] != findVal) {
                    break;
                }

                //将temp放入到resIndexList
                resIndexList.add(temp);
                //temp左移
                temp -= 1;
            }
            resIndexList.add(mid);

            //向mid的右边扫描，将所有满足1000元素的下标，加入到ArrayList
            temp = mid + 1;
            while (true) {
                //退出
                if(temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }

                //将temp放入到resIndexList
                resIndexList.add(temp);
                //temp右移
                temp += 1;
            }

            return resIndexList;
        }
    }
}
