public class SegmentTree {
  private Node root;

  private static class Node {
    private int data;
    private int stval;  // Start Interval
    private int endval;  // End Interval
    private Node left;
    private Node right;
    private int height;

    Node(int data, int stval, int endval) {
      this.data = data;
      this.height = 0;
      this.stval = stval;
      this.endval = endval;
    }

    private int getValue() {
      return data;
    }
  }

  SegmentTree() {

  }



  // private Node insert(int[] prefix, int stval, int endval) {
  //   return insert(prefix, stval, endval, root);
  // }

  private Node insert(int[] prefix, int stval, int endval) {
      if (stval > endval) {
        return null;
      }

      Node node = new Node(prefix[endval + 1] - prefix[stval], stval, endval);

      if (stval == endval) {
        return node;
      }

      int mid = (stval + endval) / 2;
      node.left = insert(prefix, stval, mid);
      node.right = insert(prefix, mid + 1, endval);

      return node;
    }


  public void populate(int[] nums) {
    int[] prefix = new int[nums.length + 1];

    for(int i = 1; i <= nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }

    root = insert(prefix, 0, nums.length - 1);

  }




  // ============================ Display ============================

  public void display() {
    display(root, "Root Node : ");
  }

  private void display(Node node, String detail) {
    if(node == null) {
      return;
    }


    System.out.println(detail + node.getValue());

    display(node.left, "Left child of " + node.getValue() + " : ");
    display(node.right, "Right child of " + node.getValue() + " : ");
  }


}
