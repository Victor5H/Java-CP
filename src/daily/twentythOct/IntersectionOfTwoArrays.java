package daily.twentythOct;

import java.util.HashSet;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    int[] helper(int[] large, int [] small){
        HashSet<Integer> set = new HashSet<>();
        int j=0,i=0;
        while(i<small.length&&j<large.length){
            while((i<small.length&&j<large.length) && small[i]<large[j]){
                i++;
            }
            while((i<small.length&&j<large.length) && small[i]>large[j]){
                j++;
            }
            while((i<small.length&&j<large.length )&& small[i]==large[j]){
                set.add(small[i]);
                i++;j++;
            }

        }
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public int[] help(int[] nums1, int []nums2){
        HashSet<Integer> intersect = new HashSet<>();
        HashSet<Integer> num = new HashSet<>();
        for(int n: nums1){
            num.add(n);
        }
        for(int n: nums2){
            if(num.contains(n)){
                intersect.add(n);
            }
        }
        return intersect.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        return help(nums1,nums2);
        // nums1 = Arrays.stream(nums1).sorted().toArray();
        // nums2 = Arrays.stream(nums2).sorted().toArray();
        // int [] res ;
        // if(nums1.length>nums2.length){
        //     res = helper(nums1,nums2);
        // }
        // else{
        //     res = helper(nums2,nums1);
        // }
        // return res;

    }
}
