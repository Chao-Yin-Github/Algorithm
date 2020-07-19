import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if (str == null || str.length() == 0) {
            System.out.println(0);
        }
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                res = i;
                break;
            }
        }
        if (res == -1) {
            System.out.println(str.length());
            return;
        }
        System.out.println(str.length() - res - 1);
    }
}