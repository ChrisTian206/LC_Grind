/*
 * HashSet() only accept unique values.
 * HashSet.add() would return a boolean, true means added, false means duplicate exist
 */

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }

        return false;
    }
}

/*
 * Another method introduced by Jeremy: binary representation
 * having an empty array int[] arr = new int[1000000];
 * each element in arr represent a number in nums. For example
 * nums: [1,2,3,4]
 * arr: [0,1,1,1,1]
 * When adding nums, if arr[i] == 0, flip 0 -> 1
 * If arr[i] == 1, then found duplicate
 */