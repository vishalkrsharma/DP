public class Maximum_Path_Sum {
  int res;

  public int solve(Node root) {
    if (root == null)
      return 0;

    int l = solve(root.left);
    int r = solve(root.right);

    int temp = Math.max(Math.max(l, r) + root.val, root.val);
    int ans = Math.max(temp, l + r + root.val);
    res = Math.max(res, ans);

    return temp;
  }

  public int maxPathSum(Node root) {
    res = Integer.MIN_VALUE;
    int x = solve(root);

    return res;
  }
}
