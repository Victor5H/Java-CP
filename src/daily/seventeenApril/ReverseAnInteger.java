package daily.seventeenApril;

public class ReverseAnInteger {
//    not checked for overflow
    public static int reverseInteger(int num){
        int out=0;
        if(num>0){
            while (num>0){
                int unit = num%10;
                num = num/10;
                out*=10;
                out+=unit;
            }
        }
        else {
            num = num*-1;
            while (num>0){
                int unit = num%10;
                num = num/10;
                out*=10;
                out+=unit;
            }
            out=out*-1;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(1534236469));
    }
}
