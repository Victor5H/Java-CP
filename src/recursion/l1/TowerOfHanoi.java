package recursion.l1;

public class TowerOfHanoi {
    public static void solve(int disks, String t1, String t2, String t3){
        if(disks==0){return;}
        solve(disks-1,t1,t3,t2);
        System.out.printf("Move %d disk form %s -> %s\n",disks,t1,t2);
        solve(disks-1,t3,t2,t1);
    }

    public static void main(String[] args) {
        solve(1,"A","B","C");
    }
}
