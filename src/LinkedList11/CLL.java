package src.LinkedList11;

//Circular Linked List
public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL() {
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
    public boolean hasCycle(Node head) {
        int i=Integer.MAX_VALUE;
        while(head!=null){
            if(head.val==i){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(14);
        list.insert(1);
        list.insert(16);
        list.insert(4);
        list.display();
    }

}
