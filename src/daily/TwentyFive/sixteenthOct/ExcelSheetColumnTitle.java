package daily.TwentyFive.sixteenthOct;

import java.util.HashMap;
//https://leetcode.com/problems/excel-sheet-column-title/

public class ExcelSheetColumnTitle {
    static HashMap<Integer,Character> map = new HashMap<>();
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber>0) {
            columnNumber--;
            int res = columnNumber % 26;
            columnNumber = columnNumber / 26;
            sb.append(map.get(res));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        for(int i=0;i<=25;i++){
            map.put(i, (char) (65+i));
        }
        System.out.println(convertToTitle(52));
    }
}
