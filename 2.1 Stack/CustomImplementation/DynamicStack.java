package CustomImplementation;

public class DynamicStack extends CustomStack{

  public DynamicStack() {
    super();
  }

  public DynamicStack(int size) {
    super(size);
  }

  @Override
  public boolean push(int item) {
    if(this.isFull()) {
      int[] temp = new int[data.length * 2];

      for(int i = 0; i < data.length; temp[i] = data[i++]);  // copy old array to new array
      data = temp;
    }

    return super.push(item);
  }

  
}
