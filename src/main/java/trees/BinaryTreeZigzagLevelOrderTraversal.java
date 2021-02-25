package trees;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {


    //return a list of each level of binary tree

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> nextToVisit = new LinkedList<>();
        if (root == null){
            return res;
        }
        nextToVisit.add(root);

        boolean reverse = false; //when flase right to left

        while (!nextToVisit.isEmpty()){//itterates each level
            //Updates when there is only elemnts from one level on quuee. This happens right before you pop leftmost element
            int nodesToVisitOnLevel = nextToVisit.size();

            LinkedList<Integer> nodesOnLevel = new LinkedList<>();

            for (int i = 0; i < nodesToVisitOnLevel; i++){
                TreeNode visiting = nextToVisit.remove();

                if (reverse)
                    nodesOnLevel.addFirst(visiting.val);
                else{
                    nodesOnLevel.addLast(visiting.val);
                }

                    if (visiting.left != null){
                        nextToVisit.add(visiting.left);
                    }

                    if (visiting.right != null){
                        nextToVisit.add(visiting.right);
                    }




            }
            //On next level order changes
            reverse = !reverse;
            res.add(nodesOnLevel);
        }
        return res;


    }
}
