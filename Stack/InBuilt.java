package Stack;

import java.util.Arrays;
import java.util.Stack; 

public class InBuilt {
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(12);
    stack.add(34);
    stack.addAll(2, Arrays.asList(1, 2, 3));

    System.out.println("Stack : " + stack);                          // [12, 34, 1, 2, 3]
    System.out.println("Pop   : " + stack.pop());                    // 3
    System.out.println("Stack : " + stack);
    System.out.println("Peek Element :" + stack.peek());                   // 2
    System.out.println("Is Empty ? " + stack.isEmpty());                // false
    System.out.println("Capacity  : " +stack.capacity());               // 10
    System.out.println("Contains 34 ? " + stack.contains(34));           // true
    System.out.println("Index of 12 : " + stack.indexOf(12));            // 0
    System.out.println("Index of 1 from index 2 : " + stack.indexOf(1, 2));       // 0
    System.out.println("Element At : " + stack.elementAt(3));      // 2
    System.out.println("Size of stack : " + stack.size());                   //
  }
}