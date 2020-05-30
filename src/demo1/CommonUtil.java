package demo1;

/**
 *
 * Demo Thread优先级
 * @author  JaneW.
 *
 */

public class CommonUtil {
    
    static void outMessage(String message) {
        long now = System.currentTimeMillis();
        String threadName =
                Thread.currentThread().toString();
        System.out.format("[%d]%s: %s%n",
                now,
                threadName,
                message);
    }
}
