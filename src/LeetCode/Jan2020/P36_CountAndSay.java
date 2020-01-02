package LeetCode.Jan2020;

public class P36_CountAndSay {

    public static void main(String args[]){
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String prev = "1";
        for(int i=1 ; i<n ; i++)
            prev = getLookAndSaySeq(prev);
        return prev;
    }

    private static String getLookAndSaySeq(String s){
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        char currChar = chars[0];
        int count = 1;
        for(int i=1 ; i<chars.length ; i++){
            if(chars[i] == currChar) {
                count++;
            } else {
                builder.append(count).append(currChar);
                count = 1;
                currChar = chars[i];
            }
        }
        builder.append(count).append(currChar);
        return builder.toString();
    }

}
