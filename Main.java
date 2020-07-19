import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String start = s.nextLine();
        String end = s.nextLine();
        Main m = new Main();
        System.out.print(m.countMethod(start, end));
    }

    private int countMethod(String start, String end) {
        char[] sc = start.toCharArray();
        char[] ec = end.toCharArray();
        int count = 0;
        int p = sc.length - 4;
        count = ec[p] - sc[p];
        // 分钟个位
        System.out.println(ec[p] - sc[p]);
        System.out.println(count);
        p--;
        // 分钟十位
        count += 10 * (ec[p] - sc[p]);
        System.out.println(10 * (ec[p] - sc[p]));
        System.out.println(count);
        p -= 2;
        // 小时
        count += 60 * (ec[p] - sc[p] + 10 * (ec[p - 1] - sc[p - 1]));
        System.out.println(60 * (ec[p] - sc[p] + 10 * (ec[p - 1] - sc[p - 1])));
        System.out.println(count);
        p -= 3;
        // todo
        // 天
        count += 24 * (ec[p] - sc[p] + 10 * (ec[p - 1] - sc[p - 1]));
        System.out.println(24 * (ec[p] - sc[p] + 10 * (ec[p - 1] - sc[p - 1])));
        p-=3;
        int month = 
        return count;
    }
}