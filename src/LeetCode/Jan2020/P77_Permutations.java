package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P77_Permutations {

    public static void main(String args[]){
        System.out.println(permute(new int[]{}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums)
            list.add(i);
        addInt(new ArrayList<>(), list, lists);
        return lists;
    }

    private static void addInt(List<Integer> prefix, List<Integer> nums, List<List<Integer>> lists){
        if(nums.size() == 0){
            lists.add(prefix);
        } else if(nums.size() == 1){
            prefix.add(nums.get(0));
            lists.add(prefix);
        } else {
            for(int i : nums){
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(i);
                List<Integer> newNums = new ArrayList<>(nums);
                newNums.remove(Integer.valueOf(i));
                addInt(newPrefix, newNums, lists);
            }
        }
    }

}
