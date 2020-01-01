package LeetCode.Dec2019;

public class P10_Merge2BinaryTrees {

    public static void main(String args[]){
        TreeNode t1 = TreeNode.createTreeFromArray(new int[]{1, 3, 2, 5, -1, -1, -1})
                , t2 = TreeNode.createTreeFromArray(new int[]{2, 1, 3, -1, 4, -1, 7})
                , t3 = mergeTrees(t1, t2);
        System.out.println(t3);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
