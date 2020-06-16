package demo2;

import demo1.CommonUtil;

import static java.lang.Thread.sleep;

/**
 * Demo : Thread Interference
 * @author  JaneW.
 *
 */

public class SyncCounter implements Runnable {

    private static int commCount = 0;
    private static int syncCount = 0;

    @Override
    public void run() {
        count();
    }

    private void count(){

        for (int i = 0; i < 1000000; i++) {

            commCount++;

            synchronized(SyncCounter.class) {
                syncCount++;
            }
        }

        CommonUtil.outMessage("子线程结束计数commCount："+commCount);
        CommonUtil.outMessage("子线程结束计数syncCount："+syncCount);
    }

    public static void main(String[] args) throws Exception {

        CommonUtil.outMessage("开始Begin...");

        //创建若干个线程进行计数。
        for (int i = 0; i < 3; i++) {
            (new Thread(new SyncCounter())).start();
        }

        //主线程休眠一会，以等最后的计数结果
        try {
            sleep(3000);//3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //期待结果： 1000000*3 = 3000000
        CommonUtil.outMessage("计数结果commCount: " + commCount);
        CommonUtil.outMessage("计数结果syncCount: " + syncCount);

    }
}