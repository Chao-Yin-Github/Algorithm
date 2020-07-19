import java.util.*;

public class Solution {
    /**
     * 过滤内容中出现的QQ号
     * 
     * @param content string字符串 待过滤内容
     * @return string字符串
     */
    public String filterContent(String content) {
        if (content == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) >= '0' && content.charAt(i) <= '9') {
                continue;
            }
            stringBuilder.append(content.charAt(i));
        }
        return stringBuilder.toString();
    }
}