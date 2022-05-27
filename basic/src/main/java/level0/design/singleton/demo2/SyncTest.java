package level0.design.singleton.demo2;

/**
 * 反编译前线build，生成class文件:
 *
 * synchronized 在方法上：相对于普通方法，其常量池中多了ACC_SYNCHRONIZED标示符。JVM就是根据该标示符来实现方法的同步的：
 * 当方法调用时，调用指令将会检查方法的 ACC_SYNCHRONIZED 访问标志是否被设置，如果设置了，执行线程将先获取monitor，获取成
 * 功之后才能执行方法体，方法执行完后再释放monitor。在方法执行期间，其他任何线程都无法再获得同一个monitor对象。 其实本质上
 * 没有区别，只是方法的同步是一种隐式的方式来实现，无需通过字节码来完成。
 *
 * synchronized 修饰代码块：
 *      monitorenter：1、如果monitor的进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的所有者。
 *                   2、如果线程已经占有该monitor，只是重新进入，则进入monitor的进入数加1.
 *                   3.如果其他线程已经占用了monitor，则该线程进入阻塞状态，直到monitor的进入数为0，再重新尝试获取monitor的所有权。
 *      monitorexit：指令执行时，monitor的进入数减1，如果减1后进入数为0，那线程退出monitor，不再是这个monitor的所有者。其
 *                   他被这个monitor阻塞的线程可以尝试去获取这个 monitor 的所有权。
 */
public class SyncTest {
    public void test1() {
        synchronized (SyncTest.class) {
            System.out.println("hello");
        }
    }

    public static synchronized void test2() throws Exception{
        System.out.println("hello");
    }

    public static void main(String[] args) {
        // SyncTest.test();
    }
}
