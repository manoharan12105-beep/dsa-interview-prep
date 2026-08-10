import java.util.*;

public class BTMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    

    BinaryTree bt = new BinaryTree();
    bt.populate(scanner);
    bt.display();
    bt.prettyDisplay();
  }
}
