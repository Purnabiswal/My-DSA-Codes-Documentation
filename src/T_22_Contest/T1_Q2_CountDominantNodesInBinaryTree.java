package src.T_22_Contest;

//https://leetcode.com/contest/weekly-contest-511/problems/count-dominant-nodes-in-a-binary-tree/
public class T1_Q2_CountDominantNodesInBinaryTree {

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int[] find(TreeNode node){
        int val=node.val;
        if(node.left==null && node.right==null){
            return new int[]{val, 1};
        }


        int[] left={Integer.MIN_VALUE, 0};
        int[] right={Integer.MIN_VALUE, 0};

        if(node.left!=null){
            left=find(node.left);
        }

        if(node.right!=null){
            right=find(node.right);
        }

        int max=Math.max(left[0], right[0]);
        int y=left[1]+right[1];
        if(val>=max){
            max=val;
            y++;
        }

        return new int[]{max, y};
    }
}





