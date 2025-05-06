package leetcode.interview150;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        int rem = 0;
        String ret = "";
        if (columnNumber > 26) {
            char c = '9';
            while (columnNumber > 26) {
                rem = columnNumber % 26;
                columnNumber = columnNumber / 26;
                if (rem==0) rem++;
                System.out.println(rem);
                c = (char) ((char) 64+rem);
                ret = ret+c;
            }
            //if (columnNumber==0) columnNumber++;
            System.out.println(columnNumber);
            c= (char) ((char) 64+columnNumber);
            ret=ret+c;

        } else {
            int a = 64 + columnNumber;
            char c = (char) a;
            ret =c+ret;
        }
        return ret;
    }
    private static void helper(int num){
        StringBuilder sb= new StringBuilder();
        while(true) {
            int rem = num % 26;
            int count = 0;
            if (rem == 0) {
                sb.append("Z");
                count++;
            } else {
                sb.append((char) (rem - 1 + 'A') + "");
            }
            num /= 26;
            num -= count;
            if (num == 0) break;
        }
        System.out.println(sb.reverse().toString());
        //return sb.reverse().toString();
    }
    public static void main(String[] args) {
//        System.out.println(convertToTitle(52));
        helper(2147483647);
        //2147483647
    }
}
