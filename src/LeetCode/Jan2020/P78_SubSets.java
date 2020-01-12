package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P78_SubSets {

    public static void main(String args[]){
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public static List<List<Integer>> subsets(int[] nums, int index){
        List<List<Integer>> powerSet;
        if(index == nums.length){
            powerSet = new ArrayList<>();
            powerSet.add(new ArrayList<>());
            return powerSet;
        }
        powerSet = subsets(nums, index+1);
        List<List<Integer>> moreSubsets = new ArrayList<>();
        List<Integer> newSubset = new ArrayList<>();
        for(List<Integer> subset : powerSet){
            newSubset = new ArrayList<>(subset);
            subset.add(nums[index]);
            moreSubsets.add(newSubset);
        }
        powerSet.addAll(moreSubsets);
        return powerSet;
    }

}
