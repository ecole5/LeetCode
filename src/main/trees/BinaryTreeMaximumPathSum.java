package trees;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class BinaryTreeMaximumPathSum {


    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //Create parent map
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        parentMapHelper(root,null,parentMap);



        //every possible starting point
        for (TreeNode n : parentMap.keySet()){
          maxPathSumHelper(n,0,parentMap,new HashSet<>());
        }

        return max;


    }

    private void maxPathSumHelper(TreeNode n, int currentPathSum, HashMap <TreeNode, TreeNode> parentMap, HashSet<TreeNode> marked){
        if (n == null ){
            return;
        }


        //do not allow two elements from same path to exist
        if (!marked.contains(n)) {

            marked.add(n); //need this because we are creating an undirect graph


            max = Math.max(max, currentPathSum+n.val); //see if this path updates global maximum

            maxPathSumHelper(n.left, currentPathSum + n.val, parentMap, marked);
            maxPathSumHelper(n.right, currentPathSum + n.val, parentMap, marked);
            maxPathSumHelper(parentMap.get(n), currentPathSum + n.val, parentMap, marked);


        }

    }

    private void parentMapHelper(TreeNode n,TreeNode parent, HashMap<TreeNode,TreeNode> parentMap){
        if (n == null){
            return;
        }

        parentMap.put(n,parent);
        parentMapHelper(n.left, n, parentMap);
        parentMapHelper(n.right, n, parentMap);

    }


}
