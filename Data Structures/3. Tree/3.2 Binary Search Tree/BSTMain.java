public class BSTMain {
  public static void main(String[] args) {
    BST tree = new BST();

    tree.populate(new int[] {7, 10, 3,4, 5, 6, 8, -5});
    tree.display();

    /* [7, 10, 3, 4, 5, 6, 8, -5]

      Root Node : 7
      Left child of 7 : 3
      Left child of 3 : -5
      Right child of 3 : 4
      Right child of 4 : 5
      Right child of 5 : 6
      Right child of 7 : 10
      Left child of 10 : 8
    
                7
          3          10
       -5   4       8 
              5
                6
    
    */

    System.out.println();

    tree.delete(4);
    tree.display();

    System.out.println("\nIs tree Balanced ? " + tree.balanced() + "\n");  // False


    BST sortedTree = new BST();
    sortedTree.populateSorted(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    sortedTree.display();

    /*
    
      Root Node : 6
      Left child of 6 : 3
      Left child of 3 : 2
      Left child of 2 : 1
      Right child of 3 : 5
      Left child of 5 : 4
      Right child of 6 : 9
      Left child of 9 : 8      Left child of 8 : 7
      Right child of 9 : 10

    */
    System.out.println("\nIs tree Balanced ? " + sortedTree.balanced() + "\n");  // True


    sortedTree.preOrder();
    System.out.println();
    sortedTree.inOrder();
    System.out.println();
    sortedTree.postOrder();
    
  }
}
