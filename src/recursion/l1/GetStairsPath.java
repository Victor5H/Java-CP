package recursion.l1;

import java.util.ArrayList;

public class GetStairsPath {
    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
        if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> path1 = getStairPaths(n - 1);
        ArrayList<String> path2 = getStairPaths(n - 2);
        ArrayList<String> path3 = getStairPaths(n - 3);
        for (String st : path1) {
            res.add(1 + st);
        }
        for (String st : path2) {
            res.add(2 + st);
        }
        for (String st : path3) {
            res.add(3 + st);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getStairPaths(3));
        System.out.println(getStairPaths(2).size());
    }
}
