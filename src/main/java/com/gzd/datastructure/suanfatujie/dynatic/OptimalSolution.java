package com.gzd.datastructure.suanfatujie.dynatic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guozhongdong
 * @date 2020/3/28 15:54
 *  利用动态规划求最优解
 *  参考视频：https://www.bilibili.com/video/BV18x411V7fm?from=search&seid=11625479885489424315
 *
 */
public class OptimalSolution {
    static List<Meet> list = new ArrayList<>();
    // 做记忆搜索，存已经查过的值
    static  Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {

        //按图的意思，设置8个工作时间和产生的价值
        list  = addMeet();
        System.out.println(opt(8));
    }

    /**
     * 计算最优解，递归
     * */
    public static  int opt(int i){
        if (i == 1){
            map.put(i,list.get(0).getIncome());
            return list.get(0).getIncome();

        }
        if (i == 0 ){
            map.put(0,0);
            return 0;
        }
        int noSelect = opt(i-1);
        map.put(i,noSelect);
        int select;
        if (map.containsKey(searchPre(i))){
            select = map.get(searchPre(i))+list.get(i-1).getIncome();
        }else{
            select = opt(searchPre(i))+list.get(i-1).getIncome();
        }
        return Math.max(noSelect,select);
    }
    /**
     * 查找前一个能用的 下标
     * */
    public static  int searchPre(int i){
        Meet meet = list.get(i-1);
        int start = meet.getStart();
        for (int i1 = list.size()-1; i1 >=0; i1--) {
            Meet meet1 = list.get(i1);
            if (meet1.getEnd() == start){
                return i1+1 ;
            }
        }
        return 0;
    }



    public static List<Meet> addMeet(){
        List<Meet> list = new ArrayList<>();
        Meet m1 = new Meet(1,4,5);
        list.add(m1);
        Meet m2 = new Meet(3,5,1);
        list.add(m2);
        Meet m3 = new Meet(0,6,8);
        list.add(m3);
        Meet m4 = new Meet(4,7,4);
        list.add(m4);
        Meet m5 = new Meet(3,8,6);
        list.add(m5);
        Meet m6 = new Meet(5,9,3);
        list.add(m6);
        Meet m7 = new Meet(6,10,2);
        list.add(m7);
        Meet m8 = new Meet(8,11,4);
        list.add(m8);
        return list;
    }
}
