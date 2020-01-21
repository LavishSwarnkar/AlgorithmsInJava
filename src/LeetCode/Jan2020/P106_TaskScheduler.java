package LeetCode.Jan2020;

public class P106_TaskScheduler {

    public static void main(String args[]){

    }

    public int leastInterval(char[] tasks, int n) {
        int[] occ = new int[26];
        int max = 0;
        for(char task : tasks) {
            int i = task - 'A';
            occ[i]++;
            if(occ[i] > max)
                max = occ[i];
        }
        return max*n + max - n;
    }

}
