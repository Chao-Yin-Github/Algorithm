import java.util.*;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (43.33%)
 * Likes:    409
 * Dislikes: 0
 * Total Accepted:    56.4K
 * Total Submissions: 130.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Pair<T, S> {
    T first;
    S second;

    public Pair(T t, S s) {
        first = t;
        second = s;
    }
}

class Solution {
    public int ladderLength(final String beginWord, final String endWord, final List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int L = beginWord.length();
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> dict = new HashMap<>();
        wordList.forEach(item -> {
            for (int i = 0; i < L; i++) {
                String general = item.substring(0, i) + "*" + item.substring(i + 1, L);
                List<String> list = dict.getOrDefault(general, new ArrayList<String>());
                list.add(item);
                dict.put(general, list);
            }
        });
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<String, Integer>(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            for (int i = 0; i < L; i++) {
                String general = node.first.substring(0, i) + "*" + node.first.substring(i + 1);
                List<String> list = dict.getOrDefault(general, new ArrayList<String>());
                for (String item : list) {
                    if (item.equals(endWord)) {
                        return node.second + 1;
                    }
                    if (!visited.contains(item)) {
                        visited.add(item);
                        queue.add(new Pair<String, Integer>(item, node.second + 1));
                    }
                }
            }
        }
        return 0;
    }
}
// @lc code=end