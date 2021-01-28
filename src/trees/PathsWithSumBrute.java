package trees;


import helper.TreeNode;


//Find number of paths that sum to target value
//Paths do not need to begin or end with root or leaf
//O(n^2 time) worst case, O(logn space)?, O(nlogN) in balanced case
public class PathsWithSumBrute {

    public static void main (String args []){
        PathsWithSumBrute run = new PathsWithSumBrute();
        TreeNode r = new TreeNode(-1,new TreeNode(1), new TreeNode(-4));
        System.out.println(run.pathSum(0,r));
    }

    private int numPathsFound = 0;

    //returns number of paths that sum to given value
    public int pathSum(int targetValue, TreeNode head){
        pathSumHelper(targetValue,head);
        return  numPathsFound;
    }


    //Preorder traverse each node to search for all paths starting from n
    private void pathSumHelper(int targetValue, TreeNode n){
        if (n != null){
            countPathsStartingFromN(targetValue, 0, n); //does 0 here work
            pathSumHelper(targetValue,n.left);
            pathSumHelper(targetValue,n.right);

        }
    }

    //Search all downward paths starting from N
    //Pass down summed value and at each point check if it is a new valid path
    private void countPathsStartingFromN(int targetValue, int sumValue, TreeNode n){
        if (n != null) {
            if (sumValue + n.val == targetValue) {
                numPathsFound++;
            }
            countPathsStartingFromN(targetValue,sumValue + n.val,n.left);
            countPathsStartingFromN(targetValue,sumValue + n.val,n.right);
        }
    }





}
