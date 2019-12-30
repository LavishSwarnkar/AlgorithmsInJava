package LeetCode;

public class P9_LCAofBST {

    public static void main(String args[]){
        TreeNode root = TreeNode.createTreeFromArray(new int[]{6,2,8,0,4,7,9,-1,-1,3,5});
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
        System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right.right).val);
        System.out.println(lowestCommonAncestor(root, root.left.left, root.right.right).val);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root!= null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        if((p.val < root.val && q.val > root.val)
                || (p.val > root.val && q.val < root.val))
            return root;
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return null;
    }

}
