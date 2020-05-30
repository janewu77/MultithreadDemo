package demo1;

import static java.lang.Thread.sleep;

/**
 * Demo 通过实现Runnable接口，创建线程。
 * @author  JaneW.
 *
 */
public class SimpleRunnableThread implements Runnable {

    @Override
    public void run() {

        //摸拟执行任务
        for (int i = 0; i < 5; i++) {

            CommonUtil.outMessage("计数："+i);

            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//End for

    }

    public static void main(String[] args) throws Exception {

        CommonUtil.outMessage("开始Begin...");

        //创建A、B、C三个线程
        (new Thread(new SimpleRunnableThread(),"A")).start();
        (new Thread(new SimpleRunnableThread(),"B")).start();
        (new Thread(new SimpleRunnableThread(),"C")).start();

    }

}