package com.gzd.datastructure.suanfatujie.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guozhongdong
 * @date 2020/3/28 9:39
 * 狄克斯特拉算法，计算最短时间，
 * 有向无环图
 */
public class Dijkstra {
    // 记录处理过的节点
    static  Map process = new HashMap();
    // 记录每个节点的花费时间
    static Map costs = new HashMap<>();
    //记录每个节点的父节点
    static Map parents = new HashMap<>();
    // 记录整个图的信息
    static Map graph = new HashMap<>();
    //记录从起点开始的节点
    static Map start = new HashMap<>();
    public static void main(String[] args) {

        start.put("a",6);
        start.put("b",2);

        costs.put("a",6);
        costs.put("b",2);
        costs.put("fin",Integer.MAX_VALUE);

        parents.put("a",start);
        parents.put("b",start);
        parents.put("fin","");


        Map ga = new HashMap<>();
        ga.put("fin",1);
        Map gb = new HashMap<>();
        gb.put("a",3);
        gb.put("fin",5);
        // 构建起点的邻居节点，是个散列
        graph.put("start",start);
        // A节点的邻居，是个散列
        graph.put("a",ga);
        // b节点的邻居，是个散列
        graph.put("b",gb);
        // 终点的邻居，是个散列，不过是空的
        graph.put("fin",new HashMap<>());
        Dijkstra.findMaxLu();
        System.out.println(costs.get("fin"));
    }

    public static void findMaxLu(){
        // 在未处理的节点中，寻找开销最小节点
        String node = findLowestCostNode(costs);
        while (node != null ){ //在所有节点都被处理过后结束
            int cost = (int) costs.get(node);
            Map<String,Integer> neighbors = (Map) graph.get(node);
            // 遍历当前节点的所有邻居
            for (Map.Entry<String,Integer> n : neighbors.entrySet()){

                int newCosts = cost + n.getValue();
                //如果经当前节点前往邻居更近，就更新邻居的开销
                int dang = (int) costs.get(n.getKey());
                if (newCosts < dang){ //
                    costs.put(n.getKey(),newCosts);
                    //将该邻居的父节点设置为当前节点
                    parents.put(n.getKey(),node);
                }
            }
            process.put(node,true);
            //找出接下来要处理的节点，并循环
            node = findLowestCostNode(costs);

        }
    }
    /**
     * 寻找最小节点
     * */
    public static String findLowestCostNode(Map<String,Integer> map){
        // 设置无穷大
        int lowestCosts = Integer.MAX_VALUE;
        String result = null;
        for (Map.Entry<String,Integer> node : map.entrySet()){

            if (node.getValue() < lowestCosts &&  !process.containsKey(node.getKey())){
                lowestCosts = node.getValue();
                result =  node.getKey();
            }
        }
        return result;
    }


}
