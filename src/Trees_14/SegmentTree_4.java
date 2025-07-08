package src.Trees_14;

public class SegmentTree_4 {

    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
        }
    }

    private Node root;

    public SegmentTree_4(int[] arr){
        //Create a tree using this array
        this.root = constructTree(arr, 0, arr.length-1);
    }
    public Node constructTree(int[] arr, int startInterval, int endInterval){
        Node node = new Node(startInterval, endInterval);
        if (startInterval==endInterval){
            node.data=arr[startInterval];
            return node;
        }
        int m=startInterval+(endInterval-startInterval)/2;
        node.left = constructTree(arr, startInterval, m);
        node.right = constructTree(arr, m+1, endInterval);
        node.data = node.left.data + node.right.data;
        return node;
    }

    //update
    public void update(int index, int value){
        if (index<0 || index > root.endInterval){
            return;
        }
        root.data=update(root, index, value);
    }
    private int update(Node node, int index, int value){
        if (index<node.startInterval || index>node.endInterval){
            return node.data;
        }
        if (node.startInterval==index && node.endInterval==index){
            node.data=value;
            return value;
        }
        node.data = update(node.left, index, value) + update(node.right, index, value);
        return node.data;
    }

    //query (Example: sum, max, min etc. query)
    public int query(int a, int b){
        return query(root, a, b);
    }
    private int query(Node node, int a, int b){
        if (node.startInterval>=a && node.endInterval<=b){
            //node is completely lying inside query
            return node.data;
        }
        if ((node.endInterval<a || node.startInterval>b)){
            //completely outside
            return 0;
        }
        //Overlapping
        return query(node.left, a, b) + query(node.right, a, b);//sum: +, max: return max
    }

    public void prettyPrint(){
        prettyPrint(root, "", true);
    }
    private void prettyPrint(Node node, String indent, boolean isLeft) {
        if (node == null) return;
        if (node.right != null) {
            prettyPrint(node.right, indent + (isLeft ? "│   " : "    "), false);
        }
        System.out.print(indent);
        System.out.print(isLeft ? "└── " : "┌── ");
        System.out.println(node.data+"["+ node.startInterval+","+ node.endInterval+"]");
        if (node.left != null) {
            prettyPrint(node.left, indent + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        int[] arr={3,8,7,6,-2,-8,4,9};
        SegmentTree_4 tree = new SegmentTree_4(arr);
        tree.prettyPrint();
//        tree.update(3, 14);
//        tree.prettyPrint();
        System.out.println(tree.query(2, 6));

    }

}
