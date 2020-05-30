package demo1;


/**
 * Demo 通过继承Thread，创建线程。
 * @author  JaneW.
 *
 */

public class SimpleExtendsThread extends Thread {

    @Override
    public void run() {
        super.run();

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
        //由于已经是继承Thread类了，所以这里直接调用star()就可以启动线程了.
        Thread threadA = new SimpleExtendsThread();
        threadA.setName("A2");
        threadA.start();

        Thread threadB = new SimpleExtendsThread();
        threadB.setName("B2");
        threadB.start();

        Thread threadC = new SimpleExtendsThread();
        threadC.setName("C2");
        threadC.start();

    }

}
