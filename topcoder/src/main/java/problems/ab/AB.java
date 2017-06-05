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
    static int[] dividers = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public String createString(int n, int k) {
        int divider1 = findDivider(k);
        String result = "";
        if (divider1 == 0) {
            result = repeatString("B", n);
        } else {
            int divider2 = k / divider1;
            if (n >= divider1 + divider2) {
                result = repeatString("B", n - divider1 - divider2);
                result = result + repeatString("A", divider1) + repeatString("B", divider2);
            }
        }
        return result;
    }

    String repeatString(String s, int x) {
        if (s == null || "".equals(s) || x <= 0) return "";
        StringBuffer sb = new StringBuffer(s.length() * x);
        for (int i = 0; i < x; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    int findDivider(int k) {
        if (k == 0) return 0;
        for (int i = (int)Math.round(Math.sqrt(k)); i > 0; i--) {
            if (k % i == 0) return i;
        }
        return 1;
    }

    int minN(int k) {
        if (k == 1) return 2;
        if (k == 2) return 3;
        int div1 = (int) Math.round(Math.sqrt(k) + 0.5);
        if (k <= div1 * (div1 - 1)) return 2 * div1 - 1;
        return 2 * div1;
    }
}
