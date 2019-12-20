/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 解答2：左右双指针法
        // 1. 定义左右双指针，左指针从左遍历，右指针从右遍历
        // 2. 定义最大面积为0，分别计算每个面积，并与最大值比较
        // 3. 移动高度较短的指针
        // 4. 返回最大值
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l],height[r]));
            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
            int minHeight = height[l] < height[r] ? height[l++] : height[r--];
            maxArea = Math.max(maxArea, minHeight * (r - l + 1));
        }
        return maxArea;


        // 解答1：暴力法
        // 1. 两次循环，指针`i`和指针`j`指向数组的每个值
        // 2. 将计算出来的面积值与当前面积比较
        // int maxArea = 0;
        // for (int i = 0; i < height.length - 1; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
        //     }
        // }
        // return maxArea;
    }
}
// @lc code=end

