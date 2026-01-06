package daily.TwentyFive.eighteenApril;

public class RemoveDuplicates {
    public static int removeDuplicates(int [] nums){
        int pointUnique=0,pointAhead=1;
        while (pointAhead< nums.length){
            if(nums[pointAhead]==nums[pointUnique]){
                pointAhead++;
            }
            else {
                nums[pointUnique+1]= nums[pointAhead];
                pointUnique++;
                pointAhead++;
            }
        }
        return pointUnique+1;
    }
}
