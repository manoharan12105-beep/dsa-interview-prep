// 1290. Convert Binary Number in a Linked List to Integer

// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.
// The most significant bit is at the head of the linked list.

package Problems;

public class BinaryToNumber {

  public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

  public int getDecimalValue(ListNode head) {
        // String s = "";
        // while(head != null) {
        //     s += head.val +"";
        //     head = head.next;
        // }

        // System.out.println(s);
        // int res = Integer.parseInt(s, 2);

        int res = 0;
        while(head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        
        return res;
    }
}
