package trees;

import java.util.ArrayList;

//Algo monster
public class TernaryTreePaths {

    static ArrayList<String> stringPaths = new ArrayList<>();

    public static String[] ternaryTreePaths(Node root) {
        if (root == null){
            return new String[] {};
        }

        ternaryPathHelper(root, new ArrayList  <String>()); //only need one of these
        return stringPaths.toArray(new String [stringPaths.size()]);
    }

    public static void ternaryPathHelper(Node n, ArrayList <String> stringSoFar) {


        //Preorder traversal
        stringSoFar.add(Integer.toString(n.val));

        //Stop traversing when we reach a leaf (all children are empty) //base case
        if (n.children[0] == null && n.children[1] == null && n.children[2] == null) {

            stringPaths.add(String.join("->", stringSoFar));


        }
        //Otherwise traverse children that exist
        else {

            if (n.children[0] != null) {
                ternaryPathHelper(n.children[0], stringSoFar);

            }
            if (n.children[1] != null) {
                ternaryPathHelper(n.children[1], stringSoFar);

            }
            if (n.children[2] != null) {
                ternaryPathHelper(n.children[2], stringSoFar);

            }

        }
        stringSoFar.remove(stringSoFar.size()-1); //remove string from stringbuilder on way up



    }

    private class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }
    }

}
