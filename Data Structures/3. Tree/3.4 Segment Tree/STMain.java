public class STMain {
  public static void main(String[] args) {
    int[] nums = {3, 8, 7, 6, -2, -8, 4, 9};

    SegmentTree st = new SegmentTree();
    st.populate(nums);
    st.display();
  }
}
