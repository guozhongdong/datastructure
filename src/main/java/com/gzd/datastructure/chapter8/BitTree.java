package com.gzd.datastructure.chapter8;

/**
 * @author guozhongdong
 * @date 2020/3/22 19:39
 * 构架一个二叉树
 *
 */
public class BitTree {

    /**
     * 设置一个跟节点
     * */
    public  BitNode root;
    /**
     * 记录树的节点数
     *
     * */
    private int size = 0;

    /**
     * 构建二叉树
     * */
    public void insertTree(BitNode node,int data){
        if (root == null){
            root = new BitNode(data);
        }else{
            if (data < node.data){
                if (node.left == null){
                    node.left = new BitNode(data);
                }else{
                    insertTree(node.left,data);
                }
            }else if (data > node.data){
                if (node.right == null){
                    node.right = new BitNode(data);
                }else{
                    insertTree(node.right,data);
                }
            }else{
                return;
            }

            size++;
        }


    }

    public static void main(String[] args) {
        BitTree bitTree = new BitTree();
        bitTree.insertTree(bitTree.root,6);
        bitTree.insertTree(bitTree.root,5);
        bitTree.insertTree(bitTree.root,9);
        bitTree.insertTree(bitTree.root,7);
        bitTree.insertTree(bitTree.root,8);
        bitTree.insertTree(bitTree.root,14);
        System.out.println(bitTree.size);
    }
}
