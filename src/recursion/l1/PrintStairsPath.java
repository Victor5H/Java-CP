package recursion.l1;

public class PrintStairsPath {
    public static void printStairsPath(int num, String  psf){
        if(num<0){return;}
        if(num==0){
            System.out.println(psf);
            return;
        }
        printStairsPath(num-1,"1"+psf);
        printStairsPath(num-2,"2"+psf);
        printStairsPath(num-3,"3"+psf);
    }

    public static void main(String[] args) {
        printStairsPath(9,"");
    }
}
