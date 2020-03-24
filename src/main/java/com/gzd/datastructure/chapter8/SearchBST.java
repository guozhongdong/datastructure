package com.gzd.datastructure.chapter8;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author guozhongdong
 * @date 2020/3/22 19:36
 * 二叉排序树
 */
public class SearchBST {
    private BitNode p;
    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
        BitTree bitTree = new BitTree();
        bitTree.insertTree(bitTree.root,6);
        bitTree.insertTree(bitTree.root,5);
        bitTree.insertTree(bitTree.root,9);
        bitTree.insertTree(bitTree.root,7);
        bitTree.insertTree(bitTree.root,8);
        bitTree.insertTree(bitTree.root,14);
        //tNode bitNode = searchBST.searchBst(bitTree.root,14,null,null);
       //ystem.out.println(bitNode.data);
        System.out.println(searchBST.insertBst(bitTree.root, 4));
    }
    /**
     * 递归查找二叉树
     * 返回对应key值对应的上一个节点
     * f 是bitNode 双亲节点
     *
     * */
    public BitNode searchBst(BitNode bitNode,int key,BitNode f){
        if (bitNode == null){
            return f;
        }else if (bitNode.data == key){

            return bitNode;
        }else if (key < bitNode.data){
            return  searchBst(bitNode.left,key,bitNode);
        }else{
            return  searchBst(bitNode.right,key,bitNode);
        }
    }

    /**
     * 递归查找二叉树
     * 二叉树插入操作
     * */
    public Boolean insertBst(BitNode bitNode, int key){
        BitNode s = null;
        BitNode b = searchBst(bitNode,key,null);
        s = new BitNode(key);
        if (key < b.data){
            b.left = s;
        }else if (key > b.data){
            b.right = s;
        }else{
            return false;
        }
        return true;

    }
}
