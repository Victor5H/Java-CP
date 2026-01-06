package daily.TwentyFive.nineteenApril;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String [] strs){
        if(strs.length==0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            while (!curr.startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flow","flower","floweraaaaa"}));
    }
}
