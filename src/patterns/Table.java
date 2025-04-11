package patterns;

public class Table {
    public static void print(int num){
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d\n",num,i,num*i);
        }
    }
    public static void main(String[] args) {
        print(12);
    }
}
