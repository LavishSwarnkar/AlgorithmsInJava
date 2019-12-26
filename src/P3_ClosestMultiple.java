public class P3_ClosestMultiple {

    public static void main(String args[]){
        System.out.println(getClosestMultiple(5, 2));
        System.out.println(getClosestMultiple(13, 6));
        System.out.println(getClosestMultiple(15, 6));
        System.out.println(getClosestMultiple(18, -7));
        /* Output :
            6
            12
            18
            21
         */

        System.out.println(getClosestMultiple(5, 2));
        System.out.println(getClosestMultiple(-13, 6));
        System.out.println(getClosestMultiple(-15, 6));
        System.out.println(getClosestMultiple(-16, 6));
        /* Output :
            6
            -12
            -18
            -18
         */

        System.out.println(getClosestMultiple(5, 2));
        System.out.println(getClosestMultiple(-13, -6));
        System.out.println(getClosestMultiple(-15, -6));
        System.out.println(getClosestMultiple(-16, -6));
        /* Output :
            6
            -12
            -18
            -18
         */
    }

    private static int getClosestMultiple(int n, int m){
        int rem = n % m;
        if(rem < 0)
            return n - (Math.abs(rem) >= Math.abs(m)/2 ? Math.abs(m) - Math.abs(rem) : rem);
        return rem == 0 ? n : n + (rem >= Math.abs(m)/2 ? Math.abs(m)-rem : -rem);
    }

}
