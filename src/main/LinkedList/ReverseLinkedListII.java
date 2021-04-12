package LinkedList;

import helper.ListNode;


//Reverse a sublist of a linked list and return head. Do it in one pass.
//Recussive solution is really 2n (up and down)
public class ReverseLinkedListII {

    public ListNode reverseBetweenItterative(ListNode head, int m, int n) {


        //Need dummyhead in case we need to change entire sublsit
        ListNode dummyHead = new ListNode(1,head);
        ListNode nodeBeforeSublist = dummyHead;


        //Move nodeBeforeSublist into correct position
        int i = 0; //index of nodeBeforeSublist
        while (i < m-1){ //index should be at m-1
            nodeBeforeSublist = nodeBeforeSublist.next;
            i++;
        }

        ListNode nodeBeforeMove = nodeBeforeSublist.next; //first item in sublist (becomes tail of sublist)
        ListNode nodeToMove = nodeBeforeMove.next;
        m++;

        while (m <= n){

            nodeBeforeMove.next = nodeToMove.next;
            nodeToMove.next = nodeBeforeSublist.next;
            nodeBeforeSublist.next = nodeToMove;
            nodeToMove = nodeBeforeMove.next; //update item to actualy move
            m++;
        }

        return dummyHead.next;
    }





//General technique is to cut out and put back.

//Important to use a dummy head
//If we are allowed to change elements it might be easier simply to shift data



        public ListNode reverseBetweenRecursive(ListNode head, int m, int n) {

            //List can not be size 1
            if (m == n){
                return head;
            }
            ListNode beforeSegment = new ListNode();
            ListNode startOfReverse = null; //set to segment


            ListNode runner = head;
            int position = 1;
            while (runner != null){
                if (position == m-1){
                    beforeSegment = runner;
                }
                if (position == m){
                    startOfReverse = runner;
                }

                if (position == n){

                    ListNode afterSegment = runner.next;
                    runner.next = null; //leetcode complains about loop detection if we dont use null
                    //cut end


                    beforeSegment.next = reverse(startOfReverse); //combine start wityh reversed end
                    startOfReverse.next = afterSegment; //start of reverse is now tail of reverse, recombine with rest of list
                    break;
                }
                runner = runner.next;
                position++;
            }

            return m == 1 ? beforeSegment.next : head;



        }

        private ListNode reverse (ListNode current){
            if (current.next == null){
                return current;
            }
            ListNode end = reverse(current.next);

            current.next.next = current;

            return end;

        }
}
