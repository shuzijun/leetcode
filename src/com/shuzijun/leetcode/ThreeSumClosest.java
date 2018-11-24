package com.shuzijun.leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int retunrn = nums[0] + nums[1] + nums[2];
        int derta = Math.abs(retunrn - target);

        for (int i = 0, j = nums.length; i <= j - 3; i++) {
           /* if (nums[i] >= target) {
                return Math.abs(nums[i] + nums[i + 1] + nums[i + 2] - target) > derta ? retunrn : nums[i] + nums[i + 1] + nums[i + 2];
            }*/
            int s = i + 1;
            int e = j - 1;
            while (s < e) {
                int temp = nums[i] + nums[s] + nums[e];
                if (temp > target) {
                    e--;
                } else if (temp < target) {
                    s++;
                } else {
                    return target;
                }
                if (Math.abs(temp - target) < derta) {
                    retunrn = temp;
                    derta = Math.abs(temp - target);
                }
            }

        }

        return retunrn;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int r =threeSumClosest.threeSumClosest(new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10},-52);
        System.out.print(r);
    }
}
