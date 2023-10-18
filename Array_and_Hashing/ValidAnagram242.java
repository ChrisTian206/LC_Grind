import java.util.*;

/*
 * First idea: 
 * first add all letters used and how many time is was used.
 * HashMap<letter, #time used>
 * {
 *  'a' : 2,
 *  'n' : 2,
 *  ...
 * }
 * Then use the second String to substract the number of times a letter was used.
 * By the end, all letters in the HashMap should have number of time used: 0
 * {
 *  'a' : 0,
 *  'b' : 0,
 *  ...
 * }
 * 
 * Then return true for valid anagram.
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> set = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!set.containsKey(curr))
                set.put(curr, 1);
            else {
                set.put(curr, set.get(curr) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!set.containsKey(curr))
                return false;
            else {
                set.put(curr, set.get(curr) - 1);
            }
        }

        for (int num : set.values()) {
            if (num != 0)
                return false;
        }

        return true;
    }
}

/*
 * Here is a even better idea:
 * It's so simple and self-explaintary...
 * The most important thing: It's FAST!
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }