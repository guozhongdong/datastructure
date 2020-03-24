package com.gzd.datastructure.linear;

/**
 * @author guozhongdong
 * @date 2020/3/19 12:09
 * 链表的基础节点
 */
public class Node {
    //存下一个节点地址,对应指针域
    public Node next;

    //节点的数据,对应数据域
    public  int value;

    public Node(int value ){
        this.value = value;
    }
}
