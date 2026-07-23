import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuiltQueue {
  public static void main(String[] args) {
    // Using Queue (FIFO)
    Queue<String> queue = new LinkedList<>();

    queue.add("Nithish");
    queue.add("Manoharan");
    queue.add("Navatha");
    queue.add("Jack");
    queue.add("Manikandan");

    System.out.println("Queue : " + queue);                          // [Nithish, Manoharan, Navatha, Jack, Manikandan]
    System.out.println("Remove : " + queue.remove());                // Nithish
    System.out.println("Queue : " + queue);                          // [Manoharan, Navatha, Jack, Manikandan]
    System.out.println("Poll   : " + queue.poll());                  // Manoharan
    System.out.println("Queue : " + queue);                          // [Navatha, Jack, Manikandan]
    System.out.println("Peek   : " + queue.peek());                  // Navatha
    System.out.println("Contains 'Jack'? " + queue.contains("Jack"));// true
    System.out.println("Size   : " + queue.size());                  // 3
    System.out.println("Is Empty? " + queue.isEmpty());              // false

    // Using Deque (Double-ended queue)
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addFirst(10);
    deque.addLast(20);
    deque.addLast(30);
    deque.addFirst(5);

    System.out.println("Deque : " + deque);                          // [5, 10, 20, 30]
    System.out.println("Remove First : " + deque.removeFirst());     // 5
    System.out.println("Remove Last  : " + deque.removeLast());      // 30
    System.out.println("Deque : " + deque);                          // [10, 20]
    System.out.println("Peek First   : " + deque.peekFirst());       // 10
    System.out.println("Peek Last    : " + deque.peekLast());        // 20
    System.out.println("Size of deque: " + deque.size());            // 2
  }
}
