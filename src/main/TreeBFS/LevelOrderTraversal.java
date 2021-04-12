package TreeBFS;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


    //return a list of each level of binary tree

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> nextToVisit = new LinkedList<>();
        if (root == null){
            return res;
        }
        nextToVisit.add(root);

        while (!nextToVisit.isEmpty()){
            //Updates when there is only elemnts from one level on quuee. This happens right before you pop leftmost element
            int nodesToVisitOnLevel = nextToVisit.size();

            List<Integer> nodesOnLevel = new LinkedList<>();

            for (int i = 0; i < nodesToVisitOnLevel; i++){
                TreeNode visiting = nextToVisit.remove();
                nodesOnLevel.add(visiting.val);

                if (visiting.left != null){
                    nextToVisit.add(visiting.left);
                }

                if (visiting.right != null){
                    nextToVisit.add(visiting.right);
                }
            }
            res.add(nodesOnLevel);
        }
        return res;


    }
}
