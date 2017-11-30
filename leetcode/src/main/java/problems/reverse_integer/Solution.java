package problems.reverse_integer;

import org.junit.Assert;
import org.junit.Test;

/*
Given a 32-bit signed integer, reverse digits of an integer.
*/

public class Solution {
    public int reverse(int x) {
        boolean signed = x < 0;
        if (x == Integer.MIN_VALUE) return 0;
        int unsignedX = signed ? -x : x;
        int result = 0;
        int divider = 1000000000;
        int multiplier = 1;
        int addition;
        while (divider > 0) {
            addition = unsignedX / divider % 10 * multiplier;
            if (addition / multiplier != unsignedX / divider % 10) return 0;
            result += addition;
            if (result < 0) return 0;
            divider /= 10;
            if (result > 0) multiplier *= 10;
        }
        return signed ? -result : result;
    }

    @Test
    public void test0() {
        Assert.assertEquals(987654321, reverse(1234567890));
    }

    @Test
    public void test1() {
        Assert.assertEquals(-123, reverse(-321));
    }

    @Test
    public void test2() {
        Assert.assertEquals(504030201, reverse(1020304050));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, reverse(1234567899));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, reverse(1563847412));
    }
}