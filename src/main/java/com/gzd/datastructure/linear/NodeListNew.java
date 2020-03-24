package com.gzd.datastructure.linear;

import javax.crypto.spec.PSource;

/**
 * @author guozhongdong
 * @date 2020/3/21 13:24
 *  创建一个单链表，实现 查询单链表，在头结点前插入，在尾节点插入，删除指定未知的元素，
 */
public class NodeListNew {

    /**
     * 设置一个头结点
     * */
    private Node head;

    private int size = 0;
    /**
     * 初始化一个单链表
     * */
    public NodeListNew(){
        head = new Node(1);
    }
    /**
     * 打印单链表
     *
     * */
    public void printNodeList(){
        Node pMove = head.next;
        while (pMove != null){
            System.out.println("输出节点的值："+pMove.value);
            pMove = pMove.next;
        }
        System.out.println("");
    }
    /**
     * 插入一个新节点,头插法
     *
     * */
    public void insertNodeByHead(int data){
        Node newNode = new Node(data);
        // 关键点，原head.next 要变成 newNode.next
        // head.next 指向 newNode
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }
    /**
     * 指定一个位置删除
     * 让指定位置的前一个节点的next 等于指定位置 的next，把指定位置给屏蔽了，
     *
     * */
    public void deleteNodeByAppoint(int data){
        Node posNode = head.next;
        Node nodeFront =head;
        if(posNode == null){
            System.out.println("未找到指定节点！！！");
        }else{
            // 未找到，就继续往下遍历
            while (posNode.value != data){
                // 重置nodeFront 和posNode
                nodeFront = posNode;
                posNode = nodeFront.next;
                if (posNode == null){
                    System.out.println("未找到指定节点！！！");
                    return;
                }
            }
        }
        nodeFront.next = posNode.next;
        posNode = null;  //释放内存

    }

    public static void main(String[] args) {
        NodeListNew nodeListNew = new NodeListNew();
        nodeListNew.insertNodeByHead(1);
        nodeListNew.insertNodeByHead(2);
        nodeListNew.insertNodeByHead(3);
        nodeListNew.printNodeList();
        nodeListNew.deleteNodeByAppoint(2);
        nodeListNew.printNodeList();
        System.out.println(nodeListNew.size);
    }

}
