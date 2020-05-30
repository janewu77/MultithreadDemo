package demo1;

import java.util.concurrent.*;

/**
 *
 * Demo Thread优先级
 * @author  JaneW.
 *
 */

public class SimpleExecutorService {


    public static void main(String[] args) {
        runExecutorsThread();
    }


    private static void runExecutorsThread(){
        // 要执行的任务，实现callable接口
        SimpleCallableThread callableDemoA = new SimpleCallableThread();
        SimpleCallableThread callableDemoB = new SimpleCallableThread();

        // 将Callable写的任务封装到一个由执行者调度的FutureTask对象
        FutureTask<String> futureTaskA = new FutureTask<String>(callableDemoA);
        FutureTask<String> futureTaskB = new FutureTask<String>(callableDemoB);

        // 指定线程池大小，创建线程池, 返回ExecutorService实例
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTaskA);  // 执行任务
        executor.execute(futureTaskB);

        while (true) {
            try {

                //如果两个任务都完成了，就关闭线程池
                if(futureTaskA.isDone() && futureTaskB.isDone()){
                    CommonUtil.outMessage("Done任务都已执行完毕");
                    executor.shutdown();
                    return;
                }


                if(!futureTaskA.isDone()){ //等待任务A完成
                    CommonUtil.outMessage("===============");
                    CommonUtil.outMessage("FutureTaskA 返回:"+futureTaskA.get());
                }

                CommonUtil.outMessage("等待FutureTaskB完成......");
                String s = futureTaskB.get(200L, TimeUnit.MILLISECONDS);
                if(s != null){
                    CommonUtil.outMessage("FutureTaskB 返回:"+s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }catch(TimeoutException e){
                //do nothing
            }
        }
    }

}