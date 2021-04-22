package TreeDFS;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        List<Integer> leftOfOrigin = new ArrayList<>();
        List<Integer> rightOfOrigin = new ArrayList<>();

        preOrderDFS(root.left,leftOfOrigin,true);
        preOrderDFS(root.right,rightOfOrigin,false);


        if (leftOfOrigin.size() != rightOfOrigin.size()){
            return false;
        }

        for (int i = 0; i < leftOfOrigin.size(); i++){
            if (!leftOfOrigin.get(i).equals(rightOfOrigin.get(i))){
                return false;
            }
        }
        return true;

    }

    private void preOrderDFS (TreeNode node, List<Integer> traversalList, boolean isLeftOfOrigin){
        if (node == null){
            traversalList.add(-1);
            return;
        }
        traversalList.add(node.val);
        if (isLeftOfOrigin){
            preOrderDFS(node.left,traversalList,isLeftOfOrigin);
            preOrderDFS(node.right,traversalList,isLeftOfOrigin);
        }
        else{
            preOrderDFS(node.right,traversalList,isLeftOfOrigin);
            preOrderDFS(node.left,traversalList,isLeftOfOrigin);

        }
    }
}
