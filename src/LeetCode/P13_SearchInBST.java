package LeetCode;

public class P13_SearchInBST {

    public static void main(String args[]){
        TreeNode root = TreeNode.createTreeFromArray(new int[]{6,2,8,0,4,7,9,-1,-1,3,5});
        System.out.println(searchBST(root, 40));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;
        if(val < root.val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

}
