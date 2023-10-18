import java.util.*;
/*
 * My original idea for this problem is to use an another str[] that is individually sorted like:
 * ["aet","aet","atn","atn",...]. With this sorted array maps to the original arr. Then go through 
 * the sorted array, sorting them by group using HashSet into a ArrayList<String>. Then return the entire
 * ArrayList<ArrayList<String>>
 * 
 * mistake to point out: 
 *    Wrong: ArrayList<ArrayList<String>> = new ArrayList<ArrayList<>>();
 *  Correct: Map<String, List<String>> map = new HashMap<>();
 *                                             ⬆️ using a single HashMap<> / ArrayList<> would be enough
 * 
 * Here is a better version:
 * iterating through each word, String curr. break into char[] then using .toCharArray() -> Arrays.sort()
 * Use a HashMap(key -> Value). The key would be the sorted word, and value would be the original word.
 * Output the value sets of the HashMap into the Map<String, List<String>>.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}