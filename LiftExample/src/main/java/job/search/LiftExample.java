package job.search;

import job.search.util.LiftUtil;

import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

public class LiftExample {
    private static Random random = new Random();

    public static void main(String[] args) {
        LiftUtil liftUtil = new LiftUtil();
        List<Runnable> threadLift = random.ints(100000, 0, 8)
                .mapToObj(getLiftRunnable(liftUtil)).toList();
        threadLift.forEach(thread -> new Thread(thread).start());
    }

    private static IntFunction<Runnable> getLiftRunnable(LiftUtil liftUtil) {
        IntFunction<Runnable> obj1 = i -> (Runnable) () -> liftUtil.pressUp(i);
        IntFunction<Runnable> obj2 = i -> (Runnable) () -> liftUtil.pressDown(i);
        List<IntFunction<Runnable>> list = List.of(obj1, obj2);
        return list.get(random.nextInt(0, 2));
    }
}