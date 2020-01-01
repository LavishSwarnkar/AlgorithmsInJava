package LeetCode.Dec2019;

public class P7_RangeSumOfBST {

    public static void main(String args[]){
        TreeNode root = TreeNode.createTreeFromArray(new int[]{10,5,15,3,7,-1,18});

        System.out.println(rangeSumBST(root, 7, 15));
        System.out.println(rangeSumBST(TreeNode.createTreeFromArray(new int[]{10,5,15,3,7,13,18,1,-1,6}), 6, 10));
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > L && root.val < R)
            return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;
        else if(root.val <= L)
            return rangeSumBST(root.right, L, R) + (root.val == L ? L : 0);
        return rangeSumBST(root.left, L, R) + (root.val == R ? R : 0);
    }



}
