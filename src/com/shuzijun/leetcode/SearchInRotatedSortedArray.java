package com.shuzijun.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {
    /**
     * 0　　1　　2　　 4　　5　　6　　7
     * 7　　0　　1　　 2　　4　　5　　6
     * 6　　7　　0　　 1　　2　　4　　5
     * 5　　6　　7　　 0　　1　　2　　4
     * 4　　5　　6　　7　　0　　1　　2
     * 2　　4　　5　　6　　7　　0　　1
     * 1　　2　　4　　5　　6　　7　　0
     */
    public int search(int[] nums, int target) {
        if (nums.length <= 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = (s+e)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < nums[e]) {
                if (nums[m] < target && nums[e] >= target) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            } else  {
                if (nums[s] <= target && nums[m] > target) {
                    e = m - 1;
                } else {
                    s = m + 1;

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 0));
    }
}
