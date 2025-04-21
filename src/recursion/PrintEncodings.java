package recursion;

import java.util.HashMap;

public class PrintEncodings {
    public static HashMap<Integer,Character> map = new HashMap<>();
    static {
        for (int i = 1; i <= 26; i++) {
            char c= (char) ('0' +i+48);
            map.put(i,c);
        }        
    }
    /*
    123
    1 or 12
     */

    public static void printEncoding(String num, String ansSF){
        if(num.isEmpty()){
            System.out.println(ansSF);
            return;
        }
        char first = num.charAt(0);
        int firstV = Integer.parseInt(String.valueOf(first));
        if(firstV==0) {
//            System.out.println(ansSF);
            return;
        }
        if(num.length()==1){printEncoding(num.substring(1),ansSF+map.get(firstV)); return;}
        int sec = Integer.parseInt(String.valueOf(num.charAt(1)));
        int combi = firstV*10+sec;
        if(combi>26){
            printEncoding(num.substring(1), ansSF+map.get(combi));
        }
        else {
            printEncoding(num.substring(1),ansSF+map.get(firstV));

            printEncoding(num.substring(2),ansSF+map.get(combi));
        }

    }
    public static void main(String[] args) {
        System.out.println(map);
        printEncoding("123","");
    }
}
