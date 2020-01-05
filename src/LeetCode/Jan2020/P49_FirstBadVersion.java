package LeetCode.Jan2020;

public class P49_FirstBadVersion {

    public static void main(String args[]){

    }

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid))
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }

    private boolean isBadVersion(int i) {
        return false;
    }


}
