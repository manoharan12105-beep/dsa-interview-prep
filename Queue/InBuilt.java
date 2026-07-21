package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuilt {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();

    queue.add("Manoharan");
    queue.add("Navatha");
    queue.add("Nithish");
    queue.add("Jack");
    queue.add("Manikandan");

    System.out.println(queue.remove());
    System.out.println(queue.remove());


    Deque<Integer> deque = new ArrayDeque<>();
    
  }
}
