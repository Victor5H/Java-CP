package daily.TwentyFive.sixteenthAug;

public class Max69Num {
    public int maximum69Number (int num) {
        StringBuilder builder  = new StringBuilder();
        int rem=0;
        while(num!=0){
            rem = num%10;
            builder.insert(0,rem);
            num = num/10;
        }
        for (int i = 0; i < builder.length(); i++) {
            if(builder.charAt(i)=='6'){
                builder.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(builder.toString());
    }
}
