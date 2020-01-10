package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

public class P70_ConstructBinaryTreeFromTraversalOrder {

    public static void main(String args[]){
        TreeNode root = buildTree(new int[]{-1}, new int[]{-1});
        //TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }

    static int index = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    public static TreeNode helper(int[] preorder, int[] inorder, int l, int r){
        if(l > r) return null;
        int mid = r;
        while (mid >= l && preorder[index] != inorder[mid]) mid--;
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = helper(preorder, inorder, l, mid - 1);
        root.right = helper(preorder, inorder, mid + 1, r);
        return root;
    }

    //MySolution : Not passing some test cases
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end || start >= inorder.length)
            return null;
        if(start == end)
            return new TreeNode(preorder[start]);
        TreeNode root = new TreeNode(preorder[start]);
        int i=0 ;
        while (i<inorder.length && inorder[i] != preorder[start])
            i++;
        root.left = buildTree(preorder, inorder, start+1, start+i);
        root.right = buildTree(preorder, inorder, start+i+1, end);
        return root;
    }

}
