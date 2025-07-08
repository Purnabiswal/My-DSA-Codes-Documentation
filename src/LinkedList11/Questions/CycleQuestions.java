package src.LinkedList11.Questions;

//Circular Linked List
public class CycleQuestions {
    private Node head;
    private Node tail;
    private int size;

    public CycleQuestions() {
        size=0;
    }

    public void insert(int val){
        Node node = new Node(val);
        if (head==null){
            head=node;
            tail=node;
            node.next=head;
            size++;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
        size++;
    }

    public void delete(int value){
        if (head==null){
            return;
        }
        if (head==tail && head.val==value){
            head=null;
            tail=null;
            size--;
            return;
        }
        if (head.val==value){
            head=head.next;
            tail.next=head;
            size--;
            return;
        }

        Node node=head;
        do {
            if (node.next.val == value) {
                node.next = node.next.next;
                if (tail.val == value) {
                    tail = node;
                }
                size--;
                return;
            }
            node = node.next;
        } while (node != head);
    }

    public Node find(int value){
        Node node=head;
        if (head!=null){
            do{
                if (node.val==value){
                    return node;
                }
                node=node.next;
            }while (node!=head);
        }
        return null;
    }

    public void display(){
        Node node=head;
        if (head!=null){
            do{
                System.out.print(node.val+" -> ");
                node=node.next;
            }while (node!=head);
        }
        System.out.println("HEAD");
    }


    class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val=val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    //Leetcode Questions

    //Asked in Amazon & Microsoft
    //Q-1: Is cycle exists? LC_141
    public boolean hasCycle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    //Q-2: Find length of cycle?
    public int lengthCycle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int length=0;
                Node temp=slow;
                do {
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return length;
            }
        }
        return 0;
    }

    //Q-3: Find the node where the cycle begins? LC_142
    public Node detectCycle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int length=0;
                Node temp=slow;
                do {
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return fun(head, length);
            }
        }
        return null;
    }
    public Node fun(Node head, int len){
        Node f=head;
        Node s=head;
        int count=0;
        while (true){
            s=s.next;
            if (count>=len){
                f=f.next;
            }
            if (f==s){
                return f;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        CycleQuestions list = new CycleQuestions();
        list.insert(14);
        list.insert(1);
        list.insert(16);
        list.insert(4);
        list.display();
    }

}
