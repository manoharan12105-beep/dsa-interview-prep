public class AVL {

  private class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
      this.data = data;
      this.height = 0;
    }

    private int getValue() {
      return data;
    }
  }

  private Node root;

  public AVL() {

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

    return rotate(node);
  }

  // =========================  AVL  ========================= //


  private Node rotate(Node node) {
    if(height(node.left) - height(node.right) > 1) {
      // Left Heavy Case
      if(height(node.left.left) - height(node.left.right) > 0) {
        // Left - Left Case
        return rightRotate(node);
      }
      if(height(node.left.left) - height(node.left.right) < 0) {
        // Left Right Case 
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }

    if(height(node.left) - height(node.right) < -1) {
      // Right Heavy Case
      if(height(node.right.left) - height(node.right.right) < 0) {
        // Right  Right Case
        return leftRotate(node);
      }
      if(height(node.right.left) - height(node.right.right) > 0) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }

    return node;
  }

  private Node rightRotate(Node par) {
    Node child = par.left;
    Node t = child.right;
    child.right = par;
    par.left = t;

    par.height = Math.max(height(par.left), height(par.right)) + 1;
    child.height = Math.max(height(child.left), height(child.right)) + 1;


    return child;
  }

  private Node leftRotate(Node child) {
    Node par = child.right;
    Node t = par.left;

    par.left = child;
    child.right = t;

    par.height = Math.max(height(par.left), height(par.right)) + 1;
    child.height = Math.max(height(child.left), height(child.right)) + 1;

    return par;
  }


// ======================== Populate Tree ======================== //


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
    if(node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.data + " ");
  }

}
