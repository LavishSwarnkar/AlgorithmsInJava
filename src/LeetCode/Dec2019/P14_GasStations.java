package LeetCode.Dec2019;

public class P14_GasStations {

    public static void main(String args[]){
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tGas, tCost, totalGas, totalCost, ans;
        tGas = tCost = totalGas = totalCost = ans = 0;
        for(int i=0 ; i<gas.length ; i++){
            tGas += gas[i];
            totalGas += gas[i];
            tCost += cost[i];
            totalCost += cost[i];

            if(tCost > tGas){
                ans = i+1;
                tGas = tCost = 0;
            }
        }
        return (totalCost > totalGas) ? -1 : ans;
    }

}
