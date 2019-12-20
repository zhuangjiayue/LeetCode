import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 解答1：暴力法
        // 1. 双重循环遍历数组，第一遍循环数字，内循环找出是否有目标元素;
        // 2. 时间复杂度`o(n^2)`，空间复杂度`o(1)`。
        // for (int i = 0; i < nums.length - 1; i++) {
        //     int tmp = target - nums[i];
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (tmp == nums[j]) {
        //             return new int[] {i,j};
        //         }
        //     }
        // }


        // 解答2：两遍HashMap法
        // 1. 第一遍，将每个元素的值和对应的index存入HashMap中;
        // 2. 第二遍，查找每个元素对应的目标是否存在于HashMap中；
        // 3. 时间复杂度`o(n)`，空间复杂度`o(n)`。
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], i);
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     int tmp = target - nums[i];
        //     if (map.containsKey(tmp) && map.get(tmp) != i) {
        //         return new int[] {i, map.get(tmp)};
        //     }
        // }

        // 解答3：一遍HashMap法
        // 1. 查找每个元素对应的目标元素是否存在于HashMap中，如果不存在，则将元素的值和对应的index存入HashMap中；
        // 2. 时间复杂度`o(n)`，空间复杂度`o(n)`。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[] {i,map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such sum sollution");
    }
}
// @lc code=end

