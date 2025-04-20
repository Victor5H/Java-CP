package recursion;

public class PrintMazePathWithJumps {
    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String pathSF){
        if(sr>dr || sc>dc){return;}
        if(sr==dr&&sc==dc){
            System.out.println(pathSF);
            return;
        }

        printMazePathWithJumps(sr+1,sc,dr,dc,pathSF+"1V ");
        printMazePathWithJumps(sr+2,sc,dr,dc,pathSF+"2V ");
        printMazePathWithJumps(sr+3,sc,dr,dc,pathSF+"3V ");
        printMazePathWithJumps(sr,sc+1,dr,dc,pathSF+"1H ");
        printMazePathWithJumps(sr,sc+2,dr,dc,pathSF+"2H ");
        printMazePathWithJumps(sr,sc+3,dr,dc,pathSF+"3H ");
        printMazePathWithJumps(sr+1,sc+1,dr,dc,pathSF+"1D ");
        printMazePathWithJumps(sr+2,sc+2,dr,dc,pathSF+"2D ");
        printMazePathWithJumps(sr+3,sc+3,dr,dc,pathSF+"3D ");

    }
    public static void main(String[] args) {
        printMazePathWithJumps(0,0,2,2,"");
    }
}
