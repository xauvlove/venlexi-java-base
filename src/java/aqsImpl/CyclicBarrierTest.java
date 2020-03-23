package java.aqsImpl;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i < cyclicBarrier.getParties(); i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(2));
                    System.out.println(Thread.currentThread().getName() + "准备好了");
                    //准备工作完成后 唤醒状态
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "开始执行");
            }).start();

        }
    }
}
