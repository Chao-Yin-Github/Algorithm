import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=535 lang=java
 *
 * [535] TinyURL 的加密与解密
 *
 * https://leetcode-cn.com/problems/encode-and-decode-tinyurl/description/
 *
 * algorithms
 * Medium (78.82%)
 * Likes:    53
 * Dislikes: 0
 * Total Accepted:    5.4K
 * Total Submissions: 6.7K
 * Testcase Example:  '"https://leetcode.com/problems/design-tinyurl"'
 *
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl
 * 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * 
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode
 * 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 * 
 */

// @lc code=start
public class Codec {
    private static final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Map<String, String> map = new HashMap<>();

    private String generateUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(62)));
        }
        return stringBuilder.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = generateUrl();
        while (map.get(tinyUrl) != null) {
            tinyUrl = generateUrl();
        }
        map.put(tinyUrl, longUrl);
        return "http://tinyUrl.com/" + tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyUrl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end
