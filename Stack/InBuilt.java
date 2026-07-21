package Stack;

import java.util.Stack;

public class InBuilt {
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(12);
    stack.push(67);
    stack.push(100);
    stack.push(7);
    stack.push(18);
    
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop()); 
    System.out.println(stack.pop()); 
    System.out.println(stack.pop());
    // System.out.println(stack.pop());
     
  }

}
