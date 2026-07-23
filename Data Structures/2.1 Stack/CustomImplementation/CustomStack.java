package CustomImplementation;
public class CustomStack {
  protected int[] data;
  private static int DEFAULT_SIZE = 10;

  int ptr = -1;

  public CustomStack() {
    this(DEFAULT_SIZE);
  }

  public CustomStack(int size) {
    this.data = new int[size];
  }


  // Method - push(data)
  public boolean push(int item) {
    if(isFull()) {
      System.out.println("Stack is full!");

      return false;
    }

    ptr++;
    data[ptr] = item;

    return true;
  }


  // Method - pop()
  public int pop() throws StackException{
    if(isEmpty()) {
      throw new StackException("Stack is currently empty!");
    }

    return data[ptr--];
  }

   
  // Method - peek()
  public int peek() throws StackException{
    if(isEmpty()) {
      throw new StackException("Stack is Empty");
    }

    return data[ptr];
  }


  // Method - isFull()
  protected boolean isFull() {
    return ptr == data.length -1;
  }


  // Method - isEmpty()
  private boolean isEmpty()  {
    return ptr == -1;
  }
}
