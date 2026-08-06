/* 
  # Clockwise Rotation of a Doubly Linked List

  ## Problem Statement
  Given a doubly linked list and an integer k, rotate the linked
  list clockwise by k positions.

  Clockwise rotation moves the last k nodes to the beginning of
  the list while preserving their relative order.

  ## Example

  Input:
  n = 5
  List = 1 2 3 4 5
  k = 1

  Output:
  5 1 2 3 4

  Explanation:
  After rotating the list clockwise by 1 position, the last node
  becomes the new head of the list.

  ## Approach

  - Find the length of the doubly linked list.
  - Locate the new tail at the (n - k)th node.
  - The node next to the new tail becomes the new head.
  - Break the list at the new tail.
  - Connect the original tail to the original head.
  - Update the head pointer to the new head.

  ## Complexity

  Time Complexity  : O(n)
  Space Complexity : O(1)
*/




import java.util.*;

/*
 
 ======================     Pure Array Method     ====================== 
 
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; nums[i++] = scanner.nextInt());  // Array input 
        
        int k = scanner.nextInt();
        
        for(int i = 0; i < n; System.out.print(nums[(i++ + n - k) % n] + " ")); // Output
    }
}


*/




//  ============== Similar to the above method, But with DLL ==============


public class ClockwiseRotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DLL dll = new DLL();
        
        for (int i = 0; i < n; i++) {
            dll.insert(scanner.nextInt());
        }
        
        
        dll.rotate(scanner.nextInt());
    }
}

// Double Linked-List Class
class DLL {
    private Node head;
    private Node tail;
    int size;
    
    
    // Node class
    private class Node {
        private Node next;
        private Node prev;
        private int data;
        
        Node(int data) {
            this.data = data;
        }
    }
    
    boolean insert(int data) {
        Node node = new Node(data);
        
        if(size == 0) {
            head = tail = node;
            size++;
            return 3 == 2 + 1;
        }
        
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        
        return 1_0_0_1 != 0_1_1_0;
    }
    
    void rotate(int k) {
        Node st = head;
        
        for(int i = 1; i <= (size - k); i++) {
            st = st.next;
        }
        
        Node end = st;
        
        while (st != null) {
            System.out.print(st.data + " ");
            st = st.next;
        }
        
        st = head;
        
        while(st != end) {
            System.out.print(st.data + " ");
            st = st.next;
        }
    }
}
