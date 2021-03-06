package com.gzd.datastructure.linear;

/**
 * @author guozhongdong
 * @date 2020/3/19 12:09
 * 链表的基础节点
 */
public class Node2 {

    //存上一个节点地址,对应指针域
    public Node2 prev;
    //存下一个节点地址,对应指针域
    public Node2 next;

    //节点的数据,对应数据域
    public  int value;

    public Node2(int value ){
        this.value = value;
    }
}
