package LeetCode.Jan2020;

import java.util.*;

public class P81_TopKfrequent {

    public static void main(String args[]){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,2,3,3,4,4,4,4,4}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int freq = 0;
        PriorityQueue<int[]> freqs = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] == nums[i-1]) {
                freq++;
            }
            else {
                freqs.offer(new int[]{nums[i-1],freq});
                freq = 1;
            }
        }
        freqs.offer(new int[]{nums[nums.length-1],freq});
        for(int i = 0; i < k; i++){
            ans.add(freqs.poll()[0]);
        }
        return ans;
    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if (k > nums.length) return res;

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq
                = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (int i = 0; i < nums.length; i ++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            pq.offer(entry);

        for (int i = 0; i < k; i++)
            res.add(pq.poll().getKey());

        return res;
    }

}
