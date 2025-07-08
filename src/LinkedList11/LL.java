package src.LinkedList11;

import src.LinkedList11.Questions.LinkList;

//Note: Max leetcode questions uses cycle detection technique or/and in-place reversal of LL technique.

public class LL {

    private Node head;
    private Node tail;

    private int size;

    //size=0 initialized in "none constructor" because to initialize once only
    public LL(){
        this.size=0;
    }

    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if (tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val){
        if (tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size+=1;
    }
    public void insertAt(int val, int index){
        if (index==0){
            insertFirst(val);
            return;
        }
        if (index==size){
            insertLast(val);
            return;
        }

        Node temp = head;
//        int i=0;
//        while (i!=index-1){
//            temp=temp.next;
//            i++;
//        }
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next=node;
        size++;
    }

    //insert using recursion
    //Way-1
//    public void insertRec(int val, int index){
//        if (index==0){
//            Node newNode=new Node(val);
//            newNode.next=head;
//            head=newNode;
//            size++;
//            return;
//        }
//         helper(val, index, head);
//    }
//
//    public void helper(int val, int index, Node node){
//        if (index==1){
//            Node newNode=new Node(val);
//            newNode.next=node.next;
//            node.next=newNode;
//            size++;
//            return;
//        }
//
//        helper(val, index-1, node.next);
//    }

    //Way-2
    //Insert using recursion
    public void insertRec(int val, int index){
        head=helper(val, index, head);
    }

    public Node helper(int val, int index, Node node){
        if (index==0){
            Node newNode=new Node(val);
            newNode.next=node;
            size++;
            return newNode;
        }

        node.next=helper(val, index-1, node.next);
        return node;
    }



    public int deleteFirst(){
        int val = head.val;
        head=head.next;
        if (head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if (size<=1){
            return deleteFirst();
        }
        int val = tail.val;
        tail= get(size-2);
        tail.next=null;
        size--;
        return val;
    }

    public int delete(int index){
        if (index>=size){
            System.out.println("IndexOutOfBoundsException");
            return -1;
        }
        if (index==0){
            return deleteFirst();
        }
        if (index==size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.val;
        prev.next=prev.next.next;
        size--;

        return val;
    }

    public Node get(int index){
        Node node=head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
    public Node find(int value){
        Node node=head;
        while(node != null){
            if (node.val==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    public void display(){
        Node temp=head;
        while (temp != null){
            System.out.print(temp.val+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    static public class Node{
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //Questions
    //Reversing a LL using recursion
    public void reverse(){
        //reverse(null, head);
        tail=reverse(head);
        if (tail!=null){
            tail.next=null;
        }
    }
    public void reverse(Node node, Node nxt_node){
        if (node==head){
            tail=node;
        }
        if (nxt_node==null){
            head=node;
            return;
        }
        Node temp=nxt_node.next;
        nxt_node.next=node;
        reverse(nxt_node, temp);
    }
    public Node reverse(Node node){
        if (node==tail){
            head=node;
            return node;
        }
        reverse(node.next).next=node;
        return node;
    }

    //Asked in google, microsoft, apple, amazon
    //In-place reversal of linked list. LC_206
    public void in_reverse(){
        if (head==null || head.next==null){
            return;
        }
        Node prev=null;
        Node cur=head;
        Node nxt=cur.next;
        while(cur!=null){
            cur.next=prev;
            prev=cur;
            cur=nxt;
            if (nxt!=null){
                nxt=nxt.next;
            }
        }
        head=prev;
    }

    //reverse the nodes of the list from position left to position right, and return the reversed list. LC_92
    public void reverseBetween(int left, int right){
        head=reverseBetween(head, left, right);
    }
    public Node reverseBetween(Node head, int left, int right) {
        Node prev=null;
        Node cur=head;
        Node nxt=cur.next;
        Node a=head;
        Node b=head;
        int count=1;
        while(count<=right && cur!=null){
            if(count==left){
                a=prev;
                b=cur;
            }
            if(count>=left){
                cur.next=prev;
            }
            prev=cur;
            cur=nxt;
            if (nxt!=null){
                nxt=nxt.next;
            }
            count++;
        }
        if (a!=null){
            a.next=prev;
        }
        b.next = cur;
        if (left==1){
            return prev;
        }
        return head;
    }

    //Asked in google
    //return true if it is a palindrome or false otherwise. LC_234
    public void isPalindrome(){
        System.out.println(isPalindrome(head));
    }
    public boolean isPalindrome(Node head){
        Node fast=head;
        Node prev=null;
        Node cur=head;
        if (head==null){
            return false;
        }
        Node nxt=cur.next;

        //Reverse first half
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
            if (nxt!=null){
                nxt=nxt.next;
            }
        }
        if (fast!=null){
            cur=cur.next;
        }
        //Check for palindrome from middle
        while (cur!=null){
            if (cur.val!=prev.val){
                return false;
            }
            cur=cur.next;
            prev=prev.next;
        }
        return true;
    }

    //Reorder List. LC_143
    public void reorderList() {
        reorderList(head);
    }
    public void reorderList(Node head) {
        Node cur;
        Node cur2=head;
        Node fast=head;
        Node nxt=head.next;
        Node nxt2;
        //Go to mid
        while(fast!=null && fast.next!=null){
            cur2=cur2.next;
            fast=fast.next.next;
        }

        //reverse second half
        cur=cur2.next;
        cur2.next=null;
        fast=cur.next;
        cur2=null;
        while (cur!=null){
            cur.next=cur2;
            cur2=cur;
            cur=fast;
            if (fast!=null){
                fast=fast.next;
            }
        }

        //Reorder
        cur=head;
        nxt2=cur2.next;
        while(cur2!=null && cur!=null){
            cur.next=cur2;
            cur2.next=nxt;
            cur=nxt;
            cur2=nxt2;
            if (nxt!=null && nxt2!=null){
                nxt=nxt.next;
                nxt2=nxt2.next;
            }
        }
    }

    //Asked in google, amazon, facebook, microsoft
    //Reverse Nodes in k-Group. LC_25
    public void reverseKGroup(int k) {
        head=reverseKGroup(head, k);
    }
    public Node reverseKGroup(Node head, int k) {
        int count=1;
        int size=1;
        Node node=head;
        while (node.next!=null){
            node=node.next;
            size++;
        }
        size=(size/k)+1;
        for (int i = 1; i < size; i++) {
            head=reverseBetween(head, count, count+k-1);
            count+=k;
        }
        return head;
    }

    public void rotateRight(int k) {
        head=rotateRight(head, k);
    }
    public Node rotateRight(Node head, int k) {
        if (head==null){
            return null;
        }
        int l=1;
        Node last=head;
        Node newLast=head;
        //Get the last node & calculate the length
        while(last.next!=null){
            l++;
            last=last.next;
        }
        //k should be less than length of list
//        while (k>=l){
//            k=k-l;
//        }
        k=k%l;

        int skip=l-k; //new tail
        while (skip!=1){
            newLast=newLast.next;
            skip--;
        }
        last.next=head;
        head=newLast.next;
        newLast.next=null;
        return head;
    }


    public static void main(String[] args) {
        LL list = new LL();

//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(3);
//        list.insertLast(2);
//        list.insertLast(1);
        for (int i = 1; i <= 5; i++) {
            list.insertLast(i);
        }
        list.display();
        //list.reverse();
        //list.in_reverse();
        //list.reverseBetween(1, 3);
        //list.isPalindrome();
        //list.reorderList();
        //list.reverseKGroup(3);
        list.rotateRight(2);
        list.display();



    }
}
