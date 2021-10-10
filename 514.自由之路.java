import java.util.*;
/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 *
 * https://leetcode-cn.com/problems/freedom-trail/description/
 *
 * algorithms
 * Hard (40.78%)
 * Likes:    178
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 33.2K
 * Testcase Example:  '"godding"\n"gd"'
 *
 * 电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * 
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * 
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00
 * 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * 
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * 
 * 
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00
 * 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key
 * 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * ⁠对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
 * ⁠对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * ⁠当然, 我们还需要1步进行拼写。
 * ⁠因此最终的输出是 4。
 * 
 * 
 * 提示：
 * 
 * 
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String plate, String target) {
        if (target == null || target.isEmpty()) {
            return 0;
        }
        char[] charp = plate.toCharArray();
        char[] chart = target.toCharArray();
        int plateLength = plate.length();
        int targetLength = target.length();
        // dp[i][j] 代表从 target 的前 i 个 字符 旋转到 palte 第 j 个字符的最小移动步数
        int[][] dp = new int[targetLength][plateLength];
        // lists 存储
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < 26; i++) {
            lists[i] = new ArrayList<>();
        }
        // 初始化下标表
        for (int i = 0; i < plateLength; i++) {
            lists[charp[i] - 'a'].add(i);
        }
        // dp 置为最大值
        for (int i = 0; i < targetLength; i++) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        // 初始化第一个
        for (int index : lists[chart[0] - 'a']) {
            dp[0][index] = Math.min(index, plateLength - index) + 1;
        }
        for (int i = 1; i < targetLength; i++) {
            for (int index : lists[chart[i] - 'a']) {
                for (int k : lists[chart[i - 1] - 'a']) {
                    dp[i][index] = Math.min(dp[i][index],
                            dp[i - 1][k] + Math.min(Math.abs(k - index), plateLength - Math.abs(k - index)) + 1);
                }
            }
        }
        return Arrays.stream(dp[targetLength - 1]).min().getAsInt();
    }
}
// @lc code=end
