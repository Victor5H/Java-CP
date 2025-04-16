package recursion;

public class PrintKeypadCombination {
    public static String [] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKeypadCombination(String input, String out){
        if(input.length()==0){
            System.out.print(out+" ");
            return;
        }
        int cha = input.charAt(0)-'0';
        String code = codes[cha];
        for(int i=0;i<code.length();i++){
            printKeypadCombination(input.substring(1),out+code.charAt(i));
        }

    }

    public static void main(String[] args) {
        printKeypadCombination("678","");
    }
}
