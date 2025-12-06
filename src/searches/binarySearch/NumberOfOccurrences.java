package searches.binarySearch;

public class NumberOfOccurrences {
    protected int count(int []nums,int target){
        int f= FirstAndLastOccurrence.firstOccurrence(nums,target);
        if(f==-1) return 0;
        return f - FirstAndLastOccurrence.lastOccurrence(nums, target) + 1;
    }
}
