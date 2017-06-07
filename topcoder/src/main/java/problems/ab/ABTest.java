package problems.ab;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Timur on 05.06.2017.
 */
public class ABTest {
    @Test
    public void testMinN() {
        Assert.assertEquals(3, new AB().minN(2));
        Assert.assertEquals(4, new AB().minN(4));
        Assert.assertEquals(2, new AB().minN(1));
        Assert.assertEquals(5, new AB().minN(5));
        Assert.assertEquals(5, new AB().minN(6));
        Assert.assertEquals(6, new AB().minN(7));
        Assert.assertEquals(6, new AB().minN(8));
        Assert.assertEquals(6, new AB().minN(9));
    }

    @Test
    public void test1() {
        Assert.assertEquals("ABB", new AB().createString(3, 2));
        Assert.assertEquals("BB", new AB().createString(2, 0));
        Assert.assertEquals("AB", new AB().createString(2, 1));
        Assert.assertEquals("", new AB().createString(5, 8));
        Assert.assertEquals("BBBAAABBBB", new AB().createString(10, 12));
        Assert.assertEquals("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAAAAABBBBBB", new AB().createString(50, 30));
        Assert.assertEquals("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAB", new AB().createString(50, 1));
        Assert.assertEquals("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAB", new AB().createString(50, 1));
        Assert.assertEquals("AAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBB", new AB().createString(50, 625));
        Assert.assertEquals("", new AB().createString(50, 626));
        Assert.assertEquals("BBAAABBBB", new AB().createString(9, 12));
        Assert.assertEquals("BAAABBBAB", new AB().createString(9, 13));
    }
}
