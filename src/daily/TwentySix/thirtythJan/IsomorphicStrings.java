package daily.TwentySix.thirtythJan;

import java.util.Arrays;
//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int [] arr1 = new int [128];
        int [] arr2 = new int [128];
        Arrays.fill(arr1,-1);
        Arrays.fill(arr2,-1);
        for(int i=0;i<s.length();i++){
            int si = s.charAt(i);
            int ti= t.charAt(i);
            if(arr1[si]==-1)
                arr1[si]=ti;
            else if(arr1[si]!=ti) return false;
            if(arr2[ti]==-1)
                arr2[ti]=si;
            else if(arr2[ti]!=si) return false;
        }
        // System.out.println(Arrays.toString(arr));
        return true;
    }
}
