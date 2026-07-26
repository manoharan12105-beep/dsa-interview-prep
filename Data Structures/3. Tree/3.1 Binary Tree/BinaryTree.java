import java.util.Scanner;

public class BinaryTree {

  private class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

  }

  private Node root;

  // ======================== Insertion ======================== //

  public void populate(Scanner scanner) {
    System.out.println("Enter the value of the root Node : ");
    int val = scanner.nextInt();
    root = new Node(val);

    populate(scanner, root);
  }

  public void populate(Scanner scanner, Node node) {
    System.out.println("Do you want to add Value to the left of node " + node.data);
    boolean left = scanner.nextBoolean();

    if(left) {
      System.out.println("Enter the Value of left :");
      node.left = new Node(scanner.nextInt());
      populate(scanner, node.left);
    }

    System.out.println("Do you want to add Value to the right of node " + node.data);
    boolean right = scanner.nextBoolean();

    if(right) {
      System.out.println("Enter the Value of right :");
      node.right = new Node(scanner.nextInt());
      populate(scanner, node.right);
    }
  }


  // ======================== Display ======================== //

  public void display() {
    display(this.root, "");
  }

  private void display(Node node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(indent + node.data);
    display(node.left, indent + "\t");
    display(node.right, indent + "\t");
  }

  public void prettyDisplay() {
    prettyDisplay(root, 0);
  }

  private void prettyDisplay(Node node, int level) {
    if (node == null) {
      return;
    }

    prettyDisplay(node.right, level + 1);

    if (level != 0) {
      for (int i = 0; i < level - 1; i++) {
        System.out.print("|\t\t");
      }
      System.out.println("|------->" + node.data);
    } else {
      System.out.println(node.data);
    }
    prettyDisplay(node.left, level + 1);
  }
  
}
