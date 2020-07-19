import java.net.URLEncoder;
import java.util.*;


public class Solution {
    /**
     * 计算token
     * 
     * @param querys string字符串ArrayList 输入参数，每个键值对用=分割
     * @return string字符串
     */
    public String createToken(ArrayList<String> querys) {
        String[] array = new String[querys.size()];
        int i = 0;
        querys.forEach(item -> {
            array[i++] = URLEncoder.encode(item, "utf-8");
        });
        Arrays.sort(array, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String o1p = o1.substring(0, o1.indexOf('='));
                String o2p = o2.substring(0, o2.indexOf('='));
                int min = Math.min(o1p.length(), o2p.length());
                int i;
                for (i = 0; i < min; i++) {
                    if (o1p.charAt(i) != o2p.charAt(i)) {
                        return o1p.charAt(i) - o2p.charAt(i);
                    }
                }
                if (min == o2p.length() && min == o1p.length()) {
                    return 0;
                } else if (min == o2p.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }
}