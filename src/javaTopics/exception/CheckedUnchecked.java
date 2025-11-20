package javaTopics.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedUnchecked {
    public static void main(String[] args) throws Exception {
        unchecked0();
        unchecked1();
        checked0();
        checked1(); // if not handled it will result in compile-time error

    }
    public static void checked0(){
        try{
            FileReader f = new FileReader("sd.txt");
        }catch (FileNotFoundException f){
            System.out.println(f);
        }
//        or
//        catch (IOException i){
//            System.out.println(i);
//        }
    }
    public static void checked1() throws FileNotFoundException /*or IOException or Exceptio*/{
        FileReader f = new FileReader("sd.txt");
    }
    public static void unchecked0(){
//        this won't result in compile-time error
        throw new RuntimeException("Aise hi");
    }
    public static void unchecked1() throws RuntimeException{
        throw new RuntimeException("Aise hi");
    }
}
