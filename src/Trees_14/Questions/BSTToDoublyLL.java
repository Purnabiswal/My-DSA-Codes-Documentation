package src.Trees_14.Questions;

import src.Trees_14.BST_2;

public class BSTToDoublyLL {
    public BSTToDoublyLL(){

    }
    public static class Node {
        private int val;
        private int height;
        private Node left;
        private Node right;
        public Node(int value) {
            this.val =value;
        }
        int getVal(){
            return val;
        }
    }
    private Node root;
    Node head;

    /* Function to print nodes in a given doubly linked list */
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }



    //Convert a BST to a doubly linked list
    Node prev=null;
    public void BinaryTree2DoubleLinkedList(Node node){
        if (node==null){
            return;
        }
        BinaryTree2DoubleLinkedList(node.left);

        //Do something
        if (prev==null){
            head=node;
        }else {
            node.left=prev;
            prev.right=node;
        }
        prev=node;

        BinaryTree2DoubleLinkedList(node.right);
    }


    public static void main(String[] args)
    {
        // Let us create the tree as shown in the above diagram
        BSTToDoublyLL tree = new BSTToDoublyLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }

}
