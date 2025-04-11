package recursion;

public class PrintArray {
    public static void printInOrder(int[] arr, int index) {
        if (index == arr.length) return;
        System.out.println(arr[index]);
        printInOrder(arr, index + 1);
    }

    public static void printReverse(int[] arr, int index) {
        if (index < 0) return;
        System.out.println(arr[index]);
        printReverse(arr, index - 1);


    }

    public static void main(String[] args) {
        printInOrder(new int[]{1, 2, 34, 5, 6, 78, 8}, 0);
        System.out.println("printing in reverse order");
        printReverse(new int[]{1, 2, 34, 5, 6, 78, 8}, 6);
    }
}
