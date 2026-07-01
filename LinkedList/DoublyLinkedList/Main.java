package LinkedList.DoublyLinkedList;

public class Main {
  public static void main(String[] args) {
    DLL dll = new DLL();
    dll.insertFirst(new User(1, "Mano", 21, 45000.00));
    dll.insertFirst(new User(2, "Mani", 21, 50000.00));
    dll.display();
    dll.displayRev();
  }
}
