package trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ValidBinarySearchTree {



    public static boolean isValid(Node root) {
          return isValidHelper(root).flag;
    }

    public static Result isValidHelper(Node n){
        if (n == null){
            return new Result();
        }

        Result left = isValidHelper(n.left);
        Result right = isValidHelper(n.right);

        //Set flag before changing max and min values. Assume duplicates on left
        left.flag = left.flag && right.flag && n.val >= left.maxValue && n.val <= right.minValue;

        //update max and min vlaues
        left.minValue = Math.min(left.minValue,right.minValue);
        left.minValue = Math.min(left.minValue,n.val);
        left.maxValue = Math.max(left.maxValue, right.maxValue);
        left.maxValue = Math.max(n.val,left.maxValue);
        return left;

    }
    static class Result{
        boolean flag;
        int maxValue;
        int minValue;

        public Result(){
            maxValue = Integer.MIN_VALUE;
            minValue = Integer.MAX_VALUE;
            flag = true;
        }
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
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();
        System.out.println(isValid(root)? "true": "false");
    }
}

