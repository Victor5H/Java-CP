package twoDArrays;

public class ExitPointOfMatrix {
    public static void main(String[] args) {
        int [][]mat = {{0,0,0,1},{0,0,0,0},{1,0,0,1}};
//        int i=0,j=0;
        int dir = 0,i=0,j=0;// dir is direction, 0=e, 1-s,2=w,3=n
        while (true){
            dir = (dir+mat[i][j])%4;
//            changing the dir or keeping same dir;
            if(dir==0){
                j++;
            } else if (dir == 1) {
                i++;
            }
            else if (dir==2){
                j--;
            }
            else if(dir==3) {
                i--;
            }
//            exiting the mat
//            since we are tarvelling only in one direction only one of these conditions will be true
            if(i<0){
                i++;
                break;
            } else if (i== mat.length) {
                i--;
            } else if (j == mat[0].length) {
                j--;
            }else if(j<0) {
                j++;
            }
        }
        System.out.println(i+" "+j);
    }
}
