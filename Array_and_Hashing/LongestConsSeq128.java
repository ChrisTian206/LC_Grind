import java.util.*;

/*
 * We started out using priority queue thinking pq operations are O(logn). But turned out 
 * Arrays.sort() is faster...
 * 
 * First, sort the nums. Then loops through all ints in nums. ignore duplicate.
 * starting at nums[1], if currInt = pre + 1, means consecutive. curr++
 * if seq stops, record highest curr and reset.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        Arrays.sort(nums); // O(nlogn) ...
        // 1,2,3,4,100,200
        // 0,0,1,2,3,4,5,6,7,8
        // 1,3,5,7,9,...

        int curr = 1;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            // ignore the case when curr and pre are the same
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    curr++;
                } else {
                    max = Math.max(curr, max);
                    curr = 1;
                }
            }
        }

        return Math.max(curr, max);
    }
}