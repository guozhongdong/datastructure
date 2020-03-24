package com.gzd.datastructure.linear;

/**
 * @author guozhongdong
 * @date 2020/3/21 13:57
 *
 * 双向链表
 */
public class DoubleNodeList {

    private Node2 head;

    public int size = 0;


    public DoubleNodeList(){
        head = new Node2(1);
    }

    /**
     * 插入一个新节点,头插法
     *
     * */
    public void insertNodeByHead(int data){
        Node2 newNode = new Node2(data);
        // 关键点，原head.next 要变成 newNode.next
        // head.next 指向 newNode
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        size++;
    }

    public static void main(String[] args) {

    }
}
