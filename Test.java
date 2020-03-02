import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        String tinyUrl = test.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(tinyUrl);
        System.out.println(test.decode(tinyUrl));
    }

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
