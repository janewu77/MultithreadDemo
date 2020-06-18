package Demo3;

import demo1.CommonUtil;

/**
 *
 * Demo : Volatile demo : status flags
 * @author  JaneW.
 *
 */

public class VolatileDemo {

    private static volatile boolean isShutdown = false;  // volatile

    static void doSomething(){
        while (!isShutdown) ;  //没停机就一直循环
        CommonUtil.outMessage("shutdown!");
    }

    static void shutdown(){
        isShutdown = true;
    }


    public static void main(String[] args) {

        CommonUtil.outMessage("开始 Begin... ");

        //启动线程开始 doSomething
        //线程A将从主存拿到 isShutdown 的值 false，保留在自己的工作内存中......
        Thread threadA = new Thread(){
            @Override
            public void run() {
                VolatileDemo.doSomething();
            }
        };
        threadA.start();

        //模拟停顿一会
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //另一个线程：设置关机标记
        Thread threadB = new Thread() {
            @Override
            public void run() {
                VolatileDemo.shutdown();
            }
        };
        threadB.start();

    }

}
