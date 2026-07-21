package LinkedList.DoublyLinkedList;

public class Main {
  public static void main(String[] args) {
    DLL dll = new DLL();
    dll.insertFirst(new User(1, "Mano", 21, 45000.00));
    dll.insertFirst(new User(2, "Mani", 21, 50000.00));
    dll.display();
    dll.displayRev();
    dll.insertLast(new User(3, "James", 25, 34500.50));
    dll.display();
    dll.displayRev();
    dll.insert(2, new User(5, "Carl", 35, 150000));
    dll.insert(2, new User(4, "Jack", 35, 150000));
    dll.display();
    dll.displayRev();
  }
}
