package recursion.l2;

import java.util.ArrayList;

public class PrintAbbreviations {
    public static ArrayList<String> arr = new ArrayList<>();
    public static void main(String[] args) {
        String inp = "pep";
        pAbbrev(inp,"",0,0);
        System.out.println(arr);
    }
    public static void pAbbrev(String input, String output,int ind, int num){
        if(ind>=input.length()) {
            if(num==0) {
                arr.add(output);
            }
            else{
                arr.add(output+num);
            }
            return;
        }
//        StringBuilder sb = new StringBuilder(input);
//        sb.setCharAt(ind,'1');
        if(num>0) {
            pAbbrev(input, output + num + input.charAt(ind), ind + 1, 0);
        }
        else {
            pAbbrev(input,output+input.charAt(ind),ind+1,0);
        }
        pAbbrev(input,output,ind+1,num+1);

    }
}
