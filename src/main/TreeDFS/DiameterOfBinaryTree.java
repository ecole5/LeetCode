package TreeDFS;

import helper.TreeNode;

public class DiameterOfBinaryTree {

    private int maxPathNodes = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLengthHelper(root);
        return maxPathNodes-1; //want number of edges not number of nodes

    }

    private int maxLengthHelper(TreeNode node){
        if (node == null){
            return 0;
        }
        //Post order traversal

        int maxPathLeft = maxLengthHelper(node.left);
        int maxPathRight = maxLengthHelper(node.right);

        //Check global considering paths merge at this node
        if (maxPathLeft+maxPathRight+1 > maxPathNodes ){
            maxPathNodes = maxPathLeft+maxPathRight+1;
        }

        return Math.max(maxPathLeft,maxPathRight)+1;

    }




}
