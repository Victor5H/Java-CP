package daily.seventeenOct;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int size = matrix.length*matrix[0].length;
        int tl=0,tr=matrix[0].length-1,bl=0,br=matrix[0].length-1;
        while(ret.size()!=size){
            int i=tl;
            while(i<=tr && ret.size()!=size){
                ret.add(matrix[tl][i]);
                i++;
            }
            tl++;
            while(i<=br && ret.size()!=size){
                ret.add(matrix[i][tr]);
                i++;
            }
            tr--;

            while(i>=bl && ret.size()!=size){
                ret.add(matrix[br][i]);
                i--;
            }
            br--;

            while(i>=tl && ret.size()!=size){
                ret.add(matrix[i][bl]);
                i--;
            }
            bl++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
