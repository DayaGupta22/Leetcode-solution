class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
         std::vector<std::vector<int>> result;
        std::sort(nums.begin(), nums.end()); // Sort the array

        for (int i = 0; i < nums.size(); i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1; // Start pointer
            int right = nums.size() - 1; // End pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.push_back({nums[i], nums[left], nums[right]});
                    // Move both pointers to the next different number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }

        return result; 
    }
};