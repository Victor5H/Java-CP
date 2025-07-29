package recursion.l1;

public class Basic {
    public static void printDecreasing(int num){
        if(num==0) return;
        System.out.println(num);
        printDecreasing(num-1);
    }
    /*
    this part is executed first, and while going up
    call()
    this part is executed last, while going down

     */
    public static void printIncreasing(int num){
        if(num==0) return;
        printIncreasing(num-1);
        System.out.println(num);
    }
    public static void printDecreasingIncreasing(int num){
        if(num==0 ) return;
        System.out.println(num);
        printDecreasingIncreasing(num-1);
        System.out.println(num);
    }

    public static void main(String[] args) {

//        printDecreasing(1000);
//        printIncreasing(10);
        printDecreasingIncreasing(8);
    }
}
