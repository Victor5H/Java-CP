package stack;

import java.util.Arrays;

public class Stack {
    int size;
    int top;
    int arr[];
    public boolean isFull(){
        return top == arr.length - 1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean push(int item){
        if(!isFull()){
            top++;
            arr[top]=item;
            return true;
        }
        else
            System.out.println("Stack overflow");
        return false;
    }
    public int pop(){
        if(!isEmpty()){
            int ele=arr[top] =0;
            top--;
            return ele;
        }
        else
            System.out.println("Stack Underflow");
        return -1;
    }
    Stack(int size){
        this.size = size;
        this.top=-1;
        this.arr=new int[size];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr) + top + isEmpty() + isFull();
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        System.out.println(s.push(5));
        System.out.println("stack"+s);
        System.out.println(s.pop());
        System.out.println("stack"+s);

    }

}
