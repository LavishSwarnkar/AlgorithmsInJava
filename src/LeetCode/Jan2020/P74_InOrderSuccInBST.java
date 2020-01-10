package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

public class P74_InOrderSuccInBST {

    public static void main(String args[]){

    }

    private static TreeNode getInOrderSucc(TreeNode node, TreeNode root){
        if(node == null)
            return null;
        if(node.right != null)
            return getLeftMostNode(node.right);
        TreeNode succ = null;
        while (root != null){
            if(node.val < root.val){
                succ = root;
                root = root.left;
            } else if(node.val > root.val){
                root = root.right;
            } else {
                break;
            }
        }
        return succ;
    }

    private static TreeNode getLeftMostNode(TreeNode node){
        if(node.left != null)
            node = node.left;
        return node;
    }

}
