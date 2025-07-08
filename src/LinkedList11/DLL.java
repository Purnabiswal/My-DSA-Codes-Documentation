package src.LinkedList11;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.size=0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        node.next=head;
        node.prev=null;
        if (head != null){ //When size is 0, head is null
            head.prev=node;
        }
        head=node;
        if (tail == null){
            tail = head;
        }
        size++;
    }

    //With tail;
//    public void insertLast(int val){
//        if (tail == null){
//            head=node;
//            tail=head;
//            size++;
//            return;
//        }
//        Node node = new Node(val);
//        node.prev=tail;
//        tail.next=node;
//        tail=node;
//        size++;
//    }

    //Without tail
    public void insertLast(int val){
        Node node=new Node(val);
        if (head==null){ //If there is no element in the List
            head=node;
            tail=head; //If you are using tail then write this line
            size++;
            return;
        }
        Node last=get(size-1);
        node.next=null;
        last.next=node;
        node.prev=last;
        tail=node;
        size++;
    }

    public void insertAfter(int valueAfter, int val){
        Node givenNode=find(valueAfter);
        if (givenNode==null){
            System.out.println(valueAfter+" does not exist in the list.");
            return;
        }
        Node node = new Node(val);
        node.next=givenNode.next;
        node.prev=givenNode;
        if (givenNode.next!=null){
            givenNode.next.prev=node;
        }
        givenNode.next=node;
        size++;
    }

    public Node find(int value){
        Node node = head;
        while(node!=null){
            if (node.val==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node=head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public void display(){
        Node temp=head;
//        for (int i = 0; i < size; i++) {
//            System.out.print(temp.val+ " - ");
//            temp=temp.next;
//        }
        while (temp != null){
            System.out.print(temp.val+ " -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    //Print in reverse
    public void displayRev(){
        Node temp=tail;
        while (temp != null){
            System.out.print(temp.val+ " -> ");
            temp=temp.prev;
        }
        System.out.println("START");
    }

    private class Node{
        private int val;
        private Node next;
        private Node prev;
        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
        public Node(int val){
            this.val = val;
        }
    }
}
