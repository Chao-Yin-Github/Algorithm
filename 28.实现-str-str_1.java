/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 * 
 * finished at 2020-03-13 22:49:57
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 * 
 * algorithms
 * Easy (38.68%)
 * Likes:    378
 * Dislikes: 0
 * Total Accepted:    137.8K
 * Total Submissions: 348.2K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

// @lc code=start
class Solution {
    private int[] array;

    private void kmpInit(String needle) {
        int length = needle.length();
        array = new int[length];
        // 表示后缀
        int i = 0;
        // 表示前缀
        int j = -1;
        array[0] = -1;
        while (i < length - 1) {
            // j=-1 时代表此时在起点,从起点开始比较
            if (j == -1 || needle.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
                /**
                 * array[i] = j 的意思是:
                 * 
                 * 虽然我不知道第 i 个 和 第 j 个位置所代表的值相不相等,
                 * 
                 * 但是我知道,对于第 i 个值,至少 前 j -1 个数的值绝对一样,不需要再比较
                 * 
                 * 1. 如果匹配第 i 个和第 j 个相等也可以,我不在乎,
                 * 
                 * 2. 但是如果不等,那么我就要回到一个合适的地方,使得比较的时候不需要比较那些绝对相同的部分,减少比较次数
                 */
                array[i] = j;
                /**
                 * 当然此处还有瑕疵需要优化: 因为如果这样写,在下次比较的时候如果不相等需要在下面 else 分支中回溯,
                 * 
                 * 回溯的结果:
                 * 
                 * 1. 要么是从头开始,
                 * 
                 * 2. 要么是之前 j 代表的值和 array[j] 代表的值完全相同
                 * 
                 * (当 needle[i] != needle[j],需要找到的仅仅是上一个合适的值)
                 * 
                 * (但是如果 needle[i] == needle[j],那么就算在 else 里面回溯了,但是值还是一样,
                 * 
                 * 这样肯定还是不匹配,需要再次回溯
                 */

                // else: 如果不相等,
                // 那么 array[i] 的值就等于 j 之前的其中一个回溯的点,需要通过 array 向前回溯
            } else {
                j = array[j];
            }
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) != needle.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
        // kmpInit(needle);
        kmpInit_change(needle);
        // Arrays.stream(array).forEach(item -> {
        // System.out.print(item + " ");
        // });
        int i = 0;
        /**
         * 此处有个特点,不能像生成 array 数组那样令 j=-1,而是0
         * 
         * 其实是0很好理解,因为肯定是要从头开始比较,那为什么上面那个生成 array 数组 j 初始值为 -1呢?
         * 
         * 这是因为上面那个是求最大公共前后缀,有一定的特点
         * 
         * 首先默认 array 数组第一位一定是-1,第二位是0
         */
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                j = array[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 改良的 kmpInit 函数
     * 
     * 使得下次比较的时候,可以直接比较,而绝对不用多次发现不匹配在 else 里面回溯
     */
    private void kmpInit_change(String needle) {
        int length = needle.length();
        array = new int[length];
        // 表示后缀
        int i = 0;
        // 表示前缀
        int j = -1;
        array[0] = -1;
        while (i < length - 1) {
            if (j == -1 || needle.charAt(j) == needle.charAt(i)) {
                i++;
                j++;
                if (needle.charAt(i) != needle.charAt(j)) {
                    array[i] = j;
                } else {
                    array[i] = array[j];
                }
            } else {
                j = array[j];
            }
        }
    }

}
// @lc code=end
