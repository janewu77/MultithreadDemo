package Demo3;

import demo1.CommonUtil;


public class VolatileOrdering {

    static volatile int i = 0, j = 0;

    static  void one() {
        i++;
        j++;
    }

    static  void two() {

        String threadName =
                Thread.currentThread().toString();

        if (i < j) {
            System.out.println(threadName + "i=" + i + " j=" + j);
        }

    }

    public static void main(String[] args) throws Exception {

        CommonUtil.outMessage("开始 Begin... ");

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int c = 0; c < 50000 ; c++) {
                    VolatileOrdering.one();
                }
            }
        }).start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int c = 0; c < 50000 ; c++) {
                    VolatileOrdering.two();
                }

            }
        }).start();

    }

}

