package trees;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Leet code 257
public class BinaryPaths {

    ArrayList<String> stringPaths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return new ArrayList<String>();
        }

        binaryPathHelper(root, new ArrayList  <String>()); //only need one of these
        return stringPaths;
    }

    public void binaryPathHelper(TreeNode n, ArrayList <String> stringSoFar) {


        //Preorder traversal
        stringSoFar.add(Integer.toString(n.val));

        //Stop traversing when we reach a leaf (all children are empty) //base case
        if (n.left == null && n.right == null) {

            stringPaths.add(String.join("->", stringSoFar));

        }
        //Otherwise traverse children that exist
        else {

            if (n.left != null) {
                binaryPathHelper(n.left, stringSoFar);

            }
            if (n.right != null) {
                binaryPathHelper(n.right, stringSoFar);

            }


        }
        stringSoFar.remove(stringSoFar.size()-1); //remove string from stringbuilder on way up



    }
}
