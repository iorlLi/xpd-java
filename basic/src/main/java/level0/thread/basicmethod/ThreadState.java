package level0.thread.basicmethod;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadState {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.info(("run() " + Thread.currentThread().getState()));
                TimeUnit.SECONDS.sleep(2);
                log.info(("run() " + Thread.currentThread().getState()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        log.info("t1 state1 : {}", t1.getState());
        t1.start();

        log.info("t1 state1 : {}", t1.getState());

        try {
            TimeUnit.SECONDS.sleep(1 / 2l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("t1 state2 : {}", t1.getState());
        try {
            TimeUnit.SECONDS.sleep(4l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("t1 state 3: {}", t1.getState());

    }
}
