package com.trees;

import com.TreeNode;

public class PathsWithSum {



    //returns number of paths that sum to given value
    public int pathSum(int givenValue, TreeNode head){
        return pathSum(givenValue,0,head);
    }

    //O(log(n)) space
    //O(n) time since every element is touched
    //n is size of

    private int pathSum (int givenValue, int totalSum, TreeNode n){
        if (n == null){ //base case is when we go past leaf
         return 0;
        }
        else{
            int sumSoFar = n.val+totalSum;
            //count paths in left subtree
            int leftSum = pathSum(givenValue,sumSoFar, n.left );
            //count paths in right subtree
            int rightSum = pathSum(givenValue,sumSoFar, n.right);
            //return paths and left and right and add 1 if the current path is at target value
            return leftSum+rightSum + (sumSoFar == givenValue ? 1 : 0);
        }
    }


}
