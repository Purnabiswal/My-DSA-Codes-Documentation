package src.Trees_14;

import java.util.*;

public class BinaryTree_1 {

    public BinaryTree_1(){

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    private TreeNode root;

    //insert elements
    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        root=new TreeNode(scanner.nextInt());

        populate(scanner, root);
    }

    private void populate(Scanner scanner, TreeNode node){
        System.out.println("Enter left node of "+node.val +" (-1 if none): ");
        int leftValue=scanner.nextInt();
        if (leftValue!=0){
            TreeNode left=new TreeNode(leftValue);
            node.left=left;
            populate(scanner, left);
        }
        System.out.println("Enter right node of "+node.val +" (-1 if none): ");
        int rightValue=scanner.nextInt();
        if (rightValue!=0){
            TreeNode right=new TreeNode(rightValue);
            node.right=right;
            populate(scanner, right);
        }
    }
    public void display(){
        prettyDisplay(root, 0);
    }
    public void display(TreeNode node, String indent){
        if (node==null){
            return;
        }
        System.out.println(indent+node.val);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

    //15 5 3 1 0 0 25 0 0 2 0 0 4 0 9 0 0
    //Good-one
    private void prettyDisplay(TreeNode node, int level){
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
    public void prettyDisplay1(TreeNode node, String indent){
        if (node==null){
            return;
        }
        prettyDisplay1(node.right, indent+"\t");
        System.out.println(indent+node.val);
        prettyDisplay1(node.left, indent+"\t");

    }


//    private void populate(Scanner scanner, Node node){
//        System.out.println("Do you want to insert in left? (y/n)");
//        if (Objects.equals(scanner.next(), "y")){
//            System.out.println("Enter value: ");
//            Node temp=new Node(scanner.nextInt());
//            node.left=temp;
//            populate(scanner, temp);
//        }
//        System.out.println("Do you want to insert in right? (y/n)");
//        if (Objects.equals(scanner.next(), "y")){
//            System.out.println("Enter value: ");
//            Node temp=new Node(scanner.nextInt());
//            node.right=temp;
//            populate(scanner, temp);
//        }
//    }

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

    //BFS
    public void bfs(){
        //1 2 4 8 0 0 9 0 0 5 0 0 3 6 10 0 0 0 7 0 11 0 0
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        ArrayList<ArrayList<Integer>> mainList = bfs(queue, root, new ArrayList<>(), list);
        System.out.println();
        for (ArrayList<Integer> e : mainList){
            System.out.print(e);
        }
    }

    //Questions
    //Binary Tree Level Order Traversal. Leetcode_102
    //TC: O(n)
    //wrong output for some cases
    public ArrayList<ArrayList<Integer>> bfs(Queue<TreeNode> queue, TreeNode node, ArrayList<ArrayList<Integer>> mainList, ArrayList<Integer> list){
        if (node==null){
            return mainList;
        }
        if (!list.isEmpty() && list.getFirst()==node.val){
            mainList.add(new ArrayList<>(list));
            list.clear();
        }
        System.out.print(node.val + " ");
        if (node.left!=null){
            queue.add(node.left);
            list.add(node.left.val);
        }
        if (node.right!=null){
            queue.add(node.right);
            list.add(node.right.val);
        }
        queue.remove();
        bfs(queue, queue.peek(), mainList, list);
        return mainList;
    }

    //LC_102
    public void levelOrder() {
//        -2 -9 3 5 -6 0 0 0 2 0 0 5 0 0 1 -1 -3 -1 0 0 0 0 9 -7 0 0 6 -9 8 0 0 0 9 -2 0 0 5 0 0
        levelOrder(root);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mainList=new ArrayList<>();
        if (root==null) return mainList;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int len = queue.size();
            for (int i = len; i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            mainList.add(list);
        }
        for (List<Integer> e:mainList){
            System.out.println(e);
        }
        return mainList;
    }

    //637. Average of Levels in the Binary Tree. LC_637
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len= queue.size();
            double avg=0;
            for (int i = 0; i < len; i++) {
                TreeNode node=queue.poll();
                queue.peek();
                avg += node.val;
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            avg/=len;
            arr.add(avg);
        }
        return arr;
    }

    //103. Binary Tree Zigzag Level Order Traversal. LC_103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainList=new ArrayList<>();
        if (root==null) return mainList;

        Deque<TreeNode> queue=new ArrayDeque<>();
        boolean isTrue=true;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int len = queue.size();
            for (int i = len; i > 0; i--) {
                TreeNode node;
                if (isTrue) {
                    node = queue.poll();
                    if (node.left!=null){
                        queue.add(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }else {
                    node = queue.removeLast();
                    if (node.right != null){
                        queue.addFirst(node.right);
                    }
                    if (node.left!=null){
                        queue.addFirst(node.left);
                    }
                }
                list.add(node.val);
            }
            isTrue = !isTrue;
            Collections.reverse(list);
            mainList.add(list);
        }
        for (List<Integer> e:mainList){
            System.out.println(e);
        }
        return mainList;
    }

    //116. Populating Next Right Pointers in Each Node. LC_116
    public TreeNode connect(TreeNode root) {
        if (root==null) return null;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len-1; i++) {
                TreeNode node = queue.poll();
                //node.next = queue.peek(); //next is used in leetcode
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
    //Optimised. LC_116
//    public Node connect(Node root) {
//        if (root==null) return root;
//        Node node=root;
//        while(node!=null){
//            Node cur=node;
//            while(cur!=null){
//                if(cur.left!=null) cur.left.next=cur.right;
//                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
//                cur=cur.next;
//            }
//            node=node.left;
//        }
//        return root;
//    }

    //199. Binary Tree Right Side View. LC_199
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> mainList=new ArrayList<>();
        if (root==null) return mainList;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (i==len-1) mainList.add(node.val);
            }

        }
        return mainList;
    }

    //993. Cousins in Binary Tree. LC_993
    //Kunal done this differently. Watch video BT questions video at 1:19:00
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        int levelX=0;
        int parentX=0;
        int levelY=0;
        int parentY=0;
        while (!queue.isEmpty()){
            if(levelX!=0) break;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                    int child=node.left.val;
                    if(child==x) {
                        levelX=level+1;
                        parentX=node.val;
                    }
                    if(child==y) {
                        levelY=level+1;
                        parentY=node.val;
                    }
                }
                if (node.right != null){
                    queue.offer(node.right);
                    int child=node.right.val;
                    if(child==x) {
                        levelX=level+1;
                        parentX=node.val;
                    }
                    if(child==y) {
                        levelY=level+1;
                        parentY=node.val;
                    }
                }
            }
            level++;
        }
        return levelX==levelY && parentX!=parentY;
    }

    //101. Symmetric Tree.
    //Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    //1 2 3 0 0 4 0 0 2 4 0 0 3 0 0
    //1 2 3 5 0 0 0 4 0 0 2 4 0 5 0 0 3 0 0
    public boolean isSymmetric() {
        return isSymmetric(root);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();

            if (left==null && right==null) continue;
            if (left==null || right==null) return false;
            if (left.val!=right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    //LC_543
    public int diameterOfBinaryTree(TreeNode node) {
        int[] dia=new int[1];
        height(node, dia);
        return dia[0];
    }

    public int height(TreeNode node, int[] dia){
        if (node==null) {
            return 0;
        }
        int left=height(node.left, dia);
        int right=height(node.right, dia);
        dia[0]=Math.max(dia[0], left+right);
        return Math.max(left, right)+1;
    }

    //LC_226
    public TreeNode invertTree(TreeNode node) {
        //preorder
        if(node == null) return node;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        invertTree(node.left);
        invertTree(node.right);
        return node;
    }
    //another way:
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                TreeNode temp=node.left;
                node.left=node.right;
                node.right=temp;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    //LC_108
    public TreeNode sortedArrayToBST(int[] nums) {
        root= sortedArrayToBST(nums, 0, nums.length-1);
        display();
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        int m=(s+e)/2;
        TreeNode node=new TreeNode(nums[m]);
        if(s>e){
            return null;
        }
        if (s==e){
            return node;
        }
        node.left=sortedArrayToBST(nums, s, m-1);
        node.right=sortedArrayToBST(nums, m+1, e);
        return node;
    }



    //LC_114
    //1 2 3 0 0 4 0 0 5 0 6 0 0
    TreeNode root1=new TreeNode(-1);
    TreeNode tail=root1;
    public void flatten(TreeNode node) {
        flatten1(node);
        node.right=root1.right.right;
        display();
    }
    public void flatten1(TreeNode node) {
        if(node==null){
            return;
        }
        insert(node);
        flatten1(node.left);
        flatten1(node.right);
    }
    public void insert(TreeNode node){
        tail.right=new TreeNode(node.val);
        tail=tail.right;
    }

    //LC_114
    static public TreeNode flatten2(TreeNode node) {
        TreeNode temp=node;
        if (node.left==null && node.right==null){
            return node;
        }
        TreeNode left=node.left;
        TreeNode right=node.right;
        if (left!=null){
            temp=flatten2(left);
            temp.right=right;
        }
        if (right!=null){
            temp=flatten2(right);
        }
        if (left!=null){
            node.right=left;
            node.left=null;
        }
        return temp;
    }
    //LC_114
    //O(1) space. Efficient
    public void flatten3(TreeNode root) {
        TreeNode node=root;
        while(node!=null){
            if(node.left!=null){
                TreeNode rightMost=node.left;
                while(rightMost.right!=null){
                    rightMost=rightMost.right;
                }
                rightMost.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
    }

    //
//    public void flatten3(Node root) {
//        if(root == null) return;
//        help(root);
//    }
//
//    public Node help(Node node) {
//        Node temp = node;
//        if (node.left == null && node.right == null) return node;
//
//        Node left = node.left;
//        Node right = node.right;
//
//        if (left != null) {
//            temp = help(left);
//            temp.right = right;
//        }
//
//        if (right != null) {
//            temp = help(right);
//        }
//
//        if (left != null) {
//            node.right = left;
//            node.left = null;
//        }
//
//        return temp;
//    }

    //LC_98
    public boolean isValidBST(TreeNode node){
        Queue<Integer> queue=new LinkedList<>();
        helper(root, queue);
        while(!queue.isEmpty()){
            int n=queue.poll();
            System.out.print(n+" ");
            if(!queue.isEmpty() && n>=queue.peek()){
                return false;
            }
        }
        return true;
    }
    public void helper(TreeNode node, Queue<Integer> queue) {
        if(node==null){
            return;
        }
        helper(node.left, queue);
        queue.offer(node.val);
        helper(node.right, queue);
    }
    //Another way
    //10 5 3 1 0 2 0 0 4 0 0 6 0 9 0 0 2 19 0 0 27 0 0
    //5 1 0 0 4 3 0 0 6 0 0
    //5 4 0 0 6 3 0 0 7 0 0
    public boolean isValidBST2(TreeNode root){
        TreeNode node=root, rightMost, prev=null;
        while (node!=null){
            if (node.left==null){
                if (prev!=null && prev.val>=node.val){
                    return false;
                }
                prev=node;
                node=node.right;
            }else {
                rightMost=node.left;
                while (rightMost.right!=node && rightMost.right!=null){
                    rightMost=rightMost.right;
                }
                if (rightMost.right==null){
                    rightMost.right=node;
                    node=node.left;
                }else {
                    if (prev!=null && prev.val>=node.val){
                        return false;
                    }
                    rightMost.right=null;
                    prev=node;
                    node=node.right;
                }
            }
        }
        return true;
    }

    //Efficient
    public boolean isValidBST3(TreeNode root) {
        TreeNode node=root;
        return help(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean help(TreeNode node, long min, long max){
        if (node==null){
            return true;
        }
        if (node.val<=min || node.val>=max){
            return false;
        }
        return help(node.left, min, node.val) && help(node.right, node.val, max);
    }

    //LC_236
    //3 5 7 28 0 0 10 34 0 0 8 0 0 11 0 0 1 6 0 0 9 0 0
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper1(root, p, q);
    }

    public TreeNode helper1(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null || node.val==p.val || node.val==q.val){
            return null;
        }
        TreeNode left=helper1(node.left, p, q);
        TreeNode right=helper1(node.right, p, q);
        if (left!=null && right!=null){
            return node;
        }
        return left==null?right:left;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val){
            return root;
        }
        TreeNode l=lowestCommonAncestor2(root.left,p,q);
        TreeNode r=lowestCommonAncestor2(root.right,p,q);
        if(l!=null && r!=null){
            return root;
        }else if(l!=null && r==null){
            return l;
        }else{
            return r;
        }
    }

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


    //105. Construct Binary Tree from Preorder and Inorder Traversal. LC_105
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i=1;
        int len=preorder.length;
        TreeNode root=new TreeNode(preorder[0]);
        while (i<len){
            TreeNode node=new TreeNode(preorder[i]);
            TreeNode cur=root;
            while (true){
                boolean res=isBig(inorder, node.val, cur.val);
                if (res){
                    if (cur.left==null){
                        cur.left=node;
                        break;
                    }else {
                        cur=cur.left;
                    }
                }else {
                    if (cur.right==null){
                        cur.right=node;
                        break;
                    }else {
                        cur=cur.right;
                    }
                }
            }
            i++;
        }
        return root;
    }

    //true means: n is smaller than c
    public boolean isBig(int[] arr, int n, int c){
        for (int j : arr) {
            if (j == n) {
                return true;
            }
            if (j == c) {
                return false;
            }
        }
        return false;
    }

    //Another way
    int p=0;
    int i=0;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree2(preorder, inorder, Integer.MIN_VALUE);
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder, int stop) {
        if (i<inorder.length && inorder[i]<stop){
            TreeNode node = new TreeNode(preorder[p++]);
            node.left=buildTree2(preorder, inorder, node.val);
            i++;
            node.right=buildTree2(preorder, inorder, stop);
            return node;
        }
        return null;
    }

    //LC_105. Using hashmap

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        int n= preorder.length;
        Map<Integer, Integer> map=new HashMap<>();

        for (int j = 0; j < n; j++) {
            map.put(inorder[i], i);
        }

        return buildTree3(preorder, inorder, map, 0, n-1, 0, n-1);
    }
    public TreeNode buildTree3(int[] preorder, int[] inorder, Map<Integer, Integer> map, int inStart, int inEnd, int pStart, int pEnd) {

        if (pStart>pEnd || inStart>inEnd){
            return null;
        }

        TreeNode node=new TreeNode(preorder[pStart]);
        int index=map.get(preorder[pStart]);
        int numLeft=index-inStart;
        node.left=buildTree3(preorder, inorder, map, inStart, index-1, pStart+1, pStart+numLeft);
        node.right=buildTree3(preorder, inorder, map, index+1, inEnd, numLeft+pStart+1, pEnd);
        return node;
    }

    //297. Serialize and Deserialize Binary Tree. LC_297-Hard
    // Encodes a tree to a single string.
    //1 2 4 0 0 5 0 0 3 0 6 0 0
    public String serialize(TreeNode root) {
        StringBuilder st=new StringBuilder();
        serialize(root, st);
        st.deleteCharAt(st.length()-1);
        String[] arr=st.toString().split(",");
//        for (String e:arr){
//            System.out.print(e+" ");
//        }
        return st.toString();
    }
public void serialize(TreeNode node, StringBuilder st) {
    if (node==null){
        st.append("null,");
        return;
    }
    st.append(node.val).append(",");
    serialize(node.left,st);
    serialize(node.right,st);
}

//using array list
//    public String serialize(TreeNode root) {
//        List<String> st=new ArrayList<>();
//        serialize(root, st);
//        String x=String.join(",",st);
//        System.out.println(x);
//        return x;
//    }
//    public void serialize(TreeNode node, List<String> st) {
//        if (node==null){
//            st.add("null");
//            return;
//        }
//        st.add(String.valueOf(node.val));
//        serialize(node.left,st);
//        serialize(node.right,st);
//    }

//    // Decodes your encoded data to tree.
    //int i=0;
    //1 2 0 0 3 4 0 0 5 0 0
    public TreeNode deserialize(String data) {
        String[] parts=data.split(",");
//        int[] arr=new int[st.length];
        TreeNode node=deserialize(parts);
        prettyDisplay(node, 0);
        return node;
    }
    public TreeNode deserialize(String[] data) {
        if (data[i].equals("null")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(data[i++]));
        node.left=deserialize(data);
        i++;
        node.right=deserialize(data);
        return node;
    }

    //112. Path Sum. LC_112-Easy
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        return hasPathSum(root, 0, targetSum);
    }
    public boolean hasPathSum(TreeNode node, int sum, int targetSum) {
        sum+=node.val;
        if (node.left==null && node.right==null){
            return sum==targetSum;
        }
        return (node.left != null && hasPathSum(node.left,sum,targetSum)) || (node.right != null && hasPathSum(node.right, sum, targetSum));
    }

    //129. Sum Root to Leaf Numbers. Medium
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode node, int num) {
        num = (num*10) + node.val;
        if (node.left == null && node.right==null){
            return num;
        }
        int left=0;
        int right=0;
        if (node.left!=null){
            left=sumNumbers(node.left, num);
        }
        if (node.right!=null){
            right=sumNumbers(node.right, num);
        }
        return left+right;
    }

    //124. Binary Tree Maximum Path Sum. Hard
//    public int maxPathSum(TreeNode root) {
//
//    }

//    public int maxPathSum(TreeNode node) {
//        if (node.left == null && node.right==null){
//            return node.val;
//        }
//        int path1=Integer.MIN_VALUE;
//        int path2=Integer.MIN_VALUE;
//        int path;
//
//        if (node.left!=null){
//            path1=maxPathSum(node.left);
//        }
//        if (node.right!=null){
//            path2=maxPathSum(node.right);
//        }
//        int left=(node.left!=null?pathSum(node.left,0):0);
//        int right=(node.right!=null?pathSum(node.right,0):0);
//        left= Math.max(left, 0);
//        right= Math.max(right, 0);
//        path=left+node.val+right;
//        path=Math.max(path,path1);
//        return Math.max(path, path2);
//    }
//
//    public int pathSum(TreeNode node, int sum){
//        sum+=node.val;
//        if (node.left==null && node.right==null){
//            return sum;
//        }
//        int left=0;
//        int right=0;
//        if (node.left!=null){
//            left=pathSum(node.left,sum);
//        }
//        if (node.right!=null){
//            right=pathSum(node.right, sum);
//        }
//        sum=Math.max(sum,left);
//        return Math.max(sum,right);
//    }

    public int maxPathSum(TreeNode node) {
        int[] res={node.val};
        maxPathSum(node,res);
        return res[0];
    }

    public int maxPathSum(TreeNode node, int[] res) {
        if (node==null){
            return 0;
        }
        int path1=maxPathSum(node.left,res);
        int path2=maxPathSum(node.right,res);
        if (path1<0) path1=0;
        if (path2<0) path2=0;
        res[0]=Math.max(res[0], path1+ node.val + path2);
        return Math.max(path1, path2)+ node.val;
    }

    //Only for checking purposes
    //max path sum from root to leaf
    public int pathSum(TreeNode node, int sum){
        sum+=node.val;
        if (node.left==null && node.right==null){
            return sum;
        }
        int left=0;
        int right=0;
        if (node.left!=null){
            left=pathSum(node.left,sum);
        }
        if (node.right!=null){
            right=pathSum(node.right, sum);
        }
        sum=Math.max(sum,left);
        return Math.max(sum,right);
    }

    //Q. Path exists in BT from root to leaf
    public boolean checkPath(TreeNode node, int[] arr){
        return checkPath(node, arr, 0);
    }
    public boolean checkPath(TreeNode node, int[] arr, int index){
        if (node==null || node.val!=arr[index] || index>arr.length-1){
            return false;
        }
        if (node.left==null && node.right==null && index==arr.length-1){
            return true;
        }
        return checkPath(node.left, arr, index+1) || checkPath(node.right, arr, index+1);
    }

    //Q. How many Paths exist in BT at any nodes? LC_437
    public int paths(TreeNode node, int n){
        List<Integer> list=new LinkedList<>();
        return paths(node, 4, list);
    }


    public int paths(TreeNode node, int n, List<Integer> path){
        if(node==null){
            return 0;
        }

        path.add(node.val);
        int count=0;
        Long sum= 0L;
        //how many paths I can make
        for (int i = path.size()-1; i >= 0; i--) {
            sum+=path.get(i);
            if (sum==n){
                count++;
            }
        }
        count+=paths(node.left, n, path)+paths(node.right, n, path);
        //backtrack
        path.removeLast();
        return count;
    }


    //Q. Return total Paths exist in BT at any nodes?
    public int findPaths(TreeNode node, int n){
        List<List<Integer>> list=new LinkedList<>();
        int ans=findPaths(node, n, new LinkedList<>(), list);
        for (List<Integer> e:list){
            System.out.println(e);
        }
        return ans;
        //1 3 0 0 2 1 11 2 2 0 0 0 13 0 0 1 0 0 3 2 0 2 10 0 0 0 0
    }

    public int findPaths(TreeNode node, int n, List<Integer> path, List<List<Integer>> mainList){
        if(node==null){
            return 0;
        }

        path.add(node.val);
        int count=0;
        Long sum= 0L;
        List<Integer> list=new ArrayList<>();
        //how many paths I can make
        for (int i = path.size()-1; i >= 0; i--) {
            int e=path.get(i);
            list.addFirst(e);
            sum+=e;
            if (sum==n){
                mainList.add(new ArrayList<>(list));
                list.clear();
                count++;
            }
        }
        count+=findPaths(node.left, n, path, mainList)+findPaths(node.right, n, path, mainList);
        //backtrack
        path.remove(path.size()-1);
        return count;
    }

    //Q. DFS using stack or without recursion
    public void dfsStack(TreeNode node){
        if (node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode removed=stack.pop();
            System.out.print(removed.val+" ");
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
    }

    //987. Vertical Order Traversal of a Binary Tree. Hard
    // 3 9 0 0 20 15 0 0 7 0 0
    // 1 2 4 0 0 6 0 0 3 5 0 0 7 0 0
    int minVal=Integer.MAX_VALUE;
    int maxVal=Integer.MIN_VALUE;
    class Pair {
        int row;
        int val;
        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] pair={0,0};
        Map<Integer, List<Pair>> map=new HashMap<>();
        verticalTraversal(root, map,0, 0);
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i = minVal; i <= maxVal; i++) {
            List<Pair> pairs = map.get(i);
            pairs.sort((a, b) -> {
                if (a.row != b.row) return a.row - b.row;
                return a.val - b.val;
            });
            List<Integer> vertical = new ArrayList<>();
            for (Pair p : pairs) {
                vertical.add(p.val);
            }
            mainList.add(vertical);
        }

        for (List<Integer> e:mainList){
            System.out.println(e);
        }

        return mainList;
    }
    //Using preorder
    public void verticalTraversal(TreeNode node, Map<Integer, List<Pair>> map, int r, int c) {
        if (node==null){
            return;
        }
        minVal=Math.min(minVal,c);
        maxVal=Math.max(maxVal,c);
        verticalTraversal(node.left, map, r+1, c-1);
        List<Pair> list=map.getOrDefault(c, new ArrayList<>());
        //add randomly then sort at the end while inserting in mainList
        list.add(new Pair(r, node.val));
        map.put(c, list);
        verticalTraversal(node.right, map, r+1, c+1);
    }













    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree_1 tree = new BinaryTree_1();
        tree.populate(scanner);
        tree.display();
        //tree.bfs();
        //tree.levelOrder();
        //System.out.println(tree.isSymmetric());
        //int[] arr={-10,-3,0,5,9};
        //tree.sortedArrayToBST(arr);
        //tree.flatten(tree.root);
        //System.out.println(tree.isValidBST2(tree.root));
        //TreeNode p=new TreeNode(5);
        //TreeNode q=new TreeNode(8);
        //System.out.println(tree.lowestCommonAncestor(tree.root, p, q).val);
        //TreeNode node=tree.lowestCommonAncestor2(tree.root, p, q);
        //System.out.println(node.val);
        //System.out.println(tree.kthSmallest(tree.root,3));
        //int[] preorder={3,9,20,15,7};
        //int[] inorder={9,3,15,20,7};
        //tree.prettyDisplay(tree.buildTree(preorder,inorder), 0);

//        StringBuilder st=new StringBuilder();
//        st.append("14,15,null,36");
//        String[] arr=st.toString().split(",");
//        for (String e:arr){
//            System.out.println(e);
//        }

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        tree.deserialize(tree.serialize(tree.root));
//
//        System.out.println(tree.pathSum(tree.root,0));
//        System.out.println(tree.maxPathSum(tree.root));

        //tree.findPaths(tree.root, 4);


        tree.verticalTraversal(tree.root);

    }
}
