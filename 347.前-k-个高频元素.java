import java.util.*;
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (60.56%)
 * Likes:    519
 * Dislikes: 0
 * Total Accepted:    106.5K
 * Total Submissions: 172.7K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 
 * 
 */

// @lc code=start
class Pair{
    Integer element;
    Integer times;
    Pair(){
    }
    Pair(Integer element,Integer times){
        this.element = element;
        this.times = times;
    }
    @Override
    public String toString(){
        return "element="+element+",times="+times;
    }

    @Override
    public boolean equals(Object o){
        Pair p = (Pair)o;
        if(!element.equals(p.element) || !times.equals(p.times)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Pair> set = new TreeSet<Pair>((o1,o2)->{
            if(o1.times-o2.times==0){
                return o1.element-o2.element;
            }else{
                return o1.times-o2.times;
            }
        });
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.forEach((key,value)->{
            System.out.println("map="+key+","+value);
            System.out.println("size="+set.size()+" "+(set.size()<k));
            if(set.size()<k){
                Pair pair = new Pair(key,value);
                System.out.println("set.add"+pair);
                set.add(pair);
            }else{
                System.out.println("set.first()"+set.first()+"=====");
                if(value>set.first().times){
                    final Pair pair = new Pair(key,value);
                    set.pollFirst();
                    set.add(pair);
                }
            }
            System.out.println("map="+key+","+value);
            System.out.println("size="+set.size()+" "+(set.size()<k));
        });
        System.out.println();
        set.forEach(System.out::println);
        return set.stream().mapToInt(item->item.element).toArray();
    }
}
// @lc code=end