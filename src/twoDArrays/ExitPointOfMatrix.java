package twoDArrays;

public class ExitPointOfMatrix {
    public static void main(String[] args) {
        int [][]mat = {{0,0,0,1},{0,0,0,0},{1,0,0,1}};
//        int i=0,j=0;
        int j=0,minj=0,i=0,mini=0;
        int maxi= mat.length-1,maxj=mat[0].length-1;
        boolean found=false;
        for (i=mini,j=minj;j<=maxj ; j++) {
            if(mat[i][j]==1){
                found=true;
                mini++;
                break;
            }
        }
        if(!found){ System.out.println(i+" "+--j);return;}
        found=false;
        for (i =mini;i  <=maxi ; ++i) {
            if(mat[i][j]==1){
                found=true;
                maxj--;
                break;
            }
        }
        if(!found){ System.out.println(i+" "+--j);return;}
        found=false;
        for (j =maxj;j>=minj ; --j) {
            if(mat[i][j]==1){
                found=true;
                maxi++;
                break;
            }
        }
        if(!found){ System.out.println(i+" "+--j);return;}
        found=false;
        for (i=maxi; i>=mini ; i--) {
            if(mat[i][j]==1){
                found=true;
                break;
            }
        }
        System.out.println(i+" "+--j);
    }
}
