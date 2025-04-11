package patterns;

public class Diamond {
    public static void print(int num){
        int spaces = num/2;
        int star = 1;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j < star; j++) {
                System.out.print(" * ");
            }
            System.out.println();
            if(i<=num/2){
                star+=2;
                spaces--;
            }
            else {
                star-=2;
                spaces++;
            }
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
