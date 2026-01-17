package daily.TwentyFive.seventeenAug;

public class AddTwoNumbers {
    ListNode ans = null;
    ListNode trav = ans;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        helper(l1,l2,0);
        return ans;
    }
    public int addNode(int sum,int add,int carry){
        if(sum>9){
            add=sum%10;
            sum=sum/10;
            carry=sum;
        }
        else{
            add=sum;
            carry=0;
        }
        if(trav==null){
            ans = new ListNode(add);
            trav = ans;
        }
        else{
            trav.next = new ListNode(add);
            trav = trav.next;
        }
        return carry;
    }
    public void helper(ListNode l1, ListNode l2,int carry){
        int sum =0,add=0;
        if(l1!=null && l2!=null){
            sum=l1.val+l2.val+carry;
            carry = addNode(sum,add,carry);
            helper(l1.next,l2.next,carry);
        }
        else if(l1==null && l2!=null){
            sum = l2.val+carry;
            carry = addNode(sum,add,carry);
            helper(l1,l2.next,carry);
        }
        else if(l1!=null && l2==null){
            sum = l1.val+carry;
            carry = addNode(sum,add,carry);
            helper(l1.next,l2,carry);
        }
        else if(carry!=0){
            sum = carry;
            carry = addNode(sum,add,carry);
            return;
        }
    }
}

