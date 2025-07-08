package src.Trees_14;


public class AVL_3 {

    public AVL_3(){

    }
    public static class Node{
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

    private Node root;

    public int height(Node node){
        if (node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void show(){
        show(root, "Root Node: ");
    }
    private void show(Node node, String details){
        if (node==null){
            return;
        }
        System.out.println(details+node.value);
        show(node.left, "Left child of "+ node.value+": ");
        show(node.right, "Right child of "+ node.value+": ");
    }
    //TC: O(log(n))
    //Recursive one
    public void insert(int value){
        root=insert(value, root);
        //check for balanced or not

    }
    public Node insert(int value, Node node){
        if (node==null){
            return new Node(value);
        }
        if (value<node.value){
            node.left=insert(value, node.left);
        }else {
            node.right=insert(value, node.right);
        }
        node.height=Math.max(height(node.left), height(node.right))+1;
        return rotate(node);
    }


    private Node rotate(Node node){
        if (height(node.left)-height(node.right)>1){
            //left heavy
            if (height(node.left.left)-height(node.left.right)>0){
                //left-left case or LL case
                return rotateRight(node);
            }else {
                //left-right case or LR case
                node.left=rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if (height(node.left)-height(node.right)<-1){
            //right heavy
            if (height(node.right.left)-height(node.right.right)<0){
                //right-right case or RR case
                return rotateLeft(node);
            }else {
                //right-left case or RL case
                node.right=rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    private Node rotateRight(Node node){
        Node temp=node.left;
        node.left=temp.right;
        temp.right=node;
        node.height=Math.max(height(node.left), height(node.right))+1;
        temp.height=Math.max(height(temp.left), height(temp.right))+1;
        return temp;
    }
    private Node rotateLeft(Node node){
        Node temp=node.right;
        node.right=temp.left;
        temp.left=node;
        node.height=Math.max(height(node.left), height(node.right))+1;
        temp.height=Math.max(height(temp.left), height(temp.right))+1;
        return temp;
    }


    public void display(){
        prettyPrint(root, "", true);
        prettyDisplay(root, 0);
    }
    public void prettyPrint(Node node, String indent, boolean isLeft) {
        if (node == null) return;
        if (node.right != null) {
            prettyPrint(node.right, indent + (isLeft ? "│   " : "    "), false);
        }
        System.out.print(indent);
        System.out.print(isLeft ? "└── " : "┌── ");
        System.out.println(node.value);
        if (node.left != null) {
            prettyPrint(node.left, indent + (isLeft ? "    " : "│   "), true);
        }
    }

    private void prettyDisplay(Node node, int level){
        if (node==null){
            return;
        }
        prettyDisplay(node.right, level+1);
        if (level!=0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.value);
        }else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);
    }


    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if (node==null){
            return true;
        }
        if (Math.abs(height(node.left) - height(node.right))>1){
            return false;
        }
        return balanced(node.left) && balanced(node.right);
    }


    public void populate(int[] arr){
        for (int e : arr) {
            insert(e);
        }
    }
    public void populateSorted(int[] arr){
       populateSorted(arr, 0, arr.length);
    }

    //Only helpful if you know the array is sorted otherwise we have self-balanced binary trees like AVL trees
    //TC: O( N(log(N) )
    public void populateSorted(int[] arr, int s, int e){
        if (s>=e){
            return;
        }
        int m=s+(e-s)/2;
        insert(arr[m]);
        populateSorted(arr, s, m);
        populateSorted(arr, m+1, e);
    }

    public static void main(String[] args) {
        AVL_3 tree=new AVL_3();

        for (int i = 0; i < 20; i++) {
            tree.insert(i);
        }
        tree.display();
        System.out.println(tree.root.height);
        System.out.println(tree.balanced());
    }


}
