package recursion.l1.revision;

public class PrintStairPaths {
    public static void levelOrder(int n, String ansSF){
        if(n<0) return;
        if(n==0){ System.out.println(ansSF);return;}
        for (int i = 1; i <=3; i++) {
            levelOrder(n-i,ansSF+i);
        }
    }

    public static void main(String[] args) {
        levelOrder(5,"");
    }
}
