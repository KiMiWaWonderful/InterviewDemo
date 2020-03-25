package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if(points == null) {
            return 0;
        }
        if(points.length <= 2) {
            return points.length;
        }

        //key为每个数组除以最大公约数后的结果，比如[8,4],[4,2],[2,1]最后都变成[2,1]存储
        Map<Map,Integer> map = new HashMap();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            //每次循环完毕要清空map，否则会把上次统计结果带到下一次循环来
            map.clear();

            //重复个数，自己算重复元素，所以初始元素为1
            int dup = 1;
            int max = 0;

            for (int j = i + 1; j < points.length; j++) {
                //计算出两者间隔
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;

                //重合的话就将dup加一
                if(x == 0 && y == 0) {
                    dup ++;
                    continue;
                }
                //计算最大公约数
                int d = gcd(x, y);
                Map tempMap = new HashMap();
                tempMap.put(x / d, y / d);

                //次数
                //是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
                map.put(tempMap, map.getOrDefault(tempMap, 0) + 1);
                //每次都将最大的放到max中，避免最后还要遍历判断map中最大次数
                max = Math.max(max, map.get(tempMap));
            }
            //最后的结果就是map+dup
            result = Math.max(result, max + dup);
        }
        return result;
    }

    private int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
