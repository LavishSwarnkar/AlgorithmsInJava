package LeetCode.Dec2019;

public class P11_FlattenTree {

    public static void main(String args[]){
        /*TreeNode root = TreeNode.createTreeFromArray(new int[]{1, 2, 5, 3, 4, 9, 6});
        System.out.println(root);
        flatten(root);
        System.out.println(root);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(root);
        flatten(root);
        System.out.println(root);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(root);
        flatten(root);
        System.out.println(root);
    }

    private static TreeNode prev = null;
    private static void flatten(TreeNode root) {

        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
