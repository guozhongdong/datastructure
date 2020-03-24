package com.gzd.datastructure.chapter4;

import com.gzd.datastructure.linear.Node;

/**
 * @author guozhongdong
 * @date 2020/3/21 14:10
 * 栈：先进后出，本例是通过链式存储实现
 * 操作类似单链表
 */
public class Stack {

    //栈顶指针
    private Node top;
    private int size = 0;

    public Stack(){

    }
    /**
     * 入栈
     * 添加一个新元素
     * */
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        //把新元素赋值到栈顶元素
        top = newNode;
        size++;

    }

    /**
     * 出栈
     * 添加一个新元素
     * */
    public void pop(int data){
        Node p ;
        if (top == null){
            System.out.println("栈为空！");
            return;
        }
        data = top.value;
        p = top;
        //栈顶指针后移一位，赋值给下一个节点
        top = top.next;
        //释放p内存
        p = null;
        size--;

    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        String stirng = "";
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size);
        stack.pop(3);
        System.out.println(stack.size);
    }
}
