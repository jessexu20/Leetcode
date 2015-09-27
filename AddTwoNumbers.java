/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode(0);
        ListNode cur=head;
        ListNode cur1=l1;
        ListNode cur2=l2;
        int carry=0,value=0;
        while(cur1!=null || cur2!=null){
            if(cur1!=null&& cur2!=null){
                value=(cur1.val+cur2.val+carry)%10;
                carry=(cur1.val+cur2.val+carry)/10;
                cur.next=new ListNode(value);
                cur=cur.next;
                cur1=cur1.next;
                cur2=cur2.next;
            }
            else if(cur1==null){
                value=(cur2.val+carry)%10;
                carry=(cur2.val+carry)/10;
                cur.next=new ListNode(value);
                cur=cur.next;
                cur2=cur2.next;
            }
            else if(cur2==null){
                value=(cur1.val+carry)%10;
                carry=(cur1.val+carry)/10;
                cur.next=new ListNode(value);
                cur=cur.next;
                cur1=cur1.next;
            }
        }
        if(carry!=0){
            cur.next=new ListNode(carry);
        }
        return head.next;
    }
}