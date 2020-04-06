import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 * ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outerList = new ArrayList<List<String>>();
        List<String> innerList = new ArrayList<String>();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j]) && !set.contains(strs[j])) {
                    if (!set.contains(strs[i])) {
                        innerList.add(strs[i]);
                        set.add(strs[i]);
                    }
                    set.add(strs[j]);
                    innerList.add(strs[j]);
                }
            }
            if (innerList.size() != 0)
                outerList.add(innerList);
            innerList = new ArrayList<String>();
        }
        for (int i = 0; i < strs.length; i++) {
            if (!set.contains(strs[i])) {
                innerList.add(strs[i]);
                outerList.add(innerList);
                set.add(strs[i]);
                innerList = new ArrayList<String>();
            }
        }
        return outerList;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }
}