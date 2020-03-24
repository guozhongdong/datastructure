package com.gzd.datastructure.linear;

import com.sun.javafx.scene.NodeHelper;

import java.util.Random;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/3/19 12:30
 */
public class NodeList {

    //容量
    public int size = 0;
    private Node head;
    private Node tail;
    /**
     * 读取一个单链表,返回第i个元素的值
     *
     * */
    public Node getElement( int i){

        if (head == null){
            return null;
        }
        if (i >size){
            return null;
        }
        int j = 1;
        //节点的第一个元素
        Node p  = head;
        while (p!= null && j<i){
            j++;
            p = p.next;
        }
        return p;
    }

    /**
     * 添加一个节点
     * */
    void insertElement(int data){
        // 如果head为空，则说明链表未添加元素，把当前节点的值赋给头结点
        if (head == null){
            head =  new Node(data);
            size ++;
            tail = head;
            return;
        }
        tail.next = new Node(data);
        tail = tail.next;
        size++;
    }

    /**
     * 创建一个完整的单链表
     * n 是一个随机数
     * */
    void createNodeList(int n){
        // 如果head为空，则说明链表未添加元素，把当前节点的值赋给头结点
        Node p ,l;
        // 头结点 ,存放链表的长度 ，l 是头结点
       l = new Node(5);
       l.next = null;
        for (int i = 0; i < n; i++) {
            //创建一个新节点，
            p  = new Node(new Random().nextInt(100));

            p.next = l.next;
            //插入到表头，新插入的值，一直就会存到l.next 里面，把以前l.next 以前的值，存到新节点的后面，
            //也就是 p.next
            l.next = p;
        }
        while (l.next != null){
            System.out.println(l.next.value);
            l = l.next;
        }

    }

    /**
     * 在指定位置上添加一个节点
     * */
    void insertElement(int index,int data){

        if (index > size){
            return;
        }
        System.out.println(head.value);
        Node p = head;
        int j = 1;
        while (p!=null && j < index){
            p = p.next;
            ++j;
        }
        // 创建一个新节点
        Node s = new Node(data);
        s.next = p.next;
        p.next = s;
        size++;
    }

    /**
     * 删除第i个节点
     * */
    void deleteElement(int index){
        // 如果索引大于链表的长度，则跳出方法
        if (index > size){
            return;
        }
        Node p = head;
        Node q ;
        int j = 1;
        while (p.next != null && j < index){
            p = p.next;
            ++j;
        }
        //
        q = p.next;
        // 将q的后继节点赋值给p 的后继节点，即是 null，
        p.next = q.next;
        // 释放q，释放内存
        q = null;
        size--;
    }

    public static void main(String[] args) {
        NodeList nodeList = new NodeList();

        nodeList.createNodeList(5);

        /*NodeList nodeList = new NodeList();
        nodeList.insertElement(1);
        nodeList.insertElement(4);
        nodeList.insertElement(2,6);
        System.out.println(nodeList.size);
        nodeList.deleteElement(1);
        System.out.println(nodeList.size);
        System.out.println(nodeList.head.value);
        System.out.println(nodeList.head.next.value);*/
    }
}
