import java.util.HashMap;

public class Boolean_Parenthesization_Memoization {

  static HashMap<String, Integer> map = new HashMap<>();

  public static int mcm(String s, int i, int j, boolean isTrue) {
    if (i > j) {
      return 0;
    }
    if (i == j) {
      if (isTrue) {
        return s.charAt(i) == 'T' ? 1 : 0;
      } else {
        return s.charAt(i) == 'F' ? 1 : 0;
      }
    }

    String key = Integer.toString(i) + " " + Integer.toString(j) + " " + Boolean.toString(isTrue);

    if (map.containsKey(key)) {
      return map.get(key);
    }

    int ans = 0;

    for (int k = i + 1; k < j; k += 2) {
      int leftTrue = mcm(s, i, k - 1, true);
      int leftFalse = mcm(s, i, k - 1, false);
      int rightTrue = mcm(s, k + 1, j, true);
      int rightFalse = mcm(s, k + 1, j, false);

      if (s.charAt(k) == '^') {
        if (isTrue) {
          ans += (leftTrue * rightFalse) + (leftFalse * rightTrue);
        } else {
          ans += (leftTrue * rightTrue) + (leftFalse * rightFalse);
        }
      } else if (s.charAt(k) == '&') {
        if (isTrue) {
          ans += (leftTrue * rightTrue);
        } else {
          ans += (leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
        }
      } else if (s.charAt(k) == '|') {
        if (isTrue) {
          ans += (leftTrue * rightTrue) + (leftFalse * rightTrue) + (leftTrue * rightFalse);
        } else {
          ans += (leftFalse * rightFalse);
        }
      }
    }

    map.put(key, ans);
    return ans;
  }

  public static void main(String args[]) {
    String s = "T^F|F";
    int n = s.length();

    System.out.println(mcm(s, 0, n - 1, true));
  }
}
