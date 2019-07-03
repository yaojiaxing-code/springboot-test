package cn.practice.test.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread().start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("myRunnable...");
            }
        };
        new Thread(runnable).start();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("myCallable...");
                return "Callable线程";
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        //System.out.println(futureTask.get());
        new Thread(futureTask).start();
        //调用FutureTask对象的get（）方法来获取子线程执行结束后的返回值。
        System.out.println(futureTask.get());

        Integer integer = Integer.valueOf("123");
        int i = integer.intValue();
        System.out.println(integer);
    }
}
