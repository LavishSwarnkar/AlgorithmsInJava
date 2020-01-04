package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P46_BinaryTreeLevelOrderTraversal {

    public static void main(String args[]){
        System.out.println(levelOrder(TreeNode.createTreeFromArray(new int[]{3,9,20,-1,-1,15,7})));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.get(0).add(root.val);
        levelOrder(lists, root.left, 1);
        levelOrder(lists, root.right, 1);
        return lists;
    }

    private static void levelOrder(List<List<Integer>> lists, TreeNode node, int lvl){
        if(node == null)
            return;
        if(lvl >= lists.size())
            lists.add(new ArrayList<>());
        lists.get(lvl).add(node.val);
        levelOrder(lists, node.left, lvl+1);
        levelOrder(lists, node.right, lvl+1);
    }

    /*public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;

        lists.add(new ArrayList<>());
        TreeNode firstNode = root
                , lastNode = root;
        int lvl = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            lists.get(lvl).add(node.val);

            if(node == firstNode){
                if(node.left == null && node.right == null)
                    firstNode = queue.peek();
                else if(node.left == null)
                    firstNode = node.right;
                else
                    firstNode = node.left;
            }
            if(node == lastNode){
                lvl++;

            }
        }
    }*/

}