package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P59_3Sum {

    public static void main(String args[]){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int start, end;
        for(int i=0 ; i<nums.length-2 ; i++){
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            start = i+1;
            end = nums.length-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>(
                            Arrays.asList(nums[i], nums[start], nums[end])
                    );
                    lists.add(list);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start-1]) start++;
                    while (start < end && nums[end] == nums[end+1]) end--;
                } else if(sum > 0){
                    end--;
                } else {
                    start++;
                }
            }
        }
        return lists;
    }

}
