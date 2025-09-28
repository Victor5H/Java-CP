package dp.tuf;

public class HouseRobber {
//// robber cannot rob 2 houses adjacent to each other, it will create a police alert,
/// and house in the list are arranged in a circular fashion
/// find out the max a robber can rob
///
/// similar to previous question, use the same logic, make 2 calls
/// one while leaving out first element and other while leaving out last element
/// since both cannot be considered in the answer

    public static int resursion(int [] houses, int ind){
        if(ind==0)
            return houses[ind];
        int dont = resursion(houses,ind-1);
        int take = houses[ind];
        if(ind>1)
            take +=resursion(houses,ind-2);

        return Math.max(take,dont);
    }
    public static void main(String[] args) {
        int []houses = new int[]{10,20,30,40,40,50};
        System.out.println(resursion(houses, houses.length-1));

    }
}
