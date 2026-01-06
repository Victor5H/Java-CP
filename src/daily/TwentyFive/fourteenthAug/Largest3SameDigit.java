package daily.TwentyFive.fourteenthAug;

import java.util.Arrays;
import java.util.List;

public class Largest3SameDigit {
    public String largestGoodInteger(String num) {
        String max = "";
        List<String> list = Arrays.asList("000","111","222","333","444","555","666","777","888","999");
        for(int i=0;i<num.length()-2;i++){
            char f = num.charAt(i);
            if(f==num.charAt(i+1)&& num.charAt(i+1)==num.charAt(i+2)){
                if(max.isEmpty()){max="000";}
                if(max.charAt(0) < f){
                    max = list.get(f-'0');
                }
            }
        }
        return max;

    }
}
