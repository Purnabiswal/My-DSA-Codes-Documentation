package src.LinkedList11.Questions;

import src.LinkedList11.LL;

public class LinkList{

    ListNode head;
    ListNode tail;
    public void insertFirst(int val){
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;
    }
    public void display(){
        ListNode temp=head;
        while (temp != null){
            System.out.print(temp.val+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }


    public void delete(){
        deleteDuplicates(head);
    }

    //LC_83: RemoveDuplicates in sorted list
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode i=head;
//        ListNode j=head;
//        while (true){
//            if (j == null){
//                if (i != null){
//                    i.next=null;
//                }
//                return head;
//            }
//            if (i.val!=j.val){
//                i.next=j;
//                i=j;
//            }
//            j=j.next;
//        }
//    }

    //Questions
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        while (node!=null && node.next!=null){
            if (node.val==node.next.val){
                node.next=node.next.next;
            }
            node=node.next;
        }
        return head;
    }

    static public void show(ListNode node){
        ListNode temp=node;
        while (temp != null){
            System.out.print(temp.val+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }



    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //Leetcode Questions

    //Q-1: Merge  2 sorted linked list. LC_21
    static public ListNode mergeTwoLists(ListNode i, ListNode j) {
        ListNode head=new ListNode();
        ListNode node=head;
        while(i!=null && j!=null){
            if(i.val < j.val){
                node.next = i;
                i = i.next;
            }else{
                node.next=j;
                j=j.next;
            }
            node = node.next;
        }
        node.next=(i==null)?j:i;
        return head.next;
    }

    //Q-2: return the middle node of the linked list. LC_876
    static public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //Q-3: return the list after sorting it in ascending order. LC_148
    private void sort() {
        head=sortList(head);
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return mergeTwoLists(left,right);
    }
    static public ListNode getMid(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }



    public static void main(String[] args) {
        LinkList list=new LinkList();
        LinkList list2=new LinkList();
//        list.insertFirst(3);
//        list.insertFirst(3);


        list.insertFirst(12);
        list.insertFirst(90);
        list.insertFirst(65);
        list.insertFirst(10);
        list.insertFirst(6);
        list.insertFirst(52);
        list.insertFirst(26);
        list.insertFirst(71);
        list.insertFirst(9);
        list.insertFirst(30);
//        list2.insertFirst(9);
//        list2.insertFirst(7);
//        list2.insertFirst(5);
//        list2.insertFirst(4);
//        list2.insertFirst(3);
//        list2.insertFirst(1);
//        show(mergeTwoLists(list.head, list2.head));




        list.display();
        list.sort();
        list.display();
    }


}
