package com.shuzijun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();

        for (int i = 0, j = nums.length; i < j; i++) {
            if (nums[i] > 0) {
                return returnList;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int s = i + 1, e = j - 1;
            while (s < e) {
                if (nums[s] + nums[e] < target) {
                    s++;
                } else if (nums[s] + nums[e] > target) {
                    e--;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[s], nums[e]);
                    returnList.add(list);
                    while (s < e) {
                        if (nums[s] == nums[s + 1]) {
                            s++;
                        } else {
                            break;
                        }
                    }
                    while (s < e) {
                        if (nums[e] == nums[e - 1]) {
                            e--;
                        } else {
                            break;
                        }
                    }
                    s++;
                    e--;

                }
            }
        }

        return returnList;
    }
}
