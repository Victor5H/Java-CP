package patterns;

public class NumTriangle {
    public static void print(int num){
        int count = 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
