public class BST {

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

  public BST() {

  }

  private int height(Node node) {
    if(node == null) 
      return -1;

    return node.height;
  }

  public boolean isEmpty() {
    return root == null;
  }


// ======================== Insertion ======================== //

  public void insert(int data) {
    root = insert(data, root);
  }

  
  private Node insert(int data, Node node) {
    if(node == null) {
      node = new Node(data);
      return node;
    }

    if(node.data > data) {
      node.left = insert(data, node.left);
    } else if(node.data < data) {
      node.right = insert(data, node.right);
    }

    node.height = Math.max(height(node.left), height(node.right)) + 1;

    return node;
  }


  public void populate(int[] nums) {
    for(int num : nums) {
      this.insert(num);
    }
  }


  public void populateSorted(int[] nums) {
    populateSorted(nums, 0, nums.length);
  }

  private void populateSorted(int[] nums, int start, int end) {
    if(start >= end) 
      return;

    int mid = (start + end) / 2;

    this.insert(nums[mid]);
    populateSorted(nums, start, mid);
    populateSorted(nums, mid + 1, end);
  }

// ======================== Deletion ======================== //

public void delete(int data) {
  root = delete(data, root);
}

public Node delete(int data, Node node) {
  if(node == null) {
    return null;
  }

  if(data < node.data) {
    node .left = delete(data, node.left);
  } else if(data > node.data) {
    node.right = delete(data, node.right);
  } else {                                          
                                                    
    /* ================ Node Deletion ================ */

    // Case 1 : No Childs
    if(node.left == null && node.right == null) { 
      return null;
    } 
    
    // Case 2 : Only Left Child
    if(node.left == null) {                           
      return node.right;
    }

    // Case 3 : Only Right Child
    if(node.right == null) {                         
      return node.left;
    }

    // Case 4 : Two Childs
    Node successor = findMin(node.right);

    node.data = successor.data;

    node.right = delete(node.data, node.right);
  }

  node.height = Math.max(height(node.left), height(node.right)) + 1;    // Updating the Height
  return node;
}

private Node findMin(Node node) {
  while(node.left != null) {
    node = node.left;
  }

  return node;
}





// ======================== Balanced? ======================== //

  public boolean balanced() {
    return balanced(root);
  }


  private boolean balanced(Node node) {
    if(node == null) {
      return true;
    }

    return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
  }


// ======================== Display ======================== //

  public  void display() {
    display(root, "Root Node : ");
  }

  private void display(Node node, String details) {
    if(node == null) 
      return;

    System.out.println(details + node.getValue());

    display(node.left, "Left child of " + node.getValue() + " : ");
    display(node.right, "Right child of " + node.getValue() + " : ");

    // System.out.println();
  }


// ==================== Order Traversal ==================== //


  // Pre-Order Traversal
  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    if(node == null) {
      return;
    }

    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
  

  
  // In-Order Travseral
  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if(node == null) {
      return;
    }

    inOrder(node.left);
    System.out.print(node.data + " ");
    inOrder(node.right);
  }


  // Post-Order Travseral
  public void postOrder() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if(node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data + " ");
  }
}
