package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

public class P47_SortedArrayToBalancedBST {

    public static void main(String args[]){
        TreeNode node = sortedArrayToBST(new int[]{});
        System.out.println(node.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, end);
        return node;
    }

}
