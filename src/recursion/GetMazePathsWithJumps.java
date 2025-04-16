package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsWithJumps {
    public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
        if(sr>dr || sc>dc){return new ArrayList<>();}
        if(sr==dr && sc==dc) {ArrayList<String > ret = new ArrayList<>(); ret.add(""); return ret;}
        List<String> verti1 = getMazePathWithJumps(sr + 1, sc, dr, dc);
        List<String> verti2 = getMazePathWithJumps(sr + 2, sc, dr, dc);
        List<String> verti3 = getMazePathWithJumps(sr + 3, sc, dr, dc);
        List<String> diag1 = getMazePathWithJumps(sr + 1, sc+1, dr, dc);
        List<String> diag2 = getMazePathWithJumps(sr + 2, sc+2, dr, dc);
        List<String> diag3 = getMazePathWithJumps(sr + 3, sc+3, dr, dc);
        List<String> hori1 = getMazePathWithJumps(sr, sc + 1, dr, dc);
        List<String> hori2 = getMazePathWithJumps(sr, sc + 2, dr, dc);
        List<String> hori3 = getMazePathWithJumps(sr, sc + 3, dr, dc);
        ArrayList<String> res = new ArrayList<>();
        for (String s : verti1) {
            res.add("1 down " + s);
        }
        for (String s : verti2) {
            res.add("2 down " + s);
        }
        for (String s : verti3) {
            res.add("3 down " + s);
        }
        for (String s : diag1) {
            res.add("1 diagonal " + s);
        }
        for (String s : diag2) {
            res.add("2 diagonal " + s);
        }
        for (String s : diag3) {
            res.add("3 diagonal " + s);
        }
        for (String s : hori1) {
            res.add("1 right " + s);
        }
        for (String s : hori2) {
            res.add("2 right " + s);
        }
        for (String s : hori3) {
            res.add("3 right " + s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMazePathWithJumps(0,0,2,2));
        System.out.println(getMazePathWithJumps(0,0,2,2).size());
    }
}
