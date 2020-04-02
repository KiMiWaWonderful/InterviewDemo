package com.company.recursion;

public class Queen8 {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    //arr[i] = val,val表示第i+1个皇后，放在第i+1行的第val+1列
    int[] array = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
        System.out.println(judgeCount);
    }

    //输出皇后摆放的位置
    private void print() {
        count ++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //查看放置的皇后是否和前面已经摆放的皇后冲突
    //n表示第n个皇后
    private boolean judge(int n) {
        judgeCount ++;
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n] 判断第n个皇后是否和前面的n-1个皇后在同一列
            //2.Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断第n个皇后和第i个皇后是否在同一列
            //3.没必要是否判断在同一行,n代表行，一直在递增
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //编写一个方法，放置第n个皇后
    //check是每一次递归时，进入到check中都有for (int i = 0; i < max; i++) ，因此会有回溯
    private void check(int n) {
        if(n == max) {
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放到该行的第一列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)) {//不冲突
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i，即将第n个皇后放置在本行的后移的一个位置
        }
    }
}
