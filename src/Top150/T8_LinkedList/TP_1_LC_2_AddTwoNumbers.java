package src.Top150.T8_LinkedList;

public class TP_1_LC_2_AddTwoNumbers {
    public static void main(String[] args) {

    }



//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1=l1;
        ListNode node2=l2;

        ListNode sumNode=null;
        ListNode sumNodeTail=null;
        int prev=0;

        while (!(node1==null && node2==null)){

            int num=((node1==null)?0:node1.val)+ ((node2==null)?0:node2.val)+prev;
            int cur=num%10;
            prev=num/10;
            ListNode temp=new ListNode(cur);
            if (sumNode==null){
                sumNode=temp;
            }else {
                sumNodeTail.next=temp;
            }
            if (node1!=null) node1=node1.next;
            if (node2!=null) node2=node2.next;
            sumNodeTail=temp;
        }

        if (prev!=0) sumNodeTail.next=new ListNode(prev);

        return sumNode;
    }
}
