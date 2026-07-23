package CustomImplementation;

public class Main {
    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(54);
        queue.insert(53);
        queue.insert(7);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(92);
        queue.display();

        System.out.println(queue.remove());
        queue.insert(32);
        queue.display();

    }
}