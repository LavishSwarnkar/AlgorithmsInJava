package LeetCode.Dec2019;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static TreeNode createTreeFromArray(int[] vals) {
        TreeNode[] nodes = new TreeNode[vals.length+1];
        nodes[1] = new TreeNode(vals[0]);
        for(int i=2 ; i<=vals.length ; i++)
            if(vals[i-1] > -1)
                nodes[i] = new TreeNode(vals[i-1]);

        for(int i=1 ; i<nodes.length ; i++){
            try {
                nodes[i].left = nodes[2*i];
                nodes[i].right = nodes[2*i+1];
            } catch (Exception ignored){}
        }

        return nodes[1];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val).append(" ");
        /*builder.append(left == null ? "" : left);
        builder.append(right == null ? "" : right);*/
        return builder.toString();
    }

}
