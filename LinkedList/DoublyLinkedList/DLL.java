package LinkedList.DoublyLinkedList;

public class DLL {
  private Node head;
  private int size;
  

  private  class Node{
    User user;
    Node next;
    Node prev;

    public Node(User user) {
      this.user = user;
    }

    public Node(User user, Node next, Node prev) {
      this.user = user;
      this.next = next;
      this.prev = prev;
    }
  }

  // Insert first (1)
  public void insertFirst(User u) {
    Node node = new Node(u);
    node.next = head;
    node.prev = null;
    if(head != null) {
      head.prev = node;
    }

    head = node;
  }



  // Display (forward) (2)
  public void display() {
    Node node = head;

    System.out.print("Display Forward : ");
    while(node != null) {
      User u = node.user;
      System.out.print("|User Id : " + u.getId() + ", User Name : " + u.getName() + "| -> ");
      node = node.next;
    }

    System.out.println("Null");
  }



  // Display the the List in Reverse 
  public void displayRev() {
    Node last = getTail();

    System.out.print("Display Backward : ");
    while(last != null) {
      User user = last.user;
      System.out.print("|User Id : " + user.getId() + ", User Name : " + user.getName() + "| -> ");
      last = last.prev;
    }
    System.out.println("Null");
  }



  // Gets the tail of the linkedList;
  public Node getTail() {
    Node node = head;
    Node last = null;
    while(node != null) {
    last = node;
    node = node.next;
    }

    return last;
  }
}
