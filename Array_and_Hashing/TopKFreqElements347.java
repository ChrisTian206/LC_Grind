import java.util.HashMap;

public class TopKFreqElements347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length == 1)
                return nums;
            HashMap<Integer, Integer> map = new HashMap<>();

            // insert all nums into a map with Key:num, Value:frequency
            for (int cur : nums) {
                if (!map.containsKey(cur)) {
                    map.put(cur, 1);
                } else {
                    map.put(cur, map.get(cur) + 1);
                }
            }

            int[] ret = new int[k];

            // exsaust search for highest freq key
            int max = 0;
            int pos = 0;
            for (int i = 0; i < k; i++) {
                for (Integer j : map.keySet()) {
                    int freq = map.get(j);
                    if (freq > max) {
                        max = freq;
                        pos = j;
                    }
                }

                ret[i] = pos;
                map.remove(pos);
                max = 0;
                pos = 0;
            }

            // for each iter, select the key with highest ferq
            // for each iter, find the current highest, insert that key into ret[],
            // delete that entry

            return ret;
        }
    }
}
