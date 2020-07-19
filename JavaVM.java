import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaVM {
    public static void main(String[] args) throws IOException {
        JavaVM mainClass = new JavaVM();

        int i = 0;
        // Java 传值,i 不变
        mainClass.inc(i);
        System.out.println(i);

        // Java 虚拟机知识(栈帧的工作方式)
        // i = i,i++,道理都懂,但是为何 i++ 还是 i ???

        // 且看字节码: int i = 0;
        // iconst_0: i对应的值 0 -> 入操作数栈
        // istore_1: 操作数栈 0 弹出,赋给局部变量表 index 为1的地方,为0的是一般表示当前实例的 this 引用

        // i = i++ 的字节码:
        // iload_1: 局部变量表 index 为1的值 0 入操作数栈,此时操作数栈的栈顶是 0
        // iinc 1,1 : 第一个1 表示对局部变量表 index 的 int 值增加,第二个1表示增加多少
        // 此时局部变量表 index 为 1 的值为 1,但是操作数栈的值还是0
        // istore_1: 将操作数栈栈顶元素 0 弹出,放到局部变量表 index 为 1 的位置,覆盖了局部变量表的计算结果
        // iload_1: 将局部变量表 index 为 1 的位置的值 0 入操作数栈,最后结果为 0
        i = i++;
        System.out.println(i);

        // 实际上可以拆成
        // temp = i(代表的值,而非变量); i = i +1; i = temp;

        Integer j = 0;
        mainClass.inc(j);
        System.out.println(j);
        j = j++;
        System.out.println(j);

        ListNode list = new ListNode(0);
        mainClass.inc(list);
        System.out.println(list.val);
    }

    private void inc(int i) {
        // 这行代码对应的是局部变量 i 的++,和传入参数没有关系(get 有关系,set 没关系)
        i++;
        // 退出代码,i++ 表示的变量在栈帧中被销毁,++无效
    }

    private void inc(Integer i) {
        // Integer i 和 int i 参数不会报错,并且使用 Integer 传参可以精确调用
        System.out.println("invoke inc Integer");
        Integer temp = i;
        // 自动拆箱 <--> 自动装箱
        ++i;
        Integer j = i;
        // 关键: 对象都不是一个对象了
        System.out.println(j == temp);
        System.out.println(j == i);
        // 退出代码块,j 代表的对象被销毁,++无效
    }

    // 重载是从子类匹配,如果子类匹配到了就不会向上匹配
    private void inc(Object i) {
        // Integer i 和 int i 参数不会报错,并且使用 Integer 传参可以精确调用
        System.out.println("invoke inc Object");
    }

    // 对象的确是值传递,但是可以改变
    // 因为 i 指向的内存区域的对象没有改变
    // 对象在堆上,线程共享,实例对象的值发生改变所有线程都可见
    // 所以在这里改变 val, main 函数可以看到
    private void inc(ListNode i) {
        System.out.println("invoke inc list");
        i.val = 1;
    }
}