
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();

        // Insert first
        sl.insertFirst(3);
        sl.insertFirst(13);
        sl.insertFirst(23);
        sl.insertFirst(34);
        sl.insertFirst(2);

        // Insert Last
        sl.insertLast(99);
        sl.insertLast(67);

        // Insert at any index(0 based) (index, data)
        sl.insert(6, 47);
        sl.insert(0, 0);
        sl.insert(7654, 200);
        sl.insert(5, 78);
        
        // Display
        sl.display();

        // Delete First
        sl.deleteFirst();
        sl.display();

        // Delete Last
        sl.deleteLast();
        sl.display();

        sl.delete(2);
        sl.display();
    }
}