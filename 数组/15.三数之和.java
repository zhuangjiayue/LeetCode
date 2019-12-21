import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 暴力法
        // List<List<Integer>> res = new ArrayList<>();
        // if (nums.length < 3) {
        //     return res;
        // }
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length - 2; i++) {
        //     if (i > 0 && nums[i] == nums[i-1]) {
        //         continue;
        //     }
        //     for (int j = i + 1; j < nums.length - 1; j++) {
        //         if (j > i + 1 && nums[j] == nums[j-1]) {
        //             continue;
        //         }
        //         for (int k = j + 1; k < nums.length; k++) {
        //             if (k > j + 1 && nums[k] == nums[k-1]) {
        //                 continue;
        //             }
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 res.add(Arrays.asList(nums[i],nums[j],nums[k]));
        //             }
        //         }
        //     }
        // }
        // return res;


        // 左右双指针法
        // 1. 对数组进行排序；
        // 2. 固定一个数`nums[i]`，然后再使用左右指针指向`num[i]`后面的两端，分别为`nums[l]`和`nums[r]`，判断三数之和是否为0，为0则加入结果集;
        //      1. 如果`nums[i] > 0`，三数结果必定无法大于0，结束循环
        //      2. 如果`nums[i] == nums[i-1]`,跳过该次循环(当i>1);
        //      3. 当`sum == 0`时，`nums[l]==nums[l+1]`和`nums[r]==nums[r-1]`都会使结果重复，应该使得`l++`和`r--`;
        // 3. 时间复杂度为`o(n)`,空间复杂度`o(1)`。
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0 && nums[nums.length - 1] >= 0) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, r = nums.length - 1, target = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            } 
        }
        return res;
    }
}
// @lc code=end

