package daily.TwentySix.twentyThird;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumPairRemovalToSortArray1 {
    public boolean isSorted(List<Integer> n){
        for(int i=0;i<n.size()-1;i++){
            if(n.get(i)>n.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
        int count=0;

        while(!isSorted(list)){
            int minSum = Integer.MAX_VALUE;
            int ind = -1;
            int sum=0;
            for(int i=0;i<list.size()-1;i++){
                sum = list.get(i)+list.get(i+1);
                if(sum<minSum){
                    minSum = sum;
                    ind=i;
                }
            }

            list.set(ind,minSum);
            list.remove(ind+1);
            count++;
            System.out.println(list);
        }
        return count;
    }
}
