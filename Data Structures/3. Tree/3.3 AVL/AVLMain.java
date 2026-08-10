public class AVLMain {
  public static void main(String[] args) {
    AVL avl = new AVL();

    for(int i = 0; i < 5000; i++) {
      avl.insert(i);
    }

    avl.display();
  }
}
