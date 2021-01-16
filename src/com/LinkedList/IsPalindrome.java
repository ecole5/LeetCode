package com.LinkedList;

import com.Node;

public class IsPalindrome {

    //2.6 find palindrom recursive
    class Result{
        boolean flag;
        Node n;
        Result(Node n, boolean flag){
            this.n = n;
            this.flag = flag;
        }
    }
    boolean evenCheck(int length){
        return (length % 2 == 0);
    }

    Result isPalHelp(Node n, int c, int length){
        if (c < ((length/2) +1)){
            Result temp = isPalHelp(n.next,c +1 , length);
            if (!temp.flag){
                return temp;
            }
            else if (n.val == temp.n.val){
                return new Result(temp.n.next, true);
            }
            else{
                return new Result(n, false);
            }
        }
        else{
            if (evenCheck(length)){
                return new Result(n, true);
            }
            else {
                return new Result(n.next, true);
            }
        }
    }
    boolean isPal(int length, Node head){
        return isPalHelp(head, 1, length).flag;
    }
}
