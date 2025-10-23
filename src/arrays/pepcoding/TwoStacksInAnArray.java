package arrays.pepcoding;

public class TwoStacksInAnArray {
    int[] arr;
    int top1;
    int top2;
    int size;

    public TwoStacksInAnArray(int size) {
        arr = new int[size];
        this.size = size;
        top2 = size;
        top1=-1;
    }

    public int peek1() {
        return arr[top1];
    }

    public int peek2() {
        return arr[top2];
    }

    public void push1(int val) {
        if (top2 - top1 > 1) {
            top1++;
            arr[top1] = val;
        } else System.out.println("stack1 overflow");
    }

    public void push2(int val) {
        System.out.println(top2-top1);
        if (top2 - top1 > 1) {
            top2--;
            arr[top2] = val;
        } else System.out.println("stack2 overflow");
    }

    public int pop1() {
        if (top1 == -1) {
            System.out.println("stack1 underflow");
            return -1;
        }
        return arr[top1--];
    }
    public int pop2() {
        if (top2 == size) {
            System.out.println("stack2 underflow");
            return -1;
        }
        return arr[top2++];
    }

    public static void main(String[] args) {
        TwoStacksInAnArray stacks = new TwoStacksInAnArray(4);
        stacks.push1(1);
        stacks.push1(2);
        stacks.push2(4);
        stacks.push2(5);
        stacks.pop2();
        stacks.pop2();
        stacks.push1(1);
        stacks.push1(2);
        stacks.pop1();
        stacks.pop1();
        stacks.pop1();
        stacks.pop1();
        stacks.pop1();
        System.out.println(stacks.top2+" "+stacks.top1);
    }
}
