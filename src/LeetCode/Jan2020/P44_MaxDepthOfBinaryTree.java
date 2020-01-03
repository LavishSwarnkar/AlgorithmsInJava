package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

public class P44_MaxDepthOfBinaryTree {

    public static void main(String args[]){
        System.out.println(maxDepth(TreeNode.createTreeFromArray(new int[]{3,9,20,-1,-1,15,7})));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
