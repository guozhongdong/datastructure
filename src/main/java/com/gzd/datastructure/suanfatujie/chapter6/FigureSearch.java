package com.gzd.datastructure.suanfatujie.chapter6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author guozhongdong
 * @date 2020/3/28 8:13
 * 广度优先搜索，查找离你最近的芒果销售商
 *
 * 数组：存储你的朋友信息
 * 散列表：存储你的朋友，和你朋友的朋友的映射关系
 * 队列：将你的朋友压入队列验证
 *
 */
public class FigureSearch {
    static  HashMap map = new HashMap();
    // 记录已经检查过的人
    static  HashMap map1 = new HashMap();
    public static void main(String[] args) {
        String[] you = {"alice","bob","claire"};
        String[] bob = {"anuj","thom1"};
        String[] alice = {"peggy","jonny"};
        String[] anuj = {};
        String[] peggy = {};
        String[] thom = {};
        String[] jonny = {};

        map.put("you",you);
        map.put("bob",bob);
        map.put("alice",alice);
        map.put("anuj",anuj);
        map.put("peggy",peggy);
        map.put("thom",thom);
        map.put("jonny",jonny);
        System.out.println(search("you"));
    }

    public static Boolean search(String name){
        String[] names = (String[]) map.get(name);
        Deque deque = new ArrayDeque();
        for (int i = 0; i < names.length; i++) {
            deque.add(names[i]);
        }
        while (!deque.isEmpty()){
            String person = (String) deque.pop();
            if (!map1.containsKey(person)){
                if (personIsSeller(person)){ //判断这个人是否检查过
                    System.out.println(person+" is a mango seller");
                    return true;
                }else{
                    String[] nameOther = (String[]) map.get(person);
                    if (nameOther != null && nameOther.length > 0 ){
                        for (int i = 0; i < nameOther.length; i++) {
                            deque.add(nameOther[i]);
                        }
                    }
                    map1.put(person,true); //标记这个人为检查过，否则容易死循环

                }
            }
        }
        return false;
    }
    /**
     * 卖芒果的人就是名字结尾为m字符的人
     * */
    public static Boolean personIsSeller(String name ){
        return (name.charAt(name.length()-1)) == 'm';
    }
}
