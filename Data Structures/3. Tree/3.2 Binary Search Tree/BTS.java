public class BTS {

  private class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
      this.data = data;
    }

    private int getValue() {
      return data;
    }
  }

  private Node root;

  public BTS() {

  }

  private int height(Node node) {
    if(node == null) 
        return -1;

    return node.height;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public  void display() {
    display(root, "Root Node : ");
  }

  private void display(Node node, String details) {
    if(node == null) 
        return;

    System.out.println(details + node.getValue());

    display(node.left, "Left child of " + node.getValue() + " : ");
    display(node.right, "Right child of " + node.getValue() + " : ");
  }
  
}
