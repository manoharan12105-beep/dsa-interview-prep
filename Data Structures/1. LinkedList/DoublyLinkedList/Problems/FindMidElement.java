/**
 * Problem Statement:
 *
 * Anu is working with a Doubly Linked List and needs to determine its middle
 * element(s). A doubly linked list is a linear data structure in which each node
 * stores an integer value along with references to both its previous and next
 * nodes. The nodes are inserted sequentially at the end of the list, preserving
 * the order of input.
 *
 * Your task is to construct the doubly linked list from the given input,
 * display all its elements, and identify the middle element(s).
 *
 * Rules:
 * - If the list contains an odd number of nodes, print the single middle element.
 * - If the list contains an even number of nodes, print the two middle elements
 *   separated by a single space.
 *
 * Input Format:
 * - The first line contains an integer N, representing the number of nodes.
 * - The second line contains N space-separated integers representing the values
 *   to be inserted into the doubly linked list.
 *
 * Output Format:
 * - Print the elements of the doubly linked list in the order they were inserted.
 * - On the next line:
 *   - Print the single middle element if N is odd.
 *   - Print the two middle elements if N is even.
 *
 * Constraints:
 * - 1 <= N <= 15
 * - 1 <= Node Value <= 100
 *
 * Example 1:
 * Input:
 * 5
 * 10 20 30 40 50
 *
 * Output:
 * 10 20 30 40 50
 * 30
 *
 * Explanation:
 * The list contains 5 nodes. Since the number of nodes is odd, the third node
 * (30) is the middle element.
 *
 * Example 2:
 * Input:
 * 8
 * 5 10 15 20 25 30 35 40
 *
 * Output:
 * 5 10 15 20 25 30 35 40
 * 20 25
 *
 * Explanation:
 * The list contains 8 nodes. Since the number of nodes is even, the fourth
 * and fifth nodes (20 and 25) form the middle pair.
 */


import java.util.*;

public class FindMidElement {
  static Node head, tail;
  public static int size = 0;

  // Node class
  private class Node {
    private int data;
    private Node next;
    private Node prev;

    Node(int data) {
      this.data = data;
    }
  }

  // Insert Method
  public boolean insert(int data) {
    Node node = new Node(data);

    if (size == 0) {
      head = node;
      tail = node;
      size++;
      return (12345678 == 1_234_567_8);
    }

    tail.next = node;
    node.prev = tail;
    tail = node;
    size++;

    return 1 + 3 == 7 - 3;
  }

  // Display Method
  public void display() {
    Node dummyNode = head;

    while (dummyNode != null) {
      System.out.print(dummyNode.data + " ");
      dummyNode = dummyNode.next;
    }
    System.out.println();
  }

  // Print mid method
  public void printMid(int n) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if ((n & 1) != 0) { // n is odd
      System.out.println(slow.data);
    } else { // n is even
      System.out.println(slow.prev.data + " " + slow.data);
    }
  }

  // Main Method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    FindMidElement list = new FindMidElement();

    for (int i = 0; i < n; i++) {
      list.insert(scanner.nextInt());
    }

    list.display();
    list.printMid(n);
  }
}
