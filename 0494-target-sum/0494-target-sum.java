
import java.util.*;

class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return partition(nums, target);
    }

    private int partition(int[] nums, int target) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) return 0;

        if ((total - target) % 2 != 0) return 0;

        int newTarget = (total - target) / 2;

        return findWays(nums, newTarget);
    }

    private int findWays(int[] num, int target) {

        int n = num.length;

        int[] prev = new int[target + 1];

        if (num[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (num[0] != 0 && num[0] <= target)
            prev[num[0]] = 1;

        for (int ind = 1; ind < n; ind++) {

            int[] cur = new int[target + 1];

            for (int sum = 0; sum <= target; sum++) {

                int nottake = prev[sum];

                int take = 0;

                if (num[ind] <= sum) {
                    take = prev[sum - num[ind]];
                }

                cur[sum] = take + nottake;
            }

            prev = cur;
        }

        return prev[target];
    }
}
