package src.Trees_14;

class Solution {
    public Solution(){

    }
    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;
        public Node(int value) {
            this.value=value;
        }
        int getValue(){
            return value;
        }
    }
    Node root=new Node(-1);
    Node tail=root;
    public void flatten(Node node) {
        flatten1(node);
        node=root.right;
    }
    public void flatten1(Node node) {
        if(node==null){
            return;
        }
        insert(node);
        flatten1(node.left);
        flatten1(node.right);
    }

    public void insert(Node node){
        tail.right=node;
        tail=node;
    }

    public static void main(String[] args) {

    }
}