package patterns;

public class RightTriangle {
    public static void print(int n){
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n-i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < i+1; j++) {

                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(8);
    }
}
