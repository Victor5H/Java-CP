package arrays.tuf;

import java.util.HashMap;

public class MajorityElement {
    public  static void better(int []nums){
//        it is using extra space
        int l = nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (int n: map.keySet()){
            if(map.get(n)>l) System.out.println(n);
        }
    }
    public static int optimal(int [] nums){
        int cnt=0,el=0;
        for(int n:nums){
            if(cnt==0){ cnt++; el=n;}
            else if (el == n) {
                cnt++;
            }
            else cnt--;

        }
        int verify=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==el) verify++;
        }
        if(verify>(nums.length/2)) return el;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,1,1,3};
        better(nums);
        System.out.println(optimal(nums));
    }
}
