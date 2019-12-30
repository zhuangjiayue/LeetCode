/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // for 循环
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int slow = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[slow]) {
        //         nums[++slow] = nums[i];
        //     }
        // }
        // return ++slow;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return ++slow;
    }
}
// @lc code=end

