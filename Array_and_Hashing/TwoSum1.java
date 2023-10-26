public class TwoSum1 {
    class Solution {

        // Brutal force
        public int[] twoSum(int[] nums, int target) {
            int[] output = new int[2];

            for (int i = 0; i < nums.length - 1; i++) {
                int first = nums[i];
                // if(first > target) continue; //not >= because there could be case 0 + target
                // == target

                for (int j = i + 1; j <= nums.length - 1; j++) {
                    int second = nums[j];

                    if (first + second == target) {
                        output[0] = i;
                        output[1] = j;
                        return output;
                    }
                }
            }

            return output;
        }
    }

    // Another apporach is to use HashMap
    /*
     * class Solution {
     * public int[] twoSum(int[] nums, int target) {
     * Map<Integer, Integer> numMap = new HashMap<>();
     * int n = nums.length;
     * 
     * for (int i = 0; i < n; i++) {
     * int complement = target - nums[i];
     * if (numMap.containsKey(complement)) {
     * return new int[]{numMap.get(complement), i};
     * }
     * numMap.put(nums[i], i);
     * }
     * 
     * return new int[]{}; // No solution found
     * }
     * }
     */
}
