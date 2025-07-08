package src.Trees_14;

import java.util.PriorityQueue;
import java.util.Random;

public class BST_2 {

    public BST_2(){

    }
    public class TreeNode {
        private int val;
        private int height;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int value) {
            this.val =value;
        }
        int getVal(){
            return val;
        }
    }

    private TreeNode root;

    public int height(TreeNode node){
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
    private void show(TreeNode node, String details){
        if (node==null){
            return;
        }
        System.out.println(details+node.val);
        show(node.left, "Left child of "+ node.val +": ");
        show(node.right, "Right child of "+ node.val +": ");
    }
    //TC: O(log(n))
    //Recursive one
    public void insert(int value){
        root=insert(value, root);
    }
    public TreeNode insert(int value, TreeNode node){
        if (node==null){
            return new TreeNode(value);
        }
        if (value<node.val){
            node.left=insert(value, node.left);
        }else {
            node.right=insert(value, node.right);
        }
        node.height=Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    //iterative one
//    public void insert(int value){
//        Node node=new Node(value);
//        if (root==null){
//            root=node;
//            return;
//        }
//        Node temp=root;
//        while(true){
//            if (value<temp.value){
//                if (temp.left==null){
//                    temp.left=node;
//                    return;
//                }
//                temp=temp.left;
//            }else {
//                if (temp.right==null){
//                    temp.right=node;
//                    return;
//                }
//                temp=temp.right;
//            }
//        }
//    }
    public void display(){
        prettyDisplay(root, 0);
    }
    public void prettyDisplay(TreeNode node, int level){
        if (node==null){
            return;
        }
        prettyDisplay(node.right, level+1);
        if (level!=0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.val);
        }else {
            System.out.println(node.val);
        }
        prettyDisplay(node.left, level+1);
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(TreeNode node){
        if (node==null){
            return true;
        }
        if (Math.abs(height(node.left) - height(node.right))>1){
            return false;
        }
        return balanced(node.left) && balanced(node.right);
    }


    //Only for me, not a genuine func. Inserting random no.s to tree
//    public void populate(){
//        Random r=new Random();
//        for (int i = 0; i < 10; i++) {
//            insert(r.nextInt(60));
////            insert((int)((Math.random())*41)+10); //another way
//        }
//    }


    public void populate(int[] arr){
        Random r=new Random();
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

    //Traversal:
    public void preorder(){
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }
    public void preorder(TreeNode node){
        if (node==null){
            return;
        }
        System.out.print(node.val +" ");
        preorder(node.left);
        preorder(node.right);
    }

    //In BST inorder always prints in a sorted manner
    public void inorder(){
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }
    public void inorder(TreeNode node){
        if (node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.val +" ");
        inorder(node.right);
    }

    public void postorder(){
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }
    public void postorder(TreeNode node){
        if (node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val +" ");
    }

    //Questions


    //LC_230
    //3 1 0 2 0 0 4 0 0
    //5 3 2 1 0 0 0 4 0 0 6 0 0
    int count=1;
    public int kthSmallest(TreeNode node, int k) {
        if(node==null) return -1;
        int left=kthSmallest(node.left, k);
        if(left==-1 && k==1){
            return node.val;
        }
        k--;
        int right=kthSmallest(node.right, k);
        return left==-1?right:left;
    }

    //Another way
    //Without global variable
    public int kthSmallest2(TreeNode node, int k) {
        int[] arr={k+1};
        return helper2(node, arr);
    }
    public int helper2(TreeNode node, int[] arr) {
        if(node==null) return -1;
        int left=helper2(node.left, arr);
        arr[0]-=1;
        if(arr[0]==1){
            return node.val;
        }
        int right=helper2(node.right, arr);
        return left==-1?right:left;
    }

    //way-3
    //Using heap
    public int kthSmallest3(TreeNode node, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        helper3(node, heap);
        int ans=0;
        for (int i = 0; i < k; i++) {
            if (!heap.isEmpty()){
                ans=heap.poll();
            }
        }
        return ans;
    }
    public void helper3(TreeNode node, PriorityQueue<Integer> heap) {
        if(node==null) return;
        helper3(node.left, heap);
        heap.add(node.val);
        helper3(node.right, heap);
    }

    //99. Recover Binary Search Tree. Medium
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        recoverTree1(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    public void recoverTree1(TreeNode node) {
        if (node==null){
            return;
        }

        recoverTree1(node.left);
        if ( prev!=null && node.val< prev.val){
            if (first==null){
                first=prev;
                second=node;
            }
            second=node;
        }
        prev=node;
        recoverTree1(node.right);
    }


    public static void main(String[] args) {
        BST_2 tree=new BST_2();
        int[] arr={10,5,7,3,4,20,21,15};
        //tree.populateSorted(arr); //Use this if your array is sorted (It will balance the tree)
        tree.populate(arr);
        tree.display();
        tree.show();
        tree.preorder();
        tree.inorder();
        tree.postorder();
        System.out.println(tree.balanced());
    }


}
