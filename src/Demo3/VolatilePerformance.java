package Demo3;

import demo1.CommonUtil;

/**
 * Demo : volatile、 synchronized 读写性能比较
 * @author  JaneW.
 *
 */

public class VolatilePerformance {

    private static int commonX = 0;             //普通无锁变量
    private static volatile int volatileX = 0;  //volatile变量
    private static int synchronizedX = 0;       //加 synchronized 进行读写

    private static final int max = Integer.MAX_VALUE/3;

    static void writeCommonX(){
        commonX++;
    }

    static int readCommonX(){
        return commonX;
    }

    static void writeVolatileX(){
        volatileX++;
    }

    static int readVolatileX(){
        return volatileX;
    }

    static synchronized void writeSynchronizedX(){
        synchronizedX++;
    }

    static synchronized int readSynchronizedX(){
        return synchronizedX;
    }

    static void testWrite(){

        long now = System.currentTimeMillis();
        for (int i=0; i<max ;i++) {
            VolatilePerformance.writeCommonX();
        }
        long time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("write CommonX: " + time);

        //2
        now = System.currentTimeMillis();
        for (int i=0; i<max;i++) {
            VolatilePerformance.writeVolatileX();
        }
        time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("write VolatileX: " + time);

        //3
        now = System.currentTimeMillis();
        for (int i=0; i<max;i++) {
            VolatilePerformance.writeSynchronizedX();
        }
        time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("write SynchronizedX: " + time);
    }

    static void testRead(){
        //1
        long now = System.currentTimeMillis();
        for (int i=0; i<max ;i++) {
            VolatilePerformance.readCommonX();
        }
        long time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("read CommonX: " + time);

        //2
        now = System.currentTimeMillis();
        for (int i=0; i<max;i++) {
            VolatilePerformance.readVolatileX();
        }
        time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("read VolatileX: " + time);

        //3
        now = System.currentTimeMillis();
        for (int i=0; i<max;i++) {
            VolatilePerformance.readSynchronizedX();
        }
        time = System.currentTimeMillis() - now;
        CommonUtil.outMessage("read SynchronizedX: " + time);

    }

    public static void main(String[] args) throws Exception {
        testWrite();

        testRead();
    }

}
