package TreeDFS;

import helper.TreeNode;

public class BinaryTreeMaximumPathSum {

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       maxPathSumHelper(root);
       return maxValue;
    }

    private int maxPathSumHelper(TreeNode n){
        if (n == null){
            return -1;
        }
        int total = n.val; //biggest possible path that includes node n

        int left = maxPathSumHelper(n.left);
        int right = maxPathSumHelper(n.right);



        if (left > 0){
            total += left;
        }
        if (right > 0){
            total += right;
        }

        maxValue = Math.max(total,maxValue); //if no nodes above are included we are allowed to consider case in which node itself is max, both left and right can contribute

        return Math.max( n.val, n.val+Math.max(left,right)); //the greatest contribtuion upward can only inlcude left and right once. No forking twice

    }



}
