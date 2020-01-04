package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

public class P45_ValidateBST {

    public static void main(String args[]){
        System.out.println(isValidBST(TreeNode.createTreeFromArray(new int[]{5,1,4,-1,-1,3,6})));
        System.out.println(isValidBST(TreeNode.createTreeFromArray(new int[]{1,1})));
        System.out.println(isValidBST(TreeNode.createTreeFromArray(new int[]{10,5,15,-1,-1,6,20})));
        System.out.println(isValidBST(TreeNode.createTreeFromArray(new int[]{2,1,3})));
        System.out.println(isValidBST(TreeNode.createTreeFromArray(new int[]{Integer.MAX_VALUE})));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if(root == null)
            return true;
        if((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;
        if(root.left != null && root.left.val >= root.val)
            return false;
        if(root.right != null && root.right.val <= root.val)
            return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

}
