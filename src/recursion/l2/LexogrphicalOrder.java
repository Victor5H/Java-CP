package recursion.l2;

public class LexogrphicalOrder {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            print(i,10000);
        }
    }
    public static void print(int i , int num){
        if(i>num) return;
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            print(i*10+j,num);
        }
    }
}
