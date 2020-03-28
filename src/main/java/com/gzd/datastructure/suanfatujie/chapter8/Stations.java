package com.gzd.datastructure.suanfatujie.chapter8;

import java.util.*;

/**
 * @author guozhongdong
 * @date 2020/3/28 13:35
 * 寻找覆盖州最多的广播台
 * 用set集合求 交集
 */
public class Stations {
    /**
     * 散列表存广播台的信息，value是存放的覆盖的州
     * */
    static Map<String,HashSet> stations = new HashMap<>();
    //州的集合
    static Set statesNeeded = new HashSet();
    // 最终的广播台的集合
    static Set finalStations = new HashSet();

    public static void main(String[] args) {
        Set result = new HashSet();

        statesNeeded.add("mt");
        statesNeeded.add("wa");
        statesNeeded.add("or");
        statesNeeded.add("id");
        statesNeeded.add("nv");
        statesNeeded.add("ut");
        statesNeeded.add("ca");
        statesNeeded.add("az");
        // 设置广播台覆盖的州


        List list = new ArrayList();
        list.add("id");
        list.add("nv");
        list.add("ut");
        stations.put("kone",new HashSet<>(list));
        List list1 = new ArrayList();
        list1.add("wa");
        list1.add("id");
        list1.add("mt");
        stations.put("ktwo",new HashSet<>(list1));
        List list2 = new ArrayList();
        list2.add("or");
        list2.add("nv");
        list2.add("ca");
        stations.put("kthree",new HashSet<>(list2));
        List list3 = new ArrayList();
        list3.add("nv");
        list3.add("ut");
        stations.put("kfour",new HashSet<>(list3));
        List list4 = new ArrayList();
        list4.add("ca");
        list4.add("az");
        stations.put("kfive",new HashSet<>(list4));
        searchCovered();
        System.out.println(finalStations);

    }

    public static void searchCovered(){
        // 存储覆盖了最多的未覆盖州的广播台

        // 不断的循环，直到州的集合为空
        while (statesNeeded.size() > 0){
            String bestStations = null;
            // 存储该广播台所有未覆盖的州
            Set statesCovered = new HashSet<>();
            // 一轮for循环下来，会找到一个最好的广播台，并记录到结果集中
            for (Map.Entry<String,HashSet> station:stations.entrySet()){
                //计算交集,当前广播台与大集合的交集，
                Set covered = new HashSet();
                covered.addAll(statesNeeded);
                covered.retainAll(station.getValue());
                // 判断上一个的交集 跟自己的交集，哪个相交的多，如果自己的大，则进入循环，
                if (covered.size() > statesCovered.size()){
                    bestStations = station.getKey();
                    // 记录自己的交集
                    statesCovered = covered;
                }
            }
            //取差集，
            Set chaji = new HashSet();
            chaji.addAll(statesNeeded);
            chaji.removeAll(statesCovered);
            //即是去掉上一个广播台覆盖的部分
            statesNeeded = chaji;
            finalStations.add(bestStations);
        }
    }
}
