package recursion.l1.revision;

public class LastIndex {
    public static int lastIndex(int [] arr, int find, int ind){
        if(ind== arr.length) return -1;
        int got = lastIndex(arr,find,ind+1);
        if(got==-1 && arr[ind]==find) return ind;
        return got;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4};
        System.out.println(lastIndex(arr,3,0));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+" "+arr[i]);
        }
    }
}
