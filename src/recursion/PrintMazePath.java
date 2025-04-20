package recursion;

public class PrintMazePath {
    public static void printMazePath(int sr, int sc, int dr, int dc, String pathSF){
        if(sr==dr && dc==sc){
            System.out.println(pathSF);
            return;
        }
        if(sr>dr || sc>dc){return;}
        printMazePath(sr+1,sc,dr,dc,pathSF+"Down ");

        printMazePath(sr,sc+1,dr,dc,pathSF+"Right ");
    }

    public static void main(String[] args) {
        printMazePath(0,0,2,2,"");
    }
}
