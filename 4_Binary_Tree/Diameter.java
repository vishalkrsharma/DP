public class Diameter {
  int res;

  public void solve(Node root) {
    if (root == null)
      return;

    int l = solve(root.left);
    int r = solve(root.right);

    int temp = Math.max(l, r) + 1;
    int ans = Math.max(temp, l + r + 1);
    res = Math.max(res, ans);

  }

  public int diameterOfBinaryTree(Node root) {
    res = Integer.MIN_VALUE;
    solve(root);
    return res - 1;
  }
}
