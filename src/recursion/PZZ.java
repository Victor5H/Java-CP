package recursion;

public class PZZ {
    /*
    the kind of recursion used in trees
     */
    public static void pzz(int num){
        if (num==0) return;
        System.out.println("PRE "+num);
        pzz(num-1);
        System.out.println("IN "+num);
        pzz(num-1);
        System.out.println("POST "+num);
    }

    public static void main(String[] args) {
        pzz(3);
    }
}
