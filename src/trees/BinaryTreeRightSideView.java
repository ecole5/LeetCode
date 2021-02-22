package trees;


import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeRightSideView {




    //Find rightmost elemenet at each level
//Also find biggest element at each level
    public List<Integer> rightSideView(TreeNode root) {


        List<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }

        Deque<TreeNode> nextToVisit = new LinkedList<>();
        nextToVisit.add(root);

        while (!nextToVisit.isEmpty()){
            int itemsToRemoveAtLevel = nextToVisit.size();

            for (int i = 0; i < itemsToRemoveAtLevel; i++){
                TreeNode visiting = nextToVisit.remove();

                if (visiting.left != null){
                    nextToVisit.add(visiting.left);
                }

                if (visiting.right != null){
                    nextToVisit.add(visiting.right);
                }

                if (i == itemsToRemoveAtLevel-1){
                    res.add(visiting.val);
                }
            }
        }
        return res;

    }

}
