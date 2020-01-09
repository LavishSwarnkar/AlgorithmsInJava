package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P69_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String args[]){
        System.out.println(zigzagLevelOrder(TreeNode.createTreeFromArray(new int[]{3,9,20,-1,-1,15,7})));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if(lvl%2 == 1)
            lists.get(lvl).add(0, node.val);
        else
            lists.get(lvl).add(node.val);
        levelOrder(lists, node.left, lvl+1);
        levelOrder(lists, node.right, lvl+1);
    }

    //Using Iteration
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }

}
