package recursion.l1.revision;

public class PrintSubsequence {
    public static void my(String inp, int ind, String ansSF){
        if(ind==inp.length()){
            System.out.println(ansSF); return;}
        char c = inp.charAt(ind);
        my(inp,ind+1,ansSF+c);
        my(inp,ind+1,ansSF);

    }

    public static void main(String[] args) {
        my("abc",0,"");
    }
}
