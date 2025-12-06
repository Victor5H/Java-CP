package javaTopics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewDemo extends Thread {
    public static void main(String[] args) {
        System.out.println("It extends thread, but does not ovverride run method");
        InterviewDemo id  = new InterviewDemo();
        id.start();
        int [] arr= {1,2,3};
        System.out.println(Arrays.toString(arr));
        int i=0,j= arr.length-1;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
        String str= "HappyNewYear";
        String s = Arrays.stream(str.split("")).distinct().collect(Collectors.joining());
        System.out.println(s);
        StringBuilder res = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(Character c: str.toCharArray()){
            if(!set.contains(c)){
                res.append(c);
                set.add(c);
            }
        }
        HashSet<String> set1 = new HashSet<>();
        Iterator<String> ci = Arrays.stream(s.split("")).iterator();
        while (ci.hasNext()){
            String ref = ci.next();
            if(set1.contains(ref)){
                ci.remove();
            }
            set1.add(ref);
        }
        System.out.println(ci);
        System.out.println(res.toString());

//


    }
}
