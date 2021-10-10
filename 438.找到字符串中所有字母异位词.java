import java.util.*;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (46.88%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 89.4K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 
 * 说明：
 * 
 * 
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 
 * 输出:
 * [0, 6]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s: "abab" p: "ab"
 * 
 * 输出:
 * [0, 1, 2]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s.length() < p.length()) {
            return list;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] charp = p.toCharArray();
        for (int i = 0; i < charp.length; i++) {
            map.put(charp[i], map.getOrDefault(charp[i], 0) + 1);
        }
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), map.getOrDefault((char) ('a' + i), 0));
        }
        int len = charp.length;
        int left = 0, right = 0;
        map.put(chars[left], map.get(chars[left]) - 1);
        while (right < chars.length) {
            // System.out.println(map);
            if (right - left + 1 == len) {
                if (match(map)) {
                    list.add(left);
                }
                map.put(chars[left], map.get(chars[left]) + 1);
                left++;
                right++;
                if (right < chars.length) {
                    map.put(chars[right], map.get(chars[right]) - 1);
                }
            } else if (right - left + 1 < len) {
                right++;
                map.put(chars[right], map.get(chars[right]) - 1);
            } else {
                left--;
                map.put(chars[left], map.get(chars[left]) + 1);
            }
        }
        return list;
    }

    private boolean match(Map<Character, Integer> map) {
        return !map.entrySet().stream().anyMatch(item -> item.getValue() != 0);
    }
}
// @lc code=end