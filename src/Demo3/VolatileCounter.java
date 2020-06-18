package Demo3;

import demo1.CommonUtil;

import static java.lang.Thread.sleep;

/**
 * Demo : Volatile 的错误使用
 * @author  JaneW.
 *
 */

public class VolatileCounter implements Runnable {

    public volatile static int volatileCount = 0;   //加volatile 修饰。

    @Override
    public void run() {
        count();
    }

    private void count(){

        for (int i = 0; i < 1000000; i++) {
            volatileCount++;  //非原子操作
        }

        CommonUtil.outMessage("子线程结束计数 volatileCount： "+volatileCount);
    }

    public static void main(String[] args) throws Exception {

        CommonUtil.outMessage("开始 Begin... ");

        //创建若干个线程进行计数。
        for (int i = 0; i < 3; i++) {
            (new Thread( new VolatileCounter())).start();
        }

        //主线程休眠一会，以等最后的计数结果
        try {
            sleep(3000);//3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //期待结果： 1000000*3 = 3000000
        CommonUtil.outMessage("计数结果 volatileCount:  " + volatileCount);
    }
}