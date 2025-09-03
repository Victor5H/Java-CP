package recursion.l1.revision;

public class FirstIndex {
    public static int findFirst(int [] arr, int find, int ind){
        if(ind== arr.length) return -1;
        if(arr[ind]==find) return ind;
        return findFirst(arr,find,ind+1);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4};
        System.out.println(findFirst(arr,4,0));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+" "+arr[i]);
        }
    }
}
