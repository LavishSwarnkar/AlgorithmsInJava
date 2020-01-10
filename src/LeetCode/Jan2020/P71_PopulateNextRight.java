package LeetCode.Jan2020;

import java.util.LinkedList;
import java.util.Queue;

public class P71_PopulateNextRight {

    public static void main(String args[]){

    }

    //Recursive solution
    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect2(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            if(node == null) {
                if (queue.size() > 0)
                    queue.add(null);
            } else {
                node.next = queue.peek();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

}
