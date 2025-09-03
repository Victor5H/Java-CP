package recursion.l1;

public class Power {
    public static int power(int num, int power){
        if(power==0) return 1;
        return num*power(num,power-1);
        /*
        faith is that this function woud
         */
    }
    public static int power2(int num, int power){
        if (power==0) return 1;
        int got = power2(num,power/2);
//        this works on principle of x^n = x^n/2*x^n/2 for n is even and x^n = x^n/2 * x^n/2 * x for odd
        int ret = got*got;
        if(power%2==1)  ret*=num;
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(power2(2,3));
    }
}
