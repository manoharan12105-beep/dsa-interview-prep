// Leetcode 206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.

package Problems;
 

public class ReverseList {

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  // Solution
  public ListNode reverseList(ListNode head) {
    ListNode result = null;

    while (head != null){
      ListNode temp = head.next;
      head.next = result;
      result = head;
      head = temp;
    }

    return result;
  }
}
