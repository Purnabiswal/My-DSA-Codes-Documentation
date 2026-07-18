package src.Top150.T8_LinkedList;

import java.util.HashMap;

public class TP_2_LC_138_CopyListWithRandomPointer {
    public static void main(String[] args) {

    }


    // Definition for a Node.
    static class  Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node newHead=new Node(head.val);
        Node node=head;
        Node node2=newHead;

        HashMap<Node, Integer> map=new HashMap<>();
        HashMap<Integer, Node> map2=new HashMap<>();

        int idx=0;
        map.put(head, idx);
        map2.put(idx, newHead);

        while (node.next!=null){
            Node temp=new Node(node.next.val);
            node2.next=temp;
            map.put(node.next, idx+1);
            map2.put(idx+1, temp);

            node=node.next;
            node2=node2.next;
            idx++;
        }


        node=head;
        node2=newHead;
        int i=0;
        while (i<=idx){
            node2.random=map2.get(map.get(node.random));
            node=node.next;
            node2=node2.next;

            i++;
        }

        return newHead;
    }




}
