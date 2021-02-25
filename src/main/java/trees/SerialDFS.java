package trees;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

//A level order might be cleaner but leets do this we dfs

class SerialDFS {


    public static String serialize(Node root) {
        StringBuilder ceral = new StringBuilder();
        serializeHelper(root,ceral);
        String cool = ceral.toString();
        return cool;




    }

    public static void serializeHelper(Node n, StringBuilder ceral){
        if (n == null){
            ceral.append("x,");
        }
        else{
            ceral.append(Integer.toString(n.val));
            ceral.append(','); //delimeter
            serializeHelper(n.left,ceral);
            serializeHelper(n.right,ceral);

        }

    }

    public static Node deserialize(String root) {
        String [] nodes = root.split(",");
        Iterator<String> tmp = Arrays.asList(nodes).iterator();
        return deserializeHelper(tmp);
    }

    public static Node deserializeHelper(Iterator<String> values){
        String val = values.next();
        if (val.equals("x")){
            return null;
        }
        Node tmp = new Node( Integer.parseInt(val));
        tmp.left = deserializeHelper(values);
        tmp.right = deserializeHelper(values);
        return tmp;


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

        public static void printTree(Node root) {
            if (root == null) {
                System.out.print("x ");
            } else {
                System.out.print(root.val + " ");
                printTree(root.left);
                printTree(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = Node.buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator());
        scanner.close();

       Node newRoot = deserialize(serialize(root));
       Node.printTree(newRoot);
    }

}