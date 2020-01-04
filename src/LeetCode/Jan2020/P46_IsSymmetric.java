package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P46_IsSymmetric {

    public static void main(String args[]){
        System.out.println(isSymmetric(TreeNode.createTreeFromArray(new int[]{1,2,2})));
        System.out.println(isSymmetric(TreeNode.createTreeFromArray(new int[]{1,2,3})));
        System.out.println(isSymmetric(TreeNode.createTreeFromArray(new int[]{1,2,2,3,4,4,3})));
        System.out.println(isSymmetric(TreeNode.createTreeFromArray(new int[]{1,2,2,-1,3,-1,3})));
        System.out.println(isSymmetric(TreeNode.createTreeFromArray(new int[]{1,2,2,2,-1,2})));

        System.out.println(isSymmetric3(TreeNode.createTreeFromArray(new int[]{1,2,2})));
        System.out.println(isSymmetric3(TreeNode.createTreeFromArray(new int[]{1,2,3})));
        System.out.println(isSymmetric3(TreeNode.createTreeFromArray(new int[]{1,2,2,3,4,4,3})));
        System.out.println(isSymmetric3(TreeNode.createTreeFromArray(new int[]{1,2,2,-1,3,-1,3})));
        System.out.println(isSymmetric3(TreeNode.createTreeFromArray(new int[]{1,2,2,2,-1,2})));
    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static boolean isSymmetric3(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null)
            return t1 == t2;
        if(t1.val != t2.val)
            return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    //Bullshit
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        Stack<Integer> stack = new Stack<>();

        int childsAdded = 2;
        while (!queue.isEmpty()){
            int prevLvlChilds = childsAdded;
            childsAdded = 0;
            for(int i=0 ; i<prevLvlChilds/2 ; i++){
                TreeNode node = queue.remove();
                stack.push(node == null ? null : node.val);

                if(node == null || (node.left == null && node.right == null))
                    continue;
                childsAdded += 2;
                queue.add(node.left);
                queue.add(node.right);
            }
            for(int i=0 ; i<prevLvlChilds/2 ; i++){
                TreeNode node = queue.remove();
                if(stack.isEmpty() || !stack.pop().equals(node == null ? null : node.val))
                    return false;

                if(node == null || (node.left == null && node.right == null))
                    continue;
                childsAdded += 2;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }

}
