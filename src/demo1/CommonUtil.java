package demo1;

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
