package helper;

public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node prev;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.prev = null;
    }
    public Node(int val,Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
        this.prev = null;

    }



}
