package LeetCode.Jan2020;

import java.util.ArrayList;
import java.util.List;

public class P89_MergeIntervals {

    public static void main(String args[]){
        merge(new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        });

        merge(new int[][]{
                {1,4},{0,4}
        });
    }

    public static int[][] merge(int[][] ints) {
        List<Integer> pairs = new ArrayList<>();
        for (int i=0 ; i<ints.length ; i++) {
            int j;
            for (j=i+1 ; j<ints.length ; j++) {
                if(ints[j][0] >= ints[i][0] && ints[j][0] <= ints[i][1]){
                    ints[j][0] = ints[i][0];
                    ints[j][1] = Math.max(ints[i][1], ints[j][1]);
                    break;
                } else if(ints[j][1] >= ints[i][0] && ints[j][1] <= ints[i][1]){
                    ints[j][0] = Math.min(ints[i][0], ints[j][0]);
                    ints[j][1] = ints[i][1];
                    break;
                } else if(ints[j][0] >= ints[i][0] && ints[j][1] <= ints[i][1]){
                    ints[j] = ints[i];
                    break;
                } else if(ints[i][0] >= ints[j][0] && ints[i][1] <= ints[j][1]){
                    break;
                }
            }
            if(j == ints.length){
                pairs.add(ints[i][0]);
                pairs.add(ints[i][1]);
            }
        }
        int[][] res = new int[pairs.size()/2][2];
        int k=0;
        for(int i=0 ; i<pairs.size() ; i+=2)
            res[k++] = new int[]{pairs.get(i), pairs.get(i+1)};
        return res;
    }

}
