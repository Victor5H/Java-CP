package twoDArrays;

public class SearchInSorted {
    public static void main(String[] args) {
        int [][]mat =  {{11,12,13,14},
                        {21,22,23,24},
                        {31,32,33,34}};
        int i=0,j=mat[0].length-1;
        int dir=0,find=21;
        // consider any point where a value is maximum like top right or bottom left corner
        while (i< mat.length&&j>=0){
            if(mat[i][j]>find){
                j--;
            }
            else if(mat[i][j]<find){
                i++;
            }
            else if(mat[i][j]==find){
                System.out.println("location: "+i+" "+j);
                return;
            }
        }
        System.out.println("Not found");
    }
}
