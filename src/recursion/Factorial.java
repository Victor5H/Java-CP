package recursion;

public class Factorial {
    public static int fact(int num){
        if(num==1) return 1;
        int h =num *fact(num-1);
        System.out.println(h);
        return h;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
