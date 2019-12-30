public class P5_LookAndSaySequence {

    public static void main(String args[]){
        String prevString = "1";
        for(int i=1 ; i<=7 ; i++){
            System.out.println(prevString);
            prevString = getLookAndSaySeq(prevString);
        }
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
