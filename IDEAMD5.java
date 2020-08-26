import java.security.MessageDigest;

public class IDEAMD5 {
    public static void main(String[] args) {
        String s = "73.25%";
        System.out.println(encode(s));
        for (int i = 0; i < 100000000; i++) {
            s = encode(s);
        }
        System.out.println(s);
    }

    private static String encode(String s) {
        try {
            byte[] btInput = s.getBytes("uTF-8");
            MessageDigest mdInst = MessageDigest.getInstance("MD2");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}