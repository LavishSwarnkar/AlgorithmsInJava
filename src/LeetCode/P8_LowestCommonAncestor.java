package LeetCode;

public class P8_LowestCommonAncestor {

    public static void main(String args[]){
        TreeNode root = TreeNode.createTreeFromArray(new int[]{3,5,1,6,2,0,8,-1,-1,7,4});
        System.out.println(lowestCommonAncestor2(root, root.left, root.left.right.right).val);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode leftLCA = lowestCommonAncestor2(root.left, p, q)
                , rightLCA = lowestCommonAncestor2(root.right, p, q);

        if(leftLCA != null && rightLCA != null)
            return root;

        if(leftLCA != null)
            return leftLCA;
        if(rightLCA != null)
            return rightLCA;

        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = contains(root, p, q);
        if(result.firstCommonAncestor != null)
            return result.firstCommonAncestor;
        return null;
    }

    private static class Result{
        boolean hasA, hasB;
        TreeNode firstCommonAncestor;
        Result(boolean hasA, boolean hasB){
            this.hasA = hasA;
            this.hasB = hasB;
        }
        Result(TreeNode firstCommonAncestor){
            hasA = hasB = true;
            this.firstCommonAncestor = firstCommonAncestor;
        }
        @Override
        public String toString() {
            return firstCommonAncestor == null ? "Not found"
                    : ("firstCommonAncestor = " + firstCommonAncestor.val);
        }
    }

    private static Result contains(TreeNode tree, TreeNode a, TreeNode b){
        if(tree == null)
            return new Result(false, false);
        if(tree == a){
            if(contains(a, b))
                return new Result(a);
            return new Result(true, false);
        }
        if(tree == b){
            if(contains(b, a))
                return new Result(b);
            return new Result(false, true);
        }
        Result leftResult = contains(tree.left, a, b)
                , rightResult = contains(tree.right, a, b);
        if(leftResult.firstCommonAncestor != null)
            return leftResult;
        if(rightResult.firstCommonAncestor != null)
            return rightResult;
        if((leftResult.hasA && rightResult.hasB)
                || (leftResult.hasB && rightResult.hasA))
            return new Result(tree);
        return new Result(leftResult.hasA || rightResult.hasA
                , leftResult.hasB || rightResult.hasB);
    }

    private static boolean contains(TreeNode tree, TreeNode x) {
        return tree != null
                && (tree == x
                || contains(tree.left, x)
                || contains(tree.right, x));
    }
    
}
