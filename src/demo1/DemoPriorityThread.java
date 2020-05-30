package demo1;

/**
 *
 * Demo Thread优先级
 * @author  JaneW.
 *
 */

public class DemoPriorityThread extends Thread {

    @Override
    public void run() {
        super.run();

        //摸拟执行任务
        for (int i = 0; i < 5; i++) {

            CommonUtil.outMessage("计数："+i);

            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//End for
    }

    public static void main(String[] args) throws Exception {

        CommonUtil.outMessage("开始Begin...");

        //创建A、B、C三个线程,并指定优先级
        //由于已经是继承Thread类了，所以这里直接调用star()就可以启动线程了.
        Thread threadA = new DemoPriorityThread();
        threadA.setName("A3");
        threadA.setPriority(MIN_PRIORITY);
        threadA.start();

        Thread threadB = new DemoPriorityThread();
        threadB.setName("B3");
        threadB.setPriority(MAX_PRIORITY);
        threadB.start();

        Thread threadC = new DemoPriorityThread();
        threadC.setName("C3");
        threadC.setPriority(MAX_PRIORITY);
        threadC.start();

    }
}
