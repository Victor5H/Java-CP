package dp.tuf;

public class HouseRobber2 {
//// robber cannot rob 2 houses adjacent to each other, it will create a police alert,
/// and house in the list are arranged in a circular fashion
/// find out the max a robber can rob
///
/// similar to previous question, use the same logic, make 2 calls
/// one while leaving out first element and other while leaving out last element
/// since both cannot be considered in the answer

    public static int spaceOptimized(int [] arr){
        int prev=arr[0],prev2=0;
        for (int i = 1; i < arr.length; i++) {
            int dont = prev;
            int take =arr[i];
            if(i>1)
                take += prev2;
            int curr= Math.max(dont,take);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        int []houses = new int[]{10,20,30,40,40,50};
        if(houses.length==1) System.out.println(houses[0]);
        int res = spaceOptimized(houses);
        int woLast = res-houses[houses.length-1];
        int woFirst = res-houses[0];
        System.out.println(Math.max(woFirst,woLast));

    }
}
