import java.util.*;

public class Solution {
    /**
     * 
     * @param str string字符串
     * @return char字符型
     */
    public char findFirstNonRepeatChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer != null) {
                map.put(chars[i], integer + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (Integer.valueOf(1).equals(map.get(chars[i]))) {
                return chars[i];
            }
        }
        throw new RuntimeException();
    }
}