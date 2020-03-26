/**
 * [翻转数位](<https://leetcode-cn.com/problems/reverse-bits-lcci/>)
 * 
 * finished at 2020-03-27 01:30:40
 * 
 * 其实和位运算关系不大,本质是逻辑题
 */
class Solution {
    public int reverseBits(int num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        int max = 0;
        int pre = 0;
        // flag 表示能否进行翻转操作
        boolean flag = true;
        while (num != 0) {
            count = 0;
            while ((num & 1) == 1) {
                count++;
                num = num >>> 1;
            }
            num = num >>> 1;
            if (flag == false) {
                max = Math.max(max, pre + count);
                flag = true;
                pre = count;
                System.out.println("count=" + count + "max=" + max);
            } else {
                max = Math.max(max, count + pre + 1);
                flag = false;
                pre = count + 1;
                System.out.println("count=" + count + "max=" + max);
            }
        }
        System.out.println("=======");
        return max;
    }
}
