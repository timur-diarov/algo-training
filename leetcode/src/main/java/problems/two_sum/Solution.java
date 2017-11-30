package problems.two_sum;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numsToIndiciesMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsToIndiciesMap.containsKey(nums[i])) {
                ArrayList<Integer> valuesArray = new ArrayList<Integer>();
                valuesArray.add(i);
                numsToIndiciesMap.put(nums[i], valuesArray);
            } else {
                numsToIndiciesMap.get(nums[i]).add(i);
            }
        }

        Object[] applicableValues = numsToIndiciesMap.keySet().toArray();
        int[] result = new int[2];

        for (int i = 0; i < applicableValues.length; i++) {
            int requiredNum = target - (Integer) applicableValues[i];
            if ((requiredNum != (Integer) applicableValues[i] || numsToIndiciesMap.get(requiredNum).size() > 1)
                    && numsToIndiciesMap.containsKey(requiredNum)) {

                result[0] = numsToIndiciesMap.get(applicableValues[i]).get(0);
                List<Integer> secondResultsList = numsToIndiciesMap.get(new Integer(requiredNum));
                result[1] = secondResultsList.get(secondResultsList.size() - 1);
                return result;
            }
        }

        return result;
    }

    @Test
    public void test0() {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }

    @Test
    public void test1() {
        int[] result = twoSum(new int[]{4, 2, 6, 11, 15}, 8);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
    }

    @Test
    public void test2() {
        int[] result = twoSum(new int[]{3, 3}, 6);
        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }

    @Test
    public void test3() {
        int[] result = twoSum(new int[]{0, 4, 3, 0}, 0);
        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(3, result[1]);
    }

    @Test
    public void test4() {
        int[] result = twoSum(new int[]{-3, 3, 5, 6}, 0);
        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(1, result[1]);
    }
}
