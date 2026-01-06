package daily.TwentyFive.twentySecondOct;
//https://leetcode.com/problems/h-index
public class Hindex {
//    dome using counting sort
    public int hIndex(int[] citations) {
        int []countS = new int[citations.length+1];
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=countS.length-1) countS[countS.length-1]++;
            else{
                countS[citations[i]]++;
            }
        }
        int paperCount=countS[countS.length-1];
        int i=countS.length-1;
        while(paperCount<i && i>=0){
            paperCount+=countS[--i];
        }
        return i;
    }
}
