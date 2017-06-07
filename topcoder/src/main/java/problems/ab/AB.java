package problems.ab;

/**
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A' or 'B'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 * <p>
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 */
public class AB {
    public String createString(int n, int k) {
        String result = "";

        int minN = minN(k);
        if (minN <= n) {
            int extraChars = n - minN;
            result = repeatString("B", extraChars);
            result = result + repeatString("A", minN / 2 - 1);

            int maxK = minN/2 * (minN - minN/2);
            int extraK = maxK - k;
            result = result + repeatString("B", extraK);
            if (n - result.length() > 0) {
                result = result + "A";
            }
            result = result + repeatString("B", n - result.length());
        }
        return result;
    }

    private String repeatString(String s, int x) {
        if (s == null || "".equals(s) || x <= 0) return "";
        StringBuffer sb = new StringBuffer(s.length() * x);
        for (int i = 0; i < x; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    int minN(int k) {
        int halfN = (int)Math.ceil((float)Math.sqrt(k));
        int secondHalf = (int)Math.ceil((float)k/(float)halfN);
        return halfN + secondHalf;
    }
}
