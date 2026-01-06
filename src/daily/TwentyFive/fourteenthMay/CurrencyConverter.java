package daily.TwentyFive.fourteenthMay;

import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {
    static class Node{
        String f;
        String t;
        double rate;
        public Node(String f, String t, double rate){
            this.f = f;
            this.t = t;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "f='" + f + '\'' +
                    ", t='" + t + '\'' +
                    ", rate=" + rate +
                    '}';
        }
    }
     static List<Node> data = new ArrayList<Node>();
    public static void main(String[] args) {

        data.add(new Node("USD", "JPY", 110));
        data.add(new Node("USD", "AUD", 1.45));
        data.add(new Node("JPY", "GBP", 0.0070));
        data.add(new Node("USD","INR",85.9));
        System.out.println(getRatio("USD","INR",4));
    }
    public static double getRatio(String f, String t, double amount){
        double ans = amount;
        for (Node n:data) {
            if(n.f==f){
                for (Node s:data){
                    if(s.t==t){
                        System.out.println(s);
                        ans = ans*s.rate;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
