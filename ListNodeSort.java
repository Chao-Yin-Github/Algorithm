import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        return String.valueOf(val);
    }
}

class Solution {
    private void print(ListNode list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        while (list.next != null) {
            System.out.print(list + ",");
            list = list.next;
        }
        System.out.print(list + "]\n");
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode pre, post, preList, postList, middle, middleList, current;
        pre = new ListNode(-1);
        post = new ListNode(-1);
        middle = new ListNode(-1);
        current = new ListNode(-1);
        preList = pre;
        postList = post;
        middleList = middle;
        current.next = head;
        while (current.next != null) {
            if (current.next.val == x) {
                middle.next = current.next;
                middle = middle.next;
                current = current.next;
                System.out.println(1);
                print(preList.next);
                print(middleList.next);
                print(postList.next);
            } else if (current.next.val < x) {
                pre.next = current.next;
                pre = pre.next;
                current = current.next;
                System.out.println(2);
                print(preList.next);
                print(middleList.next);
                print(postList.next);
            } else {
                post.next = current.next;
                post = post.next;
                current = current.next;
                System.out.println(3);
                print(preList.next);
                print(middleList.next);
                print(postList.next);
            }
        }
        middle.next = null;
        post.next = null;
        pre.next = null;
        pre.next = middleList.next;
        middle.next = postList.next;
        System.out.println("======");
        print(preList.next);
        return preList.next;
    }
}
// @lc code=end

public class ListNodeSort {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int x = Integer.parseInt(line);

            ListNode ret = new Solution().partition(head, x);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}