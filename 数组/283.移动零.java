/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
//
class Solution {
    public void moveZeroes(int[] nums) {
        // 解法1：
        // 1. 设定指针`pos`记录当前非零元素下标；
        // 2. 遍历数组，遇到非零元素则移动到`pos`处，然后`pos += 1`；
        // 3. 将剩余元素赋值为零。
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }

        while (pos < nums.length) {
            nums[pos++] = 0;
        }
        
        // 解法2
        // 1. 创建一个等长的新数组`arr`;
        // 2. 设定指针`pos`记录当新数组下标；
        // 3. 遍历数组`nums`,遇到非零元素则复制到新数组`pos`处，然后`pos += 1`；
        // 4. 将`arr`复制到`nums`;
        // 5. 时间复杂度`O(n)`，空间复杂度`O(n)`。
        // int[] arrs = new int[nums.length];
        // int pos = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         arrs[pos++] = nums[i];
        //     }
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = arrs[i];
        // }
        // 解法3
        // 1. 设定指针`pos`记录当前填入元素下标；
        // 2. 遍历数组，遇到非零元素则`i`与`pos`处元素狡猾，然后`pos += 1`；
        // 3. 解法3和解法1区别，解法3将0直接往后移动，不需要第二步的赋值操作;
        // 3. 时间复杂度`O(n)`，空间复杂度`O(1)`。
        // int pos = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0) {
        //         int temp = nums[i];
        //         nums[i] = nums[pos];
        //         nums[pos++] = temp;
        //     }
        // }

        // 解法3改进：步骤2将nums[i]赋值为0，但需要判定i与pos相等
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i == pos) {
                    pos++;
                }
                else {
                    nums[pos++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
// @lc code=end

