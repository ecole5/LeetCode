package trees;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class LowestCommonAncestor {
    static boolean found = false;

    public static Node lca(Node root, Node node1, Node node2) {
        if (root == null){
            return null; //base case
        }
        Node left = lca(root.left,node1,node2);
        //already found at lower left level
        if (found){
            return left;
        }
        //already found at lower right level
        Node right = lca(root.right, node1, node2);
        if (found){
            return right;
        }

        //does either subtree or current node contain a  node1 or node2
        if (left == node1 || left == node2 || right == node1 || right == node2 || root == node1 || root == node2){
            if (node1 == left || node1 == right || node1 == root && (node2 == left || node2 == right || node2 == root)) { //is root 1 and root 2 in root or left or right, 2 things in three places
                found = true;
                return root;
            }
                //return the one of left and n and right that has either node1 or node2
            return root == node1 || root == node2 ? root : left != null ? left: right ;
        }

        return null; //no common ancestor found

    }

    /** Driver class, do not change **/
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public static Node buildTree(Iterator<String> iter) {
            String nxt = iter.next();
            if (nxt.equals("x")) return null;
            Node node = new Node(Integer.parseInt(nxt));
            node.left = buildTree(iter);
            node.right = buildTree(iter);
            return node;
        }

        public static Node findNode(Node root, int target) {
            if (root == null) return null;
            if (root.val == target) return root;
            Node leftSearch = findNode(root.left, target);
            if (leftSearch != null) {
                return leftSearch;
            }
            return findNode(root.right, target);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        Node node1 = Node.findNode(root, Integer.parseInt(scanner.nextLine()));
        Node node2 = Node.findNode(root, Integer.parseInt(scanner.nextLine()));
        scanner.close();
        Node ans = lca(root, node1, node2);
        System.out.println(ans == null ? "null" : ans.val);
    }

}
