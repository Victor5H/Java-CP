package patterns;

public class RightDiagonal {
    public static void print(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(j+i==num-1){
                    System.out.print(" * ");
                }
                else System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(7);
    }
}
