package trees;

import com.sun.source.tree.Tree;
import helper.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {


    //Benifit of using BFS is that we only have to check nodes to level of min. As soon as we find a min node we are gauruntted that it is the absolute minimu. gt5u7


    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        Deque<TreeNode> nextVisiting = new LinkedList<>();
        nextVisiting.addFirst(root);

        int currentSize = 0;

        while (!nextVisiting.isEmpty()){

            int levelSize = nextVisiting.size();
            currentSize++;

            for (int i = 0; i < levelSize; i++){

                TreeNode visiting = nextVisiting.removeLast();

                if (visiting.left == null && visiting.right == null) {
                    return currentSize;
                }
                if (visiting.left != null){
                    nextVisiting.addFirst(visiting.left);
                }


                if (visiting.right != null){
                    nextVisiting.addFirst(visiting.right);
                }



            }

        }
        return 0;

    }
}
