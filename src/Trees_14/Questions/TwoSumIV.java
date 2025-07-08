package src.Trees_14.Questions;

import java.util.*;


//Note: In a set you cant remove an element while iterating over it, if you do so it will give you a "modification" error
public class TwoSumIV {
     public static class TreeNode {
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

    //653. Two Sum IV - Input is a BST. Easy
    int index=0;
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        helper(root, set);
        for(Integer e:set){
            int complement=k-e;
            if(set.contains(complement) && complement!=e){
                return true;
            }
        }
        return false;
    }

    public void helper(TreeNode node, HashSet<Integer> set){
         if (node==null){
             return;
         }
         helper(node.left, set);
         set.add(node.val);
         index++;
         helper(node.right, set);
    }


    //faster than previous
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        helper2(root, list);
        int left=0;
        int right=list.size()-1;
        //because I know the list is sorted
        while (left<right){
            int sum=list.get(left)+ list.get(right);
            if (sum==k){
                return true;
            } else if (sum < k) {
                left++;
            }else {
                right--;
            }
        }
        return false;
    }

    public void helper2(TreeNode node, List<Integer> list){
        if (node==null){
            return;
        }
        helper2(node.left, list);
        list.add(node.val);
        helper2(node.right, list);
    }


}
