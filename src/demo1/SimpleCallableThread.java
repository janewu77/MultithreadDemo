package demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * Demo 通过 Callable 和 Future 创建线程
 * @author  JaneW.
 *
 */

class SimpleCallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {

        //摸拟执行任务
        CommonUtil.outMessage("子线程开始......");

        for (int i = 0; i < 5; i++) {
            try {

                int waitTime = (int)(Math.random() * 100);
                CommonUtil.outMessage("子线程计数: " + i + ",然后等待: " + waitTime + "毫秒");
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //返回
        String strReturn = Thread.currentThread().getName() + "的返回值";// +Math.random();
        CommonUtil.outMessage("子线程结束.");
        return strReturn;
    }

    private static void runSimpleCallableThread() {

        CommonUtil.outMessage("begin开始......");

        //创建任务
        SimpleCallableThread simpleCallableThreadA = new SimpleCallableThread();
        FutureTask<String> futureTaskA = new FutureTask<>(simpleCallableThreadA);

        SimpleCallableThread simpleCallableThreadB = new SimpleCallableThread();
        FutureTask<String> futureTaskB = new FutureTask<String>(simpleCallableThreadB);

        for (int i = 0; i < 10; i++) {

            CommonUtil.outMessage("计数：" + i);

            if (i == 2) {//启动二个子线程
                new Thread(futureTaskA, "线程A").start();
                new Thread(futureTaskB, "线程B").start();
            }
        }

        try {
            CommonUtil.outMessage("子线程的返回值：" + futureTaskA.get());
            CommonUtil.outMessage("子线程的返回值：" + futureTaskB.get());

            String bb = futureTaskA.get() + " & " + futureTaskB.get();
            CommonUtil.outMessage("取得所有子线程的返回结果：" + bb);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CommonUtil.outMessage("end执行结束.");
    }

    public static void main(String[] args) {
        runSimpleCallableThread();
    }

}
