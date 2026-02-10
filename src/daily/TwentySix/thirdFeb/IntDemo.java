package daily.TwentySix.thirdFeb;

public class IntDemo implements Int1, Int2{
    public void print(){
//        System.out.println(Int1.val);
        Int2.super.print();

    }

    public static void main(String[] args) {
        IntDemo i = new IntDemo();
        i.print();
    }
}
