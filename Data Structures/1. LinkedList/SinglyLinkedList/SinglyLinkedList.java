public class SinglyLinkedList {
  private Node head;
  private Node tail;

  private int size;

  public SinglyLinkedList() {
    this.size = 0;
  }


  /**
   * Node Class
   */
  private class Node{
    private int data;
    private Node next;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }




  // Insertion - First (1)
  public void insertFirst(int data) {
    Node node = new Node(data);
    node.next = head;
    head = node;

    if(tail == null) {
      tail = head;
    }

    size++;
  }



  // Insertion - Last (3)
  public void insertLast(int data) {
    if(tail == null) {
      insertFirst(data);
      return;
    }

    Node node = new Node(data);
    tail.next = node;
    tail = node;
    size++;
  }


  // Insertion at any index(0 Based index) (4)
  public void insert(int index, int data) {
    if(index == 0) {
      insertFirst(data);
      return;
    } else if (index >= size) {
      insertLast(data);
      return;
    }

    Node node = new Node(data);

    Node temp = head;

    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }

    node.next = temp.next;
    temp.next = node;
    size++;

  }



  // Deletion - first (5)
  public void deleteFirst() {
    head = head.next;
    if(head == null) {
      tail = null;
    }

    size--;
  }



  // Deletion - last (6)
  public void deleteLast() {
    if(size <= 1) {
      deleteFirst();
      return;
    }

    // Node temp = head;

    // while(temp.next != tail) {
    //   temp = temp.next;
    // }

    Node temp = get(size - 2);

    temp.next = null;
    tail = temp;
    size--;
  }



  // Deletion - any Index(0 based) (7)
  public void delete(int index) {
    if(index == 0) {
      deleteFirst();
      return;
    } else if(index == size -1 ){
      deleteLast();
      return;
    }

    Node prev = get(index - 1);
    prev.next = prev.next.next;
  }



  // Display LinkedList (2)
  public void display() {
    Node temp = head;

    while(temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }

    System.out.println("End");
  }

  // Gets the Node of an index
  public Node get(int index) {
    if(index < size) {
      Node node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }

      return node;
    }

    return null;
  }



  public Node find(int value) {
    Node node = head;
    while(node != null) {
      if(node.data == value) {
        return node;
      }
      node = node.next;
    }

    return null;
  }

}
