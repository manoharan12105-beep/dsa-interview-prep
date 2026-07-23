package CustomImplementation;

public class Main {
  public static void main(String[] args) throws StackException {

    System.out.println("==== Custom Stack ====");
    CustomStack stack = new CustomStack(5);
    stack.push(67);
    stack.push(43);
    stack.push(07);
    stack.push(18);
    stack.push(45);
    stack.push(12);  // Stack is full!
    
    System.out.println(stack.pop());  // 45
    System.out.println(stack.pop());  // 18
    System.out.println(stack.pop());  // 7
    System.out.println(stack.pop());  // 43
    System.out.println(stack.pop());  // 67
//  System.out.println(stack.pop());  // CustomImplementation.StackException: Stack is currently empty!
    System.out.println();


    System.out.println("==== Dynamic Stack ====");
    DynamicStack dynamicStack = new DynamicStack(1);
    dynamicStack.push(1);
    dynamicStack.push(11);
    dynamicStack.push(21);
    dynamicStack.push(1211);
    dynamicStack.push(111221);
    dynamicStack.push(312211);

    System.out.println("Peak Element : " + dynamicStack.peek());  // Peak Element : 312211
    System.out.println(dynamicStack.pop());   // 312211
    System.out.println(dynamicStack.pop());   //  111221
    System.out.println(dynamicStack.pop());   // 1211
    System.out.println(dynamicStack.pop());   // 21
    System.out.println(dynamicStack.pop());   // 11
    System.out.println(dynamicStack.pop());   // 1
    System.out.println(dynamicStack.pop());   // CustomImplementation.StackException: Stack is currently empty!
  }
}
