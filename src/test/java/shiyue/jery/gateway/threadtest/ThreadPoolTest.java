package shiyue.jery.gateway.threadtest;

import java.util.concurrent.*;

/**
 * @author Jery
 * @date 2019/8/14
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);


    }
}

class lll implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}